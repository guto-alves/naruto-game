package com.gutotech.narutogame.data.model;

import androidx.annotation.Nullable;

import java.util.List;

public class Ramen extends ShopItem {
    private int recovers;

    public Ramen() {
    }

    public Ramen(String image, int name, int description, int value, int recovers) {
        super(image, name, description, null, value, 0);
        this.recovers = recovers;
    }

    public Ramen(String image, int name, int description, List<Requirement> requirements,
                 int value, int recovers) {
        super(image, name, description, requirements, value, 0);
        this.recovers = recovers;
    }

    public int getRecovers() {
        return recovers;
    }

    public void setRecovers(int recovers) {
        this.recovers = recovers;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof Ramen)) {
            return false;
        }

        return getImage().equals(((Ramen) obj).getImage());
    }
}
