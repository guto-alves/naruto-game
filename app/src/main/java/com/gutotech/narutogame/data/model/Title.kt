package com.gutotech.narutogame.data.model

import androidx.annotation.StringRes
import com.gutotech.narutogame.R

enum class Title(@StringRes val text: Int) {
    NONE(R.string.none),
    STUDENT(R.string.student),
    GENIN(R.string.genin),
    CHUUNIN(R.string.chuunin),
    JOUNIN(R.string.jounin),
    ANBU(R.string.anbu),
    LEAF_SANNIN(R.string.leaf_sannin),
    HERO(R.string.hero),
    SAND_SEALER(R.string.sand_sealer),
    MIST_SWORDSMAN(R.string.mist_swordsman),
    STONE_HUNTER(R.string.stone_hunter),
    CLOUD_CAPTAIN(R.string.cloud_captain),
    FUGITIVE(R.string.fugitive),
    NUKENIN_D(R.string.nukenin_d),
    NUKENIN_C(R.string.nukenin_c),
    NUKENIN_B(R.string.nukenin_b),
    NUKENIN_A(R.string.nukenin_a),
    BOUNTY_HUNTER(R.string.bounty_hunter),
    VILLAIN(R.string.villain),
    SURVIVOR(R.string.survivor),
    SOUND_SCIENTIST(R.string.sound_scientist),
    CURSED(R.string.cursed),
    ORPHAN(R.string.orphan),
    RAIN_GUARDIAN(R.string.rain_guardian),
    GOD(R.string.god);
}