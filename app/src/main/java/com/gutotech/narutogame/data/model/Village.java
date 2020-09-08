package com.gutotech.narutogame.data.model;

import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;

import com.gutotech.narutogame.R;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public enum Village implements Serializable {
    FOLHA(R.string.leaf, R.string.hokage, R.drawable.layout_home_kages_1, R.drawable.layout_bandanas_1,
            R.drawable.layout_mapa_1, Arrays.asList(34, 47, 67, 75, 98),
            new int[]{Title.STUDENT.ordinal(), Title.GENIN.ordinal(), Title.CHUUNIN.ordinal(), Title.JOUNIN.ordinal(),
                    Title.ANBU.ordinal(), Title.LEAF_SANNIN.ordinal(), Title.HERO.ordinal()}),
    AREIA(R.string.sand, R.string.kazekage, R.drawable.layout_home_kages_2, R.drawable.layout_bandanas_2,
            R.drawable.layout_mapa_2, Arrays.asList(25, 54, 63, 68, 98),
            new int[]{Title.STUDENT.ordinal(), Title.GENIN.ordinal(), Title.CHUUNIN.ordinal(), Title.JOUNIN.ordinal(),
                    Title.ANBU.ordinal(), Title.SAND_SEALER.ordinal(), Title.HERO.ordinal()}),
    NEVOA(R.string.mist, R.string.mizukage, R.drawable.layout_home_kages_3, R.drawable.layout_bandanas_3,
            R.drawable.layout_mapa_3, Arrays.asList(42, 58, 81, 94, 98),
            new int[]{Title.STUDENT.ordinal(), Title.GENIN.ordinal(), Title.CHUUNIN.ordinal(), Title.JOUNIN.ordinal(),
                    Title.ANBU.ordinal(), Title.MIST_SWORDSMAN.ordinal(), Title.HERO.ordinal()}),
    PEDRA(R.string.stone, R.string.tsuchikage, R.drawable.layout_home_kages_4, R.drawable.layout_bandanas_4,
            R.drawable.layout_mapa_4, Arrays.asList(33, 62, 68, 85, 98),
            new int[]{Title.STUDENT.ordinal(), Title.GENIN.ordinal(), Title.CHUUNIN.ordinal(), Title.JOUNIN.ordinal(),
                    Title.ANBU.ordinal(), Title.STONE_HUNTER.ordinal(), Title.HERO.ordinal()}),
    NUVEM(R.string.cloud, R.string.raikage, R.drawable.layout_home_kages_5, R.drawable.layout_bandanas_5,
            R.drawable.layout_mapa_5, Arrays.asList(31, 65, 68, 72, 98),
            new int[]{Title.STUDENT.ordinal(), Title.GENIN.ordinal(), Title.CHUUNIN.ordinal(), Title.JOUNIN.ordinal(),
                    Title.ANBU.ordinal(), Title.CLOUD_CAPTAIN.ordinal(), Title.HERO.ordinal()}),
    AKATSUKI(R.string.akatsuki, R.string.leader, R.drawable.layout_home_kages_6, R.drawable.layout_bandanas_6,
            R.drawable.layout_mapa_6, Arrays.asList(48, 54, 78, 95, 98),
            new int[]{Title.FUGITIVE.ordinal(), Title.NUKENIN_D.ordinal(), Title.NUKENIN_C.ordinal(),
                    Title.NUKENIN_B.ordinal(), Title.NUKENIN_A.ordinal(), Title.BOUNTY_HUNTER.ordinal(), Title.VILLAIN.ordinal()}),
    SOM(R.string.sound, R.string.otokage, R.drawable.layout_home_kages_7, R.drawable.layout_bandanas_7,
            R.drawable.layout_mapa_7, Arrays.asList(33, 36, 62, 65, 98),
            new int[]{Title.SURVIVOR.ordinal(), Title.GENIN.ordinal(), Title.CHUUNIN.ordinal(),
                    Title.JOUNIN.ordinal(), Title.ANBU.ordinal(), Title.SOUND_SCIENTIST.ordinal(), Title.CURSED.ordinal()}),
    CHUVA(R.string.rain, R.string.amekage, R.drawable.layout_home_kages_8, R.drawable.layout_bandanas_8,
            R.drawable.layout_mapa_8, Arrays.asList(32, 36, 48, 74, 98, 102),
            new int[]{Title.ORPHAN.ordinal(), Title.GENIN.ordinal(), Title.CHUUNIN.ordinal(), Title.JOUNIN.ordinal(),
                    Title.ANBU.ordinal(), Title.RAIN_GUARDIAN.ordinal(), Title.GOD.ordinal()}),

    NEVE(R.string.snow, 0, R.drawable.layout_home_kages_1, R.drawable.layout_bandanas_1,
            R.drawable.layout_map_9, Arrays.asList(56, 69, 73, 86, 98), null),
    CACHOEIRA(R.string.waterfall, 0, R.drawable.layout_home_kages_1, R.drawable.layout_bandanas_1,
            R.drawable.layout_map_10, Arrays.asList(55, 81, 88, 94, 101), null),
    FONTES_TERMAIS(R.string.hot_springs, 0, R.drawable.layout_home_kages_1, R.drawable.layout_bandanas_1,
            R.drawable.layout_map_11, Arrays.asList(34, 58, 62, 65, 98), null),
    GRAMA(R.string.grass, 0, R.drawable.layout_home_kages_1, R.drawable.layout_bandanas_1,
            R.drawable.layout_map_12, Arrays.asList(35, 51, 66, 82, 98), null);

    @StringRes
    public final int name;

    @DrawableRes
    public final int homeResId;

    @DrawableRes
    public final int bandanaResId;

    @DrawableRes
    public final int mapResId;

    public final List<Integer> placeEntries;

    public final int[] titleIndices;

    @StringRes
    public final int kageName;

    Village(@StringRes int name, @StringRes int kageName, @DrawableRes int homeResId,
            @DrawableRes int bandanaResId, @DrawableRes int mapResId, List<Integer> placeEntries,
            int[] titleIndices) {
        this.name = name;
        this.kageName = kageName;
        this.homeResId = homeResId;
        this.bandanaResId = bandanaResId;
        this.mapResId = mapResId;
        this.placeEntries = placeEntries;
        this.titleIndices = titleIndices;
    }

    @StringRes
    public int getName() {
        return name;
    }

    public int getTitleIndex(int graduationId) {
        return titleIndices[graduationId];
    }
}
