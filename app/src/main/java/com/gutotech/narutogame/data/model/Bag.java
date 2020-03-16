package com.gutotech.narutogame.data.model;

import java.util.ArrayList;
import java.util.List;

public class Bag {
    private List<Ramen> ramenList;
    private List<Scroll> scrollList;

    public Bag() {
    }

    public List<Ramen> getRamenList() {
        return ramenList;
    }

    public void setRamenList(List<Ramen> ramenList) {
        this.ramenList = ramenList;
    }

    public List<Scroll> getScrollList() {
        return scrollList;
    }

    public void setScrollList(List<Scroll> scrollList) {
        this.scrollList = scrollList;
    }

    public void addRamen(Ramen ramen, int quantity) {
        if (ramenList == null) {
            ramenList = new ArrayList<>();
        }

        if (ramenList.contains(ramen)) {
            int ramenIndex = ramenList.indexOf(ramen);
            Ramen r = ramenList.get(ramenIndex);
            r.setInventory(r.getInventory() + quantity);
            ramenList.set(ramenIndex, ramen);
        } else {
            ramen.setRequirements(null);
            ramen.setInventory(quantity);
            ramenList.add(ramen);
        }
    }

    public void addScroll(Scroll scroll, int quantity) {
        if (scrollList == null) {
            scrollList = new ArrayList<>();
        }

        if (scrollList.contains(scroll)) {
            int scrollIndex = scrollList.indexOf(scroll);
            Scroll r = scrollList.get(scrollIndex);
            r.setInventory(r.getInventory() + quantity);
            scrollList.set(scrollIndex, scroll);
        } else {
            scroll.setRequirements(null);
            scroll.setInventory(quantity);
            scrollList.add(scroll);
        }
    }
}
