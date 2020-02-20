package com.gutotech.narutogame.data.model;

import android.content.Context;

import com.gutotech.narutogame.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ShopUtils {
    private List<ShopItem> itemsList;

    public ShopUtils() {
        itemsList = new ArrayList<>();
    }

    public static List<ShopItem> getRamens() {
        List<ShopItem> itemsList = new ArrayList<>();
        
        itemsList.add(new Ramen("nissin", R.string.ninja_snack,
                R.string.ninja_snack_description,
                Arrays.asList(new Requirement() {
                    @Override
                    public boolean check() {
                        return CharOn.character.getLevel() >= 1;
                    }

                    @Override
                    public String toString(Context context) {
                        return context.getString(R.string.requires_level, 1);
                    }
                }), 25, 100));

        itemsList.add(new Ramen("ramen", R.string.misso_gyoza_ramen,
                R.string.misso_gyoza_description,
                Collections.singletonList(new Requirement() {
                    @Override
                    public boolean check() {
                        return CharOn.character.getLevel() >= 5;
                    }

                    @Override
                    public String toString(Context context) {
                        return context.getString(R.string.requires_level, 5);
                    }
                }), 35, 150));

        itemsList.add(new Ramen("ramen_duplo", R.string.shoyu_gyoza_ramen,
                R.string.shoyu_gyoza_ramen_description,
                Collections.singletonList(new Requirement() {
                    @Override
                    public boolean check() {
                        return CharOn.character.getLevel() >= 10;
                    }

                    @Override
                    public String toString(Context context) {
                        return context.getString(R.string.requires_level, 10);
                    }
                }), 70, 300));

        itemsList.add(new Ramen("ramen_g", R.string.shio_gyoza_ramen,
                R.string.shio_gyoza_ramen_description,
                Collections.singletonList(new Requirement() {
                    @Override
                    public boolean check() {
                        return CharOn.character.getLevel() >= 15;
                    }

                    @Override
                    public String toString(Context context) {
                        return context.getString(R.string.requires_level, 15);
                    }
                }), 105, 450));

        itemsList.add(new Ramen("Shio_Tyashu-Ramen", R.string.shio_tyashu_ramen,
                R.string.shio_tyashu_ramen_description,
                Collections.singletonList(new Requirement() {
                    @Override
                    public boolean check() {
                        return CharOn.character.getLevel() >= 20;
                    }

                    @Override
                    public String toString(Context context) {
                        return context.getString(R.string.requires_level, 20);
                    }
                }), 140, 600));

        itemsList.add(new Ramen("Shoyu_Tyashu-Ramen", R.string.shoyu_tyashu_ramen,
                R.string.shoyu_tyashu_ramen_description,
                Collections.singletonList(new Requirement() {
                    @Override
                    public boolean check() {
                        return CharOn.character.getLevel() >= 25;
                    }

                    @Override
                    public String toString(Context context) {
                        return context.getString(R.string.requires_level, 25);
                    }
                }), 175, 750));

        itemsList.add(new Ramen("Misso_Tyashu-Ramen", R.string.misso_tyashu_ramen,
                R.string.misso_tyashu_ramen_description,
                Collections.singletonList(new Requirement() {
                    @Override
                    public boolean check() {
                        return CharOn.character.getLevel() >= 30;
                    }

                    @Override
                    public String toString(Context context) {
                        return context.getString(R.string.requires_level, 30);
                    }
                }), 210, 900));

        itemsList.add(new Ramen("Shio_Yasai-Ramen", R.string.shio_yasai_ramen,
                R.string.shio_yasai_ramen_description,
                Collections.singletonList(new Requirement() {
                    @Override
                    public boolean check() {
                        return CharOn.character.getLevel() >= 35;
                    }

                    @Override
                    public String toString(Context context) {
                        return context.getString(R.string.requires_level, 35);
                    }
                }), 245, 1050));


        itemsList.add(new Ramen("Shoyu_Yasai-Ramen", R.string.shoyu_yasai_ramen,
                R.string.shoyu_yasai_ramen_description,
                Collections.singletonList(new Requirement() {
                    @Override
                    public boolean check() {
                        return CharOn.character.getLevel() >= 40;
                    }

                    @Override
                    public String toString(Context context) {
                        return context.getString(R.string.requires_level, 40);
                    }
                }), 280, 1200));


        itemsList.add(new Ramen("Misso_Yasai-Ramen", R.string.misso_yasai_ramen,
                R.string.misso_yasai_ramen_description,
                Collections.singletonList(new Requirement() {
                    @Override
                    public boolean check() {
                        return CharOn.character.getLevel() >= 45;
                    }

                    @Override
                    public String toString(Context context) {
                        return context.getString(R.string.requires_level, 45);
                    }
                }), 315, 1350));


        itemsList.add(new Ramen("Shio_Ebi-Ramen", R.string.shio_ebi_ramen,
                R.string.shio_ebi_ramen_description,
                Collections.singletonList(new Requirement() {
                    @Override
                    public boolean check() {
                        return CharOn.character.getLevel() >= 50;
                    }

                    @Override
                    public String toString(Context context) {
                        return context.getString(R.string.requires_level, 50);
                    }
                }), 350, 1500));


        itemsList.add(new Ramen("Shoyu_Ebi-Ramen", R.string.shoyu_ebi_ramen,
                R.string.shoyu_eb_ramen_description,
                Collections.singletonList(new Requirement() {
                    @Override
                    public boolean check() {
                        return CharOn.character.getLevel() >= 55;
                    }

                    @Override
                    public String toString(Context context) {
                        return context.getString(R.string.requires_level, 55);
                    }
                }), 385, 1650));


        itemsList.add(new Ramen("Misso_Ebi-Ramen", R.string.shio_gyoza_ramen,
                R.string.shio_gyoza_ramen_description,
                Collections.singletonList(new Requirement() {
                    @Override
                    public boolean check() {
                        return CharOn.character.getLevel() >= 60;
                    }

                    @Override
                    public String toString(Context context) {
                        return context.getString(R.string.requires_level, 60);
                    }
                }), 420, 1800));

        return itemsList;
    }

//    public static List<Item> getArmasLongoAlcance() {
//        itemsList.clear();
//        itemsList.add(new Arma("shuriken", "Shuriken",
//                "Você arremessa uma shuriken em seu inimigo",
//                7, 0, 2, 2, 1, 4, Arma.Tipo.TAI_BUK));
//
//        itemsList.add(new Arma("shuriken-chakra", "Shuriken de Chakra",
//                "Você arremessa uma shuriken em seu inimigo",
//                7, 0, 2, 2, 4, 1, Arma.Tipo.NIN_GEN));
//        return itemsList;
//    }
//
//    public List<Item> getArmasCurtoAlcance() {
//        itemsList.clear();
//
//        itemsList.add(new Arma("nunchaku", "Nunchaku",
//                "Consiste de dois bastões pequenos conectados em seus fins por uma corda ou corrente. Muito uitilizado para golpear a curta distância e aumentar o dano no oponente.",
//                700, 1, 5, 21, 4, 22, Arma.Tipo.TAI_BUK));
//
//        itemsList.add(new Arma("pincel2", "Pincel Gigante",
//                "Alguns Shinobis utilizam suas técnicas por meio de pinturas, como Kurama Yakumo que com sua Kekkei Genkai pode tornar suas pinturas praticamente reais.",
//                1, 1, 5, 25, 25, 4, Arma.Tipo.NIN_GEN));
//
//        itemsList.add(new Arma("pincel", "Pincel",
//                "Alguns Shinobis utilizam suas técnicas por meio de pinturas, como Kurama Yakumo que com sua Kekkei Genkai pode tornar suas pinturas praticamente reais.",
//                700, 1, 5, 21, 22, 3, Arma.Tipo.NIN_GEN));
//
//        itemsList.add(new Arma("nunchaku2", "Nunchaku Energizado",
//                "Consiste de dois bastões pequenos conectados em seus fins por uma corda ou corrente. Muito uitilizado para golpear a curta distância e aumentar o dano no oponente.",
//                1, 1, 5, 25, 3, 25, Arma.Tipo.TAI_BUK));
//
//        return itemsList;
//    }

    public static List<ShopItem> getPergaminhos() {
//        itemsList.clear();
//        itemsList.add(new Pergaminho("1", Vilas.FOLHA));
//        itemsList.add(new Pergaminho("2", Vilas.FONTES_TERMAIS));
//        itemsList.add(new Pergaminho("3", Vilas.NEVE));
//        itemsList.add(new Pergaminho("4", Vilas.CACHOEIRA));
//        itemsList.add(new Pergaminho("5", Vilas.CHUVA));
//        itemsList.add(new Pergaminho("6", Vilas.SOM));
//        itemsList.add(new Pergaminho("7", Vilas.AKATSUKI));
//        itemsList.add(new Pergaminho("8", Vilas.NUVEM));
//        itemsList.add(new Pergaminho("9", Vilas.PEDRA));
//        itemsList.add(new Pergaminho("10", Vilas.NEVOA));
//        itemsList.add(new Pergaminho("11", Vilas.AREIA));
//        itemsList.add(new Pergaminho("12", Vilas.GRAMA));
        return null;
    }
}
