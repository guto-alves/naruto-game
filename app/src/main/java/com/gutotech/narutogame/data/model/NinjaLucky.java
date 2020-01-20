package com.gutotech.narutogame.data.model;

import java.util.ArrayList;
import java.util.List;

public class NinjaLucky {
    private int lastDayPlayed;

    private List<Boolean> daysOfWeek;

    public NinjaLucky() {
    }

    public void deselectAllDaysPlayed() {
        lastDayPlayed = 0;
        daysOfWeek = new ArrayList<>();
        for (int day = 0; day < 8; day++) {
            daysOfWeek.add(day, false);
        }
    }

    public void selectDayAsPlayed(int day) {
        daysOfWeek.set(day, true);
    }

    public int getLastDayPlayed() {
        return lastDayPlayed;
    }

    public List<Boolean> getDaysOfWeek() {
        return daysOfWeek;
    }
}
