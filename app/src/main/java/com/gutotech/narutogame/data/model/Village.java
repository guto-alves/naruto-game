package com.gutotech.narutogame.data.model;

import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;

import com.gutotech.narutogame.R;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public enum Village implements Serializable {
    FOLHA(R.string.leaf, R.string.hokage, R.drawable.layout_home_kages_1, R.drawable.layout_bandanas_1,
            R.drawable.layout_mapa_1, Arrays.asList(34, 47, 67, 75, 98)),
    AREIA(R.string.sand, R.string.kazekage, R.drawable.layout_home_kages_2, R.drawable.layout_bandanas_2,
            R.drawable.layout_mapa_2, Arrays.asList(25, 54, 63, 68, 98)),
    NEVOA(R.string.mist, R.string.mizukage, R.drawable.layout_home_kages_3, R.drawable.layout_bandanas_3,
            R.drawable.layout_mapa_3, Arrays.asList(42, 58, 81, 94, 98)),
    PEDRA(R.string.stone, R.string.tsuchikage, R.drawable.layout_home_kages_4, R.drawable.layout_bandanas_4,
            R.drawable.layout_mapa_4, Arrays.asList(33, 62, 68, 85, 98)),
    NUVEM(R.string.cloud, R.string.raikage, R.drawable.layout_home_kages_5, R.drawable.layout_bandanas_5,
            R.drawable.layout_mapa_5, Arrays.asList(31, 65, 68, 72, 98)),
    AKATSUKI(R.string.akatsuki, R.string.leader, R.drawable.layout_home_kages_6, R.drawable.layout_bandanas_6,
            R.drawable.layout_mapa_6, Arrays.asList(48, 54, 78, 95, 98)),
    SOM(R.string.sound, R.string.otokage, R.drawable.layout_home_kages_7, R.drawable.layout_bandanas_7,
            R.drawable.layout_mapa_7, Arrays.asList(33, 36, 62, 65, 98)),
    CHUVA(R.string.rain, R.string.amekage, R.drawable.layout_home_kages_8, R.drawable.layout_bandanas_8,
            R.drawable.layout_mapa_8, Arrays.asList(32, 36, 48, 74, 98, 102)),

    NEVE(R.string.snow, 0, R.drawable.layout_home_kages_1, R.drawable.layout_bandanas_1,
            R.drawable.layout_map_9, Arrays.asList(56, 69, 73, 86, 98)),
    CACHOEIRA(R.string.waterfall, 0, R.drawable.layout_home_kages_1, R.drawable.layout_bandanas_1,
            R.drawable.layout_map_10, Arrays.asList(55, 81, 88, 94, 101)),
    FONTES_TERMAIS(R.string.hot_springs, 0, R.drawable.layout_home_kages_1, R.drawable.layout_bandanas_1,
            R.drawable.layout_map_11, Arrays.asList(34, 58, 62, 65, 98)),
    GRAMA(R.string.grass, 0, R.drawable.layout_home_kages_1, R.drawable.layout_bandanas_1,
            R.drawable.layout_map_12, Arrays.asList(35, 51, 66, 82, 98));

    @StringRes
    public final int name;

    @DrawableRes
    public final int homeResId;

    @DrawableRes
    public final int bandanaResId;

    @DrawableRes
    public final int mapResId;

    public final List<Integer> placeEntries;

    @StringRes
    public final int kageName;

    Village(@StringRes int name, @StringRes int kageName, @DrawableRes int homeResId,
            @DrawableRes int bandanaResId, @DrawableRes int mapResId, List<Integer> placeEntries) {
        this.name = name;
        this.kageName = kageName;
        this.homeResId = homeResId;
        this.bandanaResId = bandanaResId;
        this.mapResId = mapResId;
        this.placeEntries = placeEntries;
    }

    @StringRes
    public int getName() {
        return name;
    }
}
