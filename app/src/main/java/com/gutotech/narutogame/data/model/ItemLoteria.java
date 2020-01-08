package com.gutotech.narutogame.data.model;

public class ItemLoteria {
    private String image;
    private String nome;
    private int chanceDeGanhar;

    private enum Tipo {RYOUS, EXP, RAMEN, ARMA, ATRIBUTO, CREDITO, PONTO_TREINO, PERGAMINHO}

    private Tipo tipo;


    public ItemLoteria(String image, String nome, int chanceDeGanhar) {
        this.image = image;
        this.nome = nome;
        this.chanceDeGanhar = chanceDeGanhar;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getChanceDeGanhar() {
        return chanceDeGanhar;
    }

    public void setChanceDeGanhar(int chanceDeGanhar) {
        this.chanceDeGanhar = chanceDeGanhar;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
}
