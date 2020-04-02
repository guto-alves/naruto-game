package com.gutotech.narutogame.data.model;

public class KageAndVila {
    private int vilaId;
    private int ninjaId;
    private String kageName;
    private int kageLevel;

    public KageAndVila() {
    }

    public KageAndVila(int vilaId, int ninjaId, String kageName, int kageLevel) {
        this.vilaId = vilaId;
        this.ninjaId = ninjaId;
        this.kageName = kageName;
        this.kageLevel = kageLevel;
    }

    public int getVilaId() {
        return vilaId;
    }

    public void setVilaId(int vilaId) {
        this.vilaId = vilaId;
    }

    public int getNinjaId() {
        return ninjaId;
    }

    public void setNinjaId(int ninjaId) {
        this.ninjaId = ninjaId;
    }

    public String getKageName() {
        return kageName;
    }

    public void setKageName(String kageName) {
        this.kageName = kageName;
    }

    public int getKageLevel() {
        return kageLevel;
    }

    public void setKageLevel(int kageLevel) {
        this.kageLevel = kageLevel;
    }
}
