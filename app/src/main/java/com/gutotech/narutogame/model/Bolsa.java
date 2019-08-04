package com.gutotech.narutogame.model;

import java.util.List;

public class Bolsa {
    List<Ramen> ramenList;
    List<Pergaminho> pergaminhoList;
    List<Jutsu> armasList;

    public List<Ramen> getRamenList() {
        return ramenList;
    }

    public void setRamenList(List<Ramen> ramenList) {
        this.ramenList = ramenList;
    }

    public List<Pergaminho> getPergaminhoList() {
        return pergaminhoList;
    }

    public void setPergaminhoList(List<Pergaminho> pergaminhoList) {
        this.pergaminhoList = pergaminhoList;
    }

    public List<Jutsu> getArmasList() {
        return armasList;
    }

    public void setArmasList(List<Jutsu> armasList) {
        this.armasList = armasList;
    }
}
