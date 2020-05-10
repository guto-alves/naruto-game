package com.gutotech.narutogame.data.model;

import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;

import com.gutotech.narutogame.R;

public enum Attribute {
    TAI(R.string.taijutsu, R.drawable.layout_icones_tai),
    BUK(R.string.bukijutsu, R.drawable.layout_icones_ken),
    NIN(R.string.ninjustu, R.drawable.layout_icones_nin),
    GEN(R.string.genjutsu, R.drawable.layout_icones_gen),
    SEAL(R.string.seal, R.drawable.layout_icones_conhe),
    AGI(R.string.agility, R.drawable.layout_icones_agi),
    STR(R.string.strength, R.drawable.layout_icones_forc),
    INTE(R.string.intelligence, R.drawable.layout_icones_inte),
    RES(R.string.resistance, R.drawable.layout_icones_defense),
    ENER(R.string.energy, R.drawable.layout_icones_ene);

    @StringRes
    public final int name;

    @DrawableRes
    public final int icon;

    Attribute(@StringRes int name, @DrawableRes int icon) {
        this.name = name;
        this.icon = icon;
    }
}
