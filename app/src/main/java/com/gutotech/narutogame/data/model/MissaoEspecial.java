package com.gutotech.narutogame.data.model;

import com.gutotech.narutogame.ui.MyListener;

import java.io.Serializable;

public class MissaoEspecial extends Missao implements Serializable {
    private int derrotar;
    private int derrotados;
    private int pontosAbatidosRecompensa;
    private boolean falhou;

    public MissaoEspecial() {
    }

    public MissaoEspecial(int id, String titulo, String descricao, String graduacao, int level, String rank, String dataConcluida, String horarioConcluido, MyListener listener, int derrotar, int derrotados, int pontosAbatidosRecompensa, boolean falhou) {
        super(id, titulo, descricao, graduacao, level, rank, dataConcluida, horarioConcluido, listener);
        this.derrotar = derrotar;
        this.derrotados = derrotados;
        this.pontosAbatidosRecompensa = pontosAbatidosRecompensa;
        this.falhou = falhou;
    }

    public int getDerrotar() {
        return derrotar;
    }

    public void setDerrotar(int derrotar) {
        this.derrotar = derrotar;
    }

    public int getDerrotados() {
        return derrotados;
    }

    public void setDerrotados(int derrotados) {
        this.derrotados = derrotados;
    }

    public int getPontosAbatidosRecompensa() {
        return pontosAbatidosRecompensa;
    }

    public void setPontosAbatidosRecompensa(int pontosAbatidosRecompensa) {
        this.pontosAbatidosRecompensa = pontosAbatidosRecompensa;
    }

    public boolean isFalhou() {
        return falhou;
    }

    public void setFalhou(boolean falhou) {
        this.falhou = falhou;
    }
}
