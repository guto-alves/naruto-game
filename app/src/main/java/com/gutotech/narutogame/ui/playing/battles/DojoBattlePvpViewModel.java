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
import com.gutotech.narutogame.data.model.Score;
import com.gutotech.narutogame.data.repository.BattleRepository;
import com.gutotech.narutogame.data.repository.CharacterRepository;
import com.gutotech.narutogame.ui.adapter.JutsusAdapter;
import com.gutotech.narutogame.utils.SingleLiveEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class DojoBattlePvpViewModel extends ViewModel implements JutsusAdapter.OnJutsuClickListener {
    private final long TIME_TO_ATTACK = 150000;

    private enum Status {WON, LOST, DRAWN, INACTIVATED, CONTINUE}

    private Status status = Status.CONTINUE;

    private BattleRepository mBattleRepository;

    private Battle mBattle;

    private Character player;
    private Character opponent;

    private Formulas playerFormulas;
    private Formulas oppFormulas;

    public int myTurn;

    private MutableLiveData<List<BattleLog>> mBattleLogs = new MutableLiveData<>(new ArrayList<>());

    private CountDownTimer countDownTimer;

    public final ObservableField<String> countDown = new ObservableField<>("--:--");
    public final ObservableField<Integer> waitingFor = new ObservableField<>(R.string.waiting_your_move);

    SingleLiveEvent<View> startAnimationEvent = new SingleLiveEvent<>();
    SingleLiveEvent<Integer[]> showWonEvent = new SingleLiveEvent<>();
    SingleLiveEvent<Void> showLostEvent = new SingleLiveEvent<>();
    SingleLiveEvent<Void> showDrawnEvent = new SingleLiveEvent<>();
    SingleLiveEvent<Void> showInactivatedEvent = new SingleLiveEvent<>();

    public DojoBattlePvpViewModel(Battle battle) {
        mBattle = battle;

        if (mBattle.getPlayer1().getNick().equals(CharOn.character.getNick())) {
            player = mBattle.getPlayer1();
            opponent = mBattle.getPlayer2();
            myTurn = 0;
        } else {
            player = mBattle.getPlayer1();
            opponent = mBattle.getPlayer2();
            myTurn = 1;
        }

        playerFormulas = player.getFormulas();
        oppFormulas = opponent.getFormulas();

        mBattleRepository = BattleRepository.getInstance();

        observeBattle();

        startTimer();
    }

    public Battle getBattle() {
        return mBattle;
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

    private void startTimer() {
        countDownTimer = new CountDownTimer(TIME_TO_ATTACK, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                countDown.set(String.format(Locale.getDefault(), "%02d:%02d",
                        TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished),
                        TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) -
                                TimeUnit.MINUTES.toSeconds(
                                        TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)
                                )));

                //                        if (quemAtaca.equals(CharOn.character.getNick())) {
//                    countDownTimerTextView.setTextColor(Color.RED);
//                    vezDeQuemTextView.setText("Aguardando a sua ação");
//                } else {
//                    countDownTimerTextView.setTextColor(Color.GREEN);
//                    vezDeQuemTextView.setText("Aguardando a ação do oponente");
//                }
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

    @Override
    public void onJutsuClick(View view, Jutsu jutsu) {
        startAnimationEvent.setValue(view);

        if (myTurn == mBattle.getCurrentPlayer()) {
            JutsuInfo playerJutsuInfo = JutsuInfo.valueOf(jutsu.getName());

            if (playerJutsuInfo.type == Jutsu.Type.ATK || playerJutsuInfo.type == Jutsu.Type.DEF) {
                countDownTimer.cancel();

                if (myTurn == 1) {
//                    Jutsu oppJutsu = mBattle.getUsedJutsus().get(mBattle.getUsedJutsus().size() - 1);
//                    realizarAtaques(jutsu, playerJutsuInfo, oppJutsu, JutsuInfo.valueOf(oppJutsu.getName()));
                }

                updateFightStatus();

                if (status == Status.CONTINUE) {
                    startTimer();
                } else {
                    finishFight();
                }
            } else {
                if (playerJutsuInfo.type == Jutsu.Type.BUFF) {
                    playerFormulas.setAtkTaiBuki(playerFormulas.getAtkTaiBuki() + jutsu.getAtk());
                    playerFormulas.setAtkNinGen(playerFormulas.getAtkNinGen() + jutsu.getAtk());
                    playerFormulas.setDefTaiBuki(playerFormulas.getDefTaiBuki() + jutsu.getBaseDefense());
                    playerFormulas.setDefNinGen(playerFormulas.getDefNinGen() + jutsu.getBaseDefense());
                    playerFormulas.setAccuracy(playerFormulas.getAccuracy() + jutsu.getAccuracy());
                } else if (playerJutsuInfo.type == Jutsu.Type.DEBUFF) {
                    oppFormulas.setAtkTaiBuki(oppFormulas.getAtkTaiBuki() - jutsu.getAtk());
                    oppFormulas.setAtkNinGen(oppFormulas.getAtkNinGen() - jutsu.getAtk());
                    oppFormulas.setDefTaiBuki(oppFormulas.getDefTaiBuki() - jutsu.getBaseDefense());
                    oppFormulas.setDefNinGen(oppFormulas.getDefNinGen() - jutsu.getBaseDefense());
                    oppFormulas.setAccuracy(oppFormulas.getAccuracy() - jutsu.getAccuracy());
                }

                playerFormulas.setCurrentChakra(playerFormulas.getCurrentChakra() - jutsu.getConsumesChakra());
                playerFormulas.setCurrentStamina(playerFormulas.getCurrentStamina() - jutsu.getConsumesStamina());
//
//                addLog(new BattleLog(BattleLog.Type.BUFF_DEBUFF_WEAPON, player.getNick(),
//                        playerJutsuInfo.name, jutsu));
            }

            mBattle.setCurrentPlayer((mBattle.getCurrentPlayer() + 1) % 2);

//            if (mBattle.getUsedJutsus() == null) {
//                mBattle.setUsedJutsus(new ArrayList<>());
//            }
//
//            mBattle.getUsedJutsus().add(jutsu);
            mBattleRepository.save(mBattle);
        } else {

        }
    }

    @Override
    public void onJutsuInfoClick(View anchor, Jutsu jutsu) {

    }

    private void realizarAtaques(Jutsu playerJutsu, JutsuInfo playerJutsuInfo, Jutsu opponentJutsu,
                                 JutsuInfo opponentJutsuInfo) {
        int playerDamage = calcuteDamage(playerJutsu, playerJutsuInfo, playerFormulas, oppFormulas);
        int opponentDamage = calcuteDamage(opponentJutsu, opponentJutsuInfo, oppFormulas, playerFormulas);

        if (playerDamage > 0 && opponentDamage > 0) {
            playerFormulas.setCurrentHealth(playerFormulas.getCurrentHealth() - opponentDamage);
            oppFormulas.setCurrentHealth(oppFormulas.getCurrentHealth() - playerDamage);
        } else if (playerDamage > 0 && opponentDamage < 0) {
            opponentDamage *= -1;
            oppFormulas.setCurrentHealth(oppFormulas.getCurrentHealth() - (playerDamage - opponentDamage));
        } else if (playerDamage < 0 && opponentDamage > 0) {
            playerDamage *= -1;
            playerFormulas.setCurrentHealth(playerFormulas.getCurrentHealth() - (opponentDamage - playerDamage));
        }

        playerFormulas.setCurrentChakra(playerFormulas.getCurrentChakra() - playerJutsu.getConsumesChakra());
        playerFormulas.setCurrentStamina(playerFormulas.getCurrentStamina() - playerJutsu.getConsumesStamina());
        oppFormulas.setCurrentChakra(oppFormulas.getCurrentChakra() - opponentJutsu.getConsumesChakra());
        oppFormulas.setCurrentStamina(oppFormulas.getCurrentStamina() - opponentJutsu.getConsumesStamina());

        // Creates battle log
//        addLog(new BattleLog(BattleLog.Type.USES, player.getNick(), playerJutsuInfo.name, playerJutsu));
//        addLog(new BattleLog(BattleLog.Type.RECEIVES, opponent.getCharacter().getNick(), playerDamage));

//        addLog(new BattleLog(BattleLog.Type.USES, opponent.getCharacter().getNick(), opponentJutsuInfo.name, opponentJutsu));
//        addLog(new BattleLog(BattleLog.Type.RECEIVES, player.getNick(), opponentDamage));

        addLog(new BattleLog(BattleLog.Type.END));
    }

    private void addLog(BattleLog log) {
        List<BattleLog> logs = mBattleLogs.getValue();
        logs.add(log);
        mBattleLogs.setValue(logs);
    }

    private int calcuteDamage(Jutsu jutsu, JutsuInfo jutsuInfo, Formulas myFormulas, Formulas
            oppFormulas) {
        int damage;

        if (jutsuInfo.type == Jutsu.Type.ATK) {
            if (jutsu.getClasse() == Classe.NIN || jutsu.getClasse() == Classe.GEN) {
                damage = (jutsu.getAtk() + myFormulas.getAtkNinGen()) - oppFormulas.getDefNinGen();
            } else {
                damage = (jutsu.getAtk() + myFormulas.getAtkTaiBuki()) - oppFormulas.getDefNinGen();
            }
        } else {
            damage = jutsu.getBaseDefense() + myFormulas.getDefNinGen() * -1;
        }

        return damage;
    }

    private void updateFightStatus() {
        if ((oppFormulas.getCurrentHealth() < 10 || oppFormulas.getCurrentChakra() < 10 || oppFormulas.getCurrentStamina() < 10)
                && (playerFormulas.getCurrentHealth() < 10 || playerFormulas.getCurrentChakra() < 10 || playerFormulas.getCurrentStamina() < 10)) {
            status = Status.DRAWN;
        } else if (oppFormulas.getCurrentHealth() < 10 || oppFormulas.getCurrentChakra() < 10 || oppFormulas.getCurrentStamina() < 10) {
            status = Status.WON;
        } else if (playerFormulas.getCurrentHealth() < 10 || playerFormulas.getCurrentChakra() < 10 || playerFormulas.getCurrentStamina() < 10) {
            status = Status.LOST;
        } else {
            status = Status.CONTINUE;
        }
    }

    private void finishFight() {
        if (status == Status.WON) {
            CharOn.character.getCombatOverview().setWinsMapPvp(
                    CharOn.character.getCombatOverview().getWinsMapPvp() + 1);

            int earnedRyous = 100;
            int earnedExp = 50 + (29 * player.getLevel());

            CharOn.character.incrementExp(earnedExp);
            CharOn.character.addRyous(earnedRyous);
            CharOn.character.incrementScore(Score.VIT_MAPA_PVP);

            showWonEvent.setValue(new Integer[]{earnedRyous, earnedExp});
        } else if (status == Status.LOST) {
            CharOn.character.getCombatOverview().setLossesMapPvp(
                    CharOn.character.getCombatOverview().getLossesMapPvp() + 1);
            CharOn.character.decrementScore(Score.DER_MAPA_PVP);
            showLostEvent.call();
        } else if (status == Status.DRAWN) {
            CharOn.character.getCombatOverview().setDrawsPvp(
                    CharOn.character.getCombatOverview().getDrawsPvp() + 1);
            showDrawnEvent.call();
        } else {
            CharOn.character.getCombatOverview().setLossesMapPvp(
                    CharOn.character.getCombatOverview().getLossesMapPvp() + 1);
            CharOn.character.decrementScore(Score.DER_MAPA_PVP);
            playerFormulas.setCurrentHealth(0);
            showInactivatedEvent.call();
        }

        CharOn.character.getFormulas().setCurrentHealth(playerFormulas.getCurrentHealth());
        CharOn.character.getFormulas().setCurrentChakra(playerFormulas.getCurrentChakra());
        CharOn.character.getFormulas().setCurrentStamina(playerFormulas.getCurrentStamina());
        CharacterRepository.getInstance().save(CharOn.character);
    }

    private void observeBattle() {
        BattleRepository.getInstance().get(mBattle.getId(),
                battle -> {
                    mBattle.setPlayer1(battle.getPlayer1());
                    mBattle.setPlayer2(battle.getPlayer1());
//                    mBattle.setUsedJutsus(battle.getUsedJutsus());
                    mBattle.setCurrentPlayer(battle.getCurrentPlayer());
                    mBattle.setBattleLogs(battle.getBattleLogs());

                    if (mBattle.getPlayer1().getNick().equals(CharOn.character.getNick())) {
                        player = mBattle.getPlayer1();
                        opponent = mBattle.getPlayer2();
                    } else {
                        player = mBattle.getPlayer1();
                        opponent = mBattle.getPlayer2();
                    }

                    playerFormulas = player.getFormulas();
                    oppFormulas = opponent.getFormulas();
                });
    }
}

