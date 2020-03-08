package com.gutotech.narutogame.data.model;

import android.content.Context;

import androidx.annotation.StringRes;

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
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
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
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
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
    HORENGAN_PILL_II("pilula_verde.jpg", R.string.horengan_pill_ii, R.string.horengan_pill_ii_des,
            Jutsu.Type.BUFF,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
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
    HARIITSUBA("agulhas_sopranas.jpg", R.string.hariitsuba, R.string.hariitsuba_des,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
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
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
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
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
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
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
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
    KARENGAN_PILL_II("pilula_amarela.jpg", R.string.karengan_pill_ii, R.string.karengan_pill_ii_des,
            Jutsu.Type.BUFF,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
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
    SENSEI_DYNAMIC_ENTRY("Dynamic_Entry.gif", R.string.sensei_dynamic_entry, R.string.sensei_dynamic_entry_des,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
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
    KONOHA_DAI_SENKOU("konoha_dai_senkou.jpg", R.string.konoha_dai_senkou, R.string.konoha_dai_senkou_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
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
    SENNEN_GOROSHI("sennen-goroshi.jpg", R.string.sennen_goroshi, R.string.sennen_goroshi_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
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
    AIAN_KUROU("dynamic_entry.jpg", R.string.aian_kurou, R.string.aian_kurou_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
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
    KONOHA_REPPUU("dynamic_entry.jpg", R.string.konoha_reppuu, R.string.konoha_reppuu_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
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
    TONGARASHIGAN_PILL_I("dynamic_entry.jpg", R.string.tongarashigan_pill_i, R.string.tongarashigan_pill_i_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
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
    TONGARASHIGAN_PILL_II("dynamic_entry.jpg", R.string.tongarashigan_pill_ii, R.string.tongarashigan_pill_ii_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
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
    KONGOURIKI_FUDOU("dynamic_entry.jpg", R.string.kongouriki_fudou, R.string.kongouriki_fudou_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
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
    SHISHI_RENDAN("dynamic_entry.jpg", R.string.shishi_rendan, R.string.shishi_rendan_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
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
    PANCHI("dynamic_entry.jpg", R.string.panchi, R.string.panchi_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
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
    KONOHA_KAGE_BUYOU("dynamic_entry.jpg", R.string.konoha_kage_buyou, R.string.konoha_kage_buyou_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
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

    SENSEI_SENNEN_GOROSHI("Sennen_Goroshi.gif", R.string.sensei_sennen_goroshi, R.string.sensei_sennen_goroshi_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
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

    RAKANKEN("dynamic_entry.jpg", R.string.rakanken, R.string.rakanken_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
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
    JUUKEN_SHINAN("dynamic_entry.jpg", R.string.juuken_shinan, R.string.juuken_shinan_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
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

    DOROPPU_KIKKU("dynamic_entry.jpg", R.string.doroppu_kikku, R.string.doroppu_kikku_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
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
    CHOKUGEKI_RAIKOU("dynamic_entry.jpg", R.string.chokugeki_raikou, R.string.chokugeki_raikou_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
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
    KONOHA_GOURIKI_SENPUU("dynamic_entry.jpg", R.string.konoha_gouriki_senpuu, R.string.konoha_gouriki_senpuu_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
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
    ERUBOU("dynamic_entry.jpg", R.string.erubou, R.string.erubou_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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
    KONOHA_DAIRETSUKUU("konoha-dairetsukuu.jpg", R.string.konoha_dairetsukuu, R.string.konoha_dairetsukuu_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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
    KOSA_HO("dynamic_entry.jpg", R.string.kosa_ho, R.string.kosa_ho_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
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
    SUIKEN_I("dynamic_entry.jpg", R.string.suiken_i, R.string.suiken_i_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
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
    SUIKEN_II("dynamic_entry.jpg", R.string.suiken_ii, R.string.suiken_ii_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
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
    OBOROZUKIYO("dynamic_entry.jpg", R.string.oborozukiyo, R.string.oborozukiyo_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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
    KONOHA_KAIGANSHOU("konoha-kaiganshou.jpg", R.string.konoha_kaiganshou, R.string.konoha_kaiganshou_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
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
    HAYABUSA_OTOSHI("dynamic_entry.jpg", R.string.hayabusa_otoshi, R.string.hayabusa_otoshi_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
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
    RAIGYAKU_SUIHEI("dynamic_entry.jpg", R.string.raigyaku_suihei, R.string.raigyaku_suihei_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
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
    DOUBLE_DYNAMIC_ENTRY("double-dynamic-entry.jpg", R.string.double_dynamic_entry, R.string.double_dynamic_entry_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
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
    KONOHA_GOUHOURAIRAKU("dynamic_entry.jpg", R.string.konoha_gouhourairaku, R.string.konoha_gouhourairaku_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
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
    KYAKU_KICK("Kyaku-Kick.jpg", R.string.kyaku_kick, R.string.kyaku_kick_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
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
    SENSEI_KONOHA_GOURIKI_SENPUU("dynamic_entry.jpg", R.string.sensei_konoha_gouriki_senpuu, R.string.sensei_konoha_gouriki_senpuu_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
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
    GOURAI_RENGE("dynamic_entry.jpg", R.string.gourai_renge, R.string.gourai_renge_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
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
    HEDDO_BATTO("dynamic_entry.jpg", R.string.heddo_batto, R.string.heddo_batto_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
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
    GIROCHIN_DOROPPU("dynamic_entry.jpg", R.string.girochin_doroppu, R.string.girochin_doroppu_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
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
    KONOHA_TSUMUJI_SENPUU("dynamic_entry.jpg", R.string.konoha_tsumuji_senpuu, R.string.konoha_tsumuji_senpuu_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
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
    TSUUTENKYAKU("dynamic_entry.jpg", R.string.tsuutenkyaku, R.string.tsuutenkyaku_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
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
    BUNSHIN_KAITEN_KAKATO_OTOSHI_I("dynamic_entry.jpg", R.string.bunshin_kaiten_kakato_otoshi_i, R.string.bunshin_kaiten_kakato_otoshi_i_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
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
    BUNSHIN_KAITEN_KAKATO_OTOSHI_II("dynamic_entry.jpg", R.string.bunshin_kaiten_kakato_otoshi_ii, R.string.bunshin_kaiten_kakato_otoshi_ii_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
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
    HIKEN_TSUKIKAGE("dynamic_entry.jpg", R.string.hiken_tsukikage, R.string.hiken_tsukikage_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
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
    RARIATTO("dynamic_entry.jpg", R.string.rariatto, R.string.rariatto_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
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
    KONOHA_SHOUFUU("dynamic_entry.jpg", R.string.konoha_shoufuu, R.string.konoha_shoufuu_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
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
    TAIHOU_SENTOU("dynamic_entry.jpg", R.string.taihou_sentou, R.string.taihou_sentou_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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
    RAIKEN("dynamic_entry.jpg", R.string.raiken, R.string.raiken_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
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
    RAIGA_BOMU("dynamic_entry.jpg", R.string.raiga_bomu, R.string.raiga_bomu_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
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
    AOI_SHOUGEKI("dynamic_entry.jpg", R.string.aoi_shougeki, R.string.aoi_shougeki_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
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
    TATSUMAKI_KYAKU("dynamic_entry.jpg", R.string.tatsumaki_kyaku, R.string.tatsumaki_kyaku_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
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
    SENSEI_RAIGA_BOMU("dynamic_entry.jpg", R.string.sensei_raiga_bomu, R.string.sensei_raiga_bomu_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
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
    KONGOURIKI("dynamic_entry.jpg", R.string.kongouriki, R.string.kongouriki_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
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
    M_PANCHI("dynamic_entry.jpg", R.string.panchi, R.string.panchi_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
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
    DABURU_RARIATTO("dynamic_entry.jpg", R.string.daburu_rariatto, R.string.daburu_rariatto_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
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
    JIGOKUZUKI("dynamic_entry.jpg", R.string.jigokuzuki, R.string.jigokuzuki_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
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
    KONOHA_NEPPUU("dynamic_entry.jpg", R.string.konoha_neppuu, R.string.konoha_neppuu_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
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
    KONOHA_DAI_SENPUU("dynamic_entry.jpg", R.string.konoha_dai_senpuu, R.string.konoha_dai_senpuu_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
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
    SOLDIER_PILL_I("dynamic_entry.jpg", R.string.soldier_pill_i, R.string.soldier_pill_i_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
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
    SEINSHUN_BURUPAPUA("dynamic_entry.jpg", R.string.seinshun_burupapua, R.string.seinshun_burupapua_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
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
    SOLDIER_PILL_II("dynamic_entry.jpg", R.string.soldier_pill_ii, R.string.soldier_pill_ii_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
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
    SHICHIKENBU("dynamic_entry.jpg", R.string.shichikenbu, R.string.shichikenbu_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
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
    YONHON_NUKITE("dynamic_entry.jpg", R.string.yonhon_nukite, R.string.yonhon_nukite_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
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
    CHOUHARITE("dynamic_entry.jpg", R.string.chouharite, R.string.chouharite_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
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
    KANADZUCHI_DAGEKI("dynamic_entry.jpg", R.string.kanadzuchi_dageki, R.string.kanadzuchi_dageki_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
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
    SANBON_NUKITE("dynamic_entry.jpg", R.string.sanbon_nukite, R.string.sanbon_nukite_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
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
    KONOHA_RYUUJIN("dynamic_entry.jpg", R.string.konoha_ryuujin, R.string.konoha_ryuujin_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
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
    MYU_SENPUU("dynamic_entry.jpg", R.string.myu_senpuu, R.string.myu_senpuu_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
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
    SENSEI_SHICHIKENBU("dynamic_entry.jpg", R.string.sensei_shichikenbu, R.string.sensei_shichikenbu_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
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
    IPPON_NUKITE("dynamic_entry.jpg", R.string.ippon_nukite, R.string.ippon_nukite_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
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
    SENSEI_MYU_SENPUU("dynamic_entry.jpg", R.string.sensei_myu_senpuu, R.string.sensei_myu_senpuu_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
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

    // BUKIJUTSUS
    SOUFUUSHASAN_NO_TACHI("dynamic_entry.jpg", R.string.soufuushasan_no_tachi, R.string.soufuushasan_no_tachi_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    SOUSHURIKEN_NO_JUTSU("dynamic_entry.jpg", R.string.soushuriken_no_jutsu, R.string.soushuriken_no_jutsu_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
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
    SOUSHUUJIN_II("dynamic_entry.jpg", R.string.soushuujin_ii, R.string.soushuujin_ii_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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
    SOUSHUUJIN_I("dynamic_entry.jpg", R.string.soushuujin_i, R.string.soushuujin_i_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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
    RENSHA("dynamic_entry.jpg", R.string.rensha, R.string.rensha_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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
    JOURO_SENBON("dynamic_entry.jpg", R.string.jouro_senbon, R.string.jouro_senbon_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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
    SHIKOMISHINDAN("dynamic_entry.jpg", R.string.shikomishindan, R.string.shikomishindan_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
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
    GENEI_TAJUU_SHURIKEN("dynamic_entry.jpg", R.string.genei_tajuu_shuriken, R.string.genei_tajuu_shuriken_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
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
    HIJUTSU_ISHIBARI_I("dynamic_entry.jpg", R.string.hijutsu_ishibari_i, R.string.hijutsu_ishibari_i_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    HIJUTSU_ISHIBARI_II("dynamic_entry.jpg", R.string.hijutsu_ishibari_ii, R.string.hijutsu_ishibari_ii_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    SENSEI_SOUSHURIKEN_NO_JUTSU("dynamic_entry.jpg", R.string.sensei_soushuriken_no_jutsu, R.string.sensei_soushuriken_no_jutsu_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    SHIKOMI_KUGUTSU_SHINSHIN_HAPPA("dynamic_entry.jpg", R.string.shikomi_kugutsu_shinshin_happa, R.string.shikomi_kugutsu_shinshin_happa_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    NADESHIKORYUU_SHINKU_ENBU("dynamic_entry.jpg", R.string.nadeshikoryuu_shinku_enbu, R.string.nadeshikoryuu_shinku_enbu_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    SAMEDARE_KEKKA("dynamic_entry.jpg", R.string.samedare_kekka, R.string.samedare_kekka_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    KAWARA_SHURIKEN("dynamic_entry.jpg", R.string.kawara_shuriken, R.string.kawara_shuriken_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    RAIKOU_KENKA_I("dynamic_entry.jpg", R.string.raikou_kenka_i, R.string.raikou_kenka_i_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    RAIKOU_KENKA_II("dynamic_entry.jpg", R.string.raikou_kenka_ii, R.string.raikou_kenka_ii_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    AKAHIGI_KIKI_SANKAKU("dynamic_entry.jpg", R.string.akahigi_kiki_sankaku, R.string.akahigi_kiki_sankaku_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    KUMO_SENKYUU_SUZAKU("dynamic_entry.jpg", R.string.kumo_senkyuu_suzaku, R.string.kumo_senkyuu_suzaku_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    SOUSHUUGA("dynamic_entry.jpg", R.string.soushuuga, R.string.soushuuga_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    HADAN("dynamic_entry.jpg", R.string.hadan, R.string.hadan_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    SENSEI_SOUSHUUGA("dynamic_entry.jpg", R.string.sensei_soushuuga, R.string.sensei_soushuuga_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    SAKURA_FUBUKI_NO_JUTSU("dynamic_entry.jpg", R.string.sakura_fubuki_no_jutsu, R.string.sakura_fubuki_no_jutsu_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    KUGUTSU_NO_JUTSU_GISHU_SENBON("dynamic_entry.jpg", R.string.kugutsu_no_jutsu_gishu_senbon, R.string.kugutsu_no_jutsu_gishu_senbon_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    KUGUTSU_SAKURA_NO_MAI("dynamic_entry.jpg", R.string.kugutsu_sakura_no_mai, R.string.kugutsu_sakura_no_mai_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    SETSUNA("dynamic_entry.jpg", R.string.setsuna, R.string.setsuna_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    SENMOUFUU("dynamic_entry.jpg", R.string.senmoufuu, R.string.senmoufuu_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    TAKIGAKURERYUU_MIZUKIRI_NO_YAIBA("dynamic_entry.jpg", R.string.takigakureryuu_mizukiri_no_yaiba, R.string.takigakureryuu_mizukiri_no_yaiba_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    SHINKUUKEN("dynamic_entry.jpg", R.string.shinkuuken, R.string.shinkuuken_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    RAISOU_IKAZUCHI_NO_UTAGE("dynamic_entry.jpg", R.string.raisou_ikazuchi_no_utage, R.string.raisou_ikazuchi_no_utage_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    KONOHARYUU_YANAGI_II("dynamic_entry.jpg", R.string.konoharyuu_yanagi_ii, R.string.konoharyuu_yanagi_ii_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    KONOHARYUU_YANAGI_I("dynamic_entry.jpg", R.string.konoharyuu_yanagi_i, R.string.konoharyuu_yanagi_i_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    KAMAITACHI_NO_JUTSU("dynamic_entry.jpg", R.string.kamaitachi_no_jutsu, R.string.kamaitachi_no_jutsu_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    KAKEAMI("dynamic_entry.jpg", R.string.kakeami, R.string.kakeami_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    KUMORYUU_URAGIRI("dynamic_entry.jpg", R.string.kumoryuu_uragiri, R.string.kumoryuu_uragiri_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    SUISHOU_TOU("dynamic_entry.jpg", R.string.suishou_tou, R.string.suishou_tou_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    KUSARIGAMA_NO_JUTSU("dynamic_entry.jpg", R.string.kusarigama_no_jutsu, R.string.kusarigama_no_jutsu_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    RAIKYUU("dynamic_entry.jpg", R.string.raikyuu, R.string.raikyuu_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    KUMORYUU_MIKAZUKIGIRI("dynamic_entry.jpg", R.string.kumoryuu_mikazukigiri, R.string.kumoryuu_mikazukigiri_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    SENSEI_KUMORYUU_MIKAZUKIGIRI("dynamic_entry.jpg", R.string.sensei_kumoryuu_mikazukigiri, R.string.sensei_kumoryuu_mikazukigiri_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    KUROHIGI_KIKI_IPPATSU("dynamic_entry.jpg", R.string.kurohigi_kiki_ippatsu, R.string.kurohigi_kiki_ippatsu_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    KUROHIGI_KIKI_NIHATSU("dynamic_entry.jpg", R.string.kurohigi_kiki_nihatsu, R.string.kurohigi_kiki_nihatsu_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    IKAZUCHI_NO_KIBA("dynamic_entry.jpg", R.string.ikazuchi_no_kiba, R.string.ikazuchi_no_kiba_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    REIJINGU_SANDAA("dynamic_entry.jpg", R.string.reijingu_sandaa, R.string.reijingu_sandaa_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    KUMORYUU_KAENGIRI("dynamic_entry.jpg", R.string.kumoryuu_kaengiri, R.string.kumoryuu_kaengiri_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    MUGEN_KOUGAI_II("dynamic_entry.jpg", R.string.mugen_kougai_ii, R.string.mugen_kougai_ii_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    MUGEN_KOUGAI_I("dynamic_entry.jpg", R.string.mugen_kougai_i, R.string.mugen_kougai_i_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    KUROHIGI_KIKI_SANPATSU("dynamic_entry.jpg", R.string.kurohigi_kiki_sanpatsu, R.string.kurohigi_kiki_sanpatsu_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    AKAHIGI_KAENHOUSHAKI("dynamic_entry.jpg", R.string.akahigi_kaenhoushaki, R.string.akahigi_kaenhoushaki_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    DOKUKIRI_JIGOKU_BARIBARI_HYAKU_RENPATSU("dynamic_entry.jpg", R.string.dokukiri_jigoku_baribari_hyaku_renpatsu, R.string.dokukiri_jigoku_baribari_hyaku_renpatsu_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    KONGOU_ROUHEKI("dynamic_entry.jpg", R.string.kongou_rouheki, R.string.kongou_rouheki_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    SOUNINSHUU("dynamic_entry.jpg", R.string.souninshuu, R.string.souninshuu_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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
    SHURIKEN_SHINKUUJIN("dynamic_entry.jpg", R.string.shuriken_shinkuujin, R.string.shuriken_shinkuujin_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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
    KIBAKU_FUDA_NO_JUTSU("dynamic_entry.jpg", R.string.kibaku_fuda_no_jutsu, R.string.kibaku_fuda_no_jutsu_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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
    GUNBAI_KAZE_AEKOUSHA("dynamic_entry.jpg", R.string.gunbai_kaze_aekousha, R.string.gunbai_kaze_aekousha_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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
    SENSEI_AKAHIGI_KAENHOUSHAKI("dynamic_entry.jpg", R.string.sensei_akahigi_kaenhoushaki, R.string.sensei_akahigi_kaenhoushaki_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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
    KUMORYUU_OMOTEGIRI("dynamic_entry.jpg", R.string.kumoryuu_omotegiri, R.string.kumoryuu_omotegiri_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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
    OOKAKEAMI("dynamic_entry.jpg", R.string.ookakeami, R.string.ookakeami_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
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
    CHOU_BIBURAATO_RAITONTOU("dynamic_entry.jpg", R.string.chou_biburaato_raitontou, R.string.chou_biburaato_raitontou_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
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

    KUNAI_SHINKUUJIN("dynamic_entry.jpg", R.string.kunai_shinkuujin, R.string.kunai_shinkuujin_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
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

    IAIGIRI("dynamic_entry.jpg", R.string.iaigiri, R.string.iaigiri_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
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
    HOUSENKA_TSUMABENI("dynamic_entry.jpg", R.string.housenka_tsumabeni, R.string.housenka_tsumabeni_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
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
    UCHIHAGAESHI("dynamic_entry.jpg", R.string.uchihagaeshi, R.string.uchihagaeshi_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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
    NANATSU_BUTOUKAI_KEN_II("dynamic_entry.jpg", R.string.nanatsu_butoukai_ken_ii, R.string.nanatsu_butoukai_ken_ii_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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
    NANATSU_BUTOUKAI_KEN_I("dynamic_entry.jpg", R.string.nanatsu_butoukai_ken_i, R.string.nanatsu_butoukai_ken_i_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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
    CHIYU_KETSUEKI("dynamic_entry.jpg", R.string.chiyu_ketsueki, R.string.chiyu_ketsueki_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    TSUIRAKU_KABUTO("dynamic_entry.jpg", R.string.tsuiraku_kabuto, R.string.tsuiraku_kabuto_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    SANDAAGEETO("dynamic_entry.jpg", R.string.sandaageeto, R.string.sandaageeto_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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
    BAKUTOU_JUTSU_HAPPA_ROKUJUUSHI("dynamic_entry.jpg", R.string.bakutou_jutsu_happa_rokujuushi, R.string.bakutou_jutsu_happa_rokujuushi_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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
    KAIHOU("dynamic_entry.jpg", R.string.kaihou, R.string.kaihou_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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
    CHOUTOU_NINPOU_JIGUMO_NUI("dynamic_entry.jpg", R.string.choutou_ninpou_jigumo_nui, R.string.choutou_ninpou_jigumo_nui_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    CHAKURAHIRU_WANIZAME("Chakurahiru-Wanizame.jpg", R.string.chakurahiru_wanizame, R.string.chakurahiru_wanizame_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    SENSEI_CHOU_BIBURAATO_RAITONTOU("dynamic_entry.jpg", R.string.sensei_chou_biburaato_raitontou, R.string.sensei_chou_biburaato_raitontou_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    BAKUHATSUTEKI_IAIKAI("dynamic_entry.jpg", R.string.bakuhatsuteki_iaikai, R.string.bakuhatsuteki_iaikai_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    SENSEI_KAIHOU("dynamic_entry.jpg", R.string.sensei_kaihou, R.string.sensei_kaihou_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    // NINJUTSUS
    HENGE_NO_JUTSU("konoha_tizu.jpg", R.string.henge_no_jutsu, R.string.henge_no_jutsu_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    BUNSHIN_NO_JUTSU_I("konoha_tizu.jpg", R.string.bunshin_no_jutsu_i, R.string.bunshin_no_jutsu_i_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    KONOHA_TZU("konoha_tizu.jpg", R.string.konoha_tzu, R.string.konoha_tzu_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    BUNSHIN_NO_JUTSU_II("konoha_tizu.jpg", R.string.bunshin_no_jutsu_ii, R.string.bunshin_no_jutsu_ii_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    NINPOU_MUSHOU_DE_HITEI("konoha_tizu.jpg", R.string.ninpou_mushou_de_hitei, R.string.ninpou_mushou_de_hitei_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    KAGE_SHURIKEN_NO_JUTSU("konoha_tizu.jpg", R.string.kage_shuriken_no_jutsu, R.string.kage_shuriken_no_jutsu_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    KAKUREMINO_NO_JUTSU("konoha_tizu.jpg", R.string.kakuremino_no_jutsu, R.string.kakuremino_no_jutsu_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    KAWARIMI_NO_JUTSU("konoha_tizu.jpg", R.string.kawarimi_no_jutsu, R.string.kawarimi_no_jutsu_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    KAGE_BUNSHIN_NO_JUTSU_I("konoha_tizu.jpg", R.string.kage_bunshin_no_jutsu_i, R.string.kage_bunshin_no_jutsu_i_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    KAGE_BUNSHIN_NO_JUTSU_II("konoha_tizu.jpg", R.string.kage_bunshin_no_jutsu_ii, R.string.kage_bunshin_no_jutsu_ii_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    SENSEI_KAGE_BUNSHIN_NO_JUTSU("konoha_tizu.jpg", R.string.sensei_kage_bunshin_no_jutsu, R.string.sensei_kage_bunshin_no_jutsu_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    RASENGAN("rasengan.jpg", R.string.rasengan, R.string.rasengan_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    KURO_TATSUMAKI("konoha_tizu.jpg", R.string.kuro_tatsumaki, R.string.kuro_tatsumaki_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    MEISAI_GAKURE_NO_JUTSU_I("konoha_tizu.jpg", R.string.meisai_gakure_no_jutsu_i, R.string.meisai_gakure_no_jutsu_i_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    MEISAI_GAKURE_NO_JUTSU_II("konoha_tizu.jpg", R.string.meisai_gakure_no_jutsu_ii, R.string.meisai_gakure_no_jutsu_ii_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    TAJUU_TAKI_RASENGAN("tajuu_taki_rasengan.jpg", R.string.tajuu_taki_rasengan, R.string.tajuu_taki_rasengan_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    BUNSHIN_BAKURETSU("konoha_tizu.jpg", R.string.bunshin_bakuretsu, R.string.bunshin_bakuretsu_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    SENSEI_RASENGAN("Rasengan.gif", R.string.sensei_rasengan, R.string.sensei_rasengan_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    MIKAZUKI_NO_MAI("konoha_tizu.jpg", R.string.mikazuki_no_mai, R.string.mikazuki_no_mai_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    TATSUMAKI_RASENGAN("Tatsumaki Rasengan.jpg", R.string.tatsumaki_rasengan, R.string.tatsumaki_rasengan_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    AYATSUITO_NO_JUTSU_I("konoha_tizu.jpg", R.string.ayatsuito_no_jutsu_i, R.string.ayatsuito_no_jutsu_i_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    AYATSUITO_NO_JUTSU_II("konoha_tizu.jpg", R.string.ayatsuito_no_jutsu_ii, R.string.ayatsuito_no_jutsu_ii_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    OODAMA_RASENGAN("oodama_rasengan.jpg", R.string.oodama_rasengan, R.string.oodama_rasengan_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    GOKAN_SAKUSOU("konoha_tizu.jpg", R.string.gokan_sakusou, R.string.gokan_sakusou_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    SHIHOUHAPPOU_SHURIKEN("konoha_tizu.jpg", R.string.shihouhappou_shuriken, R.string.shihouhappou_shuriken_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    SENSEI_MIKAZUKI_NO_MAI("konoha_tizu.jpg", R.string.sensei_mikazuki_no_mai, R.string.sensei_mikazuki_no_mai_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    RANJI_SHIGUMI_NO_JUTSU("konoha_tizu.jpg", R.string.ranji_shigumi_no_jutsu, R.string.ranji_shigumi_no_jutsu_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    TAJUU_KAGE_BUNSHIN_NO_JUTSU_I("konoha_tizu.jpg", R.string.tajuu_kage_bunshin_no_jutsu_i, R.string.tajuu_kage_bunshin_no_jutsu_i_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    KAKUAN_NITTEN_SUISHU("konoha_tizu.jpg", R.string.kakuan_nitten_suishu, R.string.kakuan_nitten_suishu_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    TAJUU_KAGE_BUNSHIN_NO_JUTSU_II("konoha_tizu.jpg", R.string.tajuu_kage_bunshin_no_jutsu_ii, R.string.tajuu_kage_bunshin_no_jutsu_ii_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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
    CHOU_OODAMA_RASENGAN("Chou-Oodama-Rasengan.gif", R.string.chou_oodama_rasengan, R.string.chou_oodama_rasengan_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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
    MINIRASENSHURIKEN("konoha_tizu.jpg", R.string.minirasenshuriken, R.string.minirasenshuriken_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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
    NINPOU_GYORAISHIN("konoha_tizu.jpg", R.string.ninpou_gyoraishin, R.string.ninpou_gyoraishin_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
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
                    new

                            Requirement() {

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

    SENSEI_CHOU_OODAMA_RASENGAN("Chou-Oodama-Rasengan.gif", R.string.sensei_chou_oodama_rasengan, R.string.sensei_chou_oodama_rasengan_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    SENPOU_OODAMA_RASENGAN("Senpou Oodama Rasengan.jpg", R.string.senpou_oodama_rasengan, R.string.senpou_oodama_rasengan_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    CHOU_OODAMA_RASEN_TARENGAN("konoha_tizu.jpg", R.string.chou_oodama_rasen_tarengan, R.string.chou_oodama_rasen_tarengan_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    REIKA_NO_JUTSU("konoha_tizu.jpg", R.string.reika_no_jutsu, R.string.reika_no_jutsu_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    HIRAISHIN_NO_JUTSU_I("konoha_tizu.jpg", R.string.hiraishin_no_jutsu_i, R.string.hiraishin_no_jutsu_i_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    RASENKYUUGAN("konoha_tizu.jpg", R.string.rasenkyuugan, R.string.rasenkyuugan_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    HIRAISHIN_NO_JUTSU_II("konoha_tizu.jpg", R.string.hiraishin_no_jutsu_ii, R.string.hiraishin_no_jutsu_ii_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    WAKUSEI_RASENGAN("konoha_tizu.jpg", R.string.wakusei_rasengan, R.string.wakusei_rasengan_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    OYAKO_RASENGAN("konoha_tizu.jpg", R.string.oyako_rasengan, R.string.oyako_rasengan_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    SENSEI_HIRAISHIN_NO_JUTSU("konoha_tizu.jpg", R.string.sensei_hiraishin_no_jutsu, R.string.sensei_hiraishin_no_jutsu_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    SENSEI_OYAKO_RASENGAN("konoha_tizu.jpg", R.string.sensei_oyako_rasengan, R.string.sensei_oyako_rasengan_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    // GENJUTSUS
    KISHIBARI_NO_JUTSU("konoha_tizu.jpg", R.string.kishibari_no_jutsu, R.string.kishibari_no_jutsu_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    NEMURI_I("konoha_tizu.jpg", R.string.nemuri_i, R.string.nemuri_i_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    KASUMI_JUUHA_NO_JUTSU("konoha_tizu.jpg", R.string.kasumi_juuha_no_jutsu, R.string.kasumi_juuha_no_jutsu_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    NEMURI_II("konoha_tizu.jpg", R.string.nemuri_ii, R.string.nemuri_ii_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    KOKOROYORU_NO_JUTSU("konoha_tizu.jpg", R.string.kokoroyoru_no_jutsu, R.string.kokoroyoru_no_jutsu_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    TAZUNERU_NO_JUTSU("konoha_tizu.jpg", R.string.tazuneru_no_jutsu, R.string.tazuneru_no_jutsu_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    BAKUON_NO_JUTSU("konoha_tizu.jpg", R.string.bakuon_no_jutsu, R.string.bakuon_no_jutsu_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    UTSUSEMI_NO_JUTSU("konoha_tizu.jpg", R.string.utsusemi_no_jutsu, R.string.utsusemi_no_jutsu_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    HANA_KYOUKA_SAI_I("konoha_tizu.jpg", R.string.hana_kyouka_sai_i, R.string.hana_kyouka_sai_i_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    HANA_KYOUKA_SAI_II("konoha_tizu.jpg", R.string.hana_kyouka_sai_ii, R.string.hana_kyouka_sai_ii_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    SENSEI_HANA_KYOUKA_SAI("konoha_tizu.jpg", R.string.sensei_hana_kyouka_sai, R.string.sensei_hana_kyouka_sai_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    NINPOU_HYAKKA_RYORAN("konoha_tizu.jpg", R.string.ninpou_hyakka_ryoran, R.string.ninpou_hyakka_ryoran_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    KORI_SHINCHUU_NO_JUTSU("konoha_tizu.jpg", R.string.kori_shinchuu_no_jutsu, R.string.kori_shinchuu_no_jutsu_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    MAGEN_NARAKUMI_NO_JUTSU_I("konoha_tizu.jpg", R.string.magen_narakumi_no_jutsu_i, R.string.magen_narakumi_no_jutsu_i_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    MAGEN_NARAKUMI_NO_JUTSU_II("konoha_tizu.jpg", R.string.magen_narakumi_no_jutsu_ii, R.string.magen_narakumi_no_jutsu_ii_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    OTO_NO_GEN("konoha_tizu.jpg", R.string.oto_no_gen, R.string.oto_no_gen_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    KOKOHI_NO_JUTSU("konoha_tizu.jpg", R.string.kokohi_no_jutsu, R.string.kokohi_no_jutsu_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    SENSEI_OTO_NO_GEN("konoha_tizu.jpg", R.string.sensei_oto_no_gen, R.string.sensei_oto_no_gen_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    AN_NO_GENJUTSU("konoha_tizu.jpg", R.string.an_no_genjutsu, R.string.an_no_genjutsu_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    KARASU_NO_GENJUTSU("konoha_tizu.jpg", R.string.karasu_no_genjutsu, R.string.karasu_no_genjutsu_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    MAGEN_KOKUNI_ARAZU_NO_JUTSU_I("konoha_tizu.jpg", R.string.magen_kokuni_arazu_no_jutsu_i, R.string.magen_kokuni_arazu_no_jutsu_i_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    MAGEN_KOKUNI_ARAZU_NO_JUTSU_II("konoha_tizu.jpg", R.string.magen_kokuni_arazu_no_jutsu_ii, R.string.magen_kokuni_arazu_no_jutsu_ii_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    NEHAN_SHOUJA_NO_JUTSU("konoha_tizu.jpg", R.string.nehan_shouja_no_jutsu, R.string.nehan_shouja_no_jutsu_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    MATEKI_MUGEN_ONKI("konoha_tizu.jpg", R.string.mateki_mugen_onki, R.string.mateki_mugen_onki_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    HYAKKA_NINPOU_HANACHIRI_NUKO("konoha_tizu.jpg", R.string.hyakka_ninpou_hanachiri_nuko, R.string.hyakka_ninpou_hanachiri_nuko_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    SENSEI_KOKOHI_DEBOA("konoha_tizu.jpg", R.string.sensei_kokohi_deboa, R.string.sensei_kokohi_deboa_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    YUBI_NO_GENJUTSU("konoha_tizu.jpg", R.string.yubi_no_genjutsu, R.string.yubi_no_genjutsu_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    GENJUTSU_NO_KIRI_I("konoha_tizu.jpg", R.string.genjutsu_no_kiri_i, R.string.genjutsu_no_kiri_i_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    RAIGEN_RAIKOUCHUU("konoha_tizu.jpg", R.string.raigen_raikouchuu, R.string.raigen_raikouchuu_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    GENJUTSU_NO_KIRI_II("konoha_tizu.jpg", R.string.genjutsu_no_kiri_ii, R.string.genjutsu_no_kiri_ii_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    MAGEN_KASEGUI_NO_JUTSU("konoha_tizu.jpg", R.string.magen_kasegui_no_jutsu, R.string.magen_kasegui_no_jutsu_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    MUGEN_MAROU("konoha_tizu.jpg", R.string.mugen_marou, R.string.mugen_marou_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    SHINU_NO_GENJUTSU("konoha_tizu.jpg", R.string.shinu_no_genjutsu, R.string.shinu_no_genjutsu_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    SENSEI_MATEKI_MUGEN_ONKI("konoha_tizu.jpg", R.string.sensei_mateki_mugen_onki, R.string.sensei_mateki_mugen_onki_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    MAGEN_GAMARINSHOU("konoha_tizu.jpg", R.string.magen_gamarinshou, R.string.magen_gamarinshou_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    HANA_NINPOU_BAKUHATSU_KEMURI_NO_HANABIRA("konoha_tizu.jpg", R.string.hana_ninpou_bakuhatsu_kemuri_no_hanabira, R.string.hana_ninpou_bakuhatsu_kemuri_no_hanabira_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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

    GENJUTSU_SHIBARI("konoha_tizu.jpg", R.string.genjutsu_shibari, R.string.genjutsu_shibari_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
                    new

                            Requirement() {

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
                    new

                            Requirement() {

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
    UTAKATA_I("konoha_tizu.jpg", R.string.utakata_i, R.string.utakata_i_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
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
    KOKOHI_TATAKAI("konoha_tizu.jpg", R.string.kokohi_tatakai, R.string.kokohi_tatakai_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
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
    UTAKATA_II("konoha_tizu.jpg", R.string.utakata_ii, R.string.utakata_ii_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
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
    KOBURABIJON_ITO_SASSHIN("konoha_tizu.jpg", R.string.koburabijon_ito_sasshin, R.string.koburabijon_ito_sasshin_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
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
    SHIRANO("konoha_tizu.jpg", R.string.shirano, R.string.shirano_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
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
    SENSEI_MAGEN_KASEGUI_NO_JUTSU("konoha_tizu.jpg", R.string.sensei_magen_kasegui_no_jutsu, R.string.sensei_magen_kasegui_no_jutsu_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
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
    SENSEI_GENJUTSU_NO_KIRI("konoha_tizu.jpg", R.string.sensei_genjutsu_no_kiri, R.string.sensei_genjutsu_no_kiri_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check(boolean folded) {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    },
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
            ));


    public final String image;

    @StringRes
    public final int name;

    @StringRes
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
