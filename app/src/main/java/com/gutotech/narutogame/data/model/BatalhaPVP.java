package com.gutotech.narutogame.data.model;

public class BatalhaPVP {
    private Personagem player1;
    private Personagem player2;

    private String ganhador;
    private String quemAtaca;
    private int numeroDeQuemAtaca;

    private Jutsu acaoPlayer1;
    private Jutsu acaoPlayer2;

    public Personagem getPlayer1() {
        return player1;
    }

    public void setPlayer1(Personagem player1) {
        this.player1 = player1;
    }

    public Personagem getPlayer2() {
        return player2;
    }

    public void setPlayer2(Personagem player2) {
        this.player2 = player2;
    }

    public String getGanhador() {
        return ganhador;
    }

    public void setGanhador(String ganhador) {
        this.ganhador = ganhador;
    }

    public String getQuemAtaca() {
        return quemAtaca;
    }

    public void setQuemAtaca(String quemAtaca) {
        this.quemAtaca = quemAtaca;
    }

    public Jutsu getAcaoPlayer1() {
        return acaoPlayer1;
    }

    public void setAcaoPlayer1(Jutsu acaoPlayer1) {
        this.acaoPlayer1 = acaoPlayer1;
    }

    public Jutsu getAcaoPlayer2() {
        return acaoPlayer2;
    }

    public void setAcaoPlayer2(Jutsu acaoPlayer2) {
        this.acaoPlayer2 = acaoPlayer2;
    }

    public int getNumeroDeQuemAtaca() {
        return numeroDeQuemAtaca;
    }

    public void setNumeroDeQuemAtaca(int numeroDeQuemAtaca) {
        this.numeroDeQuemAtaca = numeroDeQuemAtaca;
    }
}
