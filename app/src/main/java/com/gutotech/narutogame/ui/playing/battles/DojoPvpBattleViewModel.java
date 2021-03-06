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
import com.gutotech.narutogame.data.firebase.FirebaseFunctionsUtils;
import com.gutotech.narutogame.data.model.Battle;
import com.gutotech.narutogame.data.model.BattleLog;
import com.gutotech.narutogame.data.model.CharOn;
import com.gutotech.narutogame.data.model.Classe;
import com.gutotech.narutogame.data.model.Element;
import com.gutotech.narutogame.data.model.ElementalJutsu;
import com.gutotech.narutogame.data.model.Fighters;
import com.gutotech.narutogame.data.model.Formulas;
import com.gutotech.narutogame.data.model.Jutsu;
import com.gutotech.narutogame.data.model.JutsuInfo;
import com.gutotech.narutogame.data.model.Score;
import com.gutotech.narutogame.data.repository.BattleRepository;
import com.gutotech.narutogame.data.repository.GlobalAlertRepository;
import com.gutotech.narutogame.data.repository.KageRepository;
import com.gutotech.narutogame.data.repository.MapRepository;
import com.gutotech.narutogame.data.repository.MissionRepository;
import com.gutotech.narutogame.ui.adapter.JutsusAdapter;
import com.gutotech.narutogame.utils.SingleLiveEvent;
import com.gutotech.narutogame.utils.SoundUtil;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class DojoPvpBattleViewModel extends AndroidViewModel
        implements JutsusAdapter.OnJutsuClickListener {
    private static final SecureRandom random = new SecureRandom();

    private final long TIME_TO_ATTACK = 90000;

    public int myTurn;

    public final ObservableField<String> countDown = new ObservableField<>("--:--");
    private CountDownTimer mCountDownTimer;

    private BattleRepository mBattleRepository;

    private Battle mBattle;
    private Fighters mFighters;

    private Formulas mPlayerFormulas;
    private Formulas mOppFormulas;

    private List<Jutsu> mAllJutsus;
    private MutableLiveData<List<Jutsu>> mJutsus = new MutableLiveData<>(new ArrayList<>());
    private Jutsu.Type mJutsuTypeSelected;

    private Jutsu mBuffDebuffPending;
    private MutableLiveData<List<Jutsu>> mPlayerBuffsDebuffsStatus = new MutableLiveData<>();
    private MutableLiveData<List<Jutsu>> mOppBuffsDebuffsStatus = new MutableLiveData<>();
    private MutableLiveData<List<BattleLog>> mBattleLogs = new MutableLiveData<>(new ArrayList<>());

    private SingleLiveEvent<Object[]> mShowJutsuInfoPopupEvent = new SingleLiveEvent<>();
    private SingleLiveEvent<Integer> mShowWarningDialogEvent = new SingleLiveEvent<>();
    private SingleLiveEvent<Integer[]> mShowWonEvent = new SingleLiveEvent<>();
    private SingleLiveEvent<Void> mShowLostEvent = new SingleLiveEvent<>();
    private SingleLiveEvent<Void> mShowDrawnEvent = new SingleLiveEvent<>();
    private SingleLiveEvent<Void> mShowInactivatedEvent = new SingleLiveEvent<>();

    public DojoPvpBattleViewModel(@NonNull Application application) {
        super(application);
        mBattle = new Battle();
        mFighters = new Fighters();
        mBattleRepository = BattleRepository.getInstance();
        CharOn.character.setItemsEnabled(false);
        mJutsuTypeSelected = Jutsu.Type.ATK;

        if (CharOn.character.isMap()) {
            CharOn.character.setMap(false);
            MapRepository.getInstance().exit(CharOn.character.getMapId(), CharOn.character.getId());
        }

        addBattleListener();
    }

    private void addBattleListener() {
        mBattle.setId(CharOn.character.getBattleId());
        mBattleRepository.addBattleListener(mBattle.getId(), battle -> {
            mBattle.setStatus(battle.getStatus());
            mBattle.setPlayer1(battle.getPlayer1());
            mBattle.setPlayer2(battle.getPlayer2());
            mBattle.setCurrentPlayer(battle.getCurrentPlayer());
            mBattle.setJutsuBuffer(battle.getJutsuBuffer());
            mBattle.setBuffsDebuffsUsed1(battle.getBuffsDebuffsUsed1());
            mBattle.setBuffsDebuffsUsed2(battle.getBuffsDebuffsUsed2());
            mBattle.setBattleLogs(battle.getBattleLogs());
            mBattle.setPlayersInBattle(battle.getPlayersInBattle());

            updateFighters();

            if (mBattle.getStatus() == Battle.Status.CONTINUE) {
                if (battle.getCurrentPlayer() == myTurn &&
                        battle.getAttackStart() != mBattle.getAttackStart()) {
                    SoundUtil.play(getApplication(), R.raw.battle);
                    if (mBuffDebuffPending != null) {
                        removeBuffOrDebuffFromStatus(mBuffDebuffPending,
                                mBuffDebuffPending.getJutsuInfo().type);
                        mBuffDebuffPending = null;
                        saveBattle();
                    }
                }

                if (battle.getAttackStart() != mBattle.getAttackStart()) {
                    mBattle.setAttackStart(battle.getAttackStart());
                    FirebaseFunctionsUtils.getServerTime(currentTimestamp ->
                            startTimer(TIME_TO_ATTACK -
                                    (currentTimestamp - mBattle.getAttackStart()))
                    );
                }

                if (mAllJutsus == null) {
                    mAllJutsus = mFighters.getPlayer().getVisibleJutsus();
                }

                filterJutsus(mJutsuTypeSelected);
            } else {
                stopTimer();
                countDown.set("--:--");
                showBattleResult();
            }
        });
    }

    private void updateFighters() {
        if (mBattle.getPlayer1().equals(CharOn.character)) {
            mFighters.setPlayer(mBattle.getPlayer1());
            mFighters.setOpponent(mBattle.getPlayer2());
            mPlayerBuffsDebuffsStatus.setValue(mBattle.getBuffsDebuffsUsed1());
            mOppBuffsDebuffsStatus.setValue(mBattle.getBuffsDebuffsUsed2());
            myTurn = 1;
        } else {
            mFighters.setPlayer(mBattle.getPlayer2());
            mFighters.setOpponent(mBattle.getPlayer1());
            mPlayerBuffsDebuffsStatus.setValue(mBattle.getBuffsDebuffsUsed2());
            mOppBuffsDebuffsStatus.setValue(mBattle.getBuffsDebuffsUsed1());
            myTurn = 2;
        }

        mPlayerFormulas = mFighters.getPlayer().getFormulas();
        mOppFormulas = mFighters.getOpponent().getFormulas();

        mBattleLogs.setValue(mBattle.getBattleLogs());
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

                if (mBattle.getCurrentPlayer() == myTurn) {
                    mBattle.setStatus(myTurn == 1 ? Battle.Status.PLAYER1_INACTIVATED : Battle.Status.PLAYER2_INACTIVATED);
                    mPlayerFormulas.setCurrentHealth(0);
                } else {
                    mBattle.setStatus(myTurn == 1 ? Battle.Status.PLAYER1_WON : Battle.Status.PLAYER2_WON);
                    mOppFormulas.setCurrentHealth(0);
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


    public void filterJutsus(Jutsu.Type filteredType) {
        if (mAllJutsus == null) {
            return;
        }

        mJutsuTypeSelected = filteredType;

        List<Jutsu> filteredJutsus = new ArrayList<>();

        int len = mAllJutsus.size();

        for (int i = 0; i < len; i++) {
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
                mAllJutsus.set(i, jutsu);

                if (jutsu.getRemainingIntervals() == 0) {
                    Jutsu.Type type = jutsu.getJutsuInfo().type;

                    if ((type == Jutsu.Type.BUFF || type == Jutsu.Type.DEBUFF) && myTurn == 1) {
                        mBuffDebuffPending = jutsu;
                    } else {
                        removeBuffOrDebuffFromStatus(jutsu, type);
                    }
                }
            }
        }
    }


    private void removeBuffOrDebuffFromStatus(Jutsu jutsu, Jutsu.Type type) {
        if (type == Jutsu.Type.BUFF) {
            List<Jutsu> buffsAndDebuffs = mPlayerBuffsDebuffsStatus.getValue();
            buffsAndDebuffs.remove(jutsu);
            mPlayerBuffsDebuffsStatus.setValue(buffsAndDebuffs);
            removeBuffDebuff(mPlayerFormulas, jutsu, type);
        } else if (type == Jutsu.Type.DEBUFF) {
            List<Jutsu> buffsAndDebuffs = mOppBuffsDebuffsStatus.getValue();
            buffsAndDebuffs.remove(jutsu);
            mOppBuffsDebuffsStatus.setValue(buffsAndDebuffs);
            removeBuffDebuff(mOppFormulas, jutsu, type);
        }
    }

    private boolean checkForBuffOrDebuffUsed(Jutsu.Type type) {
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

    private boolean mAwaitingShiftChange = false;

    @Override
    public synchronized void onJutsuClick(Jutsu jutsu) {
        if (mBattle.getCurrentPlayer() != myTurn || mAwaitingShiftChange) {
            mShowWarningDialogEvent.setValue(R.string.it_is_not_your_turn_to_attack);
            return;
        }

        if (jutsu.getRemainingIntervals() != 0) {
            mShowWarningDialogEvent.setValue(R.string.jutsu_is_not_yet_available);
            return;
        }

        if (jutsu.getConsumesChakra() > mPlayerFormulas.getCurrentChakra() ||
                jutsu.getConsumesStamina() > mPlayerFormulas.getCurrentStamina()) {
            mShowWarningDialogEvent.setValue(R.string.dont_have_chakra_to_use_this_jutsu);
            return;
        }

        JutsuInfo jutsuInfo = jutsu.getJutsuInfo();

        if (jutsuInfo.type == Jutsu.Type.ATK || jutsuInfo.type == Jutsu.Type.DEF) {
            mAwaitingShiftChange = true;

            if (myTurn == 2) {
                executeAttacks(jutsu, jutsuInfo, mBattle.getJutsuBuffer(),
                        mBattle.getJutsuBuffer().getJutsuInfo());
                updateBattleStatus();
            } else {
                mBattle.setJutsuBuffer(jutsu);
            }

            if (mBattle.getStatus() == Battle.Status.CONTINUE) {
                updateRemainingIntervals();
                mBattle.setCurrentPlayer(mBattle.getCurrentPlayer() % 2 + 1);
                mBattleRepository.save(mBattle, true);
                mAwaitingShiftChange = false;
            }
        } else if (!checkForBuffOrDebuffUsed(jutsuInfo.type)) {
            if (jutsuInfo.type == Jutsu.Type.BUFF) {
                addBuffOrDebuff(mPlayerFormulas, jutsu, jutsuInfo.type);

                List<Jutsu> buffsAndDebuffs;

                if (mBattle.getPlayer1().equals(CharOn.character)) {
                    buffsAndDebuffs = mBattle.getBuffsDebuffsUsed1();
                } else {
                    buffsAndDebuffs = mBattle.getBuffsDebuffsUsed2();
                }

                buffsAndDebuffs.add(jutsu);
                mPlayerBuffsDebuffsStatus.setValue(buffsAndDebuffs);
            } else if (jutsuInfo.type == Jutsu.Type.DEBUFF) {
                addBuffOrDebuff(mOppFormulas, jutsu, jutsuInfo.type);

                List<Jutsu> buffsAndDebuffs;

                if (mBattle.getPlayer1().equals(CharOn.character)) {
                    buffsAndDebuffs = mBattle.getBuffsDebuffsUsed2();
                } else {
                    buffsAndDebuffs = mBattle.getBuffsDebuffsUsed1();
                }

                buffsAndDebuffs.add(jutsu);
                mOppBuffsDebuffsStatus.setValue(buffsAndDebuffs);
            }

            mPlayerFormulas.subChakra(jutsu.getConsumesChakra());
            mPlayerFormulas.subStamina(jutsu.getConsumesStamina());

            addLog(new BattleLog(mFighters.getPlayer().getNick(), BattleLog.Action.BUFF_DEBUFF_WEAPON,
                    jutsuInfo.name, jutsu)
            );
        } else {
            mShowWarningDialogEvent.setValue(R.string.jutsu_is_not_yet_available);
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
            mFighters.getPlayer().setJutsu(jutsu);
        }

        saveBattle();
    }

    @Override
    public void onJutsuInfoClick(View anchor, Jutsu jutsu) {
        Object[] objects = new Object[3];
        objects[0] = calculateChanceOfSuccess(jutsu.getAccuracy(), mPlayerFormulas.getAccuracy());
        objects[1] = jutsu;
        objects[2] = anchor;
        mShowJutsuInfoPopupEvent.setValue(objects);
    }


    private void executeAttacks(Jutsu myJutsu, JutsuInfo myJutsuInfo, Jutsu oppJutsu,
                                JutsuInfo oppJutsuInfo) {
        int myChanceOfError = calculateChanceOfError(myJutsu.getAccuracy(), mPlayerFormulas.getAccuracy());
        int oppChanceOfError = calculateChanceOfError(oppJutsu.getAccuracy(), mOppFormulas.getAccuracy());

        boolean myMissed = missedTheJutsu(myChanceOfError);
        boolean oppMissed = missedTheJutsu(oppChanceOfError);

        int myDamage = calculateDamage(myJutsu, myJutsuInfo, mPlayerFormulas, mOppFormulas);
        int oppDamage = calculateDamage(oppJutsu, oppJutsuInfo, mOppFormulas, mPlayerFormulas);

        if (myJutsu instanceof ElementalJutsu && oppJutsu instanceof ElementalJutsu) {
            Element playerElement = mFighters.getPlayer().getElement();
            Element oppElement = mFighters.getOpponent().getElement();
            int diff = Math.abs(playerElement.ordinal() - oppElement.ordinal());
            if (diff == 1) {
                if (playerElement.ordinal() < oppElement.ordinal()) {
                    myDamage = (int) (myDamage * 1.25);
                } else {
                    oppDamage = (int) (oppDamage * 1.25);
                }
            } else if (diff == 4 && playerElement.ordinal() > oppElement.ordinal()) {
                myDamage = (int) (myDamage * 1.25);
            } else {
                oppDamage = (int) (oppDamage * 1.25);
            }
        }

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
        addLog(new BattleLog(mFighters.getPlayer().getNick(), BattleLog.Action.USES, myJutsuInfo.name, myJutsu,
                calculateChanceOfSuccess(myJutsu.getAccuracy(), mPlayerFormulas.getAccuracy())));
        if (myMissed) {
            addLog(new BattleLog(mFighters.getPlayer().getNick(), BattleLog.Action.MISSED));
        } else if (myJutsuInfo.type == Jutsu.Type.ATK) {
            addLog(new BattleLog(mFighters.getOpponent().getNick(), BattleLog.Action.RECEIVES, myDamage));
        }

        addLog(new BattleLog(mFighters.getOpponent().getNick(), BattleLog.Action.USES, oppJutsuInfo.name,
                oppJutsu, calculateChanceOfSuccess(oppJutsu.getAccuracy(), mOppFormulas.getAccuracy())));
        if (oppMissed) {
            addLog(new BattleLog(mFighters.getOpponent().getNick(), BattleLog.Action.MISSED));
        } else if (oppJutsuInfo.type == Jutsu.Type.ATK) {
            addLog(new BattleLog(mFighters.getPlayer().getNick(), BattleLog.Action.RECEIVES, oppDamage));
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

    private boolean missedTheJutsu(int chanceOfError) {
        int n = random.nextInt(100);
        return n < chanceOfError;
    }

    private int calculateDamage(Jutsu jutsu, JutsuInfo jutsuInfo, Formulas myFormulas,
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


    private void updateBattleStatus() {
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
            mShowDrawnEvent.call();
        } else if ((mBattle.getStatus() == Battle.Status.PLAYER1_WON && myTurn == 1) ||
                (mBattle.getStatus() == Battle.Status.PLAYER2_WON && myTurn == 2)) {
            int earnedRyous = 0;
            int earnedExp = 0;

            if (CharOn.character.getBattleId().contains(Battle.MAP_PVP)) {
                earnedRyous = 16 * mFighters.getPlayer().getLevel() + 250;
                earnedExp = 16 * mFighters.getPlayer().getLevel() + 150;
            } else if (CharOn.character.getGraduationId() == 1) { // Dojo PVP
                earnedRyous = 10 * CharOn.character.getLevel() + 100;
                earnedExp = Math.max(300 - 20 * CharOn.character.getLevel(), 0);
            }

            mShowWonEvent.setValue(new Integer[]{earnedRyous, earnedExp});

            CharOn.character.getFormulas().setCurrentHealth(mPlayerFormulas.getCurrentHealth());
            CharOn.character.getFormulas().setCurrentChakra(mPlayerFormulas.getCurrentChakra());
            CharOn.character.getFormulas().setCurrentStamina(mPlayerFormulas.getCurrentStamina());
            CharOn.character.setItemsEnabled(true);
        } else if ((mBattle.getStatus() == Battle.Status.PLAYER1_INACTIVATED && myTurn == 1) ||
                (mBattle.getStatus() == Battle.Status.PLAYER2_INACTIVATED && myTurn == 2)) {
            CharOn.character.getFormulas().setCurrentHealth(0);
            mShowInactivatedEvent.call();
        } else {
            mShowLostEvent.call();
        }

        MapRepository.getInstance().removeBattleRequest(CharOn.character.getId());
    }

    synchronized void exit() {
        if ((mBattle.getStatus() == Battle.Status.PLAYER1_WON && myTurn == 1) ||
                (mBattle.getStatus() == Battle.Status.PLAYER2_WON && myTurn == 2)) {
            if (CharOn.character.getBattleId().contains(Battle.MAP_PVP)) {
                CharOn.character.incrementScore(Score.WIN_MAP_PVP);
                CharOn.character.addRyous(16 * mFighters.getPlayer().getLevel() + 250);
                CharOn.character.incrementExp(16 * mFighters.getPlayer().getLevel() + 150);
                CharOn.character.getCombatOverview().setWinsMapPvp(
                        CharOn.character.getCombatOverview().getWinsMapPvp() + 1);
                if (CharOn.character.isSpecialMission()) {
                    MissionRepository.getInstance().increaseDefeated();
                }
            } else {
                CharOn.character.incrementScore(Score.WIN_DOJO_PVP);
                CharOn.character.getCombatOverview().setWinsDojoPvp(
                        CharOn.character.getCombatOverview().getWinsDojoPvp() + 1);

                if (CharOn.character.getGraduationId() == 1) {
                    CharOn.character.addRyous(10 * CharOn.character.getLevel() + 100);
                    CharOn.character.incrementExp(Math.max(300 - 20 * CharOn.character.getLevel(), 0));
                }
            }
            KageRepository.getInstance().getKage(mFighters.getOpponent().getVillage(), kage -> {
                if (kage.getNick().equals(mFighters.getOpponent().getNick())) {
                    Map<String, String> map = new HashMap<>();
                    map.put("kageTitle", String.valueOf(kage.getVillage().kageName));
                    map.put("kageName", kage.getNick());
                    map.put("player", CharOn.character.getNick());
                    map.put("type", "kage_defeated");
                    GlobalAlertRepository.getInstance().showAlert(map);
                }
            });
        } else {
            CharOn.character.getFormulas().setCurrentHealth(mPlayerFormulas.getCurrentHealth());
            CharOn.character.getFormulas().setCurrentChakra(mPlayerFormulas.getCurrentChakra());
            CharOn.character.getFormulas().setCurrentStamina(mPlayerFormulas.getCurrentStamina());

            if (mBattle.getStatus() == Battle.Status.DRAWN) {
                CharOn.character.getCombatOverview().setDrawsPvp(
                        CharOn.character.getCombatOverview().getDrawsPvp() + 1);
            } else if (CharOn.character.getBattleId().contains(Battle.MAP_PVP)) {
                CharOn.character.decrementScore(Score.DER_MAP_PVP);
                CharOn.character.getCombatOverview().setLossesMapPvp(
                        CharOn.character.getCombatOverview().getLossesMapPvp() + 1);
            } else {
                CharOn.character.decrementScore(Score.DER_DOJO_PVP);
                CharOn.character.getCombatOverview().setLossesDojoPvp(
                        CharOn.character.getCombatOverview().getLossesDojoPvp() + 1);
            }
        }

        if (!(mBattle.getStatus() == Battle.Status.PLAYER1_INACTIVATED && myTurn == 1)
                || !(mBattle.getStatus() == Battle.Status.PLAYER2_INACTIVATED && myTurn == 2)) {
            CharOn.character.incrementSkillPoint();
        }

        mBattleRepository.removeBattleListener();
        mBattleRepository.exit(mBattle.getId());

        CharOn.character.setItemsEnabled(true);
        CharOn.character.setBattle(false);
    }

    private void saveBattle() {
        mBattleRepository.save(mBattle, false);
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

    Formulas getPlayerFormulas() {
        return mPlayerFormulas;
    }

    Formulas getOppFormulas() {
        return mOppFormulas;
    }

    LiveData<List<BattleLog>> getBattleLogs() {
        return mBattleLogs;
    }

    LiveData<List<Jutsu>> getJutsus() {
        return mJutsus;
    }

    LiveData<List<Jutsu>> getPlayerBuffsDebuffsStatus() {
        return mPlayerBuffsDebuffsStatus;
    }

    LiveData<List<Jutsu>> getOppBuffsDebuffsStatus() {
        return mOppBuffsDebuffsStatus;
    }

    LiveData<Object[]> getShowJutsuInfoPopupEvent() {
        return mShowJutsuInfoPopupEvent;
    }

    LiveData<Integer> getShowWarningDialogEvent() {
        return mShowWarningDialogEvent;
    }

    LiveData<Integer[]> getShowWonEvent() {
        return mShowWonEvent;
    }

    LiveData<Void> getShowLostEvent() {
        return mShowLostEvent;
    }

    LiveData<Void> getShowDrawnEvent() {
        return mShowDrawnEvent;
    }

    LiveData<Void> getShowInactivatedEvent() {
        return mShowInactivatedEvent;
    }
}

