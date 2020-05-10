package com.gutotech.narutogame.data.model;

import java.io.Serializable;

public class SpecialMission extends Mission implements Serializable {
    private int defeat;
    private int defeated;

    public SpecialMission() {
    }

    public SpecialMission(String missionInfo, int defeat) {
        super(missionInfo);
        this.defeat = defeat;
    }

    public int getDefeat() {
        return defeat;
    }

    public void setDefeat(int defeat) {
        this.defeat = defeat;
    }

    public int getDefeated() {
        return defeated;
    }

    public void setDefeated(int defeated) {
        this.defeated = defeated;
    }
}
