package com.gutotech.narutogame.data.model;

public enum Attribute {
    TAI("Taijutsu"),
    BUK("Bukijutsu"),
    NIN("Ninjutsu"),
    GEN("Genjutsu"),
    SELO("Selo"),
    AGI("Agilidade"),
    FOR("Força"),
    INTE("Inteligência"),
    ENER("Energia"),
    RES("Resistência");

    public final String name;

    Attribute(String name) {
        this.name = name;
    }
}
