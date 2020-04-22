package com.gutotech.narutogame.data.model;

import java.util.List;

public class BattleLogs {
    private long initialTime;
    private long finalTime;
    private String fighter1Id;
    private String fighter2Id;
    private List<BattleLog> battleLogs;

    public BattleLogs() {
    }

    public BattleLogs(String fighter1Id, String fighter2Id, List<BattleLog> battleLogs) {
        this.initialTime = initialTime;
        this.finalTime = finalTime;
        this.fighter1Id = fighter1Id;
        this.fighter2Id = fighter2Id;
        this.battleLogs = battleLogs;
    }

    public BattleLogs(long initialTime, long finalTime, String fighter1Id, String fighter2Id, List<BattleLog> battleLogs) {
        this.initialTime = initialTime;
        this.finalTime = finalTime;
        this.fighter1Id = fighter1Id;
        this.fighter2Id = fighter2Id;
        this.battleLogs = battleLogs;
    }

    public long getInitialTime() {
        return initialTime;
    }

    public void setInitialTime(long initialTime) {
        this.initialTime = initialTime;
    }

    public long getFinalTime() {
        return finalTime;
    }

    public void setFinalTime(long finalTime) {
        this.finalTime = finalTime;
    }

    public String getFighter1Id() {
        return fighter1Id;
    }

    public void setFighter1Id(String fighter1Id) {
        this.fighter1Id = fighter1Id;
    }

    public String getFighter2Id() {
        return fighter2Id;
    }

    public void setFighter2Id(String fighter2Id) {
        this.fighter2Id = fighter2Id;
    }

    public List<BattleLog> getBattleLogs() {
        return battleLogs;
    }

    public void setBattleLogs(List<BattleLog> battleLogs) {
        this.battleLogs = battleLogs;
    }
}
