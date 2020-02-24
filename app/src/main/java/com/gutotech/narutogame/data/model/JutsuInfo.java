package com.gutotech.narutogame.data.model;

import android.content.Context;

import com.gutotech.narutogame.R;

import java.util.Arrays;
import java.util.List;

public enum JutsuInfo {
    DEFESA_MAO("defesa_2_mao.jpg", R.string.simple_block, R.string.simple_block_des,
            Jutsu.Type.DEF,
            null),

    DEFESA_ACROBATICA("defesa_acrobatica.jpg", R.string.simple_dodge, R.string.simple_dodge_des,
            Jutsu.Type.DEF,
            null),
    SOCO("soco.jpg", R.string.punch, R.string.punch_des,
            Jutsu.Type.ATK,
            null),
    CHUTE("chute.jpg", R.string.kick, R.string.kick_des,
            Jutsu.Type.ATK,
            null),


    // TAIJUTSUS
    DYNAMIC_KICK("chute_dinamico.jpg", R.string.dynamic_kick, R.string.dynamic_kick_des,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 3;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getStrength() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), context.getString(Attribute.FOR.name)
                            );
                        }
                    },
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 4;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getTaijutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Taijutsu");
                        }
                    }
            )),

    DYNAMIC_ENTRY("dynamic_entry.jpg", R.string.dynamic_entry, R.string.dynamic_entry_des,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 4;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getStrength() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), context.getString(Attribute.FOR.name)
                            );
                        }
                    },
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 5;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getTaijutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Taijutsu");
                        }
                    }
            )),
    HORENGAN_PILL_I("pilula_verde.jpg", R.string.horengan_pill_i, R.string.horengan_pill_i_des,
            Jutsu.Type.BUFF,
            Arrays.asList(
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 5;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getTaijutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Taijutsu");
                        }
                    }
            )),
    HORENGAN_PILL_II("pilula_verde.jpg", R.string.horengan_pill_ii, R.string.horengan_pill_ii_des,
            Jutsu.Type.BUFF,
            Arrays.asList(
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 5;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getTaijutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Taijutsu");
                        }
                    }
            )),
    HARIITSUBA("agulhas_sopranas.jpg", R.string.hariitsuba, R.string.hariitsuba_des,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 6;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getStrength() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), context.getString(Attribute.FOR.name)
                            );
                        }
                    },
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 8;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getTaijutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Taijutsu");
                        }
                    }
            )),
    KONOHA_FULL_KICK_SOCCER("konoha_full_kick_soccer.jpg", R.string.konoha_full_kick_soccer, R.string.konoha_full_kick_soccer_des,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 8;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getStrength() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), context.getString(Attribute.FOR.name)
                            );
                        }
                    },
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 10;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getTaijutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Taijutsu");
                        }
                    }
            )),
    KONOHA_SENPUU("chute_furacao.jpg", R.string.konoha_senpuu, R.string.konoha_senpuu_des,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 8;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getStrength() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), context.getString(Attribute.FOR.name)
                            );
                        }
                    },
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 10;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getTaijutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Taijutsu");
                        }
                    }
            )),
    GANGEKI("golpe_ombro.jpg", R.string.gangeki, R.string.gangeki_des,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 9;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getStrength() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), context.getString(Attribute.FOR.name)
                            );
                        }
                    },
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 12;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getTaijutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Taijutsu");
                        }
                    }
            )),
    KARENGAN_PILL_I("pilula_amarela.jpg", R.string.karengan_pill_i, R.string.karengan_pill_i_des,
            Jutsu.Type.BUFF,
            Arrays.asList(
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 12;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getTaijutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Taijutsu");
                        }
                    }
            )),
    KARENGAN_PILL_II("pilula_amarela.jpg", R.string.karengan_pill_ii, R.string.karengan_pill_ii_des,
            Jutsu.Type.BUFF,
            Arrays.asList(
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 12;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getTaijutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Taijutsu");
                        }
                    }
            )),
    SENSEI_DYNAMIC_ENTRY("Dynamic_Entry.gif", R.string.sensei_dynamic_entry, R.string.sensei_dynamic_entry_des,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 11;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getStrength() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), context.getString(Attribute.FOR.name)
                            );
                        }
                    },
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 14;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getTaijutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Taijutsu");
                        }
                    }
            )),

    // TAI- Chuunin
    KONOHA_DAI_SENKOU("konoha_dai_senkou.jpg", R.string.konoha_dai_senkou, R.string.konoha_dai_senkou_des,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 11;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getStrength() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), context.getString(Attribute.FOR.name)
                            );
                        }
                    },
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 15;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getTaijutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Taijutsu");
                        }
                    }
            )),

    SENNEN_GOROSHI("sennen-goroshi.jpg", R.string.sennen_goroshi, R.string.sennen_goroshi_des,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 11;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getStrength() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), context.getString(Attribute.FOR.name)
                            );
                        }
                    },
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 15;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getTaijutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Taijutsu");
                        }
                    }
            )),

    AIAN_KUROU("aian-kurou.jpg", R.string.aian_kurou, R.string.aian_kurou_des,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 13;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getStrength() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), context.getString(Attribute.FOR.name)
                            );
                        }
                    },
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 17;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getTaijutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Taijutsu");
                        }
                    }
            )),
    KONOHA_REPPUU("chute_furacao_violento.jpg", R.string.konoha_reppuu, R.string.konoha_reppuu_des,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 14;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getStrength() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), context.getString(Attribute.FOR.name)
                            );
                        }
                    },
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 18;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getTaijutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Taijutsu");
                        }
                    }
            )),
    TONGARASHIGAN_PILL_I("pilula_vermelha.jpg", R.string.tongarashigan_pill_i, R.string.tongarashigan_pill_i_des,
            Jutsu.Type.BUFF,
            Arrays.asList(
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 18;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getTaijutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Taijutsu");
                        }
                    }
            )),
    TONGARASHIGAN_PILL_II("pilula_vermelha.jpg", R.string.tongarashigan_pill_ii, R.string.tongarashigan_pill_ii_des,
            Jutsu.Type.BUFF,
            Arrays.asList(
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 18;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getTaijutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Taijutsu");
                        }
                    }
            )),
    KONGOURIKI_FUDOU("kongouriki-fudou.jpg", R.string.kongouriki_fudou, R.string.kongouriki_fudou_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 13;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getStrength() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), context.getString(Attribute.FOR.name)
                            );
                        }
                    },
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 17;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getTaijutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Taijutsu");
                        }
                    }
            )),
    SHISHI_RENDAN("shishi_rendan.jpg", R.string.shishi_rendan, R.string.shishi_rendan_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 15;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getStrength() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), context.getString(Attribute.FOR.name)
                            );
                        }
                    },
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 20;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getTaijutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Taijutsu");
                        }
                    }
            )),
    PANCHI_1000M("1000m-panchi.jpg", R.string.panchi_1000m, R.string.panchi_1000m_des,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 16;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getStrength() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), context.getString(Attribute.FOR.name)
                            );
                        }
                    },
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 21;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getTaijutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Taijutsu");
                        }
                    }
            )),
    KONOHA_KAGE_BUYOU("kage_buyou.jpg", R.string.konoha_kage_buyou, R.string.konoha_kage_buyou_des,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 17;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getStrength() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), context.getString(Attribute.FOR.name)
                            );
                        }
                    },
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 21;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getTaijutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Taijutsu");
                        }
                    }
            )),
    SENSEI_SENNEN_GOROSHI("Sennen_Goroshi.gif", R.string.sensei_sennen_goroshi, R.string.sensei_sennen_goroshi_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 18;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getStrength() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), context.getString(Attribute.FOR.name)
                            );
                        }
                    },
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 24;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getTaijutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Taijutsu");
                        }
                    }
            )),


    // BUKIJUTSU
    SOUFUUSHASAN_NO_TACHI("soufuushasan-no-tachi.jpg", R.string.soufuushasan_no_tachi, R.string.soufuushasan_no_tachi_des,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 3;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getStrength() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), context.getString(Attribute.FOR.name)
                            );
                        }
                    },
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 4;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getBukijutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Bukijutsu");
                        }
                    }
            )),
    SOUSHURIKEN_NO_JUTSU("sou_shuriken.jpg", R.string.soushuriken_no_jutsu, R.string.soushuriken_no_jutsu_des,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 4;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getStrength() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), context.getString(Attribute.FOR.name)
                            );
                        }
                    },
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 5;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getBukijutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Bukijutsu");
                        }
                    }
            )),
    SOUSHUUJIN_I("Soushuujin.jpg", R.string.soushuujin_i, R.string.soushuujin_i_des,
            Jutsu.Type.DEBUFF,
            Arrays.asList(
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 5;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getBukijutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Bukijutsu");
                        }
                    }
            )),
    SOUSHUUJIN_II("Soushuujin.jpg", R.string.soushuujin_ii, R.string.soushuujin_ii_des,
            Jutsu.Type.DEBUFF,
            Arrays.asList(
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 5;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getBukijutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Bukijutsu");
                        }
                    }
            )),
    RENSHA("rensha.jpg", R.string.rensha, R.string.rensha_des,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 6;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getStrength() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), context.getString(Attribute.FOR.name)
                            );
                        }
                    },
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 8;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getBukijutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Bukijutsu");
                        }
                    }
            )),
    JOURO_SENBON("Jouro-Senbon.jpg", R.string.jouro_senbon, R.string.jouro_senbon_des,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 8;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getStrength() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), context.getString(Attribute.FOR.name)
                            );
                        }
                    },
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 10;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getBukijutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Bukijutsu");
                        }
                    }
            )),
    SHIKOMISHINDAN("Shikomishindan.jpg", R.string.shikomishindan, R.string.shikomishindan_des,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 8;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getStrength() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), context.getString(Attribute.FOR.name)
                            );
                        }
                    },
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 10;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getBukijutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Taijutsu");
                        }
                    }
            )),
    GEN_EI_TAJUU_SHURIKEN("Genei-Tajuu-Shuriken.jpg", R.string.gen_ei_tajuu_shuriken, R.string.gen_ei_tajuu_shuriken_des,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 9;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getStrength() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), context.getString(Attribute.FOR.name)
                            );
                        }
                    },
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 12;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getBukijutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Taijutsu");
                        }
                    }
            )),
    HIJUTSU_ISHIBARI_I("Hijutsu-Ishibari.jpg", R.string.hijutsu_ishibari_i, R.string.hijutsu_ishibari_i_des,
            Jutsu.Type.DEBUFF,
            Arrays.asList(
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 12;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getBukijutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Bukijutsu");
                        }
                    }
            )),
    HIJUTSU_ISHIBARI_II("Hijutsu-Ishibari.jpg", R.string.hijutsu_ishibari_ii, R.string.hijutsu_ishibari_ii_des,
            Jutsu.Type.DEBUFF,
            Arrays.asList(
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 12;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getBukijutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Bukijutsu");
                        }
                    }
            )),
    SENSEI_SOUSHURIKEN_NO_JUTSU("Soushuriken_no_Jutsu.gif", R.string.sensen_soushuriken, R.string.sensei_soushuriken_des,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 11;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getStrength() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), context.getString(Attribute.FOR.name)
                            );
                        }
                    },
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 14;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getBukijutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Taijutsu");
                        }
                    }
            )),

    // BUK- Chuunin
    SHIKOMI("konoha_dai_senkou.jpg", R.string.konoha_dai_senkou, R.string.konoha_dai_senkou_des,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 11;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getStrength() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), context.getString(Attribute.FOR.name)
                            );
                        }
                    },
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 15;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getBukijutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Bukijutsu");
                        }
                    }
            )),

    NADESHIKO("sennen-goroshi.jpg", R.string.sennen_goroshi, R.string.sennen_goroshi_des,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 11;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getStrength() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), context.getString(Attribute.FOR.name)
                            );
                        }
                    },
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 15;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getBukijutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Bukijutsu");
                        }
                    }
            )),

    SAMEDARE("aian-kurou.jpg", R.string.aian_kurou, R.string.aian_kurou_des,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 13;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getStrength() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), context.getString(Attribute.FOR.name)
                            );
                        }
                    },
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 17;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getBukijutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Bukijutsu");
                        }
                    }
            )),

    KAWARA_SHURIKEN("chute_furacao_violento.jpg", R.string.konoha_reppuu, R.string.konoha_reppuu_des,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 14;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getStrength() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), context.getString(Attribute.FOR.name)
                            );
                        }
                    },
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 18;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getBukijutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Bukijutsu");
                        }
                    }
            )),
    RAIKOU_I("pilula_vermelha.jpg", R.string.tongarashigan_pill_i, R.string.tongarashigan_pill_i_des,
            Jutsu.Type.BUFF,
            Arrays.asList(
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 18;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getBukijutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Bukijutsu");
                        }
                    }
            )),
    RAIKOU_II("pilula_vermelha.jpg", R.string.tongarashigan_pill_ii, R.string.tongarashigan_pill_ii_des,
            Jutsu.Type.BUFF,
            Arrays.asList(
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 18;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getBukijutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Bukijutsu");
                        }
                    }
            )),
    AKAHIGI("kongouriki-fudou.jpg", R.string.kongouriki_fudou, R.string.kongouriki_fudou_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 13;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getStrength() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), context.getString(Attribute.FOR.name)
                            );
                        }
                    },
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 17;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getBukijutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Bukijutsu");
                        }
                    }
            )),
    KUMO("shishi_rendan.jpg", R.string.shishi_rendan, R.string.shishi_rendan_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 15;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getStrength() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), context.getString(Attribute.FOR.name)
                            );
                        }
                    },
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 20;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getBukijutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Bukijutsu");
                        }
                    }
            )),
    SOUSHUUGA("Soushuuga.jpg", R.string.panchi_1000m, R.string.panchi_1000m_des,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 16;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getStrength() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), context.getString(Attribute.FOR.name)
                            );
                        }
                    },
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 21;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getBukijutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Bukijutsu");
                        }
                    }
            )),
    HADAN("kage_buyou.jpg", R.string.konoha_kage_buyou, R.string.konoha_kage_buyou_des,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 17;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getStrength() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), context.getString(Attribute.FOR.name)
                            );
                        }
                    },
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 21;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getBukijutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Bukijutsu");
                        }
                    }
            )),
    SENSEI_SOUSHUUGA("Soushuuga.gif", R.string.sensei_sennen_goroshi, R.string.sensei_sennen_goroshi_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 18;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getStrength() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), context.getString(Attribute.FOR.name)
                            );
                        }
                    },
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 24;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getBukijutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Bukijutsu");
                        }
                    }
            )),

    // NINJUTSUS
    HENGE_NO_JUTSU("transformacao.jpg", R.string.henge_no_jutsu, R.string.henge_no_jutsu_des,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 3;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getIntelligence() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), context.getString(Attribute.INTE.name)
                            );
                        }
                    },
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 4;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getNinjutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Ninjutsu");
                        }
                    }
            )),
    KONOHA_TZU("konoha_tizu.jpg", R.string.konoha_tzu, R.string.konoha_tzu_des,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 4;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getIntelligence() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), context.getString(Attribute.INTE.name)
                            );
                        }
                    },
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 5;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getNinjutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Ninjutsu");
                        }
                    }
            )),
    BUNSHIN_NO_JUTSU_I("bunshin_no_jutsu.jpg", R.string.bunshin_no_jutsu_i, R.string.bunshin_no_jutsu_i_des,
            Jutsu.Type.BUFF,
            Arrays.asList(
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 5;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getNinjutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Ninjutsu");
                        }
                    }
            )),
    BUNSHIN_NO_JUTSU_II("bunshin_no_jutsu.jpg", R.string.bunshin_no_jutsu_ii, R.string.bunshin_no_jutsu_ii_des,
            Jutsu.Type.BUFF,
            Arrays.asList(
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 5;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getNinjutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Ninjutsu");
                        }
                    }
            )),
    NINPOU("mushou_de_hitei.jpg", R.string.ninpou, R.string.ninpou_des,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 6;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getIntelligence() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), context.getString(Attribute.INTE.name)
                            );
                        }
                    },
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 8;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getNinjutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Ninjutsu");
                        }
                    }
            )),
    KAGE_SHURIKEN("kage_shuriken_no_jutsu.jpg", R.string.kage_shuriken_no_jutsu, R.string.kage_shuriken_no_jutsu_des,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 8;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getIntelligence() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), context.getString(Attribute.INTE.name)
                            );
                        }
                    },
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 10;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getNinjutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Ninjutsu");
                        }
                    }
            )),
    KAKUREMINO("kakuremino_no_jutsu.jpg", R.string.kakuremino, R.string.kakuremino_des,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 8;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getIntelligence() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), context.getString(Attribute.INTE.name)
                            );
                        }
                    },
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 10;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getNinjutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Ninjutsu");
                        }
                    }
            )),
    KAWARIMI("substituicao.jpg", R.string.kawarimi, R.string.kawarimi_des,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 9;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getIntelligence() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), context.getString(Attribute.INTE.name)
                            );
                        }
                    },
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 12;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getNinjutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Ninjutsu");
                        }
                    }
            )),
    KAGE_BUNSHIN_I("clones.jpg", R.string.kage_bunshin_no_jutsu_i, R.string.kage_bunshin_no_jutsu_i_des,
            Jutsu.Type.BUFF,
            Arrays.asList(
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 12;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getNinjutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Ninjutsu");
                        }
                    }
            )),
    KAGE_BUNSHIN_II("clones.jpg", R.string.kage_bunshin_no_jutsu_ii, R.string.kage_bunshin_no_jutsu_ii_des,
            Jutsu.Type.BUFF,
            Arrays.asList(
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 12;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getNinjutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Ninjutsu");
                        }
                    }
            )),
    SENSEI_KAGE_BUNSHIN_NO_JUTSU("Kage-Bunshin-no-Jutsu.gif", R.string.sensei_kage_bunshin_no_jutsu, R.string.sensei_kage_bunshin_no_jutsu_des,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 11;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getIntelligence() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), context.getString(Attribute.INTE.name)
                            );
                        }
                    },
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 14;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getNinjutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Ninjutsu");
                        }
                    }
            )),

    // NIN - Chuunin
    RASENGAN("rasengan.jpg", R.string.rasengan, R.string.rasengan_des,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 11;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getIntelligence() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), context.getString(Attribute.INTE.name)
                            );
                        }
                    },
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 15;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getNinjutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Ninjutsu");
                        }
                    }
            )),
    KURO("kuro-tatsumaki.jpg", R.string.kuro, R.string.kuro_des,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 14;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getIntelligence() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), context.getString(Attribute.INTE.name)
                            );
                        }
                    },
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 18;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getNinjutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Ninjutsu");
                        }
                    }
            )),
    MEISAI_I("touton-no-jutsu.jpg", R.string.meisai_i, R.string.meisai_des,
            Jutsu.Type.BUFF,
            Arrays.asList(
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 18;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getNinjutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Ninjutsu");
                        }
                    }
            )),
    MEISAI_II("touton-no-jutsu.jpg", R.string.meisai_ii, R.string.meisai_des,
            Jutsu.Type.BUFF,
            Arrays.asList(
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 18;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getNinjutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Ninjutsu");
                        }
                    }
            )),
    TAJUU_TAKI("tajuu_taki_rasengan.jpg", R.string.tajuu_taki, R.string.tajuu_taki_des,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 15;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getIntelligence() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), context.getString(Attribute.INTE.name)
                            );
                        }
                    },
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 20;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getNinjutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Ninjutsu");
                        }
                    }
            )),
    BUNSHIN("bushin-bakuretsu.jpg", R.string.bunshin_bakuretsu, R.string.bunshin_bakuretsu_des,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 17;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getIntelligence() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), context.getString(Attribute.INTE.name)
                            );
                        }
                    },
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 22;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getNinjutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Ninjutsu");
                        }
                    }
            )),
    SENSEI_RASENGAN("Rasengan.gif", R.string.sensei_rasengan, R.string.sensei_rasengan_des,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 18;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getIntelligence() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), context.getString(Attribute.INTE.name)
                            );
                        }
                    },
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 24;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getNinjutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Ninjutsu");
                        }
                    }
            )),


    // GENJUTSUS
    KISHIBARI_NO_JUTSU("Kishibari_no_Jutsu.jpg", R.string.kishibari_no_jutsu, R.string.kishibari_no_jutsu_des,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 3;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getIntelligence() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), context.getString(Attribute.INTE.name)
                            );
                        }
                    },
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 4;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getGenjutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Genjutsu");
                        }
                    }
            )),

    KASUMI_JUUHA("Kasumi_Juuha_no_Jutsu.jpg", R.string.kasumi_juuha, R.string.kasumi_juuha_des,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 4;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getIntelligence() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), context.getString(Attribute.INTE.name)
                            );
                        }
                    },
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 5;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getGenjutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Ninjutsu");
                        }
                    }
            )),
    NEMURI_I("nerumi.jpg", R.string.nemuri_i, R.string.nemuri_i_des,
            Jutsu.Type.DEBUFF,
            Arrays.asList(
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 5;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getGenjutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Ninjutsu");
                        }
                    }
            )),
    NEMURI_II("nerumi.jpg", R.string.nemuri_ii, R.string.nemuri_ii_des,
            Jutsu.Type.DEBUFF,
            Arrays.asList(
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 5;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getGenjutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Ninjutsu");
                        }
                    }
            )),
    KOKOROYOURU("Kokoroyoru_no_jutsu.jpg", R.string.kokoroyoru, R.string.kokoroyoru_des,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 6;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getIntelligence() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), context.getString(Attribute.INTE.name)
                            );
                        }
                    },
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 8;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getGenjutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Ninjutsu");
                        }
                    }
            )),
    TAZUNERU("Tazuneru_no_Jutsu.jpg", R.string.tazuneru, R.string.tazuneru_des,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 8;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getIntelligence() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), context.getString(Attribute.INTE.name)
                            );
                        }
                    },
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 10;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getGenjutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Ninjutsu");
                        }
                    }
            )),
    BAKUON("Bakuon_no_Jutsu.jpg", R.string.bukuon, R.string.bukuon_des,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 8;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getIntelligence() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), context.getString(Attribute.INTE.name)
                            );
                        }
                    },
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 10;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getGenjutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Genjutsu");
                        }
                    }
            )),
    UTSUSEMI("Utsusemi_no_Jutsu.jpg", R.string.utsusemi, R.string.utsusemi_des,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 9;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getIntelligence() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), context.getString(Attribute.INTE.name)
                            );
                        }
                    },
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 12;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getGenjutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Genjutsu");
                        }
                    }
            )),
    HANA_I("Hana_Kyouka_Sai.jpg", R.string.hana_kyouka_sai_i, R.string.hana_kyouka_sai_i_des,
            Jutsu.Type.DEBUFF,
            Arrays.asList(
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 12;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getGenjutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Genjutsu");
                        }
                    }
            )),
    HANA_II("Hana_Kyouka_Sai.jpg", R.string.hana_kyouka_sai_ii, R.string.hana_kyouka_sai_ii_des,
            Jutsu.Type.DEBUFF,
            Arrays.asList(
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 12;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getGenjutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Genjutsu");
                        }
                    }
            )),
    SENSEI_HANA("Hana-Kyouka-Sai.gif", R.string.sensei_hana_kyouka_sai, R.string.sensei_hana_kyouka_sai_des,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 11;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getIntelligence() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), context.getString(Attribute.INTE.name)
                            );
                        }
                    },
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 14;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getGenjutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Genjutsu");
                        }
                    }
            )),

    // GEN - Chuunin
    NINPOU_HYAKKA("ninpou_hyakka_ryoran.jpg", R.string.ninpou_hyakka_ryoran, R.string.ninpou_kyakka_ryoran_des,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 11;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getIntelligence() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), context.getString(Attribute.INTE.name)
                            );
                        }
                    },
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 15;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getGenjutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Genjutsu");
                        }
                    }
            )),
    KORI("kori_shinchuu.jpg", R.string.kori_shinchuu, R.string.kori_shinchuu_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 14;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getIntelligence() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), context.getString(Attribute.INTE.name)
                            );
                        }
                    },
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 18;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getGenjutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Genjutsu");
                        }
                    }
            )),
    MAGEN_I("magen_narakumi.jpg", R.string.magen_i, R.string.magen_des,
            Jutsu.Type.DEBUFF,
            Arrays.asList(
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 18;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getGenjutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Genjutsu");
                        }
                    }
            )),
    MAGEN_II("magen_narakumi.jpg", R.string.magen_ii, R.string.magen_des,
            Jutsu.Type.DEBUFF,
            Arrays.asList(
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 18;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getGenjutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Genjutsu");
                        }
                    }
            )),
    OTO("oto_no_gen.jpg", R.string.oto, R.string.oto_des,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 15;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getIntelligence() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), context.getString(Attribute.INTE.name)
                            );
                        }
                    },
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 20;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getGenjutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Genjutsu");
                        }
                    }
            )),
    KOKOHI("kokohi.jpg", R.string.kokohi, R.string.kokohi_des,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 17;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getIntelligence() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), context.getString(Attribute.INTE.name)
                            );
                        }
                    },
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 22;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getGenjutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Genjutsu");
                        }
                    }
            )),
    SENSEI_OTO("Oto-no-Gen.gif", R.string.sensei_oto, R.string.sensei_oto_des,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 18;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getIntelligence() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), context.getString(Attribute.INTE.name)
                            );
                        }
                    },
                    new Requirement() {

                        @Override
                        public Object value() {
                            return 24;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getAttributes().getGenjutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Genjutsu");
                        }
                    }
            ));


    public final String image;
    public final int name;
    public final int description;
    public final Jutsu.Type type;
    public final List<Requirement> requirements;

    JutsuInfo(String image, int name, int description, Jutsu.Type type, List<Requirement> requirements) {
        this.image = image;
        this.name = name;
        this.description = description;
        this.type = type;
        this.requirements = requirements;
    }

    public int getName() {
        return name;
    }
}
