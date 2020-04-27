package com.gutotech.narutogame.data.model;

import androidx.annotation.Nullable;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;

import com.google.firebase.database.Exclude;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Jutsu extends BaseObservable implements Serializable {
    public enum Type {ATK, DEF, BUFF, DEBUFF, WEAPON}

    public static final String SLOT_1 = "slot1";
    public static final String SLOT_2 = "slot2";
    public static final String SLOT_3 = "slot3";

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
    private boolean visible;
    private int level;
    private Map<String, Enhancement> enhancements;

    public Jutsu() {
    }

    public Jutsu(String name, Classe classe, int atk, int baseDefense, int accuracy,
                 int consumesChakra, int consumesStamina) {
        this(name, classe, atk, baseDefense, accuracy, consumesChakra,
                consumesStamina, 4);
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
        this.inventory = 1;
        visible = true;
    }

    public void activate(Enhancement enhancement, String slot) {
        if (getEnhancements().containsKey(slot)) {
            deactivate(slot);
        }
        getEnhancements().put(slot, enhancement);

        setLevel(getLevel() + 1);
        setAtk(getAtk() + enhancement.getAtk());
        setBaseDefense(getBaseDefense() + enhancement.getDefense());
        setAccuracy(getAccuracy() + enhancement.getAccuracy());

        enhancement.setChakraBuffer((getConsumesChakra() * enhancement.getPercentOfChakra() / 100));
        enhancement.setStaminaBuffer((getConsumesStamina() * enhancement.getPercentOfStamina() / 100));

        setConsumesChakra(getConsumesChakra() + enhancement.getChakraBuffer());
        setConsumesStamina(getConsumesStamina() + enhancement.getStaminaBuffer());

        notifyPropertyChanged(BR.enhancements);
    }

    private void deactivate(String slot) {
        Enhancement enhancement = getEnhancements().get(slot);
        setLevel(getLevel() - 1);
        setAtk(getAtk() - enhancement.getAtk());
        setBaseDefense(getBaseDefense() - enhancement.getDefense());
        setAccuracy(getAccuracy() - enhancement.getAccuracy());
        setConsumesChakra(getConsumesChakra() - enhancement.getChakraBuffer());
        setConsumesStamina(getConsumesStamina() - enhancement.getStaminaBuffer());
    }

    @Exclude
    public JutsuInfo getJutsuInfo() {
        return JutsuInfo.valueOf(getName());
    }

    public boolean isBuffOrDebuff() {
        return isBuffOrDebuff(getJutsuInfo());
    }

    public boolean isBuffOrDebuff(JutsuInfo jutsuInfo) {
        return jutsuInfo.type == Jutsu.Type.BUFF
                || jutsuInfo.type == Jutsu.Type.DEBUFF;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof Jutsu)) {
            return false;
        }

        return getName().equals(((Jutsu) obj).getName());
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

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Bindable
    public Map<String, Enhancement> getEnhancements() {
        if (enhancements == null) {
            enhancements = new HashMap<>();
        }
        return enhancements;
    }

    public void setEnhancements(Map<String, Enhancement> enhancements) {
        this.enhancements = enhancements;
    }
}
