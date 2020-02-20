package com.gutotech.narutogame.data.model;

import java.util.List;

public class Scroll extends ShopItem {
    private Village village;

    public Scroll() {
    }

    public Scroll(String image, int name, int description, List<Requirement> requirements,
                  Village village) {
        super(image, name, description, requirements, 2000, 5);
        this.village = village;
    }

    public Village getVillage() {
        return village;
    }

    public void setVillage(Village village) {
        this.village = village;
    }
}
