package com.gutotech.narutogame.ui.playing.battles;

import android.app.Application;
import android.os.CountDownTimer;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.Battle;
import com.gutotech.narutogame.data.model.BattleLog;
import com.gutotech.narutogame.data.model.CharOn;
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
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class DojoBattlePvpViewModel extends AndroidViewModel
        implements JutsusAdapter.OnJutsuClickListener {
    private static final SecureRandom random = new SecureRandom();

    private final long TIME_TO_ATTACK = 90000;
    public final ObservableField<String> countDown = new ObservableField<>("--:--");
    private CountDownTimer mCountDownTimer;

    private BattleRepository mBattleRepository;

    private Battle mBattle;
    private Fighters mFighters;

    private Formulas mPlayerFormulas;
    private Formulas mOppFormulas;

    public int myTurn;

    private List<Jutsu> mAllJutsus;
    private MutableLiveData<List<Jutsu>> mJutsus = new MutableLiveData<>(new ArrayList<>());
    private Jutsu.Type mJutsuTypeSelected;

    private MutableLiveData<List<Jutsu>> myBuffsDebuffsStatus = new MutableLiveData<>();
    private MutableLiveData<List<Jutsu>> oppBuffsDebuffsStatus = new MutableLiveData<>();
    private MutableLiveData<List<BattleLog>> mBattleLogs = new MutableLiveData<>(new ArrayList<>());

    SingleLiveEvent<Object[]> showJutsuInfoPopupEvent = new SingleLiveEvent<>();
    SingleLiveEvent<Integer> showWarningDialogEvent = new SingleLiveEvent<>();
    SingleLiveEvent<View> startAnimationEvent = new SingleLiveEvent<>();
    SingleLiveEvent<Integer[]> showWonEvent = new SingleLiveEvent<>();
    SingleLiveEvent<Void> showLostEvent = new SingleLiveEvent<>();
    SingleLiveEvent<Void> showDrawnEvent = new SingleLiveEvent<>();
    SingleLiveEvent<Void> showInactivatedEvent = new SingleLiveEvent<>();

    DojoBattlePvpViewModel(@NonNull Application application) {
        super(application);

        mBattle = new Battle();
        mBattle.setId(CharOn.character.battleId);

        mFighters = new Fighters();

        mBattleRepository = BattleRepository.getInstance();

        mJutsuTypeSelected = Jutsu.Type.ATK;

        observeBattle();
    }

    public Battle getBattle() {
        return mBattle;
    }

    public void setBattle(Battle mBattle) {
        this.mBattle = mBattle;
    }

    public Fighters getFighters() {
        return mFighters;
    }

    public Formulas getPlayerFormulas() {
        return mPlayerFormulas;
    }

    public Formulas getOppFormulas() {
        return mOppFormulas;
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


    private void observeBattle() {
        mBattleRepository.observeBattle(mBattle.getId(), battle -> {
            mBattle.setStatus(battle.getStatus());
            mBattle.setPlayer1(battle.getPlayer1());
            mBattle.setPlayer2(battle.getPlayer2());
            mBattle.setCurrentPlayer(battle.getCurrentPlayer());
            mBattle.setOppJutsu(battle.getOppJutsu());
            mBattle.setPlayer1BuffsDebuffsStatus(battle.getPlayer1BuffsDebuffsStatus());
            mBattle.setPlayer2BuffsDebuffsStatus(battle.getPlayer2BuffsDebuffsStatus());
            mBattle.setBattleLogs(battle.getBattleLogs());
            mBattle.setPlayerCount(battle.getPlayerCount());

            updateFighters();

            if (mBattle.getStatus() == Battle.Status.CONTINUE) {
                if (battle.getCurrentPlayer() == myTurn && battle.getAttackStart() != mBattle.getAttackStart()) {
                    SoundUtils.play(getApplication(), R.raw.battle);
                }

                mBattle.setAttackStart(battle.getAttackStart());

                stopTimer();
                startTimer(calculateElapsedTime());
                mAllJutsus = mFighters.getPlayer().getJutsus();
                filterJutsus(mJutsuTypeSelected);
            } else {
                showBattleResult();
            }
        });
    }

    private void updateFighters() {
        if (mBattle.getPlayer1().equals(CharOn.character)) {
            mFighters.setPlayer(mBattle.getPlayer1());
            mFighters.setOpponent(mBattle.getPlayer2());
            myBuffsDebuffsStatus.setValue(mBattle.getPlayer1BuffsDebuffsStatus());
            oppBuffsDebuffsStatus.setValue(mBattle.getPlayer2BuffsDebuffsStatus());
            myTurn = 1;
        } else {
            mFighters.setPlayer(mBattle.getPlayer2());
            mFighters.setOpponent(mBattle.getPlayer1());
            myBuffsDebuffsStatus.setValue(mBattle.getPlayer2BuffsDebuffsStatus());
            oppBuffsDebuffsStatus.setValue(mBattle.getPlayer1BuffsDebuffsStatus());
            myTurn = 2;
        }

        mPlayerFormulas = mFighters.getPlayer().getFormulas();
        mOppFormulas = mFighters.getOpponent().getFormulas();

        mBattleLogs.setValue(mBattle.getBattleLogs());
    }

    private void startTimer(long elapsedTime) {
        mCountDownTimer = new CountDownTimer(
                TIME_TO_ATTACK - elapsedTime, 1000) {

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

                int currentPlayer = mBattle.getCurrentPlayer();

                if (currentPlayer != myTurn) {
                    mBattle.setStatus(myTurn == 1 ? Battle.Status.PLAYER1_WON : Battle.Status.PLAYER2_WON);
                } else {
                    mBattle.setStatus(myTurn == 1 ? Battle.Status.PLAYER2_WON : Battle.Status.PLAYER1_WON);
                    mPlayerFormulas.setCurrentHealth(0);
                }

                saveBattle();
            }
        }.start();
    }

    private void stopTimer() {
        if (mCountDownTimer != null) {
            mCountDownTimer.cancel();
            mCountDownTimer = null;
        }
    }

    private long calculateElapsedTime() {
        return DateCustom.getTimeInMillis() - mBattle.getAttackStart();
    }

    public void filterJutsus(Jutsu.Type filteredType) {
        mJutsuTypeSelected = filteredType;

        List<Jutsu> filteredJutsus = new ArrayList<>();

        for (Jutsu jutsu : mAllJutsus) {
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
        for (int i = 0; i < mAllJutsus.size(); i++) {
            Jutsu jutsu = mAllJutsus.get(i);

            if (jutsu.getRemainingIntervals() > 0) {
                jutsu.setRemainingIntervals(jutsu.getRemainingIntervals() - 1);
                mAllJutsus.set(i, jutsu);

                if (jutsu.getRemainingIntervals() == 0) {
                    if (jutsu.getJutsuInfo().type == Jutsu.Type.BUFF) {
                        List<Jutsu> buffsAndDebuffs = myBuffsDebuffsStatus.getValue();
                        buffsAndDebuffs.remove(jutsu);
                        myBuffsDebuffsStatus.setValue(buffsAndDebuffs);
                        removeBuffDebuff(mPlayerFormulas, jutsu);
                    } else if (jutsu.getJutsuInfo().type == Jutsu.Type.DEBUFF) {
                        List<Jutsu> buffsAndDebuffs = oppBuffsDebuffsStatus.getValue();
                        buffsAndDebuffs.remove(jutsu);
                        oppBuffsDebuffsStatus.setValue(buffsAndDebuffs);
                        removeBuffDebuff(mOppFormulas, jutsu);
                    }
                }
            }
        }
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

        if (jutsu.getConsumesChakra() > mPlayerFormulas.getCurrentChakra() ||
                jutsu.getConsumesStamina() > mPlayerFormulas.getCurrentStamina()) {
            showWarningDialogEvent.setValue(R.string.dont_have_chakra_to_use_this_jutsu);
            return;
        }

        JutsuInfo playerJutsuInfo = jutsu.getJutsuInfo();

        if (playerJutsuInfo.type == Jutsu.Type.ATK || playerJutsuInfo.type == Jutsu.Type.DEF) {
            if (myTurn == 2) {
                executeAttacks(jutsu, playerJutsuInfo, mBattle.getOppJutsu(),
                        mBattle.getOppJutsu().getJutsuInfo());
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
                    addBuffOrDebuff(mPlayerFormulas, jutsu);

                    List<Jutsu> buffsAndDebuffs;

                    if (mBattle.getPlayer1().equals(CharOn.character)) {
                        buffsAndDebuffs = mBattle.getPlayer1BuffsDebuffsStatus();
                    } else {
                        buffsAndDebuffs = mBattle.getPlayer2BuffsDebuffsStatus();
                    }

                    buffsAndDebuffs.add(jutsu);
                    myBuffsDebuffsStatus.setValue(buffsAndDebuffs);
                } else if (playerJutsuInfo.type == Jutsu.Type.DEBUFF) {
                    addBuffOrDebuff(mOppFormulas, jutsu);

                    List<Jutsu> buffsAndDebuffs;

                    if (mBattle.getPlayer1().equals(CharOn.character)) {
                        buffsAndDebuffs = mBattle.getPlayer1BuffsDebuffsStatus();
                    } else {
                        buffsAndDebuffs = mBattle.getPlayer2BuffsDebuffsStatus();
                    }

                    buffsAndDebuffs.add(jutsu);
                    oppBuffsDebuffsStatus.setValue(buffsAndDebuffs);
                }

                mPlayerFormulas.subChakra(jutsu.getConsumesChakra());
                mPlayerFormulas.subStamina(jutsu.getConsumesStamina());

                addLog(new BattleLog(mFighters.getPlayer().getNick(), BattleLog.Type.BUFF_DEBUFF_WEAPON,
                        playerJutsuInfo.name, jutsu));
            } else {
                return;
            }
        }

        if (mBattle.getStatus() == Battle.Status.CONTINUE) {
            int jutsuIndex = mAllJutsus.indexOf(jutsu);
            jutsu.setRemainingIntervals(jutsu.getUsageInterval() - 1);
            mAllJutsus.set(jutsuIndex, jutsu);
            mFighters.getPlayer().setJutsus(mAllJutsus);
        }

        saveBattle();
    }

    @Override
    public void onJutsuInfoClick(View anchor, Jutsu jutsu) {
        Object[] objects = new Object[3];
        objects[0] = calculateChanceOfSuccess(jutsu.getAccuracy(), mPlayerFormulas.getAccuracy());
        objects[1] = jutsu;
        objects[2] = anchor;

        showJutsuInfoPopupEvent.setValue(objects);
    }


    private void executeAttacks(Jutsu myJutsu, JutsuInfo myJutsuInfo, Jutsu oppJutsu,
                                JutsuInfo oppJutsuInfo) {
        int myChanceOfError = calculateChanceOfError(myJutsu.getAccuracy(), mPlayerFormulas.getAccuracy());
        int oppChanceOfError = calculateChanceOfError(oppJutsu.getAccuracy(), mOppFormulas.getAccuracy());

        boolean myMissed = missedTheJutsu(myChanceOfError);
        boolean oppMissed = missedTheJutsu(oppChanceOfError);

        int myDamage = calcuteDamage(myJutsu, myJutsuInfo, mPlayerFormulas, mOppFormulas);
        int oppDamage = calcuteDamage(oppJutsu, oppJutsuInfo, mOppFormulas, mPlayerFormulas);

        if (!myMissed && !oppMissed) {
            if (myDamage > 0 && oppDamage > 0) {
                mPlayerFormulas.subHeath(oppDamage);
                mOppFormulas.subHeath(myDamage);
            } else if (myDamage > 0 && oppDamage < 0) {
                myDamage = myDamage - Math.abs(oppDamage);
                mOppFormulas.subHeath(myDamage);
            } else if (myDamage < 0 && oppDamage > 0) {
                oppDamage = oppDamage - Math.abs(myDamage);
                mPlayerFormulas.subHeath(oppDamage);
            }
        } else if (myMissed && !oppMissed) {
            if (oppDamage > 0) {
                mPlayerFormulas.subHeath(oppDamage);
            }
        } else if (!myMissed) {
            if (myDamage > 0) {
                mOppFormulas.subHeath(oppDamage);
            }
        }

        mPlayerFormulas.subChakra(myJutsu.getConsumesChakra());
        mPlayerFormulas.subStamina(myJutsu.getConsumesStamina());
        mOppFormulas.subChakra(oppJutsu.getConsumesChakra());
        mOppFormulas.subStamina(oppJutsu.getConsumesStamina());

        // Creates battle log
        addLog(new BattleLog(mFighters.getPlayer().getNick(), BattleLog.Type.USES, myJutsuInfo.name, myJutsu,
                calculateChanceOfSuccess(myJutsu.getAccuracy(), mPlayerFormulas.getAccuracy())));
        if (myMissed) {
            addLog(new BattleLog(mFighters.getPlayer().getNick(), BattleLog.Type.MISSED));
        } else {
            if (myJutsuInfo.type == Jutsu.Type.ATK) {
                addLog(new BattleLog(mFighters.getOpponent().getNick(), BattleLog.Type.RECEIVES, myDamage));
            }
        }

        addLog(new BattleLog(mFighters.getOpponent().getNick(), BattleLog.Type.USES, oppJutsuInfo.name,
                oppJutsu, calculateChanceOfSuccess(oppJutsu.getAccuracy(), mOppFormulas.getAccuracy())));
        if (oppMissed) {
            addLog(new BattleLog(mFighters.getOpponent().getNick(), BattleLog.Type.MISSED));
        } else {
            if (oppJutsuInfo.type == Jutsu.Type.ATK) {
                addLog(new BattleLog(mFighters.getPlayer().getNick(), BattleLog.Type.RECEIVES, oppDamage));
            }
        }

        addLog(new BattleLog(BattleLog.Type.END));
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

    private boolean missedTheJutsu(int chanceOfError) {
        int n = random.nextInt(100);
        return n < chanceOfError;
    }

    private int calcuteDamage(Jutsu jutsu, JutsuInfo jutsuInfo, Formulas myFormulas,
                              Formulas mOppFormulas) {
        int damage;

        if (jutsuInfo.type == Jutsu.Type.ATK) {
            if (jutsu.getClasse() == Classe.NIN || jutsu.getClasse() == Classe.GEN) {
                damage = (jutsu.getAtk() + myFormulas.getAtkNinGen()) - mOppFormulas.getDefNinGen();
            } else {
                damage = (jutsu.getAtk() + myFormulas.getAtkTaiBuki()) - mOppFormulas.getDefNinGen();
            }
        } else {
            damage = (jutsu.getBaseDefense() + myFormulas.getDefNinGen()) * -1;
        }

        return damage;
    }


    private void addLog(BattleLog log) {
        mBattle.getBattleLogs().add(log);
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


    private void updateFightStatus() {
        if ((mOppFormulas.getCurrentHealth() < 10 || mOppFormulas.getCurrentChakra() < 10 ||
                mOppFormulas.getCurrentStamina() < 10) &&
                (mPlayerFormulas.getCurrentHealth() < 10 || mPlayerFormulas.getCurrentChakra() < 10
                        || mPlayerFormulas.getCurrentStamina() < 10)) {
            mBattle.setStatus(Battle.Status.DRAWN);
        } else if (mOppFormulas.getCurrentHealth() < 10 || mOppFormulas.getCurrentChakra() < 10 ||
                mOppFormulas.getCurrentStamina() < 10) {
            mBattle.setStatus(myTurn == 1 ? Battle.Status.PLAYER1_WON : Battle.Status.PLAYER2_WON);
        } else if (mPlayerFormulas.getCurrentHealth() < 10 || mPlayerFormulas.getCurrentChakra() < 10 ||
                mPlayerFormulas.getCurrentStamina() < 10) {
            mBattle.setStatus(myTurn == 1 ? Battle.Status.PLAYER2_WON : Battle.Status.PLAYER1_WON);
        } else {
            mBattle.setStatus(Battle.Status.CONTINUE);
        }
    }

    private void showBattleResult() {
        if (mBattle.getStatus() == Battle.Status.DRAWN) {
            showDrawnEvent.call();
        } else if ((mBattle.getStatus() == Battle.Status.PLAYER1_WON && myTurn == 1) ||
                (mBattle.getStatus() == Battle.Status.PLAYER2_WON && myTurn == 2)) {
            int earnedRyous;
            int earnedExp;

            if (CharOn.character.battleId.contains("VILLAGEMAP-PVP")) {
                earnedExp = 15 * mFighters.getPlayer().getLevel() + 100;
                earnedRyous = 10 * mFighters.getPlayer().getLevel() + 150;
            } else {
                earnedExp = Math.max(344 - (29 * mFighters.getPlayer().getLevel()), 0);
                earnedRyous = 100;
            }

            showWonEvent.setValue(new Integer[]{earnedRyous, earnedExp});
        } else {
            showLostEvent.call();
        }
    }

    void exit() {
        CharOn.character.getFormulas().setCurrentHealth(mPlayerFormulas.getCurrentHealth());
        CharOn.character.getFormulas().setCurrentChakra(mPlayerFormulas.getCurrentChakra());
        CharOn.character.getFormulas().setCurrentStamina(mPlayerFormulas.getCurrentStamina());


        if ((mBattle.getStatus() == Battle.Status.PLAYER1_WON && myTurn == 1) ||
                (mBattle.getStatus() == Battle.Status.PLAYER2_WON && myTurn == 2)) {
            if (CharOn.character.battleId.contains("VILLAGEMAP-PVP")) {
                CharOn.character.incrementScore(Score.VIT_MAPA_PVP);
                CharOn.character.incrementExp(15 * mFighters.getPlayer().getLevel() + 100);
                CharOn.character.addRyous(10 * mFighters.getPlayer().getLevel() + 150);
                CharOn.character.getCombatOverview().setWinsMapPvp(
                        CharOn.character.getCombatOverview().getWinsMapPvp() + 1);
            } else {
                CharOn.character.incrementScore(Score.VIT_DOJO_PVP);
                CharOn.character.incrementExp(
                        Math.max(344 - (29 * mFighters.getPlayer().getLevel()), 0));
                CharOn.character.addRyous(100);
                CharOn.character.getCombatOverview().setWinsDojoPvp(
                        CharOn.character.getCombatOverview().getWinsDojoPvp() + 1);
            }
        } else if (mBattle.getStatus() == Battle.Status.DRAWN) {
            CharOn.character.getCombatOverview().setDrawsPvp(
                    CharOn.character.getCombatOverview().getDrawsPvp() + 1);
        } else {
            if (CharOn.character.battleId.contains("VILLAGEMAP-PVP")) {
                CharOn.character.incrementScore(Score.DER_MAPA_PVP);
                CharOn.character.getCombatOverview().setLossesMapPvp(
                        CharOn.character.getCombatOverview().getLossesMapPvp() + 1);
            } else {
                CharOn.character.incrementScore(Score.DER_DOJO_PVP);
                CharOn.character.getCombatOverview().setLossesDojoPvp(
                        CharOn.character.getCombatOverview().getLossesDojoPvp() + 1);
            }
        }

        CharOn.character.getAttributes().incrementTraningPoints(50);
        CharOn.character.getExtrasInformation().incrementTotalTraining(50);

        int playerCount = mBattle.getPlayerCount() - 1;

        mBattleRepository.removeBattleListener();

        if (playerCount == 0) {
            mBattleRepository.delete(mBattle.getId());
        } else {
            mBattle.setPlayerCount(playerCount);
        }

        saveBattle();

        CharOn.character.battleId = "";
        CharOn.character.setBattle(false);
    }

    private void saveBattle() {
        mBattleRepository.save(mBattle);
    }
}

