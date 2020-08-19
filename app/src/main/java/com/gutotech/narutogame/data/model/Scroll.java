package com.gutotech.narutogame.data.model;

import androidx.annotation.Nullable;

import java.util.List;

public class Scroll extends ShopItem {
    private static int SCROLL_DEFAULT_PRICE = 200;
    private static int INVENTORY_DEFAULT_VALUE = 5;

    private Village village;

    public Scroll() {
    }

    public Scroll(String image, Village village) {
        this(image, 0, 0, null, village);
    }

    public Scroll(String image, int name, int description, List<Requirement> requirements,
                  Village village) {
        super(image, name, description, requirements, SCROLL_DEFAULT_PRICE, INVENTORY_DEFAULT_VALUE);
        this.village = village;
    }

    public Village getVillage() {
        return village;
    }

    public void setVillage(Village village) {
        this.village = village;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof Scroll)) {
            return false;
        }

        return getVillage() == ((Scroll) obj).getVillage();
    }
}
