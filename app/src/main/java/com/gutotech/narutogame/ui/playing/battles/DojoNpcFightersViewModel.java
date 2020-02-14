package com.gutotech.narutogame.ui.playing.battles;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.Battle;
import com.gutotech.narutogame.data.model.CharOn;
import com.gutotech.narutogame.data.model.Formulas;
import com.gutotech.narutogame.data.model.Npc;
import com.gutotech.narutogame.data.repository.BattleRepository;
import com.gutotech.narutogame.data.repository.CharacterRepository;
import com.gutotech.narutogame.utils.DateCustom;
import com.gutotech.narutogame.utils.SingleLiveEvent;

public class DojoNpcFightersViewModel extends ViewModel {
    static final int MAX_DAILY_COMBAT = 30;

    private Battle mBattle;

    private SingleLiveEvent<Void> showProgressBar = new SingleLiveEvent<>();
    private SingleLiveEvent<Integer> showStatusEvent = new SingleLiveEvent<>();
    private SingleLiveEvent<Npc> showFightersEvent = new SingleLiveEvent<>();

    public DojoNpcFightersViewModel() {
        mBattle = new Battle();
    }

    void init() {
        if (CharOn.character.getNpcDailyCombat() < MAX_DAILY_COMBAT) {
            Formulas formulas = CharOn.character.getFormulas();

            if ((double) formulas.getCurrentHealth() / formulas.getHealth() >= 0.5 &&
                    (double) formulas.getCurrentChakra() / formulas.getChakra() >= 0.5 &&
                    (double) formulas.getCurrentStamina() / formulas.getStamina() >= 0.5) {
                showProgressBar.call();
                generateNpc();
            } else {
                showStatusEvent.setValue(R.string.too_weak_to_fight);
            }
        }
    }

    SingleLiveEvent<Void> getShowProgressBar() {
        return showProgressBar;
    }

    LiveData<Integer> getShowStatusEvent() {
        return showStatusEvent;
    }

    LiveData<Npc> getShowFightersEvent() {
        return showFightersEvent;
    }

    public Battle getBattle() {
        return mBattle;
    }

    private void generateNpc() {
        CharacterRepository.getInstance().getChar(CharOn.character.getNick(),
                npcCharacter -> {
                    Npc.create(npcCharacter);
                    mBattle.setPlayer2(npcCharacter);
                    mBattle.setPlayer1(CharOn.character);
                    showFightersEvent.call();
                }
        );
    }

    public void onAcceptBattleButtonPressed() {
        mBattle.setId(BattleRepository.getInstance().generateId("DOJO"));
        mBattle.setPlayer1(CharOn.character);
        mBattle.setAttackStart(DateCustom.getTimeInMillis());

        BattleRepository.getInstance().save(mBattle);

        CharOn.character.battleId = mBattle.getId();
        CharOn.character.setBattle(true);
    }
}
