package com.gutotech.narutogame.data.model;

import android.content.Context;

import com.gutotech.narutogame.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShopUtils {

    public static List<ShopItem> getRamens() {
        List<ShopItem> itemsList = new ArrayList<>();

        itemsList.add(new Ramen("nissin", R.string.ninja_snack,
                R.string.ninja_snack_description,
                Collections.singletonList(new Requirement() {
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
}
