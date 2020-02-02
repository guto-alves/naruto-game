package com.gutotech.narutogame.data.model;

public class Mission {
    public enum MissionRank {TASK, RANK_D, RANK_C, RANK_B, RANK_A, RANK_S}

    private String missionInfo;

    public Mission() {
    }

    public Mission(String missionInfo) {
        this.missionInfo = missionInfo;
    }

    public String getMissionInfo() {
        return missionInfo;
    }

    public void setMissionInfo(String missionInfo) {
        this.missionInfo = missionInfo;
    }

    public MissionInfo missionInfo() {
        return MissionInfo.valueOf(getMissionInfo());
    }
}
