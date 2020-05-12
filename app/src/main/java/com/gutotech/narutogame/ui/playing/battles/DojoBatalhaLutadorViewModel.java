package com.gutotech.narutogame.ui.playing.battles;

import android.os.CountDownTimer;
import android.view.View;

import androidx.databinding.ObservableField;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.firebase.FirebaseFunctionsUtils;
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
import com.gutotech.narutogame.utils.SingleLiveEvent;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class DojoBatalhaLutadorViewModel extends ViewModel
        implements JutsusAdapter.OnJutsuClickListener {
    public final ObservableField<String> countDown = new ObservableField<>("--:--");

    private final long TIME_TO_ATTACK = 150000;

    private CountDownTimer mCountDownTimer;

    private BattleRepository mBattleRepository;

    private Battle mBattle;

    private Character mPlayer;
    private List<Jutsu> mAllJutsus;
    private MutableLiveData<List<Jutsu>> mJutsus = new MutableLiveData<>(new ArrayList<>());
    private Jutsu.Type mJutsuTypeSelected;

    private Npc mNpc;

    private Formulas mPlayerFormulas;
    private Formulas mNpcFormulas;

    private MutableLiveData<List<Jutsu>> mPlayerBuffsDebuffsStatus = new MutableLiveData<>();
    private MutableLiveData<List<Jutsu>> mOppBuffsDebuffsStatus = new MutableLiveData<>();

    private MutableLiveData<List<BattleLog>> mBattleLogs = new MutableLiveData<>(new ArrayList<>());

    SingleLiveEvent<Object[]> showJutsuInfoPopupEvent = new SingleLiveEvent<>();
    SingleLiveEvent<Integer> showWarningDialogEvent = new SingleLiveEvent<>();
    SingleLiveEvent<Integer[]> showWonEvent = new SingleLiveEvent<>();
    SingleLiveEvent<Void> showLostEvent = new SingleLiveEvent<>();
    SingleLiveEvent<Void> showDrawnEvent = new SingleLiveEvent<>();
    SingleLiveEvent<Void> showInactivatedEvent = new SingleLiveEvent<>();

    DojoBatalhaLutadorViewModel(Battle battle) {
        mBattle = battle;
        mBattleRepository = BattleRepository.getInstance();

        CharOn.character.setItemsEnabled(false);

        mPlayer = mBattle.getPlayer1();
        mNpc = new Npc(mBattle.getPlayer2());

        mPlayerFormulas = mPlayer.getFormulas();
        mNpcFormulas = mNpc.getCharacter().getFormulas();

        mPlayerBuffsDebuffsStatus.setValue(mBattle.getBuffsDebuffsUsed1());
        mOppBuffsDebuffsStatus.setValue(mBattle.getBuffsDebuffsUsed2());
        mBattleLogs.postValue(mBattle.getBattleLogs());

        mAllJutsus = mPlayer.getVisibleJutsus();
        filterJutsus(Jutsu.Type.ATK);

        if (mBattle.getStatus() == Battle.Status.CONTINUE) {
            FirebaseFunctionsUtils.getServerTime(currentTimestamp ->
                    startTimer(TIME_TO_ATTACK - (currentTimestamp - mBattle.getAttackStart()))
            );
        } else {
            showBattleResult();
        }
    }

    private void startTimer(long millisInFuture) {
        stopTimer();
        mCountDownTimer = new CountDownTimer(millisInFuture, 1000) {
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

                if (mBattle.getStatus() != Battle.Status.CONTINUE) {
                    return;
                }

                mBattle.setStatus(Battle.Status.PLAYER1_INACTIVATED);
                mPlayerFormulas.setCurrentHealth(0);

                showBattleResult();
            }
        }.start();
    }

    private void stopTimer() {
        if (mCountDownTimer != null) {
            mCountDownTimer.cancel();
            mCountDownTimer = null;
        }
    }


    @Override
    public void onJutsuClick(Jutsu jutsu) {
        if (jutsu.getRemainingIntervals() != 0) {
            showWarningDialogEvent.setValue(R.string.jutsu_is_not_yet_available);
            return;
        }

        if (jutsu.getConsumesChakra() > mPlayerFormulas.getCurrentChakra() ||
                jutsu.getConsumesStamina() > mPlayerFormulas.getCurrentStamina()) {
            showWarningDialogEvent.setValue(R.string.dont_have_chakra_to_use_this_jutsu);
            return;
        }

        JutsuInfo jutsuInfo = jutsu.getJutsuInfo();

        if (jutsuInfo.type == Jutsu.Type.ATK || jutsuInfo.type == Jutsu.Type.DEF) {
            stopTimer();

            Jutsu jutsuNpc = mNpc.attack();

            executeAttacks(jutsu, jutsuInfo, jutsuNpc, jutsuNpc.getJutsuInfo());

            updateFightStatus();

            if (mBattle.getStatus() == Battle.Status.CONTINUE) {
                updateRemainingIntervals();
                FirebaseFunctionsUtils.getServerTime(currentTimestamp -> {
                    mBattle.setAttackStart(currentTimestamp);
                    saveBattle();
                    startTimer(TIME_TO_ATTACK);
                });
            }
        } else if (!buffOrDebuffUsed(jutsuInfo.type)) {
            if (jutsuInfo.type == Jutsu.Type.BUFF) {
                addBuffOrDebuff(mPlayerFormulas, jutsu, jutsuInfo.type);
                List<Jutsu> buffsAndDebuffs = mBattle.getBuffsDebuffsUsed1();
                buffsAndDebuffs.add(jutsu);
                mPlayerBuffsDebuffsStatus.setValue(buffsAndDebuffs);
            } else if (jutsuInfo.type == Jutsu.Type.DEBUFF) {
                addBuffOrDebuff(mNpcFormulas, jutsu, jutsuInfo.type);
                List<Jutsu> buffsAndDebuffs = mBattle.getBuffsDebuffsUsed2();
                buffsAndDebuffs.add(jutsu);
                mOppBuffsDebuffsStatus.setValue(buffsAndDebuffs);
            }

            mPlayerFormulas.subChakra(jutsu.getConsumesChakra());
            mPlayerFormulas.subStamina(jutsu.getConsumesStamina());

            addLog(new BattleLog(mPlayer.getNick(), BattleLog.Action.BUFF_DEBUFF_WEAPON,
                    jutsuInfo.name, jutsu));
        } else {
            showWarningDialogEvent.setValue(R.string.jutsu_is_not_yet_available);
            return;
        }

        if (mBattle.getStatus() == Battle.Status.CONTINUE) {
            int jutsuIndex = mAllJutsus.indexOf(jutsu);
            if (jutsuInfo.type == Jutsu.Type.BUFF || jutsuInfo.type == Jutsu.Type.DEBUFF) {
                jutsu.setRemainingIntervals(jutsu.getUsageInterval());
            } else {
                jutsu.setRemainingIntervals(jutsu.getUsageInterval() - 1);
            }
            mAllJutsus.set(jutsuIndex, jutsu);
            filterJutsus(mJutsuTypeSelected);
        } else {
            showBattleResult();
        }
    }

    @Override
    public void onJutsuInfoClick(View anchor, Jutsu jutsu) {
        Object[] objects = new Object[3];
        objects[0] = calculateChanceOfSuccess(jutsu.getAccuracy(), mPlayerFormulas.getAccuracy());
        objects[1] = jutsu;
        objects[2] = anchor;
        showJutsuInfoPopupEvent.setValue(objects);
    }

    private boolean buffOrDebuffUsed(Jutsu.Type type) {
        if (type == Jutsu.Type.BUFF) {
            for (Jutsu jutsu : mPlayerBuffsDebuffsStatus.getValue()) {
                if (jutsu.getJutsuInfo().type == Jutsu.Type.BUFF) {
                    return true;
                }
            }
        } else {
            for (Jutsu jutsu : mOppBuffsDebuffsStatus.getValue()) {
                if (jutsu.getJutsuInfo().type == Jutsu.Type.DEBUFF) {
                    return true;
                }
            }
        }

        return false;
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

    private void updateRemainingIntervals() {
        int len = mAllJutsus.size();
        for (int i = 0; i < len; i++) {
            Jutsu jutsu = mAllJutsus.get(i);

            if (jutsu.getRemainingIntervals() > 0) {
                jutsu.setRemainingIntervals(jutsu.getRemainingIntervals() - 1);

                if (jutsu.getRemainingIntervals() == 0) {
                    Jutsu.Type type = jutsu.getJutsuInfo().type;
                    if (type == Jutsu.Type.BUFF) {
                        List<Jutsu> buffsAndDebuffs = mPlayerBuffsDebuffsStatus.getValue();
                        buffsAndDebuffs.remove(jutsu);
                        mPlayerBuffsDebuffsStatus.setValue(buffsAndDebuffs);
                        removeBuffDebuff(mPlayerFormulas, jutsu, type);
                    } else if (type == Jutsu.Type.DEBUFF) {
                        List<Jutsu> buffsAndDebuffs = mOppBuffsDebuffsStatus.getValue();
                        buffsAndDebuffs.remove(jutsu);
                        mOppBuffsDebuffsStatus.setValue(buffsAndDebuffs);
                        removeBuffDebuff(mNpcFormulas, jutsu, type);
                    }
                }
            }
        }
    }

    private void addBuffOrDebuff(Formulas formulas, Jutsu buffOrDebuff, Jutsu.Type type) {
        if (type == Jutsu.Type.BUFF) {
            if (buffOrDebuff.getClasse() == Classe.NIN || buffOrDebuff.getClasse() == Classe.GEN) {
                formulas.setAtkNinGen(formulas.getAtkNinGen() + buffOrDebuff.getAtk());
            } else {
                formulas.setAtkTaiBuki(formulas.getAtkTaiBuki() + buffOrDebuff.getAtk());
            }
        }
        formulas.setDefTaiBuki(formulas.getDefTaiBuki() + buffOrDebuff.getBaseDefense());
        formulas.setDefNinGen(formulas.getDefNinGen() + buffOrDebuff.getBaseDefense());
        formulas.setAccuracy(formulas.getAccuracy() + buffOrDebuff.getAccuracy());
    }

    private void removeBuffDebuff(Formulas formulas, Jutsu buffOrDebuff, Jutsu.Type type) {
        if (type == Jutsu.Type.BUFF) {
            if (buffOrDebuff.getClasse() == Classe.NIN || buffOrDebuff.getClasse() == Classe.GEN) {
                formulas.setAtkNinGen(formulas.getAtkNinGen() - buffOrDebuff.getAtk());
            } else {
                formulas.setAtkTaiBuki(formulas.getAtkTaiBuki() - buffOrDebuff.getAtk());
            }
        } else {
            formulas.setAtkTaiBuki(formulas.getAtkTaiBuki() - buffOrDebuff.getAtk());
            formulas.setAtkNinGen(formulas.getAtkNinGen() - buffOrDebuff.getAtk());
        }
        formulas.setDefTaiBuki(formulas.getDefTaiBuki() - buffOrDebuff.getBaseDefense());
        formulas.setDefNinGen(formulas.getDefNinGen() - buffOrDebuff.getBaseDefense());
        formulas.setAccuracy(formulas.getAccuracy() - buffOrDebuff.getAccuracy());
    }


    private void executeAttacks(Jutsu myJutsu, JutsuInfo myJutsuInfo, Jutsu oppJutsu,
                                JutsuInfo oppJutsuInfo) {
        int myChanceOfError = calculateChanceOfError(myJutsu.getAccuracy(), mPlayerFormulas.getAccuracy());

        boolean myMissed = missedTheJutsu(myChanceOfError);

        int myDamage = 0;
        int oppDamage = calculateDamage(oppJutsu, oppJutsuInfo, mNpcFormulas, mPlayerFormulas);

        if (myMissed) {
            if (oppDamage > 0) {
                mPlayerFormulas.subHeath(oppDamage);
            }
        } else {
            myDamage = calculateDamage(myJutsu, myJutsuInfo, mPlayerFormulas, mNpcFormulas);

            if (myDamage > 0 && oppDamage > 0) {
                mPlayerFormulas.subHeath(oppDamage);
                mNpcFormulas.subHeath(myDamage);
            } else if (myDamage > 0 && oppDamage < 0) {
                myDamage = myDamage - Math.abs(oppDamage);
                mNpcFormulas.subHeath(myDamage);
            } else if (myDamage < 0 && oppDamage > 0) {
                oppDamage = oppDamage - Math.abs(myDamage);
                mPlayerFormulas.subHeath(oppDamage);
            }
        }

        mPlayerFormulas.subChakra(myJutsu.getConsumesChakra());
        mPlayerFormulas.subStamina(myJutsu.getConsumesStamina());
        mNpcFormulas.subChakra(oppJutsu.getConsumesChakra());
        mNpcFormulas.subStamina(oppJutsu.getConsumesStamina());

        // Creates battle log
        addLog(new BattleLog(mPlayer.getNick(), BattleLog.Action.USES, myJutsuInfo.name, myJutsu,
                calculateChanceOfSuccess(myJutsu.getAccuracy(), mPlayerFormulas.getAccuracy())));
        if (myMissed) {
            addLog(new BattleLog(mPlayer.getNick(), BattleLog.Action.MISSED));
        } else {
            if (myJutsuInfo.type == Jutsu.Type.ATK) {
                addLog(new BattleLog(mNpc.getCharacter().getNick(), BattleLog.Action.RECEIVES, myDamage));
            }
        }

        addLog(new BattleLog(mNpc.getCharacter().getNick(), BattleLog.Action.USES, oppJutsuInfo.name,
                oppJutsu, 100));
        if (oppJutsuInfo.type == Jutsu.Type.ATK) {
            addLog(new BattleLog(mPlayer.getNick(), BattleLog.Action.RECEIVES, oppDamage));
        }

        addLog(new BattleLog(BattleLog.Action.END));
    }

    private int calculateChanceOfSuccess(int jutsuAccuracy, int currentAccuracy) {
        int chanceOfSuccess;

        try {
            chanceOfSuccess = (int) ((double) currentAccuracy / jutsuAccuracy * 100);
        } catch (ArithmeticException e) {
            chanceOfSuccess = 100;
        }

        if (chanceOfSuccess > 100) {
            chanceOfSuccess = 100;
        } else if (chanceOfSuccess < 0) {
            chanceOfSuccess = 0;
        }

        return chanceOfSuccess;
    }

    private int calculateChanceOfError(int jutsuAccuracy, int currentAccuracy) {
        return 100 - calculateChanceOfSuccess(jutsuAccuracy, currentAccuracy);
    }

    private final SecureRandom random = new SecureRandom();

    private boolean missedTheJutsu(int chanceOfError) {
        int n = random.nextInt(100);
        return n < chanceOfError;
    }

    private int calculateDamage(Jutsu jutsu, JutsuInfo jutsuInfo, Formulas myFormulas,
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


    private void updateFightStatus() {
        if ((mNpcFormulas.getCurrentHealth() < 10 || mNpcFormulas.getCurrentChakra() < 10 ||
                mNpcFormulas.getCurrentStamina() < 10) &&
                (mPlayerFormulas.getCurrentHealth() < 10 || mPlayerFormulas.getCurrentChakra() < 10 ||
                        mPlayerFormulas.getCurrentStamina() < 10)) {
            mBattle.setStatus(Battle.Status.DRAWN);
        } else if (mNpcFormulas.getCurrentHealth() < 10 || mNpcFormulas.getCurrentChakra() < 10 ||
                mNpcFormulas.getCurrentStamina() < 10) {
            mBattle.setStatus(Battle.Status.PLAYER1_WON);
        } else if (mPlayerFormulas.getCurrentHealth() < 10 || mPlayerFormulas.getCurrentChakra() < 10 ||
                mPlayerFormulas.getCurrentStamina() < 10) {
            mBattle.setStatus(Battle.Status.PLAYER2_WON);
        } else {
            mBattle.setStatus(Battle.Status.CONTINUE);
        }
    }

    private void showBattleResult() {
        if (mBattle.getStatus() == Battle.Status.PLAYER1_WON) {
            int earnedRyous = 10 * CharOn.character.getLevel() + 100;
            int earnedExp = Math.max(300 - 20 * CharOn.character.getLevel(), 0);

            showWonEvent.setValue(new Integer[]{earnedRyous, earnedExp});
        } else if (mBattle.getStatus() == Battle.Status.PLAYER2_WON) {
            showLostEvent.call();
        } else if (mBattle.getStatus() == Battle.Status.DRAWN) {
            showDrawnEvent.call();
        } else {
            mPlayerFormulas.setCurrentHealth(0);
            showInactivatedEvent.call();
        }
        saveBattle();
    }

    void exit() {
        CharOn.character.setNpcDailyCombat(CharOn.character.getNpcDailyCombat() + 1);
        CharOn.character.getFormulas().setCurrentHealth(mPlayerFormulas.getCurrentHealth());
        CharOn.character.getFormulas().setCurrentChakra(mPlayerFormulas.getCurrentChakra());
        CharOn.character.getFormulas().setCurrentStamina(mPlayerFormulas.getCurrentStamina());

        if (mBattle.getStatus() == Battle.Status.PLAYER1_WON) {
            CharOn.character.getCombatOverview().setWinsNpc(
                    CharOn.character.getCombatOverview().getWinsNpc() + 1);

            int earnedRyous = 10 * CharOn.character.getLevel() + 100;
            int earnedExp = Math.max(300 - 20 * CharOn.character.getLevel(), 0);

            CharOn.character.addRyous(earnedRyous);
            CharOn.character.incrementExp(earnedExp);
            CharOn.character.incrementScore(Score.VIT_DOJO_NPC);
        } else if (mBattle.getStatus() == Battle.Status.PLAYER2_WON) {
            CharOn.character.getCombatOverview().setLossesNpc(
                    CharOn.character.getCombatOverview().getLossesNpc() + 1);
            CharOn.character.decrementScore(Score.DER_DOJO_NPC);
        } else if (mBattle.getStatus() == Battle.Status.DRAWN) {
            CharOn.character.getCombatOverview().setDrawsNpc(
                    CharOn.character.getCombatOverview().getDrawsNpc() + 1);
        } else {
            CharOn.character.getCombatOverview().setLossesNpc(
                    CharOn.character.getCombatOverview().getLossesNpc() + 1);
            CharOn.character.decrementScore(Score.DER_DOJO_NPC);
        }

        mBattleRepository.delete(mBattle.getId());

        CharOn.character.setBattleId("");
        CharOn.character.setItemsEnabled(true);
        CharOn.character.setBattle(false);
        CharacterRepository.getInstance().save(CharOn.character);
    }

    private void saveBattle() {
        mBattleRepository.save(mBattle);
    }


    public Character getPlayer() {
        return mPlayer;
    }

    public Npc getNpc() {
        return mNpc;
    }

    public Formulas getPlayerFormulas() {
        return mPlayerFormulas;
    }

    public Formulas getNpcFormulas() {
        return mNpcFormulas;
    }

    LiveData<List<BattleLog>> getBattleLogs() {
        return mBattleLogs;
    }

    LiveData<List<Jutsu>> getJutsus() {
        return mJutsus;
    }

    LiveData<List<Jutsu>> getMyBuffsDebuffsStatus() {
        return mPlayerBuffsDebuffsStatus;
    }

    LiveData<List<Jutsu>> getOppBuffsDebuffsStatus() {
        return mOppBuffsDebuffsStatus;
    }
}
