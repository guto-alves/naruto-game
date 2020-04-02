package com.gutotech.narutogame.data.model;

import androidx.annotation.Nullable;

import com.google.firebase.database.Exclude;

public class Jutsu {
    public enum Type {ATK, DEF, BUFF, DEBUFF, WEAPON}

    private String name; // refers to JutsuInfo Enum

    private Classe classe;

    private int atk;
    private int baseDefense;
    private int accuracy;

    private int consumesChakra;
    private int consumesStamina;

    private int usageInterval;
    private int remainingIntervals;

    private int inventory;

    public Jutsu() {
    }

    public Jutsu(String name, Classe classe, int atk, int baseDefense, int accuracy,
                 int consumesChakra, int consumesStamina, int usageInterval) {
        this.name = name;
        this.classe = classe;
        this.atk = atk;
        this.baseDefense = baseDefense;
        this.accuracy = accuracy;
        this.consumesChakra = consumesChakra;
        this.consumesStamina = consumesStamina;
        this.usageInterval = usageInterval;
        inventory = 1;
    }

    public Jutsu(String name, Classe classe, int atk, int baseDefense, int accuracy,
                 int consumesChakra, int consumesStamina) {
        this.name = name;
        this.classe = classe;
        this.atk = atk;
        this.baseDefense = baseDefense;
        this.accuracy = accuracy;
        this.consumesChakra = consumesChakra;
        this.consumesStamina = consumesStamina;
        this.usageInterval = 4;
        inventory = 1;
    }

    public Jutsu(String name, Classe classe, int atk, int baseDefense, int accuracy,
                 int consumesChakra, int consumesStamina, int usageInterval, int inventory) {
        this.name = name;
        this.classe = classe;
        this.atk = atk;
        this.baseDefense = baseDefense;
        this.accuracy = accuracy;
        this.consumesChakra = consumesChakra;
        this.consumesStamina = consumesStamina;
        this.usageInterval = usageInterval;
        this.inventory = inventory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getBaseDefense() {
        return baseDefense;
    }

    public void setBaseDefense(int baseDefense) {
        this.baseDefense = baseDefense;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public int getConsumesStamina() {
        return consumesStamina;
    }

    public void setConsumesStamina(int consumesStamina) {
        this.consumesStamina = consumesStamina;
    }

    public int getConsumesChakra() {
        return consumesChakra;
    }

    public void setConsumesChakra(int consumesChakra) {
        this.consumesChakra = consumesChakra;
    }

    public int getUsageInterval() {
        return usageInterval;
    }

    public void setUsageInterval(int usageInterval) {
        this.usageInterval = usageInterval;
    }

    public int getRemainingIntervals() {
        return remainingIntervals;
    }

    public void setRemainingIntervals(int remainingIntervals) {
        this.remainingIntervals = remainingIntervals;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    @Exclude
    public JutsuInfo getJutsuInfo() {
        return JutsuInfo.valueOf(getName());
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof Jutsu)) {
            return false;
        }

        return getName().equals(((Jutsu) obj).getName());
    }
}
