package com.gutotech.narutogame.data.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;

import java.util.ArrayList;
import java.util.List;

public class Battle extends BaseObservable {
    public enum Status {
        CONTINUE, PLAYER1_WON, PLAYER2_WON, PLAYER1_INACTIVATED, PLAYER2_INACTIVATED, DRAWN
    }

    private Status status;
    private String id;
    private Character player1;
    private Character player2;
    private int currentPlayer;
    private long attackStart;
    private Jutsu jutsuBuffer;
    private int playersInBattle;
    private List<Jutsu> buffsDebuffsUsed1;
    private List<Jutsu> buffsDebuffsUsed2;
    private List<BattleLog> battleLogs;

    public Battle() {
    }

    public Battle(String id, Character player1, Character player2, long attackStart) {
        this.id = id;
        this.player1 = player1;
        this.player2 = player2;
        this.attackStart = attackStart;
        status = Status.CONTINUE;
        currentPlayer = 1;
        playersInBattle = 2;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Bindable
    public Character getPlayer1() {
        return player1;
    }

    public void setPlayer1(Character player1) {
        this.player1 = player1;
        notifyPropertyChanged(BR.player1);
    }

    @Bindable
    public Character getPlayer2() {
        return player2;
    }

    public void setPlayer2(Character player2) {
        this.player2 = player2;
        notifyPropertyChanged(BR.player2);
    }

    @Bindable
    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(int currentPlayer) {
        this.currentPlayer = currentPlayer;
        notifyPropertyChanged(BR.currentPlayer);
    }

    public long getAttackStart() {
        return attackStart;
    }

    public void setAttackStart(long attackStart) {
        this.attackStart = attackStart;
    }

    public Jutsu getJutsuBuffer() {
        return jutsuBuffer;
    }

    public void setJutsuBuffer(Jutsu jutsuBuffer) {
        this.jutsuBuffer = jutsuBuffer;
    }

    public List<Jutsu> getBuffsDebuffsUsed1() {
        if (buffsDebuffsUsed1 == null) {
            buffsDebuffsUsed1 = new ArrayList<>();
        }
        return buffsDebuffsUsed1;
    }

    public void setBuffsDebuffsUsed1(List<Jutsu> buffsDebuffsUsed1) {
        this.buffsDebuffsUsed1 = buffsDebuffsUsed1;
    }

    public List<Jutsu> getBuffsDebuffsUsed2() {
        if (buffsDebuffsUsed2 == null) {
            buffsDebuffsUsed2 = new ArrayList<>();
        }
        return buffsDebuffsUsed2;
    }

    public void setBuffsDebuffsUsed2(List<Jutsu> buffsDebuffsUsed2) {
        this.buffsDebuffsUsed2 = buffsDebuffsUsed2;
    }

    public int getPlayersInBattle() {
        return playersInBattle;
    }

    public void setPlayersInBattle(int playersInBattle) {
        this.playersInBattle = playersInBattle;
    }

    public List<BattleLog> getBattleLogs() {
        if (battleLogs == null) {
            battleLogs = new ArrayList<>();
        }
        return battleLogs;
    }

    public void setBattleLogs(List<BattleLog> battleLogs) {
        this.battleLogs = battleLogs;
    }

}
