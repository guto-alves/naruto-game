package com.gutotech.narutogame.data.model;

import java.util.List;

public class Ramen extends ShopItem {
    private int recovers;

    public Ramen() {
    }

    public Ramen(String image, int name, int description, List<Requirement> requirements,
                 int value, int recovers) {
        super(image, name, description, requirements, value, 0);
        this.recovers = recovers;
    }

    public Ramen(String image, int name, int description, List<Requirement> requirements,
                 int value, int inventory, int recovers) {
        super(image, name, description, requirements, value, inventory);
        this.recovers = recovers;
    }

    public int getRecovers() {
        return recovers;
    }

    public void setRecovers(int recovers) {
        this.recovers = recovers;
    }
}
