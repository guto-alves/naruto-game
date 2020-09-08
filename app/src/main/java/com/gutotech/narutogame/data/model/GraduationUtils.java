package com.gutotech.narutogame.data.model;

import androidx.annotation.StringRes;

import com.gutotech.narutogame.R;

public class GraduationUtils {

    @StringRes
    public static int getName(int graduationId, Village village) {
        if (village == Village.LEAF) {
            switch (graduationId) {
                case 0:
                    return R.string.student;
                case 1:
                    return R.string.genin;
                case 2:
                    return R.string.chuunin;
                case 3:
                    return R.string.jounin;
                case 4:
                    return R.string.anbu;
                case 5:
                    return R.string.leaf_sannin;
                case 6:
                    return R.string.hero;
            }
        } else if (village == Village.SAND) {
            switch (graduationId) {
                case 0:
                    return R.string.student;
                case 1:
                    return R.string.genin;
                case 2:
                    return R.string.chuunin;
                case 3:
                    return R.string.jounin;
                case 4:
                    return R.string.anbu;
                case 5:
                    return R.string.sand_sealer;
                case 6:
                    return R.string.hero;
            }
        } else if (village == Village.MIST) {
            switch (graduationId) {
                case 0:
                    return R.string.student;
                case 1:
                    return R.string.genin;
                case 2:
                    return R.string.chuunin;
                case 3:
                    return R.string.jounin;
                case 4:
                    return R.string.anbu;
                case 5:
                    return R.string.mist_swordsman;
                case 6:
                    return R.string.hero;
            }
        } else if (village == Village.STONE) {
            switch (graduationId) {
                case 0:
                    return R.string.student;
                case 1:
                    return R.string.genin;
                case 2:
                    return R.string.chuunin;
                case 3:
                    return R.string.jounin;
                case 4:
                    return R.string.anbu;
                case 5:
                    return R.string.stone_hunter;
                case 6:
                    return R.string.hero;
            }
        } else if (village == Village.CLOUD) {
            switch (graduationId) {
                case 0:
                    return R.string.student;
                case 1:
                    return R.string.genin;
                case 2:
                    return R.string.chuunin;
                case 3:
                    return R.string.jounin;
                case 4:
                    return R.string.anbu;
                case 5:
                    return R.string.cloud_captain;
                case 6:
                    return R.string.hero;
            }
        } else if (village == Village.AKATSUKI) {
            switch (graduationId) {
                case 0:
                    return R.string.fugitive;
                case 1:
                    return R.string.nukenin_d;
                case 2:
                    return R.string.nukenin_c;
                case 3:
                    return R.string.nukenin_b;
                case 4:
                    return R.string.nukenin_a;
                case 5:
                    return R.string.bounty_hunter;
                case 6:
                    return R.string.villain;
            }
        } else if (village == Village.SOUND) {
            switch (graduationId) {
                case 0:
                    return R.string.survivor;
                case 1:
                    return R.string.genin;
                case 2:
                    return R.string.chuunin;
                case 3:
                    return R.string.jounin;
                case 4:
                    return R.string.anbu;
                case 5:
                    return R.string.sound_scientist;
                case 6:
                    return R.string.cursed;
            }
        } else if (village == Village.RAIN) {
            switch (graduationId) {
                case 0:
                    return R.string.orphan;
                case 1:
                    return R.string.genin;
                case 2:
                    return R.string.chuunin;
                case 3:
                    return R.string.jounin;
                case 4:
                    return R.string.anbu;
                case 5:
                    return R.string.rain_guardian;
                case 6:
                    return R.string.god;
            }
        }

        return 0;
    }

    @StringRes
    public static int getName(int graduationId) {
        if (CharOn.character == null) {
            return 0;
        }
        return getName(graduationId, CharOn.character.getVillage());
    }

    @StringRes
    public static int getDescription(int graduationId) {
        Village village = CharOn.character.getVillage();

        if (village == Village.AKATSUKI) {
            switch (graduationId) {
                case 1:
                    return R.string.nukenin_d_desc;
                case 2:
                    return R.string.nukenin_c_des;
                case 3:
                    return R.string.nukenin_b_desc;
                case 4:
                    return R.string.nukenin_a_des;
                case 5:
                    return R.string.bounty_hunter_desc;
                case 6:
                    return R.string.villain_description;
            }
        } else {
            switch (graduationId) {
                case 1:
                    return R.string.genin_description;
                case 2:
                    return R.string.chuunin_description;
                case 3:
                    return R.string.jounin_description;
                case 4:
                    return R.string.anbu_description;
                case 5:
                    return R.string.sannin_description;
                case 6:
                    return R.string.hero_description;
            }
        }

        return 0;
    }
}
