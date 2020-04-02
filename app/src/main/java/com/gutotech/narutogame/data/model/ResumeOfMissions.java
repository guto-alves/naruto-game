package com.gutotech.narutogame.data.model;

import java.util.List;

public class ResumeOfMissions {
    private int rankS;
    private int rankA;
    private int rankB;
    private int rankC;
    private int rankD;
    private int tasks;

    private List<Integer> missionsFinishedId;

    public ResumeOfMissions() {
    }

    public int getRankS() {
        return rankS;
    }

    public void setRankS(int rankS) {
        this.rankS = rankS;
    }

    public int getRankA() {
        return rankA;
    }

    public void setRankA(int rankA) {
        this.rankA = rankA;
    }

    public int getRankB() {
        return rankB;
    }

    public void setRankB(int rankB) {
        this.rankB = rankB;
    }

    public int getRankC() {
        return rankC;
    }

    public void setRankC(int rankC) {
        this.rankC = rankC;
    }

    public int getRankD() {
        return rankD;
    }

    public void setRankD(int rankD) {
        this.rankD = rankD;
    }

    public int getTasks() {
        return tasks;
    }

    public void setTasks(int tasks) {
        this.tasks = tasks;
    }

    public List<Integer> getMissionsFinishedId() {
        return missionsFinishedId;
    }

    public void setMissionsFinishedId(List<Integer> missionsFinishedId) {
        this.missionsFinishedId = missionsFinishedId;
    }
}
