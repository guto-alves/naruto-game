package com.gutotech.narutogame.data.model;

import android.content.Context;

import com.gutotech.narutogame.R;

import java.util.Arrays;
import java.util.List;

public enum Jutsus {
    DEFESA_MAO("defesa_2_mao", R.string.simple_block, R.string.simple_block_des,
            Classe.NIN, Jutsu.Tipo.DEF,
            null),

    DEFESA_ACROBATICA("defesa_acrobatica", R.string.simple_dodge, R.string.simple_dodge_des,
            Classe.NIN, Jutsu.Tipo.DEF,
            null),

    SOCO("soco", R.string.punch, R.string.punch_des,
            Classe.NIN, Jutsu.Tipo.ATK,
            null),

    CHUTE("chute", R.string.kick, R.string.kick_des,
            Classe.NIN, Jutsu.Tipo.ATK,
            null),

    // TAIJUTSUS
    DYNAMIC_KICK("chute_dinamico", R.string.dynamic_kick, R.string.dynamic_kick_des,
            Classe.TAI, Jutsu.Tipo.ATK,
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
    DYNAMIC_ENTRY("dynamic_entry", R.string.dynamic_entry, R.string.dynamic_entry_des,
            Classe.TAI, Jutsu.Tipo.ATK,
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
    HORENGAN_PILL_I("pilula_verde", R.string.horengan_pill_i, R.string.horengan_pill_i_des,
            Classe.TAI, Jutsu.Tipo.BUFF,
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
    HORENGAN_PILL_II("pilula_verde", R.string.horengan_pill_ii, R.string.horengan_pill_ii_des,
            Classe.TAI, Jutsu.Tipo.BUFF,
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
    HARIITSUBA("agulhas_sopranas", R.string.hariitsuba, R.string.hariitsuba_des,
            Classe.TAI, Jutsu.Tipo.ATK,
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
    KONOHA_FULL_KICK_SOCCER("konoha_full_kick_soccer", R.string.konoha_full_kick_soccer, R.string.konoha_full_kick_soccer_des,
            Classe.TAI, Jutsu.Tipo.ATK,
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
    KONOHA_SENPUU("chute_furacao", R.string.konoha_senpuu, R.string.konoha_senpuu_des,
            Classe.TAI, Jutsu.Tipo.ATK,
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
    GANGEKI("golpe_ombro", R.string.gangeki, R.string.gangeki_des,
            Classe.TAI, Jutsu.Tipo.ATK,
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
    KARENGAN_PILL_I("pilula_amarela", R.string.karengan_pill_i, R.string.karengan_pill_i_des,
            Classe.TAI, Jutsu.Tipo.BUFF,
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
    KARENGAN_PILL_II("pilula_amarela", R.string.karengan_pill_ii, R.string.karengan_pill_ii_des,
            Classe.TAI, Jutsu.Tipo.BUFF,
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
    SENSEI_DYNAMIC_ENTRY("Dynamic_Entry", R.string.sensei_dynamic_entry, R.string.sensei_dynamic_entry_des,
            Classe.TAI, Jutsu.Tipo.ATK,
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


    // BUKIJUTSU
    SOUFUUSHASAN_NO_TACHI("soufuushasan-no-tachi", R.string.soufuushasan_no_tachi, R.string.soufuushasan_no_tachi_des,
            Classe.BUK, Jutsu.Tipo.ATK,
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
    SOUSHURIKEN_NO_JUTSU("sou_shuriken", R.string.soushuriken_no_jutsu, R.string.soushuriken_no_jutsu_des,
            Classe.TAI, Jutsu.Tipo.ATK,
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
    SOUSHUUJIN_I("Soushuujin", R.string.soushuujin_i, R.string.soushuujin_i_des,
            Classe.TAI, Jutsu.Tipo.BUFF,
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
    SOUSHUUJIN_II("Soushuujin", R.string.soushuujin_ii, R.string.soushuujin_ii_des,
            Classe.TAI, Jutsu.Tipo.BUFF,
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
    RENSHA("rensha", R.string.rensha, R.string.rensha_des,
            Classe.TAI, Jutsu.Tipo.ATK,
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
    JOURO_SENBON("Jouro-Senbon", R.string.jouro_senbon, R.string.jouro_senbon_des,
            Classe.TAI, Jutsu.Tipo.ATK,
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
    SHIKOMISHINDAN("Shikomishindan", R.string.shikomishindan, R.string.shikomishindan_des,
            Classe.TAI, Jutsu.Tipo.ATK,
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
    GEN_EI_TAJUU_SHURIKEN("Genei-Tajuu-Shuriken", R.string.gen_ei_tajuu_shuriken, R.string.gen_ei_tajuu_shuriken_des,
            Classe.TAI, Jutsu.Tipo.ATK,
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
    HIJUTSU_ISHIBARI_I("Hijutsu-Ishibari", R.string.hijutsu_ishibari_i, R.string.hijutsu_ishibari_i_des,
            Classe.TAI, Jutsu.Tipo.BUFF,
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
    HIJUTSU_ISHIBARI_II("Hijutsu-Ishibari", R.string.hijutsu_ishibari_ii, R.string.hijutsu_ishibari_ii_des,
            Classe.TAI, Jutsu.Tipo.BUFF,
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
    SENSEI_SOUSHURIKEN_NO_JUTSU("Soushuriken_no_Jutsu", R.string.sensen_soushuriken, R.string.sensei_soushuriken_des,
            Classe.TAI, Jutsu.Tipo.ATK,
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


    // NINJUTSUS
    HENGE_NO_JUTSU("transformacao", R.string.henge_no_jutsu, R.string.henge_no_jutsu_des,
            Classe.NIN, Jutsu.Tipo.ATK,
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
    KONOHA_TZU("konoha_tizu", R.string.konoha_tzu, R.string.konoha_tzu_des,
            Classe.NIN, Jutsu.Tipo.ATK,
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
    BUNSHIN_NO_JUTSU_I("bunshin_no_jutsu", R.string.bunshin_no_jutsu_i, R.string.bunshin_no_jutsu_i_des,
            Classe.NIN, Jutsu.Tipo.BUFF,
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
    BUNSHIN_NO_JUTSU_II("bunshin_no_jutsu", R.string.bunshin_no_jutsu_ii, R.string.bunshin_no_jutsu_ii_des,
            Classe.NIN, Jutsu.Tipo.BUFF,
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
    NINPOU("mushou_de_hitei", R.string.ninpou, R.string.ninpou_des,
            Classe.NIN, Jutsu.Tipo.ATK,
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
    KAGE_SHURIKEN("kage_shuriken_no_jutsu", R.string.kage_shuriken_no_jutsu, R.string.kage_shuriken_no_jutsu_des,
            Classe.NIN, Jutsu.Tipo.ATK,
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
    KAKUREMINO("kakuremino_no_jutsu", R.string.kakuremino, R.string.kakuremino_des,
            Classe.NIN, Jutsu.Tipo.ATK,
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
                                    value(folded), "Taijutsu");
                        }
                    }
            )),
    KAWARIMI("substituicao", R.string.kawarimi, R.string.kawarimi_des,
            Classe.NIN, Jutsu.Tipo.ATK,
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
                                    value(folded), "Taijutsu");
                        }
                    }
            )),
    KAGE_BUNSHIN_I("clones", R.string.kage_bunshin_no_jutsu_i, R.string.kage_bunshin_no_jutsu_i_des,
            Classe.NIN, Jutsu.Tipo.BUFF,
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
    KAGE_BUNSHIN_II("clones", R.string.kage_bunshin_no_jutsu_ii, R.string.kage_bunshin_no_jutsu_ii_des,
            Classe.NIN, Jutsu.Tipo.BUFF,
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
    SENSEI_KAGE_BUNSHIN_NO_JUTSU("Kage-Bunshin-no-Jutsu", R.string.sensei_kage_bunshin_no_jutsu, R.string.sensei_kage_bunshin_no_jutsu_des,
            Classe.NIN, Jutsu.Tipo.ATK,
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
                                    value(folded), "Taijutsu");
                        }
                    }
            )),


    // GENJUTSUS
    KISHIBARI_NO_JUTSU("Kishibari_no_Jutsu", R.string.kishibari_no_jutsu, R.string.kishibari_no_jutsu_des,
            Classe.GEN, Jutsu.Tipo.ATK,
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
    KASUMI_JUUHA("Kasumi_Juuha_no_Jutsu", R.string.kasumi_juuha, R.string.kasumi_juuha_des,
            Classe.GEN, Jutsu.Tipo.ATK,
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
    NEMURI_I("nerumi", R.string.nemuri_i, R.string.nemuri_i_des,
            Classe.GEN, Jutsu.Tipo.DEBUFF,
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
    NEMURI_II("nerumi", R.string.nemuri_ii, R.string.nemuri_ii_des,
            Classe.GEN, Jutsu.Tipo.DEBUFF,
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
    KOKOROYOURU("Kokoroyoru_no_jutsu", R.string.kokoroyoru, R.string.kokoroyoru_des,
            Classe.GEN, Jutsu.Tipo.ATK,
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
    TAZUNERU("Tazuneru_no_Jutsu", R.string.tazuneru, R.string.tazuneru_des,
            Classe.GEN, Jutsu.Tipo.ATK,
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
    BAKUON("Bakuon_no_Jutsu", R.string.bukuon, R.string.bukuon_des,
            Classe.GEN, Jutsu.Tipo.ATK,
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
                                    value(folded), "Taijutsu");
                        }
                    }
            )),
    UTSUSEMI("Utsusemi_no_Jutsu", R.string.utsusemi, R.string.utsusemi_des,
            Classe.GEN, Jutsu.Tipo.ATK,
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
                                    value(folded), "Taijutsu");
                        }
                    }
            )),
    HANA_I("Hana_Kyouka_Sai", R.string.hana_kyouka_sai_i, R.string.hana_kyouka_sai_i_des,
            Classe.GEN, Jutsu.Tipo.DEBUFF,
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
    HANA_II("Hana_Kyouka_Sai", R.string.hana_kyouka_sai_ii, R.string.hana_kyouka_sai_ii_des,
            Classe.GEN, Jutsu.Tipo.DEBUFF,
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
    SENSEI_HANA("Hana-Kyouka-Sai", R.string.sensei_hana_kyouka_sai, R.string.sensei_hana_kyouka_sai_des,
            Classe.GEN, Jutsu.Tipo.ATK,
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
            ));


    public final String image;
    public final int name;
    public final int description;
    public final Classe classe;
    public final Jutsu.Tipo tipo;
    public final List<Requirement> requirements;

    Jutsus(String image, int name, int description, Classe classe, Jutsu.Tipo tipo, List<Requirement> requirements) {
        this.image = image;
        this.name = name;
        this.description = description;
        this.classe = classe;
        this.tipo = tipo;
        this.requirements = requirements;
    }
}
