package com.gutotech.narutogame.data.model;

import androidx.annotation.StringRes;

import java.util.List;

public class Item {
    private String image;

    @StringRes
    private int name;

    @StringRes
    private int description;

    private List<Requirement> requirements;

    public Item() {
    }

    public Item(String image, @StringRes int name, @StringRes int description, List<Requirement> requirements) {
        this.image = image;
        this.name = name;
        this.description = description;
        this.requirements = requirements;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @StringRes
    public int getName() {
        return name;
    }

    public void setName(@StringRes int name) {
        this.name = name;
    }

    @StringRes
    public int getDescription() {
        return description;
    }

    public void setDescription(@StringRes int description) {
        this.description = description;
    }

    public List<Requirement> getRequirements() {
        return requirements;
    }

    public void setRequirements(List<Requirement> requirements) {
        this.requirements = requirements;
    }
}


