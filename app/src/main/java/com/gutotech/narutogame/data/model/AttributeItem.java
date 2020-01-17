package com.gutotech.narutogame.data.model;

public class AttributeItem {
    private Attribute attribute;
    private int total;

    public AttributeItem() {
    }

    public AttributeItem(Attribute attribute, int total) {
        this.attribute = attribute;
        this.total = total;
    }

    public Attribute getAttribute() {
        return attribute;
    }

    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
