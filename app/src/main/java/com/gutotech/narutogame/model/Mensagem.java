package com.gutotech.narutogame.model;

public class Mensagem {
    private String quemMandou;
    private String oQueMandou;

    public Mensagem() {

    }

    public Mensagem(String quemMandou, String oQueMandou) {
        this.quemMandou = quemMandou;
        this.oQueMandou = oQueMandou;
    }

    public String getQuemMandou() {
        return quemMandou;
    }

    public void setQuemMandou(String quemMandou) {
        this.quemMandou = quemMandou;
    }

    public String getoQueMandou() {
        return oQueMandou;
    }

    public void setoQueMandou(String oQueMandou) {
        this.oQueMandou = oQueMandou;
    }
}
