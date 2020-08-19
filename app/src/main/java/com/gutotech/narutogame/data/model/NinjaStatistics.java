package com.gutotech.narutogame.data.model;

public class NinjaStatistics {
    public int ninjaId;
    public String name;
    public int totalPlayers;

    public NinjaStatistics() {
    }

    public NinjaStatistics(Ninja ninja) {
        ninjaId = ninja.getId();
        name = ninja.getName();
        totalPlayers = 0;
    }
}
