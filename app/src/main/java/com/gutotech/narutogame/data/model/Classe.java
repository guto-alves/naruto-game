package com.gutotech.narutogame.data.model;

public enum Classe {
    TAI("Taijutsu"),
    BUK("Bukijutsu"),
    NIN("Ninjutsu"),
    GEN("Genjutsu");

    public final String name;

    Classe(String name) {
        this.name = name;
    }
}
