package com.gutotech.narutogame.data.model;

public class NinjaStatistics {
    public int ninjaId;
    public int totalPlayers;
    public String name;

    public NinjaStatistics() {
    }

    public NinjaStatistics(Ninja ninja) {
        ninjaId = ninja.getId();
        name = ninja.getName();
    }
}
