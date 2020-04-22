package com.gutotech.narutogame.data.model;

public class ElementalJutsu extends Jutsu {
    private Element element;

    public ElementalJutsu() {
    }

    public ElementalJutsu(String name, Classe classe, int atk, int baseDefense, int accuracy,
                          int consumesChakra, int consumesStamina, Element element) {
        super(name, classe, atk, baseDefense, accuracy, consumesChakra, consumesStamina);
        this.element = element;
    }

    public Element getElement() {
        return element;
    }

    public void setElement(Element element) {
        this.element = element;
    }
}
