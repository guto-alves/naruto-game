package com.gutotech.narutogame.data.model;

import androidx.annotation.NonNull;

public enum Classe {
    TAI("Taijutsu"),
    BUK("Bukijutsu"),
    NIN("Ninjutsu"),
    GEN("Genjutsu");

    public final String name;

    Classe(String name) {
        this.name = name;
    }

    @NonNull
    @Override
    public String toString() {
        return name;
    }
}
