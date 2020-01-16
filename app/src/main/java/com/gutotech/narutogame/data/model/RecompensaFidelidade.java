package com.gutotech.narutogame.data.model;

import com.gutotech.narutogame.ui.MyListener;

import java.util.Locale;

public class RecompensaFidelidade {
    public enum Tipo {RY, EXP, RAMEM, PONTO_BIJUU, CREDITO}

    private Tipo tipo;
    private int quantidade;
    private String recompensaString;
    private MyListener myListener;

    public RecompensaFidelidade() {
    }

    public RecompensaFidelidade(Tipo tipo, int quantidade, String recompensaString, MyListener myListener) {
        this.tipo = tipo;
        this.quantidade = quantidade;
        this.recompensaString = recompensaString;
        this.myListener = myListener;
    }

    public void receberRecompensa(int position) {
        myListener.callback(position);
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return String.format(Locale.getDefault(), "%d %s", getQuantidade(), recompensaString);
    }
}
