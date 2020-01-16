package com.gutotech.narutogame.data.model;

import com.google.firebase.database.Exclude;
import com.gutotech.narutogame.ui.MyListener;

import java.io.Serializable;

public class Atributo implements Serializable {
    // Nomes dos atributos
    public static final String TAI = "Taijutsu";
    public static final String BUK = "Bukijutsu";
    public static final String NIN = "Ninjutsu";
    public static final String GEN = "Genjutsu";
    public static final String SELO = "Selo";
    public static final String AGI = "Agilidade";
    public static final String FOR = "Força";
    public static final String INTE = "Inteligência";
    public static final String ENER = "Energia";
    public static final String RES = "Resistência";

    private String nome;
    private int imagem;
    private int quantidade;

    private MyListener listener;

    public Atributo() {
    }

    public Atributo(String nome, int imagem, int quantidade) {
        this.nome = nome;
        this.imagem = imagem;
        this.quantidade = quantidade;
    }

    public Atributo(String nome, int imagem, int quantidade, MyListener listener) {
        this.nome = nome;
        this.imagem = imagem;
        this.quantidade = quantidade;
        this.listener = listener;
    }

    public void treinarAtributo(int atributoPosition) {
        listener.callback(atributoPosition);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Exclude
    public MyListener getListener() {
        return listener;
    }

    public void setListener(MyListener listener) {
        this.listener = listener;
    }
}
