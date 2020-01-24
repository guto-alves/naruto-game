package com.gutotech.narutogame.data.model;

import java.util.List;

public class ShopItem extends Item {
    private int value;
    private int inventory;

    public ShopItem() {
    }

    public ShopItem(String image, int name, int description, List<Requirement> requirements,
                    int value, int inventory) {
        super(image, name, description, requirements);
        this.value = value;
        this.inventory = inventory;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }
}
