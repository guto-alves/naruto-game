package com.gutotech.narutogame.data.model;

import java.util.ArrayList;
import java.util.Collections;
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
            Ramen myRamen = ramenList.get(ramenIndex);
            myRamen.setInventory(myRamen.getInventory() + quantity);
            ramenList.set(ramenIndex, myRamen);
        } else {
            ramen.setRequirements(null);
            ramen.setInventory(quantity);
            ramenList.add(ramen);
            sortRamens(ramenList);
        }
    }

    public void addScroll(Scroll scroll, int quantity) {
        if (scrollList == null) {
            scrollList = new ArrayList<>();
        }

        if (scrollList.contains(scroll)) {
            int scrollIndex = scrollList.indexOf(scroll);
            Scroll myScroll = scrollList.get(scrollIndex);
            myScroll.setInventory(myScroll.getInventory() + (scroll.getInventory() * quantity));
            scrollList.set(scrollIndex, myScroll);
        } else {
            scroll.setRequirements(null);
            scroll.setInventory(scroll.getInventory() * quantity);
            scrollList.add(scroll);
            sortScrolls(scrollList);
        }
    }

    private void sortRamens(List<Ramen> ramens) {
        Collections.sort(ramens, (ramen1, ramen2) -> {
            if (ramen1.getRecovers() == ramen2.getRecovers()) {
                return 0;
            }
            return ramen1.getRecovers() > ramen2.getRecovers() ? 1 : -1;
        });
    }

    private void sortScrolls(List<Scroll> scrolls) {
        Collections.sort(scrolls, (scroll1, scroll2) -> {
            if (scroll1.getVillage().ordinal() == scroll2.getVillage().ordinal()) {
                return 0;
            }
            return scroll1.getVillage().ordinal() > scroll2.getVillage().ordinal() ? 1 : -1;
        });
    }
}
