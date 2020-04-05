package com.gutotech.narutogame.ui.playing.battles;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.firebase.FirebaseFunctionsUtils;
import com.gutotech.narutogame.data.model.Battle;
import com.gutotech.narutogame.data.model.CharOn;
import com.gutotech.narutogame.data.model.Fighters;
import com.gutotech.narutogame.data.model.Formulas;
import com.gutotech.narutogame.data.model.Npc;
import com.gutotech.narutogame.data.repository.BattleRepository;
import com.gutotech.narutogame.data.repository.CharacterRepository;
import com.gutotech.narutogame.utils.SingleLiveEvent;

public class DojoNpcFightersViewModel extends ViewModel {
    static final int MAX_DAILY_COMBAT = 10;

    private Fighters mFighters = new Fighters();

    private SingleLiveEvent<Void> mShowProgressBarEvent = new SingleLiveEvent<>();
    private SingleLiveEvent<Integer> mShowStatusEvent = new SingleLiveEvent<>();
    private SingleLiveEvent<Npc> mShowFightersEvent = new SingleLiveEvent<>();
    private SingleLiveEvent<Boolean> mProgressDialogEvent = new SingleLiveEvent<>();

    void init() {
        if (CharOn.character.getNpcDailyCombat() < MAX_DAILY_COMBAT) {
            Formulas formulas = CharOn.character.getFormulas();

            if ((double) formulas.getCurrentHealth() / formulas.getHealth() >= 0.5 &&
                    (double) formulas.getCurrentChakra() / formulas.getChakra() >= 0.5 &&
                    (double) formulas.getCurrentStamina() / formulas.getStamina() >= 0.5) {
                mShowProgressBarEvent.call();
                generateNpc();
            } else {
                mShowStatusEvent.setValue(R.string.too_weak_to_fight);
            }
        }
    }

    private void generateNpc() {
        CharacterRepository.getInstance().getChar(CharOn.character.getId(),
                baseChar -> {
                    Npc.create(baseChar);
                    mFighters.setOpponent(baseChar);
                    mFighters.setPlayer(CharOn.character);
                    mShowFightersEvent.call();
                }
        );
    }

    public void onAcceptBattleButtonPressed() {
        mProgressDialogEvent.setValue(true);

        FirebaseFunctionsUtils.getServerTime(currentTimestamp -> {
            Battle battle = new Battle(
                    BattleRepository.getInstance().generateId("DOJO-NPC"),
                    mFighters.getPlayer(),
                    mFighters.getOpponent(),
                    currentTimestamp);

            BattleRepository.getInstance().save(battle);

            mProgressDialogEvent.setValue(false);

            CharOn.character.battleId = battle.getId();
            CharOn.character.setBattle(true);
        });
    }


    public Fighters getFighters() {
        return mFighters;
    }

    LiveData<Void> getShowProgressBar() {
        return mShowProgressBarEvent;
    }

    LiveData<Integer> getShowStatusEvent() {
        return mShowStatusEvent;
    }

    LiveData<Npc> getShowFightersEvent() {
        return mShowFightersEvent;
    }

    LiveData<Boolean> getProgressDialogEvent() {
        return mProgressDialogEvent;
    }
}
