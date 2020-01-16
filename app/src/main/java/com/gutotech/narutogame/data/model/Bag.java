package com.gutotech.narutogame.data.model;

import java.io.Serializable;
import java.util.List;

public class Bag implements Serializable {
    private List<Ramen> ramensList;
    private List<Pergaminho> pergaminhosList;
    private List<Jutsu> armasList;

    public Bag() {
    }

    public Bag(List<Ramen> ramensList) {
        this.ramensList = ramensList;
    }

    public Bag(List<Ramen> ramensList, List<Pergaminho> pergaminhosList, List<Jutsu> armasList) {
        this.ramensList = ramensList;
        this.pergaminhosList = pergaminhosList;
        this.armasList = armasList;
    }

    public List<Ramen> getRamensList() {
        return ramensList;
    }

    public void setRamensList(List<Ramen> ramensList) {
        this.ramensList = ramensList;
    }

    public List<Pergaminho> getPergaminhosList() {
        return pergaminhosList;
    }

    public void setPergaminhosList(List<Pergaminho> pergaminhosList) {
        this.pergaminhosList = pergaminhosList;
    }

    public List<Jutsu> getArmasList() {
        return armasList;
    }

    public void setArmasList(List<Jutsu> armasList) {
        this.armasList = armasList;
    }
}
