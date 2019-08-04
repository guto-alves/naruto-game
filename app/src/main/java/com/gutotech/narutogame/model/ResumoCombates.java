package com.gutotech.narutogame.model;

import java.io.Serializable;

public class ResumoCombates implements Serializable {
    private int vitNPC;
    private int vitDojo;
    private int vitMapa;
    private int vit4x4;

    private int derNPC;
    private int derDojo;
    private int derMapa;
    private int der4x4;

    private int empNPC;
    private int empPVP;

    public int getVitNPC() {
        return vitNPC;
    }

    public void setVitNPC(int vitNPC) {
        this.vitNPC = vitNPC;
    }

    public int getVitDojo() {
        return vitDojo;
    }

    public void setVitDojo(int vitDojo) {
        this.vitDojo = vitDojo;
    }

    public int getVitMapa() {
        return vitMapa;
    }

    public void setVitMapa(int vitMapa) {
        this.vitMapa = vitMapa;
    }

    public int getVit4x4() {
        return vit4x4;
    }

    public void setVit4x4(int vit4x4) {
        this.vit4x4 = vit4x4;
    }

    public int getDerNPC() {
        return derNPC;
    }

    public void setDerNPC(int derNPC) {
        this.derNPC = derNPC;
    }

    public int getDerDojo() {
        return derDojo;
    }

    public void setDerDojo(int derDojo) {
        this.derDojo = derDojo;
    }

    public int getDerMapa() {
        return derMapa;
    }

    public void setDerMapa(int derMapa) {
        this.derMapa = derMapa;
    }

    public int getDer4x4() {
        return der4x4;
    }

    public void setDer4x4(int der4x4) {
        this.der4x4 = der4x4;
    }

    public int getEmpNPC() {
        return empNPC;
    }

    public void setEmpNPC(int empNPC) {
        this.empNPC = empNPC;
    }

    public int getEmpPVP() {
        return empPVP;
    }

    public void setEmpPVP(int empPVP) {
        this.empPVP = empPVP;
    }
}
