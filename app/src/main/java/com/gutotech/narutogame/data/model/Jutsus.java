package com.gutotech.narutogame.data.model;

import android.content.Context;

import com.gutotech.narutogame.R;

import java.util.Arrays;
import java.util.List;

public enum Jutsus {
    JUTSUS1("transformacao", R.string.name, R.string.description, Classe.NIN, Jutsu.Tipo.ATK,
            Arrays.asList(
                    new Requirement() {
                        @Override
                        public boolean check() {
                            return false;
                        }

                        @Override
                        public String show(Context context) {
                            return null;
                        }
                    },
                    new Requirement() {
                        @Override
                        public boolean check() {
                            return false;
                        }

                        @Override
                        public String show(Context context) {
                            return null;
                        }
                    }
            )),

    JUTSUS11("konoha_tizu", R.string.name, R.string.description, Classe.NIN, Jutsu.Tipo.ATK,
            Arrays.asList(
                    new Requirement() {
                        @Override
                        public boolean check() {
                            return false;
                        }

                        @Override
                        public String show(Context context) {
                            return null;
                        }
                    },
                    new Requirement() {
                        @Override
                        public boolean check() {
                            return false;
                        }

                        @Override
                        public String show(Context context) {
                            return null;
                        }
                    }
            )),

    JUTSUS2("substituicao", R.string.name, R.string.description, Classe.NIN, Jutsu.Tipo.ATK,
            Arrays.asList(
                    new Requirement() {
                        @Override
                        public boolean check() {
                            return false;
                        }

                        @Override
                        public String show(Context context) {
                            return null;
                        }
                    },
                    new Requirement() {
                        @Override
                        public boolean check() {
                            return false;
                        }

                        @Override
                        public String show(Context context) {
                            return null;
                        }
                    }
            )),
    JUTSUS3("Tazuneru_no_Jutsu", R.string.name, R.string.description, Classe.GEN, Jutsu.Tipo.ATK,
            Arrays.asList(
                    new Requirement() {
                        @Override
                        public boolean check() {
                            return false;
                        }

                        @Override
                        public String show(Context context) {
                            return null;
                        }
                    },
                    new Requirement() {
                        @Override
                        public boolean check() {
                            return false;
                        }

                        @Override
                        public String show(Context context) {
                            return null;
                        }
                    }
            )),
    JUTSUS7("Kishibari_no_Jutsu", R.string.name, R.string.description, Classe.GEN, Jutsu.Tipo.ATK,
            Arrays.asList(
                    new Requirement() {
                        @Override
                        public boolean check() {
                            return false;
                        }

                        @Override
                        public String show(Context context) {
                            return null;
                        }
                    },
                    new Requirement() {
                        @Override
                        public boolean check() {
                            return false;
                        }

                        @Override
                        public String show(Context context) {
                            return null;
                        }
                    }
            )),
    JUTSUS4("Utsusemi_no_Jutsu", R.string.name, R.string.description, Classe.GEN, Jutsu.Tipo.ATK,
            Arrays.asList(
                    new Requirement() {
                        @Override
                        public boolean check() {
                            return false;
                        }

                        @Override
                        public String show(Context context) {
                            return null;
                        }
                    },
                    new Requirement() {
                        @Override
                        public boolean check() {
                            return false;
                        }

                        @Override
                        public String show(Context context) {
                            return null;
                        }
                    }
            ));

    /*
    - nin
        bunshin_no_jutsu
        transformacao
        tajuu_taki_rasengan
        clones
        Hiraishin no Jutsu

    - gen
        Kokoroyoru_no_jutsu
        nerumi
        Tazuneru_no_Jutsu
        Kasumi_Juuha_no_Jutsu
        Bakuon_no_Jutsu
        Hana_Kyouka_Sai
        Utsusemi_no_Jutsu
        amaterasu
        utakata
        magen_narakumi
        Ayatsuito-no-Jutsu
        magen_kokuni_arazu_no_jutsu
        mateki_mugen_onki
        oto_no_gen
        Oto-no-Gen

    - tai
        chute_dinamico
        suiken
        dynamic_entry
        Dynamic_Entry
        konoha_full_kick_soccer
        pilula_vermelha
        pilula_verde
        pilula_amarela
        pilula_soldado
        Konoha_Gouriki_Senpuu

    - buky
        Soushuujin


    defesa_2_mao
    defesa_acrobatica
    chute
    soco

     */

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
