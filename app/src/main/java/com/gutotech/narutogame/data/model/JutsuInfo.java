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
                            return 2;
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
    SENNEN_GOROSHI("sennen-goroshi.jpg", R.string.sennen_goroshi, R.string.sennen_goroshi_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 2;
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
    AIAN_KUROU("aian-kurou.jpg", R.string.aian_kurou, R.string.aian_kurou_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 2;
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
    KONOHA_REPPUU("chute_furacao_violento.jpg", R.string.konoha_reppuu, R.string.konoha_reppuu_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 2;
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
    TONGARASHIGAN_PILL_I("pilula_vermelha.jpg", R.string.tongarashigan_pill_i, R.string.tongarashigan_pill_i_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 2;
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
    TONGARASHIGAN_PILL_II("pilula_vermelha.jpg", R.string.tongarashigan_pill_ii, R.string.tongarashigan_pill_ii_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 2;
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
                        public int getValue() {
                            return 2;
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
                            return 19;
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
                        public int getValue() {
                            return 2;
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
    PANCHI("1000m-panchi.jpg", R.string.panchi, R.string.panchi_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 2;
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
    KONOHA_KAGE_BUYOU("kage_buyou.jpg", R.string.konoha_kage_buyou, R.string.konoha_kage_buyou_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 2;
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
                            return 22;
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
                            return 2;
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

    RAKANKEN("rakanken.jpg", R.string.rakanken, R.string.rakanken_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 3;
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
    JUUKEN_SHINAN("juuken-shinan.jpg", R.string.juuken_shinan, R.string.juuken_shinan_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 3;
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
    DOROPPU_KIKKU("doroppu-kikku.jpg", R.string.doroppu_kikku, R.string.doroppu_kikku_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 3;
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
                            return 19;
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
    CHOKUGEKI_RAIKOU("chokugeki-raikou.jpg", R.string.chokugeki_raikou, R.string.chokugeki_raikou_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 3;
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
    KONOHA_GOURIKI_SENPUU("konoha_gouriki_senpuu.jpg", R.string.konoha_gouriki_senpuu, R.string.konoha_gouriki_senpuu_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 3;
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
                            return 19;
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
                            return 25;
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
    ERUBOU("erubou.jpg", R.string.erubou, R.string.erubou_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 3;
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
                            return 20;
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
                            return 26;
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
                            return 3;
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
    KOSA_HO("kosa-ho.jpg", R.string.kosa_ho, R.string.kosa_ho_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 3;
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
    SUIKEN_I("suiken.jpg", R.string.suiken_i, R.string.suiken_i_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 3;
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
                            return 28;
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
    SUIKEN_II("suiken.jpg", R.string.suiken_ii, R.string.suiken_ii_desc,
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
                            return 28;
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
    OBOROZUKIYO("oborozukiyo.jpg", R.string.oborozukiyo, R.string.oborozukiyo_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 3;
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
                            return 22;
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
                            return 29;
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
                            return 3;
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
                            return 22;
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
                            return 29;
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
    HAYABUSA_OTOSHI("hayabusa_otoshi.jpg", R.string.hayabusa_otoshi, R.string.hayabusa_otoshi_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 3;
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
                            return 23;
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
                            return 30;
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
    RAIGYAKU_SUIHEI("raigyaku-suihei.jpg", R.string.raigyaku_suihei, R.string.raigyaku_suihei_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 3;
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
                            return 23;
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
                            return 31;
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
                            return 3;
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
                            return 23;
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
                            return 31;
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
    KONOHA_GOUHOURAIRAKU("konoha_gouhourairaku.jpg", R.string.konoha_gouhourairaku, R.string.konoha_gouhourairaku_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 3;
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
                            return 24;
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
                            return 32;
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
                            return 3;
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
                            return 24;
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
                            return 32;
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
    SENSEI_KONOHA_GOURIKI_SENPUU("Konoha_Gouriki_Senpuu.gif", R.string.sensei_konoha_gouriki_senpuu, R.string.sensei_konoha_gouriki_senpuu_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 3;
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
                            return 26;
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
                            return 34;
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

    GOURAI_RENGE("gourai_renge.jpg", R.string.gourai_renge, R.string.gourai_renge_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 4;
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
                            return 26;
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
                            return 35;
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
    HEDDO_BATTO("heddo-batto.jpg", R.string.heddo_batto, R.string.heddo_batto_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 4;
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
                            return 26;
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
                            return 35;
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
    GIROCHIN_DOROPPU("girochin-doroppu.jpg", R.string.girochin_doroppu, R.string.girochin_doroppu_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 4;
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
    KONOHA_TSUMUJI_SENPUU("konoha-tsumuji-senpuu.jpg", R.string.konoha_tsumuji_senpuu, R.string.konoha_tsumuji_senpuu_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 4;
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
    TSUUTENKYAKU("tsuutenkyaku.jpg", R.string.tsuutenkyaku, R.string.tsuutenkyaku_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 4;
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
    BUNSHIN_KAITEN_KAKATO_OTOSHI_I("kaiten_kakato_otoshi.jpg", R.string.bunshin_kaiten_kakato_otoshi_i, R.string.bunshin_kaiten_kakato_otoshi_i_desc,
            Jutsu.Type.BUFF,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 4;
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
                            return 38;
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
    BUNSHIN_KAITEN_KAKATO_OTOSHI_II("kaiten_kakato_otoshi.jpg", R.string.bunshin_kaiten_kakato_otoshi_ii, R.string.bunshin_kaiten_kakato_otoshi_ii_desc,
            Jutsu.Type.BUFF,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 4;
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
                            return 38;
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
    HIKEN_TSUKIKAGE("hiken-tsukikage.jpg", R.string.hiken_tsukikage, R.string.hiken_tsukikage_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 4;
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
    RARIATTO("lariat.jpg", R.string.rariatto, R.string.rariatto_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 4;
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
                            return 29;
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
                            return 39;
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
    KONOHA_SHOUFUU("konoha-shoufuu.jpg", R.string.konoha_shoufuu, R.string.konoha_shoufuu_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 4;
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
                            return 29;
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
                            return 39;
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
    TAIHOU_SENTOU("soco_canhao.jpg", R.string.taihou_sentou, R.string.taihou_sentou_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 4;
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
                            return 30;
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
                            return 40;
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
    RAIKEN("Raiken.jpg", R.string.raiken, R.string.raiken_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 4;
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
                            return 30;
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
                            return 40;
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
    RAIGA_BOMU("raiga-bomu.jpg", R.string.raiga_bomu, R.string.raiga_bomu_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 4;
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
                            return 31;
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
                            return 41;
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
    AOI_SHOUGEKI("ao-shougeki.jpg", R.string.aoi_shougeki, R.string.aoi_shougeki_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 4;
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
                            return 32;
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
                            return 42;
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
    TATSUMAKI_KYAKU("chute_tornado.jpg", R.string.tatsumaki_kyaku, R.string.tatsumaki_kyaku_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 4;
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
    SENSEI_RAIGA_BOMU("Raiga_Bomu.gif", R.string.sensei_raiga_bomu, R.string.sensei_raiga_bomu_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 4;
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
                            return 33;
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
                            return 44;
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

    KONGOURIKI("kongouriki.jpg", R.string.kongouriki, R.string.kongouriki_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 5;
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
    M_PANCHI("1000m-panchi.jpg", R.string.panchi, R.string.panchi_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 5;
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
    DABURU_RARIATTO("daburu-rariatto.jpg", R.string.daburu_rariatto, R.string.daburu_rariatto_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 5;
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
    JIGOKUZUKI("jigokuzuki.jpg", R.string.jigokuzuki, R.string.jigokuzuki_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 5;
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
    KONOHA_NEPPUU("konoha-neppuu.jpg", R.string.konoha_neppuu, R.string.konoha_neppuu_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 5;
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
    KONOHA_DAI_SENPUU("konoha_dai_senkou.jpg", R.string.konoha_dai_senpuu, R.string.konoha_dai_senpuu_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 5;
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
    SOLDIER_PILL_I("pilula_soldado.jpg", R.string.soldier_pill_i, R.string.soldier_pill_i_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 5;
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
                            return 48;
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
    SEINSHUN_BURUPAPUA("seinshun_burupapua.jpg", R.string.seinshun_burupapua, R.string.seinshun_burupapua_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 5;
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
    SOLDIER_PILL_II("pilula_soldado.jpg", R.string.soldier_pill_ii, R.string.soldier_pill_ii_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 5;
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
                            return 48;
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
    SHICHIKENBU("shichikenbu.jpg", R.string.shichikenbu, R.string.shichikenbu_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 5;
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
                            return 37;
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
                            return 49;
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
    YONHON_NUKITE("yonhon-nukite.jpg", R.string.yonhon_nukite, R.string.yonhon_nukite_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 5;
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
                            return 37;
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
                            return 49;
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
    CHOUHARITE("chouharite.jpg", R.string.chouharite, R.string.chouharite_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 5;
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
                            return 37;
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
                            return 49;
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
    KANADZUCHI_DAGEKI("kanadzuchi_dageki.jpg", R.string.kanadzuchi_dageki, R.string.kanadzuchi_dageki_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 5;
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
                            return 38;
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
                            return 50;
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
    SANBON_NUKITE("sanbon-nukite.jpg", R.string.sanbon_nukite, R.string.sanbon_nukite_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 5;
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
                            return 38;
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
                            return 51;
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
    KONOHA_RYUUJIN("konoha-ryuujin.jpg", R.string.konoha_ryuujin, R.string.konoha_ryuujin_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 5;
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
    MYU_SENPUU("myu_senpuu.jpg", R.string.myu_senpuu, R.string.myu_senpuu_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 5;
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
    SENSEI_SHICHIKENBU("Shichikenbu.gif", R.string.sensei_shichikenbu, R.string.sensei_shichikenbu_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 5;
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

    IPPON_NUKITE("ippon-nukite.jpg", R.string.ippon_nukite, R.string.ippon_nukite_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 6;
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
                            return 41;
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
                            return 55;
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
    SENSEI_MYU_SENPUU("Myu_Senpuu.gif", R.string.sensei_myu_senpuu, R.string.sensei_myu_senpuu_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 6;
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
                            return 44;
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
                            return 58;
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
    SOUFUUSHASAN_NO_TACHI("soufuushasan-no-tachi.jpg", R.string.soufuushasan_no_tachi, R.string.soufuushasan_no_tachi_desc,
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

    SOUSHURIKEN_NO_JUTSU("sou_shuriken.jpg", R.string.soushuriken_no_jutsu, R.string.soushuriken_no_jutsu_desc,
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
                            return CharOn.character.getAttributes().getBukijutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Bukijutsu");
                        }
                    }
            )),
    SOUSHUUJIN_II("Soushuujin.jpg", R.string.soushuujin_ii, R.string.soushuujin_ii_desc,
            Jutsu.Type.DEBUFF,
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
                            return CharOn.character.getAttributes().getBukijutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Bukijutsu");
                        }
                    }
            )),
    SOUSHUUJIN_I("Soushuujin.jpg", R.string.soushuujin_i, R.string.soushuujin_i_desc,
            Jutsu.Type.DEBUFF,
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
                            return CharOn.character.getAttributes().getBukijutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Bukijutsu");
                        }
                    }
            )),
    RENSHA("rensha.jpg", R.string.rensha, R.string.rensha_desc,
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
                            return CharOn.character.getAttributes().getBukijutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Bukijutsu");
                        }
                    }
            )),
    JOURO_SENBON("Jouro-Senbon.jpg", R.string.jouro_senbon, R.string.jouro_senbon_desc,
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
                            return CharOn.character.getAttributes().getBukijutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Bukijutsu");
                        }
                    }
            )),
    SHIKOMISHINDAN("Shikomishindan.jpg", R.string.shikomishindan, R.string.shikomishindan_desc,
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
                            return CharOn.character.getAttributes().getBukijutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Bukijutsu");
                        }
                    }
            )),
    GENEI_TAJUU_SHURIKEN("Genei-Tajuu-Shuriken.jpg", R.string.genei_tajuu_shuriken, R.string.genei_tajuu_shuriken_desc,
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
                                    value(folded), "Bukijutsu");
                        }
                    }
            )),
    HIJUTSU_ISHIBARI_I("Hijutsu-Ishibari.jpg", R.string.hijutsu_ishibari_i, R.string.hijutsu_ishibari_i_desc,
            Jutsu.Type.DEBUFF,
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
                            return CharOn.character.getAttributes().getBukijutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Bukijutsu");
                        }
                    }
            )),
    HIJUTSU_ISHIBARI_II("Hijutsu-Ishibari.jpg", R.string.hijutsu_ishibari_ii, R.string.hijutsu_ishibari_ii_desc,
            Jutsu.Type.DEBUFF,
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
                            return CharOn.character.getAttributes().getBukijutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Bukijutsu");
                        }
                    }
            )),
    SENSEI_SOUSHURIKEN_NO_JUTSU("Soushuriken_no_Jutsu.gif", R.string.sensei_soushuriken_no_jutsu, R.string.sensei_soushuriken_no_jutsu_desc,
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
                            return CharOn.character.getAttributes().getBukijutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Bukijutsu");
                        }
                    }
            )),

    SHIKOMI_KUGUTSU_SHINSHIN_HAPPA("Shikomi-Kugutsu-Shinshin-Happa.jpg", R.string.shikomi_kugutsu_shinshin_happa, R.string.shikomi_kugutsu_shinshin_happa_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 2;
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
    NADESHIKORYUU_SHINKU_ENBU("Nadeshiko-Ryuu-Shinku-Enbu.jpg", R.string.nadeshikoryuu_shinku_enbu, R.string.nadeshikoryuu_shinku_enbu_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 2;
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
    SAMEDARE_KEKKA("Samedare-Kekka.jpg", R.string.samedare_kekka, R.string.samedare_kekka_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 2;
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
    KAWARA_SHURIKEN("Kawara-Shuriken.jpg", R.string.kawara_shuriken, R.string.kawara_shuriken_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 2;
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
    RAIKOU_KENKA_I("Raikou-Kenka.jpg", R.string.raikou_kenka_i, R.string.raikou_kenka_i_desc,
            Jutsu.Type.DEBUFF,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 2;
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
    RAIKOU_KENKA_II("Raikou-Kenka.jpg", R.string.raikou_kenka_ii, R.string.raikou_kenka_ii_desc,
            Jutsu.Type.DEBUFF,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 2;
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
    AKAHIGI_KIKI_SANKAKU("Akahigi-Kiki-Sankaku.jpg", R.string.akahigi_kiki_sankaku, R.string.akahigi_kiki_sankaku_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 2;
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
                            return 19;
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
    KUMO_SENKYUU_SUZAKU("Kumo-Senkyuu-Suzaku.jpg", R.string.kumo_senkyuu_suzaku, R.string.kumo_senkyuu_suzaku_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 2;
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
    SOUSHUUGA("Soushuuga.jpg", R.string.soushuuga, R.string.soushuuga_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 2;
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
    HADAN("Hadan.jpg", R.string.hadan, R.string.hadan_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 2;
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
                            return 22;
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
    SENSEI_SOUSHUUGA("Soushuuga.gif", R.string.sensei_soushuuga, R.string.sensei_soushuuga_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 2;
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

    SAKURA_FUBUKI_NO_JUTSU("Sakura-Fubuki-no-Jutsu.jpg", R.string.sakura_fubuki_no_jutsu, R.string.sakura_fubuki_no_jutsu_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 3;
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
    KUGUTSU_NO_JUTSU_GISHU_SENBON("Kugutsu-no-Jutsu-Gishu-Senbon.jpg", R.string.kugutsu_no_jutsu_gishu_senbon, R.string.kugutsu_no_jutsu_gishu_senbon_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 3;
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
                            return CharOn.character.getAttributes().getBukijutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Bukijutsu");
                        }
                    }
            )),
    KUGUTSU_SAKURA_NO_MAI("Kugutsu-Sakura-no-Mai.jpg", R.string.kugutsu_sakura_no_mai, R.string.kugutsu_sakura_no_mai_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 3;
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
                            return CharOn.character.getAttributes().getBukijutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Bukijutsu");
                        }
                    }
            )),
    SETSUNA("Setsuna.jpg", R.string.setsuna, R.string.setsuna_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 3;
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
                            return CharOn.character.getAttributes().getBukijutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Bukijutsu");
                        }
                    }
            )),
    SENMOUFUU("Senmoufuu.jpg", R.string.senmoufuu, R.string.senmoufuu_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 3;
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
                            return CharOn.character.getAttributes().getBukijutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Bukijutsu");
                        }
                    }
            )),
    TAKIGAKURERYUU_MIZUKIRI_NO_YAIBA("Takigakure-Ryuu-Mizukiri-no-Yaiba.jpg", R.string.takigakureryuu_mizukiri_no_yaiba, R.string.takigakureryuu_mizukiri_no_yaiba_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 3;
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
                            return CharOn.character.getAttributes().getBukijutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Bukijutsu");
                        }
                    }
            )),
    SHINKUUKEN("Shinkuuken.jpg", R.string.shinkuuken, R.string.shinkuuken_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 3;
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
                            return CharOn.character.getAttributes().getBukijutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Bukijutsu");
                        }
                    }
            )),
    RAISOU_IKAZUCHI_NO_UTAGE("Raisou-Ikazuchi-no-Utage.jpg", R.string.raisou_ikazuchi_no_utage, R.string.raisou_ikazuchi_no_utage_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 3;
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
                            return CharOn.character.getAttributes().getBukijutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Bukijutsu");
                        }
                    }
            )),
    KONOHARYUU_YANAGI_II("Konoha-Ryuu-Yanagi.jpg", R.string.konoharyuu_yanagi_ii, R.string.konoharyuu_yanagi_ii_desc,
            Jutsu.Type.DEBUFF,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 3;
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
                            return 28;
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
    KONOHARYUU_YANAGI_I("Konoha-Ryuu-Yanagi.jpg", R.string.konoharyuu_yanagi_i, R.string.konoharyuu_yanagi_i_desc,
            Jutsu.Type.DEBUFF,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 3;
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
                            return 28;
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
    KAMAITACHI_NO_JUTSU("Kamaitachi-no-Jutsu.jpg", R.string.kamaitachi_no_jutsu, R.string.kamaitachi_no_jutsu_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 3;
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
                            return CharOn.character.getAttributes().getBukijutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Bukijutsu");
                        }
                    }
            )),
    KAKEAMI("Kakeami.jpg", R.string.kakeami, R.string.kakeami_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 3;
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
                            return CharOn.character.getAttributes().getBukijutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Bukijutsu");
                        }
                    }
            )),
    KUMORYUU_URAGIRI("Kumo-Ryuu-Uragiri.jpg", R.string.kumoryuu_uragiri, R.string.kumoryuu_uragiri_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 3;
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
                            return CharOn.character.getAttributes().getBukijutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Bukijutsu");
                        }
                    }
            )),
    SUISHOU_TOU("Suishou-Tou.jpg", R.string.suishou_tou, R.string.suishou_tou_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 3;
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
                            return 23;
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
                            return 31;
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
    KUSARIGAMA_NO_JUTSU("Kusarigama-no-jutsu.jpg", R.string.kusarigama_no_jutsu, R.string.kusarigama_no_jutsu_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 3;
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
                            return 23;
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
                            return 31;
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
    RAIKYUU("Raikyuu.jpg", R.string.raikyuu, R.string.raikyuu_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 3;
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
                            return 24;
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
                            return 32;
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
    KUMORYUU_MIKAZUKIGIRI("Kumo-Ryuu-Mikazukigiri.jpg", R.string.kumoryuu_mikazukigiri, R.string.kumoryuu_mikazukigiri_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 3;
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
                            return 24;
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
                            return 32;
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
    SENSEI_KUMORYUU_MIKAZUKIGIRI("Kumo-Ryuu_Mikazukigiri.gif", R.string.sensei_kumoryuu_mikazukigiri, R.string.sensei_kumoryuu_mikazukigiri_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 3;
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
                            return 26;
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
                            return 34;
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

    KUROHIGI_KIKI_IPPATSU("Kurohigi-Kiki-Ippatsu.jpg", R.string.kurohigi_kiki_ippatsu, R.string.kurohigi_kiki_ippatsu_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 4;
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
                            return CharOn.character.getAttributes().getBukijutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Bukijutsu");
                        }
                    }
            )),
    KUROHIGI_KIKI_NIHATSU("Kurohigi-Kiki-Nihatsu.jpg", R.string.kurohigi_kiki_nihatsu, R.string.kurohigi_kiki_nihatsu_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 4;
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
                            return CharOn.character.getAttributes().getBukijutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Bukijutsu");
                        }
                    }
            )),
    IKAZUCHI_NO_KIBA("Ikazuchi-no-Kiba.jpg", R.string.ikazuchi_no_kiba, R.string.ikazuchi_no_kiba_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 4;
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
                            return CharOn.character.getAttributes().getBukijutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Bukijutsu");
                        }
                    }
            )),
    REIJINGU_SANDAA("Reijingu-Sandaa.jpg", R.string.reijingu_sandaa, R.string.reijingu_sandaa_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 4;
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
                            return CharOn.character.getAttributes().getBukijutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Bukijutsu");
                        }
                    }
            )),
    KUMORYUU_KAENGIRI("Kumo-Ryuu-Kaengiri.jpg", R.string.kumoryuu_kaengiri, R.string.kumoryuu_kaengiri_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 4;
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
                            return CharOn.character.getAttributes().getBukijutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Bukijutsu");
                        }
                    }
            )),
    MUGEN_KOUGAI_II("Mugen-Kougai.jpg", R.string.mugen_kougai_ii, R.string.mugen_kougai_ii_desc,
            Jutsu.Type.DEBUFF,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 4;
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
                            return 38;
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
    MUGEN_KOUGAI_I("Mugen-Kougai.jpg", R.string.mugen_kougai_i, R.string.mugen_kougai_i_desc,
            Jutsu.Type.DEBUFF,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 4;
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
                            return 38;
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
    KUROHIGI_KIKI_SANPATSU("Kurohigi-Kiki-Sanpatsu.jpg", R.string.kurohigi_kiki_sanpatsu, R.string.kurohigi_kiki_sanpatsu_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 4;
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
                            return 29;
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
                            return 39;
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
    AKAHIGI_KAENHOUSHAKI("Akahigi-Kaenhoushaki.jpg", R.string.akahigi_kaenhoushaki, R.string.akahigi_kaenhoushaki_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 4;
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
                            return 29;
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
                            return 39;
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
    DOKUKIRI_JIGOKU_BARIBARI_HYAKU_RENPATSU("Dokukiri-Jigoku-Baribari-Hyaku-Renpatsu.jpg", R.string.dokukiri_jigoku_baribari_hyaku_renpatsu, R.string.dokukiri_jigoku_baribari_hyaku_renpatsu_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 4;
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
                            return 29;
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
                            return 39;
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
    KONGOU_ROUHEKI("Kongou-Rouheki.jpg", R.string.kongou_rouheki, R.string.kongou_rouheki_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 4;
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
                            return 30;
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
                            return 40;
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
    SOUNINSHUU("Souninshuu.jpg", R.string.souninshuu, R.string.souninshuu_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 4;
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
                            return 30;
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
                            return 40;
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
    SHURIKEN_SHINKUUJIN("Shuriken-Shinkuujin.jpg", R.string.shuriken_shinkuujin, R.string.shuriken_shinkuujin_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 4;
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
                            return 31;
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
                            return 41;
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
    KIBAKU_FUDA_NO_JUTSU("Kibaku-Fuda-no-Jutsu.jpg", R.string.kibaku_fuda_no_jutsu, R.string.kibaku_fuda_no_jutsu_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 4;
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
                            return 31;
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
                            return 41;
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
    GUNBAI_KAZE_AEKOUSHA("Gunbai-Kaze-Aekousha.jpg", R.string.gunbai_kaze_aekousha, R.string.gunbai_kaze_aekousha_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 4;
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
                            return 32;
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
                            return 42;
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
    SENSEI_AKAHIGI_KAENHOUSHAKI("Akahigi_Kaenhoushaki.gif", R.string.sensei_akahigi_kaenhoushaki, R.string.sensei_akahigi_kaenhoushaki_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 4;
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
                            return 33;
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
                            return 44;
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

    KUMORYUU_OMOTEGIRI("Kumo-Ryuu-Omotegiri.jpg", R.string.kumoryuu_omotegiri, R.string.kumoryuu_omotegiri_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 5;
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
                            return CharOn.character.getAttributes().getBukijutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Bukijutsu");
                        }
                    }
            )),
    OOKAKEAMI("Ookakeami.jpg", R.string.ookakeami, R.string.ookakeami_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 5;
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
                            return CharOn.character.getAttributes().getBukijutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Bukijutsu");
                        }
                    }
            )),
    CHOU_BIBURAATO_RAITONTOU("Chou-Biburaato-Raitontou.jpg", R.string.chou_biburaato_raitontou, R.string.chou_biburaato_raitontou_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 5;
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
                            return CharOn.character.getAttributes().getBukijutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Bukijutsu");
                        }
                    }
            )),
    KUNAI_SHINKUUJIN("Kunai-Shinkuujin.jpg", R.string.kunai_shinkuujin, R.string.kunai_shinkuujin_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 5;
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
                            return CharOn.character.getAttributes().getBukijutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Bukijutsu");
                        }
                    }
            )),
    IAIGIRI("Iaigiri.jpg", R.string.iaigiri, R.string.iaigiri_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 5;
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
                            return CharOn.character.getAttributes().getBukijutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Bukijutsu");
                        }
                    }
            )),
    HOUSENKA_TSUMABENI("Housenka-Tsumabeni.jpg", R.string.housenka_tsumabeni, R.string.housenka_tsumabeni_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 5;
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
                            return CharOn.character.getAttributes().getBukijutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Bukijutsu");
                        }
                    }
            )),
    UCHIHAGAESHI("uchihagaeshi.jpg", R.string.uchihagaeshi, R.string.uchihagaeshi_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 5;
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
                            return CharOn.character.getAttributes().getBukijutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Bukijutsu");
                        }
                    }
            )),
    NANATSU_BUTOUKAI_KEN_II("Nanatsu-Butoukai-Ken.jpg", R.string.nanatsu_butoukai_ken_ii, R.string.nanatsu_butoukai_ken_ii_desc,
            Jutsu.Type.DEBUFF,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 5;
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
                            return 48;
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
    NANATSU_BUTOUKAI_KEN_I("Nanatsu-Butoukai-Ken.jpg", R.string.nanatsu_butoukai_ken_i, R.string.nanatsu_butoukai_ken_i_desc,
            Jutsu.Type.DEBUFF,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 5;
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
                            return 48;
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
    CHIYU_KETSUEKI("Chiyu-Ketsueki.jpg", R.string.chiyu_ketsueki, R.string.chiyu_ketsueki_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 5;
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
                            return 37;
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
                            return 49;
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
    TSUIRAKU_KABUTO("Tsuiraku-Kabuto.jpg", R.string.tsuiraku_kabuto, R.string.tsuiraku_kabuto_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 5;
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
                            return CharOn.character.getAttributes().getBukijutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Bukijutsu");
                        }
                    }
            )),
    SANDAAGEETO("Raiton-Sandaageeto.jpg", R.string.sandaageeto, R.string.sandaageeto_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 5;
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
                            return 37;
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
                            return 49;
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
    BAKUTOU_JUTSU_HAPPA_ROKUJUUSHI("Bakutou-Jutsu-Happa-Rokujuushi.jpg", R.string.bakutou_jutsu_happa_rokujuushi, R.string.bakutou_jutsu_happa_rokujuushi_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 5;
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
                            return 39;
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
                            return 50;
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
    KAIHOU("Kaihou.jpg", R.string.kaihou, R.string.kaihou_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 5;
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
                            return 38;
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
                            return 51;
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
    CHOUTOU_NINPOU_JIGUMO_NUI("Choutou-Ninpou-Jigumo-Nui.jpg", R.string.choutou_ninpou_jigumo_nui, R.string.choutou_ninpou_jigumo_nui_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 5;
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
                            return 38;
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
                            return 51;
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
    CHAKURAHIRU_WANIZAME("Chakurahiru-Wanizame.jpg", R.string.chakurahiru_wanizame, R.string.chakurahiru_wanizame_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 5;
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
                            return 39;
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
                            return 52;
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
    SENSEI_CHOU_BIBURAATO_RAITONTOU("Chou_Biburaato_Raitontou.gif", R.string.sensei_chou_biburaato_raitontou, R.string.sensei_chou_biburaato_raitontou_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 5;
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
                            return 41;
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
                            return 54;
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

    BAKUHATSUTEKI_IAIKAI("Bakuhatsuteki-Iaikai.jpg", R.string.bakuhatsuteki_iaikai, R.string.bakuhatsuteki_iaikai_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 6;
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
                            return 41;
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
                            return 55;
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
    SENSEI_KAIHOU("Kaihou.gif", R.string.sensei_kaihou, R.string.sensei_kaihou_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 6;
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
                            return 44;
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
                            return 58;
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
    HENGE_NO_JUTSU("transformacao.jpg", R.string.henge_no_jutsu, R.string.henge_no_jutsu_desc,
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

    BUNSHIN_NO_JUTSU_I("bunshin_no_jutsu.jpg", R.string.bunshin_no_jutsu_i, R.string.bunshin_no_jutsu_i_desc,
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
    BUNSHIN_NO_JUTSU_II("bunshin_no_jutsu.jpg", R.string.bunshin_no_jutsu_ii, R.string.bunshin_no_jutsu_ii_desc,
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
                            return CharOn.character.getAttributes().getNinjutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Ninjutsu");
                        }
                    }
            )),
    NINPOU_MUSHOU_DE_HITEI("mushou_de_hitei.jpg", R.string.ninpou_mushou_de_hitei, R.string.ninpou_mushou_de_hitei_desc,
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
    KAGE_SHURIKEN_NO_JUTSU("kage_shuriken_no_jutsu.jpg", R.string.kage_shuriken_no_jutsu, R.string.kage_shuriken_no_jutsu_desc,
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
    KAKUREMINO_NO_JUTSU("kakuremino_no_jutsu.jpg", R.string.kakuremino_no_jutsu, R.string.kakuremino_no_jutsu_desc,
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
    KAWARIMI_NO_JUTSU("substituicao.jpg", R.string.kawarimi_no_jutsu, R.string.kawarimi_no_jutsu_desc,
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
    KAGE_BUNSHIN_NO_JUTSU_I("clones.jpg", R.string.kage_bunshin_no_jutsu_i, R.string.kage_bunshin_no_jutsu_i_desc,
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
                            return CharOn.character.getAttributes().getNinjutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Ninjutsu");
                        }
                    }
            )),
    KAGE_BUNSHIN_NO_JUTSU_II("clones.jpg", R.string.kage_bunshin_no_jutsu_ii, R.string.kage_bunshin_no_jutsu_ii_desc,
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
                            return CharOn.character.getAttributes().getNinjutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Ninjutsu");
                        }
                    }
            )),
    SENSEI_KAGE_BUNSHIN_NO_JUTSU("Kage-Bunshin-no-Jutsu.gif", R.string.sensei_kage_bunshin_no_jutsu, R.string.sensei_kage_bunshin_no_jutsu_desc,
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

    RASENGAN("rasengan.jpg", R.string.rasengan, R.string.rasengan_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 2;
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
    KURO_TATSUMAKI("kuro-tatsumaki.jpg", R.string.kuro_tatsumaki, R.string.kuro_tatsumaki_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 2;
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
    MEISAI_GAKURE_NO_JUTSU_I("touton-no-jutsu.jpg", R.string.meisai_gakure_no_jutsu_i, R.string.meisai_gakure_no_jutsu_i_desc,
            Jutsu.Type.BUFF,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 2;
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
    MEISAI_GAKURE_NO_JUTSU_II("touton-no-jutsu.jpg", R.string.meisai_gakure_no_jutsu_ii, R.string.meisai_gakure_no_jutsu_ii_desc,
            Jutsu.Type.BUFF,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 2;
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
    TAJUU_TAKI_RASENGAN("tajuu_taki_rasengan.jpg", R.string.tajuu_taki_rasengan, R.string.tajuu_taki_rasengan_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 2;
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
    BUNSHIN_BAKURETSU("bushin-bakuretsu.jpg", R.string.bunshin_bakuretsu, R.string.bunshin_bakuretsu_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 2;
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
    SENSEI_RASENGAN("Rasengan.gif", R.string.sensei_rasengan, R.string.sensei_rasengan_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 2;
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

    MIKAZUKI_NO_MAI("Mikazuki-no-Mai.jpg", R.string.mikazuki_no_mai, R.string.mikazuki_no_mai_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 3;
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
                            return 19;
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
                            return 25;
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
                            return 3;
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
                            return 21;
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
                            return 28;
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
    AYATSUITO_NO_JUTSU_I("Ayatsuito-no-Jutsu.jpg", R.string.ayatsuito_no_jutsu_i, R.string.ayatsuito_no_jutsu_i_desc,
            Jutsu.Type.BUFF,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 3;
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
                            return 28;
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
    AYATSUITO_NO_JUTSU_II("Ayatsuito-no-Jutsu.jpg", R.string.ayatsuito_no_jutsu_ii, R.string.ayatsuito_no_jutsu_ii_desc,
            Jutsu.Type.BUFF,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 3;
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
                            return 28;
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
                            return 3;
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
                            return 23;
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
                            return 30;
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
    GOKAN_SAKUSOU("Gokan-Sakusou.jpg", R.string.gokan_sakusou, R.string.gokan_sakusou_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 3;
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
                            return 24;
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
                            return 32;
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
    SHIHOUHAPPOU_SHURIKEN("Shihouhappou-Shuriken.jpg", R.string.shihouhappou_shuriken, R.string.shihouhappou_shuriken_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 3;
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
                            return 24;
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
                            return 32;
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
    SENSEI_MIKAZUKI_NO_MAI("Mikazuki-no-Mai.gif", R.string.sensei_mikazuki_no_mai, R.string.sensei_mikazuki_no_mai_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 3;
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
                            return 26;
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
                            return 34;
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

    RANJI_SHIGUMI_NO_JUTSU("Ranji-Shigumi.jpg", R.string.ranji_shigumi_no_jutsu, R.string.ranji_shigumi_no_jutsu_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 4;
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
    TAJUU_KAGE_BUNSHIN_NO_JUTSU_I("tajuu-kage-bunshin.jpg", R.string.tajuu_kage_bunshin_no_jutsu_i, R.string.tajuu_kage_bunshin_no_jutsu_i_desc,
            Jutsu.Type.BUFF,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 4;
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
                            return 38;
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
    KAKUAN_NITTEN_SUISHU("Kakuan-Nitten-Suishu.jpg", R.string.kakuan_nitten_suishu, R.string.kakuan_nitten_suishu_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 4;
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
    TAJUU_KAGE_BUNSHIN_NO_JUTSU_II("tajuu-kage-bunshin.jpg", R.string.tajuu_kage_bunshin_no_jutsu_ii, R.string.tajuu_kage_bunshin_no_jutsu_ii_desc,
            Jutsu.Type.BUFF,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 4;
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
                            return 38;
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
    CHOU_OODAMA_RASENGAN("oodama_rasengan.jpg", R.string.chou_oodama_rasengan, R.string.chou_oodama_rasengan_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 4;
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
                            return 30;
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
                            return 40;
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
    MINIRASENSHURIKEN("mini-rasenshuriken.jpg", R.string.minirasenshuriken, R.string.minirasenshuriken_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 4;
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
    NINPOU_GYORAISHIN("Gyoraishin.jpg", R.string.ninpou_gyoraishin, R.string.ninpou_gyoraishin_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 4;
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
    SENSEI_CHOU_OODAMA_RASENGAN("Chou-Oodama-Rasengan.gif", R.string.sensei_chou_oodama_rasengan, R.string.sensei_chou_oodama_rasengan_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 4;
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
                            return 33;
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
                            return 44;
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
                            return 5;
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
                            return 34;
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
                            return 45;
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
    CHOU_OODAMA_RASEN_TARENGAN("chou-oodama-rasen-tarengan.jpg", R.string.chou_oodama_rasen_tarengan, R.string.chou_oodama_rasen_tarengan_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 5;
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
                            return 34;
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
                            return 45;
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
    REIKA_NO_JUTSU("Reika-Jutsu.jpg", R.string.reika_no_jutsu, R.string.reika_no_jutsu_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 5;
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
                            return 36;
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
                            return 48;
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
    HIRAISHIN_NO_JUTSU_I("Hiraishin no Jutsu.jpg", R.string.hiraishin_no_jutsu_i, R.string.hiraishin_no_jutsu_i_desc,
            Jutsu.Type.BUFF,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 5;
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
                            return 48;
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
    RASENKYUUGAN("rasenkyuugan.jpg", R.string.rasenkyuugan, R.string.rasenkyuugan_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 5;
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
                            return 36;
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
                            return 48;
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
    HIRAISHIN_NO_JUTSU_II("Hiraishin no Jutsu.jpg", R.string.hiraishin_no_jutsu_ii, R.string.hiraishin_no_jutsu_ii_desc,
            Jutsu.Type.BUFF,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 5;
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
                            return 48;
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
    WAKUSEI_RASENGAN("wakusei-rasengan.jpg", R.string.wakusei_rasengan, R.string.wakusei_rasengan_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 5;
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
                            return 38;
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
                            return 50;
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
    OYAKO_RASENGAN("oyako.jpg", R.string.oyako_rasengan, R.string.oyako_rasengan_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 5;
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
                            return 39;
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
                            return 52;
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
    SENSEI_HIRAISHIN_NO_JUTSU("Hiraishin-no-Jutsu.gif", R.string.sensei_hiraishin_no_jutsu, R.string.sensei_hiraishin_no_jutsu_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 5;
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
                            return 41;
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
                            return 54;
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

    SENSEI_OYAKO_RASENGAN("Oyako-Rasengan.gif", R.string.sensei_oyako_rasengan, R.string.sensei_oyako_rasengan_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 6;
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
                            return 44;
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
                            return 58;
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
    KISHIBARI_NO_JUTSU("Kishibari_no_Jutsu.jpg", R.string.kishibari_no_jutsu, R.string.kishibari_no_jutsu_desc,
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
                                    value(folded), "Genjutsu");
                        }
                    }
            )),

    NEMURI_I("nerumi.jpg", R.string.nemuri_i, R.string.nemuri_i_desc,
            Jutsu.Type.DEBUFF,
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
                            return CharOn.character.getAttributes().getGenjutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Genjutsu");
                        }
                    }
            )),
    KASUMI_JUUHA_NO_JUTSU("Kasumi_Juuha_no_Jutsu.jpg", R.string.kasumi_juuha_no_jutsu, R.string.kasumi_juuha_no_jutsu_desc,
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
                            return CharOn.character.getAttributes().getGenjutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Genjutsu");
                        }
                    }
            )),
    NEMURI_II("nerumi.jpg", R.string.nemuri_ii, R.string.nemuri_ii_desc,
            Jutsu.Type.DEBUFF,
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
                            return CharOn.character.getAttributes().getGenjutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Genjutsu");
                        }
                    }
            )),
    KOKOROYORU_NO_JUTSU("Kokoroyoru_no_jutsu.jpg", R.string.kokoroyoru_no_jutsu, R.string.kokoroyoru_no_jutsu_desc,
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
                                    value(folded), "Genjutsu");
                        }
                    }
            )),
    TAZUNERU_NO_JUTSU("Tazuneru_no_Jutsu.jpg", R.string.tazuneru_no_jutsu, R.string.tazuneru_no_jutsu_desc,
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
    BAKUON_NO_JUTSU("Bakuon_no_Jutsu.jpg", R.string.bakuon_no_jutsu, R.string.bakuon_no_jutsu_desc,
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
    UTSUSEMI_NO_JUTSU("Utsusemi_no_Jutsu.jpg", R.string.utsusemi_no_jutsu, R.string.utsusemi_no_jutsu_desc,
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
    HANA_KYOUKA_SAI_I("Hana_Kyouka_Sai.jpg", R.string.hana_kyouka_sai_i, R.string.hana_kyouka_sai_i_desc,
            Jutsu.Type.DEBUFF,
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
                            return CharOn.character.getAttributes().getGenjutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Genjutsu");
                        }
                    }
            )),
    HANA_KYOUKA_SAI_II("Hana_Kyouka_Sai.jpg", R.string.hana_kyouka_sai_ii, R.string.hana_kyouka_sai_ii_desc,
            Jutsu.Type.DEBUFF,
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
                            return CharOn.character.getAttributes().getGenjutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Genjutsu");
                        }
                    }
            )),
    SENSEI_HANA_KYOUKA_SAI("Hana-Kyouka-Sai.gif", R.string.sensei_hana_kyouka_sai, R.string.sensei_hana_kyouka_sai_desc,
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

    NINPOU_HYAKKA_RYORAN("ninpou_hyakka_ryoran.jpg", R.string.ninpou_hyakka_ryoran, R.string.ninpou_hyakka_ryoran_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 2;
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
    KORI_SHINCHUU_NO_JUTSU("kori_shinchuu.jpg", R.string.kori_shinchuu_no_jutsu, R.string.kori_shinchuu_no_jutsu_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 2;
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
    MAGEN_NARAKUMI_NO_JUTSU_I("magen_narakumi.jpg", R.string.magen_narakumi_no_jutsu_i, R.string.magen_narakumi_no_jutsu_i_desc,
            Jutsu.Type.DEBUFF,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 2;
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
    MAGEN_NARAKUMI_NO_JUTSU_II("magen_narakumi.jpg", R.string.magen_narakumi_no_jutsu_ii, R.string.magen_narakumi_no_jutsu_ii_desc,
            Jutsu.Type.DEBUFF,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 2;
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
    OTO_NO_GEN("oto_no_gen.jpg", R.string.oto_no_gen, R.string.oto_no_gen_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 2;
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
    KOKOHI_NO_JUTSU("kokohi.jpg", R.string.kokohi_no_jutsu, R.string.kokohi_no_jutsu_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 2;
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
    SENSEI_OTO_NO_GEN("Oto-no-Gen.gif", R.string.sensei_oto_no_gen, R.string.sensei_oto_no_gen_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 2;
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
            )),

    AN_NO_GENJUTSU("an_no_genjutsu.jpg", R.string.an_no_genjutsu, R.string.an_no_genjutsu_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 3;
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
                            return 19;
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
                            return 25;
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
    KARASU_NO_GENJUTSU("karasu-genjutsu.png", R.string.karasu_no_genjutsu, R.string.karasu_no_genjutsu_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 3;
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
                            return 21;
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
                            return 28;
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
    MAGEN_KOKUNI_ARAZU_NO_JUTSU_I("magen_kokuni_arazu_no_jutsu.jpg", R.string.magen_kokuni_arazu_no_jutsu_i, R.string.magen_kokuni_arazu_no_jutsu_i_desc,
            Jutsu.Type.DEBUFF,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 3;
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
                            return 28;
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
    MAGEN_KOKUNI_ARAZU_NO_JUTSU_II("magen_kokuni_arazu_no_jutsu.jpg", R.string.magen_kokuni_arazu_no_jutsu_ii, R.string.magen_kokuni_arazu_no_jutsu_ii_desc,
            Jutsu.Type.DEBUFF,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 3;
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
                            return 28;
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
    NEHAN_SHOUJA_NO_JUTSU("nehan_shouja.jpg", R.string.nehan_shouja_no_jutsu, R.string.nehan_shouja_no_jutsu_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 3;
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
                            return CharOn.character.getAttributes().getGenjutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Genjutsu");
                        }
                    }
            )),
    MATEKI_MUGEN_ONKI("mateki_mugen_onki.jpg", R.string.mateki_mugen_onki, R.string.mateki_mugen_onki_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 3;
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
                            return CharOn.character.getAttributes().getGenjutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Genjutsu");
                        }
                    }
            )),
    HYAKKA_NINPOU_HANACHIRI_NUKO("Hyakka Ninpou_Hanachiri Nuko.jpg", R.string.hyakka_ninpou_hanachiri_nuko, R.string.hyakka_ninpou_hanachiri_nuko_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 3;
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
                            return CharOn.character.getAttributes().getGenjutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Genjutsu");
                        }
                    }
            )),
    SENSEI_KOKOHI_DEBOA("Kokohi-Deboa.gif", R.string.sensei_kokohi_deboa, R.string.sensei_kokohi_deboa_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 3;
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
                            return CharOn.character.getAttributes().getGenjutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Genjutsu");
                        }
                    }
            )),

    YUBI_NO_GENJUTSU("yubi_no_genjutsu.jpg", R.string.yubi_no_genjutsu, R.string.yubi_no_genjutsu_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 4;
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
                            return CharOn.character.getAttributes().getGenjutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Genjutsu");
                        }
                    }
            )),
    GENJUTSU_NO_KIRI_I("genjutsu_no_kiri.jpg", R.string.genjutsu_no_kiri_i, R.string.genjutsu_no_kiri_i_desc,
            Jutsu.Type.DEBUFF,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 4;
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
                            return 38;
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
    RAIGEN_RAIKOUCHUU("raigen-raikouchuu.png", R.string.raigen_raikouchuu, R.string.raigen_raikouchuu_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 4;
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
                            return 29;
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
                            return 38;
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
    GENJUTSU_NO_KIRI_II("genjutsu_no_kiri.jpg", R.string.genjutsu_no_kiri_ii, R.string.genjutsu_no_kiri_ii_desc,
            Jutsu.Type.DEBUFF,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 4;
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
                            return 38;
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
    MAGEN_KASEGUI_NO_JUTSU("magen_kasegui_no_jutsu.jpg", R.string.magen_kasegui_no_jutsu, R.string.magen_kasegui_no_jutsu_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 4;
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
                            return 30;
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
                            return 40;
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
    MUGEN_MAROU("mugen-marou.png", R.string.mugen_marou, R.string.mugen_marou_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 4;
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
                            return CharOn.character.getAttributes().getGenjutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Genjutsu");
                        }
                    }
            )),
    SHINU_NO_GENJUTSU("shinu_no_genjutsu.jpg", R.string.shinu_no_genjutsu, R.string.shinu_no_genjutsu_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 4;
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
                            return CharOn.character.getAttributes().getGenjutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Genjutsu");
                        }
                    }
            )),
    SENSEI_MATEKI_MUGEN_ONKI("Mateki-Mugen-Onki.gif", R.string.sensei_mateki_mugen_onki, R.string.sensei_mateki_mugen_onki_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 4;
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
                            return CharOn.character.getAttributes().getGenjutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Genjutsu");
                        }
                    }
            )),

    MAGEN_GAMARINSHOU("gamarinshou.png", R.string.magen_gamarinshou, R.string.magen_gamarinshou_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 5;
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
                            return CharOn.character.getAttributes().getGenjutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Genjutsu");
                        }
                    }
            )),
    HANA_NINPOU_BAKUHATSU_KEMURI_NO_HANABIRA("Hana Ninpou_Bakuhatsu Kemuri no Hanabira.jpg", R.string.hana_ninpou_bakuhatsu_kemuri_no_hanabira, R.string.hana_ninpou_bakuhatsu_kemuri_no_hanabira_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 5;
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
                            return CharOn.character.getAttributes().getGenjutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Genjutsu");
                        }
                    }
            )),
    GENJUTSU_SHIBARI("gen-shibari.png", R.string.genjutsu_shibari, R.string.genjutsu_shibari_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 5;
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
                            return CharOn.character.getAttributes().getGenjutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Genjutsu");
                        }
                    }
            )),
    UTAKATA_I("utakata.jpg", R.string.utakata_i, R.string.utakata_i_desc,
            Jutsu.Type.DEBUFF,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 5;
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
                            return 48;
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
    KOKOHI_TATAKAI("kokohi-tatakai.png", R.string.kokohi_tatakai, R.string.kokohi_tatakai_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 5;
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
                            return 36;
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
                            return 48;
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
    UTAKATA_II("utakata.jpg", R.string.utakata_ii, R.string.utakata_ii_desc,
            Jutsu.Type.DEBUFF,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 5;
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
                            return 48;
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
    KOBURABIJON_ITO_SASSHIN("sasshin.png", R.string.koburabijon_ito_sasshin, R.string.koburabijon_ito_sasshin_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 5;
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
                            return CharOn.character.getAttributes().getGenjutsu() >= value(folded);
                        }

                        @Override
                        public String toString(Context context, boolean folded) {
                            return context.getString(R.string.requires_points,
                                    value(folded), "Genjutsu");
                        }
                    }
            )),
    SHIRANO("Shirano.jpg", R.string.shirano, R.string.shirano_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 5;
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
                            return 39;
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
                            return 55;
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
    SENSEI_MAGEN_KASEGUI_NO_JUTSU("Magen-Kasegu-no-Jutsu.gif", R.string.sensei_magen_kasegui_no_jutsu, R.string.sensei_magen_kasegui_no_jutsu_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 5;
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
                            return 41;
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
                            return 54;
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

    SENSEI_GENJUTSU_NO_KIRI("Genjutsu-no-Kiri.gif", R.string.sensei_genjutsu_no_kiri, R.string.sensei_genjutsu_no_kiri_desc,
            Jutsu.Type.ATK,
            Arrays.asList(
                    new Requirement() {
                        public int getValue() {
                            return 6;
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
                            return 44;
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
                            return 58;
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
