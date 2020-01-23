package com.gutotech.narutogame.data.model;

import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;

import com.gutotech.narutogame.R;

public enum Formula {
    HEALTH(0, R.string.health, R.drawable.layout_icones_p_hp),
    CHAKRA(1, R.string.chakra, R.drawable.layout_icones_p_chakra),
    STAMINA(2, R.string.stamina, R.drawable.layout_icones_p_stamina),
    ATK_TAI(3, R.string.atk_tai_buk, R.drawable.layout_icones_atk_fisico),
    ATK_NIN(4, R.string.atk_nin_gen, R.drawable.layout_icones_atk_magico),
    DEF_TAI(5, R.string.defense_tai_buk, R.drawable.layout_icones_shield_fisico),
    DEF_NIN(6, R.string.defense_nin_gen, R.drawable.layout_icones_shield_magico),
    ACC(7, R.string.accuracy, R.drawable.layout_icones_precisao);

    public int id;

    @StringRes
    public final int name;

    @DrawableRes
    public final int icon;

    Formula(int id, @StringRes int name, @DrawableRes int icon) {
        this.id = id;
        this.name = name;
        this.icon = icon;
    }
}
