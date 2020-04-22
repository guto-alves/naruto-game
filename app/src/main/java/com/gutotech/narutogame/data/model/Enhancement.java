package com.gutotech.narutogame.data.model;

import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;

import java.io.Serializable;

public class Enhancement implements Serializable {
    @DrawableRes
    private int image;
    private int atk;
    private int defense;
    private int accuracy;
    private int percentOfChakra;
    private int percentOfStamina;
    private int chakraBuffer;
    private int staminaBuffer;

    public Enhancement() {
    }

    public Enhancement(@DrawableRes int image, int atk, int defense, int accuracy, int percentOfChakra,
                       int percentOfStamina) {
        this.image = image;
        this.atk = atk;
        this.defense = defense;
        this.accuracy = accuracy;
        this.percentOfChakra = percentOfChakra;
        this.percentOfStamina = percentOfStamina;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof Enhancement)) {
            return false;
        }
        return image == ((Enhancement) obj).image;
    }

    @DrawableRes
    public int getImage() {
        return image;
    }

    public void setImage(@DrawableRes int image) {
        this.image = image;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public int getPercentOfChakra() {
        return percentOfChakra;
    }

    public void setPercentOfChakra(int percentOfChakra) {
        this.percentOfChakra = percentOfChakra;
    }

    public int getPercentOfStamina() {
        return percentOfStamina;
    }

    public void setPercentOfStamina(int percentOfStamina) {
        this.percentOfStamina = percentOfStamina;
    }

    public int getChakraBuffer() {
        return chakraBuffer;
    }

    public void setChakraBuffer(int chakraBuffer) {
        this.chakraBuffer = chakraBuffer;
    }

    public int getStaminaBuffer() {
        return staminaBuffer;
    }

    public void setStaminaBuffer(int staminaBuffer) {
        this.staminaBuffer = staminaBuffer;
    }
}
