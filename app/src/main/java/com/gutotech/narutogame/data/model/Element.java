package com.gutotech.narutogame.data.model;

import androidx.annotation.StringRes;

import com.gutotech.narutogame.R;

public enum Element {
    KATON("Katon", R.string.katon_description),
    FUUTON("Fuuton", R.string.fuuton_description),
    RAITON("Raiton", R.string.raiton_description),
    DOTON("Doton", R.string.doton_description),
    SUITON("Suiton", R.string.suiton_description);

    public final String name;

    @StringRes
    public final int description;

    Element(String name, @StringRes int description) {
        this.name = name;
        this.description = description;
    }
}
