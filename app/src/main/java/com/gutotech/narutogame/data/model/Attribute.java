package com.gutotech.narutogame.data.model;

import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;

import com.gutotech.narutogame.R;

public enum Attribute {
    TAI(0, R.string.taijutsu, R.drawable.layout_icones_tai),
    BUK(1, R.string.bukijutsu, R.drawable.layout_icones_ken),
    NIN(2, R.string.ninjustu, R.drawable.layout_icones_nin),
    GEN(3, R.string.genjutsu, R.drawable.layout_icones_gen),
    SEAL(4, R.string.seal, R.drawable.layout_icones_conhe),
    AGI(5, R.string.agility, R.drawable.layout_icones_agi),
    FOR(6, R.string.strength, R.drawable.layout_icones_forc),
    INTE(7, R.string.intelligence, R.drawable.layout_icones_inte),
    RES(8, R.string.resistance, R.drawable.layout_icones_defense),
    ENER(9, R.string.energy, R.drawable.layout_icones_ene);

    public int id;

    @StringRes
    public final int name;

    @DrawableRes
    public final int icon;

    Attribute(int id, @StringRes int name, @DrawableRes int icon) {
        this.id = id;
        this.name = name;
        this.icon = icon;
    }
}
