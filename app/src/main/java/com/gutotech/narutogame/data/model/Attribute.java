package com.gutotech.narutogame.data.model;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;

import com.gutotech.narutogame.R;

public enum Attribute {
    TAI("Taijutsu", R.drawable.layout_icones_tai),
    BUK("Bukijutsu", R.drawable.layout_icones_ken),
    NIN("Ninjutsu", R.drawable.layout_icones_nin),
    GEN("Genjutsu", R.drawable.layout_icones_gen),
    SELO("Selo", R.drawable.layout_icones_conhe),
    AGI("Agilidade", R.drawable.layout_icones_agi),
    FOR("Força", R.drawable.layout_icones_forc),
    INTE("Inteligência", R.drawable.layout_icones_inte),
    ENER("Energia", R.drawable.layout_icones_defense),
    RES("Resistência", R.drawable.layout_icones_ene),

    HEALTH("Vida", R.drawable.layout_icones_p_hp),
    CHAKRA("Chakra", R.drawable.layout_icones_p_chakra),
    STAMINA("Stamina", R.drawable.layout_icones_p_stamina),
    ATK_TAI("Atk. ( Tai / Buk )", R.drawable.layout_icones_atk_fisico),
    ATK_NIN("Atk. ( Nin / Gen )", R.drawable.layout_icones_atk_magico),
    DEF_TAI("Def. ( Tai / Buk )", R.drawable.layout_icones_shield_fisico),
    DEF_NIN("Def. ( Nin / Gen )", R.drawable.layout_icones_shield_magico),
    ACC("Precisão", R.drawable.layout_icones_precisao);

    public final String name;

    @DrawableRes
    public final int icon;

    Attribute(String name, @DrawableRes int icon) {
        this.name = name;
        this.icon = icon;
    }

    @NonNull
    @Override
    public String toString() {
        return name;
    }
}
