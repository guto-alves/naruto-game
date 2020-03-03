package com.gutotech.narutogame.ui.playing.battles;

import android.app.Application;
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
import com.gutotech.narutogame.data.model.Fighters;
import com.gutotech.narutogame.data.model.Formulas;
import com.gutotech.narutogame.data.model.Jutsu;
import com.gutotech.narutogame.data.model.JutsuInfo;
import com.gutotech.narutogame.data.model.Score;
import com.gutotech.narutogame.data.repository.BattleRepository;
import com.gutotech.narutogame.ui.adapter.JutsusAdapter;
import com.gutotech.narutogame.utils.DateCustom;
import com.gutotech.narutogame.utils.SingleLiveEvent;
import com.gutotech.narutogame.utils.SoundUtils;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class DojoBattlePvpViewModel extends ViewModel
        implements JutsusAdapter.OnJutsuClickListener {
    private final long TIME_TO_ATTACK = 90000;

    private Application mApplication;

    private BattleRepository mBattleRepository;

    private Battle mBattle;

    public int myTurn;
    private Character player;
    private List<Jutsu> mAllJutsus;
    private MutableLiveData<List<Jutsu>> mJutsus = new MutableLiveData<>(new ArrayList<>());
    private Jutsu.Type mJutsuTypeSelected;

    private Character opponent;

    private Formulas playerFormulas;
    private Formulas oppFormulas;

    private Fighters fighters = new Fighters();

    private MutableLiveData<List<Jutsu>> myBuffsDebuffsStatus = new MutableLiveData<>();
    private MutableLiveData<List<Jutsu>> oppBuffsDebuffsStatus = new MutableLiveData<>();

    private CountDownTimer mCountDownTimer;
    public final ObservableField<String> countDown = new ObservableField<>("--:--");

    private MutableLiveData<List<BattleLog>> mBattleLogs = new MutableLiveData<>(new ArrayList<>());

    SingleLiveEvent<Object[]> showJutsuInfoPopupEvent = new SingleLiveEvent<>();
    SingleLiveEvent<Integer> showWarningDialogEvent = new SingleLiveEvent<>();
    SingleLiveEvent<View> startAnimationEvent = new SingleLiveEvent<>();
    SingleLiveEvent<Integer[]> showWonEvent = new SingleLiveEvent<>();
    SingleLiveEvent<Void> showLostEvent = new SingleLiveEvent<>();
    SingleLiveEvent<Void> showDrawnEvent = new SingleLiveEvent<>();
    SingleLiveEvent<Void> showInactivatedEvent = new SingleLiveEvent<>();

    private long elapsedTime;

    DojoBattlePvpViewModel(Application application, Battle battle) {
        mApplication = application;
        mBattle = battle;

        updateFighters();

        mBattleRepository = BattleRepository.getInstance();

        if (mBattle.getStatus() == Battle.Status.CONTINUE) {
            init();
            observeBattle();
            mAllJutsus = player.getJutsus();
            filterJutsus(Jutsu.Type.ATK);
        } else {
            finishFight();
        }
    }

    void init() {
        elapsedTime = Calendar.getInstance().getTimeInMillis() - mBattle.getAttackStart();

        if (mCountDownTimer == null) {
            startTimer();
        }
    }

    public Battle getBattle() {
        return mBattle;
    }

    public void setBattle(Battle mBattle) {
        this.mBattle = mBattle;
    }

    public Fighters getFighters() {
        return fighters;
    }

    public Character getPlayer() {
        return player;
    }

    public Character getOpponent() {
        return opponent;
    }

    public Formulas getPlayerFormulas() {
        return playerFormulas;
    }

    public Formulas getOppFormulas() {
        return oppFormulas;
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
    public void onJutsuClick(View view, Jutsu jutsu) {
        startAnimationEvent.setValue(view);

        if (mBattle.getCurrentPlayer() != myTurn) {
            showWarningDialogEvent.setValue(R.string.it_is_not_your_turn_to_attack);
            return;
        }

        if (jutsu.getRemainingIntervals() != 0) {
            showWarningDialogEvent.setValue(R.string.jutsu_is_not_yet_available);
            return;
        }

        if (jutsu.getConsumesChakra() > playerFormulas.getCurrentChakra() ||
                jutsu.getConsumesStamina() > playerFormulas.getCurrentStamina()) {
            showWarningDialogEvent.setValue(R.string.dont_have_chakra_to_use_this_jutsu);
            return;
        }

        JutsuInfo playerJutsuInfo = jutsu.getJutsuInfo();

        if (playerJutsuInfo.type == Jutsu.Type.ATK || playerJutsuInfo.type == Jutsu.Type.DEF) {
            mCountDownTimer.cancel();

            if (myTurn == 2) {
                executeAttacks(jutsu, playerJutsuInfo, mBattle.getOppJutsu(), mBattle.getOppJutsu().getJutsuInfo());
                updateFightStatus();
            } else {
                mBattle.setOppJutsu(jutsu);
            }

            updateRemainingIntervals();

            mBattle.setCurrentPlayer(mBattle.getCurrentPlayer() % 2 + 1);
            mBattle.setAttackStart(DateCustom.getTimeInMillis());
        } else {
            if (!buffOrDebuffUsed(playerJutsuInfo.type)) {
                if (playerJutsuInfo.type == Jutsu.Type.BUFF) {
                    addBuffOrDebuff(playerFormulas, jutsu);

                    List<Jutsu> buffsAndDebuffs;
                    if (mBattle.getPlayer1().getNick().equals(CharOn.character.getNick())) {
                        buffsAndDebuffs = mBattle.getPlayer1BuffsDebuffsStatus();
                    } else {
                        buffsAndDebuffs = mBattle.getPlayer2BuffsDebuffsStatus();
                    }

                    buffsAndDebuffs.add(jutsu);
                    myBuffsDebuffsStatus.setValue(buffsAndDebuffs);
                } else if (playerJutsuInfo.type == Jutsu.Type.DEBUFF) {
                    addBuffOrDebuff(oppFormulas, jutsu);

                    List<Jutsu> buffsAndDebuffs;
                    if (mBattle.getPlayer1().getNick().equals(CharOn.character.getNick())) {
                        buffsAndDebuffs = mBattle.getPlayer1BuffsDebuffsStatus();
                    } else {
                        buffsAndDebuffs = mBattle.getPlayer2BuffsDebuffsStatus();
                    }

                    buffsAndDebuffs.add(jutsu);
                    oppBuffsDebuffsStatus.setValue(buffsAndDebuffs);
                }

                playerFormulas.subChakra(jutsu.getConsumesChakra());
                playerFormulas.subStamina(jutsu.getConsumesStamina());

                addLog(new BattleLog(player.getNick(), BattleLog.Type.BUFF_DEBUFF_WEAPON,
                        playerJutsuInfo.name, jutsu));
            } else {
                return;
            }
        }

        saveBattle();

        if (mBattle.getStatus() == Battle.Status.CONTINUE) {
            int jutsuIndex = mAllJutsus.indexOf(jutsu);
            jutsu.setRemainingIntervals(jutsu.getUsageInterval() - 1);
            mAllJutsus.set(jutsuIndex, jutsu);
            filterJutsus(mJutsuTypeSelected);
        }
    }

    @Override
    public void onJutsuInfoClick(View anchor, Jutsu jutsu) {
        Object[] objects = new Object[3];
        objects[0] = calculateChanceOfSuccess(jutsu.getAccuracy(), playerFormulas.getAccuracy());
        objects[1] = jutsu;
        objects[2] = anchor;

        showJutsuInfoPopupEvent.setValue(objects);
    }

    private boolean buffOrDebuffUsed(Jutsu.Type type) {
        if (type == Jutsu.Type.BUFF) {
            for (Jutsu jutsu : myBuffsDebuffsStatus.getValue()) {
                if (jutsu.getJutsuInfo().type == Jutsu.Type.BUFF) {
                    return true;
                }
            }
        } else {
            for (Jutsu jutsu : oppBuffsDebuffsStatus.getValue()) {
                if (jutsu.getJutsuInfo().type == Jutsu.Type.DEBUFF) {
                    return true;
                }
            }
        }

        return false;
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

    private void executeAttacks(Jutsu myJutsu, JutsuInfo myJutsuInfo, Jutsu oppJutsu,
                                JutsuInfo oppJutsuInfo) {
        int myChanceOfError = calculateChanceOfError(myJutsu.getAccuracy(), playerFormulas.getAccuracy());
        int oppChanceOfError = calculateChanceOfError(oppJutsu.getAccuracy(), oppFormulas.getAccuracy());

        boolean myMissed = missedTheJutsu(myChanceOfError);
        boolean oppMissed = missedTheJutsu(oppChanceOfError);

        int myDamage = calcuteDamage(myJutsu, myJutsuInfo, playerFormulas, oppFormulas);
        int oppDamage = calcuteDamage(oppJutsu, oppJutsuInfo, oppFormulas, playerFormulas);

        if (!myMissed && !oppMissed) {
            if (myDamage > 0 && oppDamage > 0) {
                playerFormulas.subHeath(oppDamage);
                oppFormulas.subHeath(myDamage);
            } else if (myDamage > 0 && oppDamage < 0) {
                myDamage = myDamage - Math.abs(oppDamage);
                oppFormulas.subHeath(myDamage);
            } else if (myDamage < 0 && oppDamage > 0) {
                oppDamage = oppDamage - Math.abs(myDamage);
                playerFormulas.subHeath(oppDamage);
            }
        } else if (myMissed && !oppMissed) {
            if (oppDamage > 0) {
                playerFormulas.subHeath(oppDamage);
            }
        } else if (!myMissed) {
            if (myDamage > 0) {
                oppFormulas.subHeath(oppDamage);
            }
        }

        playerFormulas.subChakra(myJutsu.getConsumesChakra());
        playerFormulas.subStamina(myJutsu.getConsumesStamina());
        oppFormulas.subChakra(oppJutsu.getConsumesChakra());
        oppFormulas.subStamina(oppJutsu.getConsumesStamina());

        // Creates battle log
        addLog(new BattleLog(player.getNick(), BattleLog.Type.USES, myJutsuInfo.name, myJutsu,
                calculateChanceOfSuccess(myJutsu.getAccuracy(), playerFormulas.getAccuracy())));
        if (myMissed) {
            addLog(new BattleLog(player.getNick(), BattleLog.Type.MISSED));
        } else {
            if (myJutsuInfo.type == Jutsu.Type.ATK) {
                addLog(new BattleLog(opponent.getNick(), BattleLog.Type.RECEIVES, myDamage));
            }
        }

        addLog(new BattleLog(opponent.getNick(), BattleLog.Type.USES, oppJutsuInfo.name,
                oppJutsu, calculateChanceOfSuccess(oppJutsu.getAccuracy(), oppFormulas.getAccuracy())));
        if (oppMissed) {
            addLog(new BattleLog(opponent.getNick(), BattleLog.Type.MISSED));
        } else {
            if (oppJutsuInfo.type == Jutsu.Type.ATK) {
                addLog(new BattleLog(player.getNick(), BattleLog.Type.RECEIVES, oppDamage));
            }
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
        mBattle.getBattleLogs().add(log);
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
                        removeBuffDebuff(oppFormulas, jutsu);
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
        if ((oppFormulas.getCurrentHealth() < 10 || oppFormulas.getCurrentChakra() < 10 || oppFormulas.getCurrentStamina() < 10)
                && (playerFormulas.getCurrentHealth() < 10 || playerFormulas.getCurrentChakra() < 10 || playerFormulas.getCurrentStamina() < 10)) {
            mBattle.setStatus(Battle.Status.DRAWN);
        } else if (oppFormulas.getCurrentHealth() < 10 || oppFormulas.getCurrentChakra() < 10 || oppFormulas.getCurrentStamina() < 10) {
            mBattle.setStatus(myTurn == 1 ? Battle.Status.PLAYER1_WON : Battle.Status.PLAYER2_WON);
        } else if (playerFormulas.getCurrentHealth() < 10 || playerFormulas.getCurrentChakra() < 10 || playerFormulas.getCurrentStamina() < 10) {
            mBattle.setStatus(myTurn == 1 ? Battle.Status.PLAYER2_WON : Battle.Status.PLAYER1_WON);
        } else {
            mBattle.setStatus(Battle.Status.CONTINUE);
        }
    }

    private void finishFight() {
        if (mBattle.getStatus() == Battle.Status.PLAYER1_WON && myTurn == 1) {
            int earnedRyous = 100;
            int earnedExp = 344 - (29 * player.getLevel()) > 0 ? 344 - (29 * player.getLevel()) : 0;

            showWonEvent.setValue(new Integer[]{earnedRyous, earnedExp});
        } else if (mBattle.getStatus() == Battle.Status.PLAYER2_WON && myTurn == 2) {
            showLostEvent.call();
        } else if (mBattle.getStatus() == Battle.Status.DRAWN) {
            showDrawnEvent.call();
        } else {
            playerFormulas.setCurrentHealth(0);
            showInactivatedEvent.call();
        }

        saveBattle();
    }

    void exit() {
        CharOn.character.getFormulas().setCurrentHealth(playerFormulas.getCurrentHealth());
        CharOn.character.getFormulas().setCurrentChakra(playerFormulas.getCurrentChakra());
        CharOn.character.getFormulas().setCurrentStamina(playerFormulas.getCurrentStamina());
        CharOn.character.getAttributes().incrementTraningPoints(50);
        CharOn.character.getExtrasInformation().incrementTotalTraining(50);

        if ((mBattle.getStatus() == Battle.Status.PLAYER1_WON && myTurn == 1) ||
                (mBattle.getStatus() == Battle.Status.PLAYER2_WON && myTurn == 2)) {
            CharOn.character.getCombatOverview().setWinsMapPvp(CharOn.character.getCombatOverview().getWinsMapPvp() + 1);

            int earnedRyous = 100;
            int earnedExp = 344 - (29 * player.getLevel()) > 0 ? 344 - (29 * player.getLevel()) : 0;

            CharOn.character.incrementExp(earnedExp);
            CharOn.character.addRyous(earnedRyous);
            CharOn.character.incrementScore(Score.VIT_MAPA_PVP);
        } else if (mBattle.getStatus() == Battle.Status.DRAWN) {
            CharOn.character.getCombatOverview().setDrawsPvp(CharOn.character.getCombatOverview().getDrawsPvp() + 1);
        } else {
            CharOn.character.getCombatOverview().setLossesNpc(CharOn.character.getCombatOverview().getLossesMapPvp() + 1);
            CharOn.character.decrementScore(Score.DER_MAPA_PVP);
        }

        int playerCount = mBattle.getPlayerCount() - 1;

        mBattleRepository.removeBattleListener();

        if (playerCount == 0) {
            mBattleRepository.delete(mBattle.getId());
        } else {
            mBattle.setPlayerCount(playerCount);
        }

        mBattleRepository.save(mBattle);

        CharOn.character.battleId = "";
        CharOn.character.setBattle(false);
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

                if (mBattle.getCurrentPlayer() != myTurn) {
                    mBattle.setStatus(Battle.Status.PLAYER1_WON);
                } else {
                    mBattle.setStatus(Battle.Status.PLAYER2_WON);
                    playerFormulas.setCurrentHealth(0);
                }

                finishFight();
            }
        }.start();
    }

    private void stopTimer() {
        if (mCountDownTimer != null) {
            mCountDownTimer.cancel();
            mCountDownTimer = null;
        }
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

    private void observeBattle() {
        mBattleRepository.observeBattle(mBattle.getId(), battle -> {
            if (battle.getCurrentPlayer() != mBattle.getCurrentPlayer()) {
                SoundUtils.play(mApplication, R.raw.crystal);
            }

            mBattle.setStatus(battle.getStatus());
            mBattle.setAttackStart(battle.getAttackStart());
            mBattle.setCurrentPlayer(battle.getCurrentPlayer());
            mBattle.setPlayer1(battle.getPlayer1());
            mBattle.setPlayer2(battle.getPlayer2());
            mBattle.setPlayer1BuffsDebuffsStatus(battle.getPlayer1BuffsDebuffsStatus());
            mBattle.setPlayer2BuffsDebuffsStatus(battle.getPlayer2BuffsDebuffsStatus());
            mBattle.setBattleLogs(battle.getBattleLogs());
            mBattle.setOppJutsu(battle.getOppJutsu());
            mBattle.setPlayerCount(battle.getPlayerCount());

            updateFighters();

            if (mBattle.getStatus() == Battle.Status.CONTINUE) {
                stopTimer();
                elapsedTime = Calendar.getInstance().getTimeInMillis() - mBattle.getAttackStart();
                startTimer();
            } else {
                finishFight();
            }
        });
    }

    private void updateFighters() {
        if (mBattle.getPlayer1().getNick().equals(CharOn.character.getNick())) {
            fighters.setPlayer(mBattle.getPlayer1());
            fighters.setOpponent(mBattle.getPlayer2());
            player = mBattle.getPlayer1();
            opponent = mBattle.getPlayer2();
            myBuffsDebuffsStatus.setValue(mBattle.getPlayer1BuffsDebuffsStatus());
            oppBuffsDebuffsStatus.setValue(mBattle.getPlayer2BuffsDebuffsStatus());
            myTurn = 1;
        } else {
            fighters.setPlayer(mBattle.getPlayer2());
            fighters.setOpponent(mBattle.getPlayer1());
            player = mBattle.getPlayer2();
            opponent = mBattle.getPlayer1();
            myBuffsDebuffsStatus.setValue(mBattle.getPlayer2BuffsDebuffsStatus());
            oppBuffsDebuffsStatus.setValue(mBattle.getPlayer1BuffsDebuffsStatus());
            myTurn = 2;
        }

        playerFormulas = player.getFormulas();
        oppFormulas = opponent.getFormulas();

        mBattleLogs.setValue(mBattle.getBattleLogs());
    }
}

