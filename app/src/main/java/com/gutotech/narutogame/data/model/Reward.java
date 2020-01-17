package com.gutotech.narutogame.data.model;

import com.gutotech.narutogame.R;

public abstract class Reward {
    public enum Tipo {
        MISSION(R.string.missions), EQUIPE(1), BATALHAS(6);

        Tipo(int missão) {
        }
    }
}
