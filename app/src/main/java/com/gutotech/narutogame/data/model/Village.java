package com.gutotech.narutogame.data.model;

import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;

import com.gutotech.narutogame.R;

import java.io.Serializable;

public enum Village implements Serializable {
    FOLHA(1, R.string.leaf, R.drawable.layout_home_kages_1, R.drawable.layout_bandanas_1, R.drawable.layout_mapa_1),
    AREIA(2, R.string.sand, R.drawable.layout_home_kages_2, R.drawable.layout_bandanas_2, R.drawable.layout_mapa_2),
    NEVOA(3, R.string.mist, R.drawable.layout_home_kages_3, R.drawable.layout_bandanas_3, R.drawable.layout_mapa_3),
    PEDRA(4, R.string.stone, R.drawable.layout_home_kages_4, R.drawable.layout_bandanas_4, R.drawable.layout_mapa_4),
    NUVEM(5, R.string.cloud, R.drawable.layout_home_kages_5, R.drawable.layout_bandanas_5, R.drawable.layout_mapa_5),
    AKATSUKI(6, R.string.akatsuki, R.drawable.layout_home_kages_6, R.drawable.layout_bandanas_6, R.drawable.layout_mapa_6),
    SOM(7, R.string.sound, R.drawable.layout_home_kages_7, R.drawable.layout_bandanas_7, R.drawable.layout_mapa_7),
    CHUVA(8, R.string.rain, R.drawable.layout_home_kages_8, R.drawable.layout_bandanas_8, R.drawable.layout_mapa_8),

    NEVE(9, R.string.snow, R.drawable.layout_home_kages_1, R.drawable.layout_bandanas_1, R.drawable.layout_map_9),
    CACHOEIRA(10, R.string.waterfall, R.drawable.layout_home_kages_1, R.drawable.layout_bandanas_1, R.drawable.layout_map_10),
    FONTES_TERMAIS(11, R.string.hot_springs, R.drawable.layout_home_kages_1, R.drawable.layout_bandanas_1, R.drawable.layout_map_11),
    GRAMA(12, R.string.grass, R.drawable.layout_home_kages_1, R.drawable.layout_bandanas_1, R.drawable.layout_map_12);

    public final int id;
    @StringRes
    public final int name;
    @DrawableRes
    public final int homeResId;
    @DrawableRes
    public final int bandanaResId;
    @DrawableRes
    public final int mapResId;

    Village(int id, @StringRes int name, @DrawableRes int homeResId, @DrawableRes int bandanaResId, @DrawableRes int mapResId) {
        this.id = id;
        this.name = name;
        this.homeResId = homeResId;
        this.bandanaResId = bandanaResId;
        this.mapResId = mapResId;
    }

    @StringRes
    public int getName() {
        return name;
    }
}
