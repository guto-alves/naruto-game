package com.gutotech.narutogame.data.model;

public enum Graduation {
    ESTUDANTE(4000),
    GENIN(6000),
    CHUUNIN(8000),
    JOUNIN(10000),
    ANBU(12000),
    SANNIN(14000),
    HERO(15000);

    public final int dailyTrainingLimit;

    Graduation(int dailyTrainingLimit) {
        this.dailyTrainingLimit = dailyTrainingLimit;
    }
}
