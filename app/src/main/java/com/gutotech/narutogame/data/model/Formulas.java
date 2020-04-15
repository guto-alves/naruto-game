package com.gutotech.narutogame.data.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;

import com.google.firebase.database.Exclude;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class Formulas extends BaseObservable implements Serializable {
    private int health;
    private int currentHealth;
    private int chakra;
    private int currentChakra;
    private int stamina;
    private int currentStamina;
    private int atkTaiBuki;
    private int atkNinGen;
    private int defTaiBuki;
    private int defNinGen;
    private int accuracy;
    private int ninjaPower;

    public Formulas() {
    }

    public void validateCeil() {
        if (getCurrentHealth() > getHealth()) {
            setCurrentHealth(getHealth());
        }

        if (getCurrentChakra() > getChakra()) {
            setCurrentChakra(getChakra());
        }

        if (getCurrentStamina() > getStamina()) {
            setCurrentStamina(getStamina());
        }
    }

    public void full() {
        setCurrentHealth(getHealth());
        setCurrentChakra(getChakra());
        setCurrentStamina(getStamina());
    }

    @Exclude
    public boolean isFull() {
        return getCurrentHealth() == getHealth() &&
                getCurrentChakra() == getChakra() &&
                getCurrentStamina() == getStamina();
    }

    public void subHeath(int value) {
        setCurrentHealth(Math.max(getCurrentHealth() - value, 0));
    }

    public void subChakra(int value) {
        setCurrentChakra(Math.max(getCurrentChakra() - value, 0));
    }

    public void subStamina(int value) {
        setCurrentStamina(Math.max(getCurrentStamina() - value, 0));
    }

    public void addHeath(int value) {
        int newHealth = getCurrentHealth() + value;
        setCurrentHealth(newHealth >= getHealth() ? getHealth() : newHealth);
    }

    public void addChakra(int value) {
        int newChakra = getCurrentChakra() + value;
        setCurrentChakra(newChakra >= getChakra() ? getChakra() : newChakra);
    }

    public void addStamina(int value) {
        int newStamina = getCurrentStamina() + value;
        setCurrentStamina(newStamina >= getStamina() ? getStamina() : newStamina);
    }

    public List<Integer> asList() {
        return Arrays.asList(
                currentHealth,
                currentChakra,
                currentStamina,
                atkTaiBuki,
                atkNinGen,
                defTaiBuki,
                defNinGen,
                accuracy
        );
    }


    @Bindable
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
        notifyPropertyChanged(BR.health);
    }

    @Bindable
    public int getChakra() {
        return chakra;
    }

    public void setChakra(int chakra) {
        this.chakra = chakra;
        notifyPropertyChanged(BR.chakra);
    }

    @Bindable
    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
        notifyPropertyChanged(BR.stamina);
    }

    @Bindable
    public int getAtkTaiBuki() {
        return atkTaiBuki;
    }

    @Bindable
    public void setAtkTaiBuki(int atkTaiBuki) {
        this.atkTaiBuki = atkTaiBuki;
        notifyPropertyChanged(BR.atkTaiBuki);
    }

    @Bindable
    public int getAtkNinGen() {
        return atkNinGen;
    }

    public void setAtkNinGen(int atkNinGen) {
        this.atkNinGen = atkNinGen;
        notifyPropertyChanged(BR.atkNinGen);
    }

    @Bindable
    public int getDefTaiBuki() {
        return defTaiBuki;
    }

    public void setDefTaiBuki(int defTaiBuki) {
        this.defTaiBuki = defTaiBuki;
        notifyPropertyChanged(BR.defTaiBuki);
    }

    @Bindable
    public int getDefNinGen() {
        return defNinGen;
    }

    public void setDefNinGen(int defNinGen) {
        this.defNinGen = defNinGen;
        notifyPropertyChanged(BR.defNinGen);
    }

    @Bindable
    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
        notifyPropertyChanged(BR.accuracy);
    }

    @Bindable
    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
        notifyPropertyChanged(BR.currentHealth);
    }

    @Bindable
    public int getCurrentChakra() {
        return currentChakra;
    }

    public void setCurrentChakra(int currentChakra) {
        this.currentChakra = currentChakra;
        notifyPropertyChanged(BR.currentChakra);
    }

    @Bindable
    public int getCurrentStamina() {
        return currentStamina;
    }

    public void setCurrentStamina(int currentStamina) {
        this.currentStamina = currentStamina;
        notifyPropertyChanged(BR.currentStamina);
    }

    @Bindable
    public int getNinjaPower() {
        return ninjaPower;
    }

    public void setNinjaPower(int ninjaPower) {
        this.ninjaPower = ninjaPower;
        notifyPropertyChanged(BR.ninjaPower);
    }
}
