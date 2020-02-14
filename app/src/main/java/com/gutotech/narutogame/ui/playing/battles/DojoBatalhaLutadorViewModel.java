package com.gutotech.narutogame.ui.playing.battles;

import android.os.CountDownTimer;
import android.view.View;

import androidx.databinding.ObservableField;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.Battle;
import com.gutotech.narutogame.data.model.BattleLog;
import com.gutotech.narutogame.data.model.CharOn;
import com.gutotech.narutogame.data.model.Character;
import com.gutotech.narutogame.data.model.Classe;
import com.gutotech.narutogame.data.model.Formulas;
import com.gutotech.narutogame.data.model.Jutsu;
import com.gutotech.narutogame.data.model.JutsuInfo;
import com.gutotech.narutogame.data.model.Npc;
import com.gutotech.narutogame.data.model.Score;
import com.gutotech.narutogame.data.repository.BattleRepository;
import com.gutotech.narutogame.data.repository.CharacterRepository;
import com.gutotech.narutogame.ui.adapter.JutsusAdapter;
import com.gutotech.narutogame.utils.DateCustom;
import com.gutotech.narutogame.utils.SingleLiveEvent;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class DojoBatalhaLutadorViewModel extends ViewModel implements JutsusAdapter.OnJutsuClickListener {
    private final long TIME_TO_ATTACK = 150000;

    private enum Status {WON, LOST, DRAWN, INACTIVATED, CONTINUE}

    private Status status = Status.CONTINUE;

    private BattleRepository mBattleRepository;

    private Battle mBattle;

    private Character player;
    private List<Jutsu> mAllJutsus;
    private MutableLiveData<List<Jutsu>> mJutsus = new MutableLiveData<>(new ArrayList<>());
    private Jutsu.Type mJutsuTypeSelected;

    private Npc npc;

    private Formulas playerFormulas;
    private Formulas npcFormulas;

    private MutableLiveData<List<Jutsu>> myBuffsDebuffsStatus = new MutableLiveData<>();
    private MutableLiveData<List<Jutsu>> oppBuffsDebuffsStatus = new MutableLiveData<>();

    private MutableLiveData<List<BattleLog>> mBattleLogs = new MutableLiveData<>(new ArrayList<>());

    private CountDownTimer mCountDownTimer;

    public final ObservableField<String> countDown = new ObservableField<>("--:--");

    SingleLiveEvent<Integer> showWarningDialogEvent = new SingleLiveEvent<>();
    SingleLiveEvent<View> startAnimationEvent = new SingleLiveEvent<>();
    SingleLiveEvent<Integer[]> showWonEvent = new SingleLiveEvent<>();
    SingleLiveEvent<Void> showLostEvent = new SingleLiveEvent<>();
    SingleLiveEvent<Void> showDrawnEvent = new SingleLiveEvent<>();
    SingleLiveEvent<Void> showInactivatedEvent = new SingleLiveEvent<>();

    private long elapsedTime;

    DojoBatalhaLutadorViewModel(Battle battle) {
        mBattle = battle;

        player = mBattle.getPlayer1();
        npc = new Npc(mBattle.getPlayer2());

        playerFormulas = player.getFormulas();
        npcFormulas = npc.getCharacter().getFormulas();

        myBuffsDebuffsStatus.setValue(mBattle.getPlayer1BuffsDebuffsStatus());
        oppBuffsDebuffsStatus.setValue(mBattle.getPlayer2BuffsDebuffsStatus());
        mBattleLogs.setValue(mBattle.getBattleLogs());

        mAllJutsus = player.getJutsus();
        filterJutsus(Jutsu.Type.ATK);

        mBattleRepository = BattleRepository.getInstance();

        init();
    }

    void init() {
        elapsedTime = Calendar.getInstance().getTimeInMillis() - mBattle.getAttackStart();

        if (mCountDownTimer == null) {
            startTimer();
        }
    }

    public Character getPlayer() {
        return player;
    }

    public Npc getNpc() {
        return npc;
    }

    public Formulas getPlayerFormulas() {
        return playerFormulas;
    }

    public Formulas getNpcFormulas() {
        return npcFormulas;
    }

    LiveData<List<BattleLog>> getBattleLogs() {
        return mBattleLogs;
    }

    LiveData<List<Jutsu>> getJutsus() {
        return mJutsus;
    }

    LiveData<List<Jutsu>> getMyBuffsDebuffsStatus() {
        return myBuffsDebuffsStatus;
    }

    LiveData<List<Jutsu>> getOppBuffsDebuffsStatus() {
        return oppBuffsDebuffsStatus;
    }

    @Override
    public boolean onJutsuClick(View view, Jutsu jutsu) {
        startAnimationEvent.setValue(view);

        JutsuInfo playerJutsuInfo = JutsuInfo.valueOf(jutsu.getName());

        if (jutsu.getRemainingIntervals() == 0) {
            if (playerJutsuInfo.type == Jutsu.Type.ATK || playerJutsuInfo.type == Jutsu.Type.DEF) {

                mCountDownTimer.cancel();

                Jutsu jutsuNpc = npc.attack();

                realizarAtaques(jutsu, playerJutsuInfo, jutsuNpc, JutsuInfo.valueOf(jutsuNpc.getName()));
                updateFightStatus();
            } else {
                if (playerJutsuInfo.type == Jutsu.Type.BUFF) {
                    addBuffOrDebuff(playerFormulas, jutsu);

                    List<Jutsu> buffsAndDebuffs = mBattle.getPlayer1BuffsDebuffsStatus();
                    buffsAndDebuffs.add(jutsu);
                    myBuffsDebuffsStatus.setValue(buffsAndDebuffs);
                } else if (playerJutsuInfo.type == Jutsu.Type.DEBUFF) {
                    addBuffOrDebuff(npcFormulas, jutsu);

                    List<Jutsu> buffsAndDebuffs = mBattle.getPlayer2BuffsDebuffsStatus();
                    buffsAndDebuffs.add(jutsu);
                    oppBuffsDebuffsStatus.setValue(buffsAndDebuffs);
                }

                playerFormulas.subChakra(jutsu.getConsumesChakra());
                playerFormulas.subStamina(jutsu.getConsumesStamina());

                addLog(new BattleLog(BattleLog.Type.BUFF_DEBUFF_WEAPON, player.getNick(),
                        playerJutsuInfo.name, jutsu));
            }

            if (status == Status.CONTINUE) {
                mBattle.setAttackStart(DateCustom.getTimeInMillis());
                elapsedTime = 0;
                saveBattle();

                updateRemainingIntervals();
                int jutsuIndex = mAllJutsus.indexOf(jutsu);
                jutsu.setRemainingIntervals(jutsu.getUsageInterval() - 1);
                mAllJutsus.set(jutsuIndex, jutsu);
                filterJutsus(mJutsuTypeSelected);
                startTimer();
            } else {
                finishFight();
            }
        } else {
            showWarningDialogEvent.setValue(R.string.jutsu_is_not_yet_available);
        }

        return true;
    }

    private void realizarAtaques(Jutsu playerJutsu, JutsuInfo playerJutsuInfo, Jutsu npcJutsu,
                                 JutsuInfo npcJutsuInfo) {
        int playerDamage = calcuteDamage(playerJutsu, playerJutsuInfo, playerFormulas, npcFormulas);
        int npcDamage = calcuteDamage(npcJutsu, npcJutsuInfo, npcFormulas, playerFormulas);

        if (playerDamage > 0 && npcDamage > 0) {
            playerFormulas.subHeath(npcDamage);
            npcFormulas.subHeath(playerDamage);
        } else if (playerDamage > 0 && npcDamage < 0) {
            npcDamage = Math.abs(npcDamage);
            npcFormulas.subHeath((playerDamage - npcDamage));
        } else if (playerDamage < 0 && npcDamage > 0) {
            playerDamage = Math.abs(playerDamage);
            playerFormulas.subHeath((npcDamage - playerDamage));
        }

        playerFormulas.subChakra(playerJutsu.getConsumesChakra());
        playerFormulas.subStamina(playerJutsu.getConsumesStamina());
        npcFormulas.subChakra(npcJutsu.getConsumesChakra());
        npcFormulas.subStamina(npcJutsu.getConsumesStamina());

        // Creates battle log
        addLog(new BattleLog(BattleLog.Type.USES, player.getNick(), playerJutsuInfo.name, playerJutsu));
        if (playerJutsuInfo.type == Jutsu.Type.ATK) {
            addLog(new BattleLog(BattleLog.Type.RECEIVES, npc.getCharacter().getNick(), playerDamage));
        }

        addLog(new BattleLog(BattleLog.Type.USES, npc.getCharacter().getNick(), npcJutsuInfo.name, npcJutsu));
        if (npcJutsuInfo.type == Jutsu.Type.ATK) {
            addLog(new BattleLog(BattleLog.Type.RECEIVES, player.getNick(), npcDamage));
        }

        addLog(new BattleLog(BattleLog.Type.END));
    }

    private int calcuteDamage(Jutsu jutsu, JutsuInfo jutsuInfo, Formulas myFormulas,
                              Formulas oppFormulas) {
        int damage;

        if (jutsuInfo.type == Jutsu.Type.ATK) {
            if (jutsu.getClasse() == Classe.NIN || jutsu.getClasse() == Classe.GEN) {
                damage = (jutsu.getAtk() + myFormulas.getAtkNinGen()) - oppFormulas.getDefNinGen();
            } else {
                damage = (jutsu.getAtk() + myFormulas.getAtkTaiBuki()) - oppFormulas.getDefNinGen();
            }
        } else {
            damage = (jutsu.getBaseDefense() + myFormulas.getDefNinGen()) * -1;
        }

        return damage;
    }


    private void addLog(BattleLog log) {
        List<BattleLog> logs = mBattle.getBattleLogs();
        logs.add(log);
        mBattleLogs.setValue(logs);
    }

    private void updateRemainingIntervals() {
        for (int i = 0; i < mAllJutsus.size(); i++) {
            Jutsu jutsu = mAllJutsus.get(i);

            if (jutsu.getRemainingIntervals() > 0) {
                jutsu.setRemainingIntervals(jutsu.getRemainingIntervals() - 1);

                if (jutsu.getRemainingIntervals() == 0) {
                    if (jutsu.getJutsuInfo().type == Jutsu.Type.BUFF) {
                        List<Jutsu> buffsAndDebuffs = myBuffsDebuffsStatus.getValue();
                        buffsAndDebuffs.remove(jutsu);
                        myBuffsDebuffsStatus.setValue(buffsAndDebuffs);
                        removeBuffDebuff(playerFormulas, jutsu);
                    } else if (jutsu.getJutsuInfo().type == Jutsu.Type.DEBUFF) {
                        List<Jutsu> buffsAndDebuffs = oppBuffsDebuffsStatus.getValue();
                        buffsAndDebuffs.remove(jutsu);
                        oppBuffsDebuffsStatus.setValue(buffsAndDebuffs);
                        removeBuffDebuff(npcFormulas, jutsu);
                    }
                }
            }
        }
    }

    private void addBuffOrDebuff(Formulas formulas, Jutsu buffOrDebuff) {
        formulas.setAtkTaiBuki(formulas.getAtkTaiBuki() + buffOrDebuff.getAtk());
        formulas.setAtkNinGen(formulas.getAtkNinGen() + buffOrDebuff.getAtk());
        formulas.setDefTaiBuki(formulas.getDefTaiBuki() + buffOrDebuff.getBaseDefense());
        formulas.setDefNinGen(formulas.getDefNinGen() + buffOrDebuff.getBaseDefense());
        formulas.setAccuracy(formulas.getAccuracy() + buffOrDebuff.getAccuracy());
    }

    private void removeBuffDebuff(Formulas formulas, Jutsu buffOrDebuff) {
        formulas.setAtkTaiBuki(formulas.getAtkTaiBuki() - buffOrDebuff.getAtk());
        formulas.setAtkNinGen(formulas.getAtkNinGen() - buffOrDebuff.getAtk());
        formulas.setDefTaiBuki(formulas.getDefTaiBuki() - buffOrDebuff.getBaseDefense());
        formulas.setDefNinGen(formulas.getDefNinGen() - buffOrDebuff.getBaseDefense());
        formulas.setAccuracy(formulas.getAccuracy() - buffOrDebuff.getAccuracy());
    }

    public void filterJutsus(Jutsu.Type filteredType) {
        mJutsuTypeSelected = filteredType;

        List<Jutsu> filteredJutsus = new ArrayList<>();

        for (int i = 0; i < mAllJutsus.size(); i++) {
            Jutsu jutsu = mAllJutsus.get(i);
            JutsuInfo jutsuInfo = jutsu.getJutsuInfo();

            if (filteredType == Jutsu.Type.ATK &&
                    (jutsuInfo.type == Jutsu.Type.ATK || jutsuInfo.type == Jutsu.Type.DEF)) {
                filteredJutsus.add(jutsu);
            } else if (filteredType == Jutsu.Type.BUFF &&
                    (jutsuInfo.type == Jutsu.Type.BUFF || jutsuInfo.type == Jutsu.Type.DEBUFF)) {
                filteredJutsus.add(jutsu);
            }
        }

        mJutsus.setValue(filteredJutsus);
    }

    private void updateFightStatus() {
        if ((npcFormulas.getCurrentHealth() < 10 || npcFormulas.getCurrentChakra() < 10 || npcFormulas.getCurrentStamina() < 10)
                && (playerFormulas.getCurrentHealth() < 10 || playerFormulas.getCurrentChakra() < 10 || playerFormulas.getCurrentStamina() < 10)) {
            status = Status.DRAWN;
        } else if (npcFormulas.getCurrentHealth() < 10 || npcFormulas.getCurrentChakra() < 10 || npcFormulas.getCurrentStamina() < 10) {
            status = Status.WON;
        } else if (playerFormulas.getCurrentHealth() < 10 || playerFormulas.getCurrentChakra() < 10 || playerFormulas.getCurrentStamina() < 10) {
            status = Status.LOST;
        } else {
            status = Status.CONTINUE;
        }
    }

    private void finishFight() {
        if (status == Status.WON) {
            CharOn.character.getCombatOverview().setWinsNpc(CharOn.character.getCombatOverview().getWinsNpc() + 1);

            int earnedRyous = 100;
            int earnedExp = 344 - (29 * player.getLevel()) > 0 ? 344 - (29 * player.getLevel()) : 0;

            CharOn.character.incrementExp(earnedExp);
            CharOn.character.addRyous(earnedRyous);
            CharOn.character.incrementScore(Score.VIT_DOJO_NPC);

            showWonEvent.setValue(new Integer[]{earnedRyous, earnedExp});
        } else if (status == Status.LOST) {
            CharOn.character.getCombatOverview().setLossesNpc(CharOn.character.getCombatOverview().getLossesNpc() + 1);
            CharOn.character.decrementScore(Score.DER_DOJO_NPC);
            showLostEvent.call();
        } else if (status == Status.DRAWN) {
            CharOn.character.getCombatOverview().setDrawsNpc(CharOn.character.getCombatOverview().getDrawsNpc() + 1);
            showDrawnEvent.call();
        } else {
            CharOn.character.getCombatOverview().setLossesNpc(CharOn.character.getCombatOverview().getLossesNpc() + 1);
            CharOn.character.decrementScore(Score.DER_DOJO_NPC);
            playerFormulas.setCurrentHealth(0);
            showInactivatedEvent.call();
        }

        CharOn.character.setNpcDailyCombat(CharOn.character.getNpcDailyCombat() + 1);
        CharOn.character.getFormulas().setCurrentHealth(playerFormulas.getCurrentHealth());
        CharOn.character.getFormulas().setCurrentChakra(playerFormulas.getCurrentChakra());
        CharOn.character.getFormulas().setCurrentStamina(playerFormulas.getCurrentStamina());
    }

    void exit() {
        CharOn.character.setBattle(false);
        CharOn.character.battleId = "";
        CharacterRepository.getInstance().save(CharOn.character);
        BattleRepository.getInstance().remove(CharOn.character.battleId);
    }

    private void startTimer() {
        mCountDownTimer = new CountDownTimer(TIME_TO_ATTACK - elapsedTime, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                countDown.set(String.format(Locale.getDefault(), "%02d:%02d",
                        TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished),
                        TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) -
                                TimeUnit.MINUTES.toSeconds(
                                        TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)
                                )
                        )
                );
            }

            @Override
            public void onFinish() {
                countDown.set("--:--");

                if (status == Status.CONTINUE) {
                    status = Status.INACTIVATED;
                    finishFight();
                }
            }
        }.start();
    }

    void stop() {
        if (mCountDownTimer != null) {
            mCountDownTimer.cancel();
            mCountDownTimer = null;
            saveBattle();
        }
    }

    private void saveBattle() {
        mBattleRepository.save(mBattle);
    }
}
