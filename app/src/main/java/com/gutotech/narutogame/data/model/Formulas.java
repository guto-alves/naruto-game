package com.gutotech.narutogame.data.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Formulas implements Serializable {
    private int health;
    private int currentHealth;
    private int chakra;
    private int chakraAtual;
    private int stamina;
    private int staminaAtual;
    private int atkTaiBuki;
    private int atkNinGen;
    private int defTaiBuki;
    private int defNinGen;
    private int accuracy;
    private int concentracao;
    private int percepcao;
    private int conviccao;
    private double esquiva;
    private int determinacao;
    private int ninjaPower;

    public Formulas() {
    }

    public void full() {
        setCurrentHealth(getHealth());
        setChakraAtual(getChakra());
        setStaminaAtual(getStamina());
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getChakra() {
        return chakra;
    }

    public void setChakra(int chakra) {
        this.chakra = chakra;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getAtkTaiBuki() {
        return atkTaiBuki;
    }

    public void setAtkTaiBuki(int atkTaiBuki) {
        this.atkTaiBuki = atkTaiBuki;
    }

    public int getAtkNinGen() {
        return atkNinGen;
    }

    public void setAtkNinGen(int atkNinGen) {
        this.atkNinGen = atkNinGen;
    }

    public int getDefTaiBuki() {
        return defTaiBuki;
    }

    public void setDefTaiBuki(int defTaiBuki) {
        this.defTaiBuki = defTaiBuki;
    }

    public int getDefNinGen() {
        return defNinGen;
    }

    public void setDefNinGen(int defNinGen) {
        this.defNinGen = defNinGen;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public int getConcentracao() {
        return concentracao;
    }

    public void setConcentracao(int concentracao) {
        this.concentracao = concentracao;
    }

    public int getPercepcao() {
        return percepcao;
    }

    public void setPercepcao(int percepcao) {
        this.percepcao = percepcao;
    }

    public int getConviccao() {
        return conviccao;
    }

    public void setConviccao(int conviccao) {
        this.conviccao = conviccao;
    }

    public double getEsquiva() {
        return esquiva;
    }

    public void setEsquiva(double esquiva) {
        this.esquiva = esquiva;
    }

    public int getDeterminacao() {
        return determinacao;
    }

    public void setDeterminacao(int determinacao) {
        this.determinacao = determinacao;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public int getChakraAtual() {
        return chakraAtual;
    }

    public void setChakraAtual(int chakraAtual) {
        this.chakraAtual = chakraAtual;
    }

    public int getStaminaAtual() {
        return staminaAtual;
    }

    public void setStaminaAtual(int staminaAtual) {
        this.staminaAtual = staminaAtual;
    }

    public int getNinjaPower() {
        return ninjaPower;
    }

    public void setNinjaPower(int ninjaPower) {
        this.ninjaPower = ninjaPower;
    }

    public List<AttributeItem> asList() {
        List<AttributeItem> attributeItems = new ArrayList<>();

        attributeItems.add(new AttributeItem(Attribute.HEALTH, currentHealth));
        attributeItems.add(new AttributeItem(Attribute.CHAKRA, chakraAtual));
        attributeItems.add(new AttributeItem(Attribute.STAMINA, staminaAtual));
        attributeItems.add(new AttributeItem(Attribute.ATK_TAI, atkTaiBuki));
        attributeItems.add(new AttributeItem(Attribute.ATK_NIN, atkNinGen));
        attributeItems.add(new AttributeItem(Attribute.DEF_TAI, defTaiBuki));
        attributeItems.add(new AttributeItem(Attribute.DEF_NIN, defNinGen));
        attributeItems.add(new AttributeItem(Attribute.ACC, accuracy));

        return attributeItems;
    }


}
