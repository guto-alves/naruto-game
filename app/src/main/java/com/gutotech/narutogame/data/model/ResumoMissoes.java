package com.gutotech.narutogame.data.model;

import java.io.Serializable;

public class ResumoMissoes implements Serializable {
    private int rankS;
    private int rankA;
    private int rankB;
    private int rankC;
    private int rankD;
    private int tarefas;

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

    public int getTarefas() {
        return tarefas;
    }

    public void setTarefas(int tarefas) {
        this.tarefas = tarefas;
    }
}
