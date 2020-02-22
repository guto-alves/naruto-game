package com.gutotech.narutogame.data.repository;

import com.gutotech.narutogame.data.model.CharOn;
import com.gutotech.narutogame.data.model.Classe;
import com.gutotech.narutogame.data.model.Jutsu;
import com.gutotech.narutogame.data.model.JutsuInfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class JutsuRepository {
    private static final JutsuRepository ourInstance = new JutsuRepository();

    public static JutsuRepository getInstance() {
        return ourInstance;
    }

    private JutsuRepository() {
    }

    public List<Jutsu> getJutsusDefault(Classe classe) {
        List<Jutsu> jutsusDefault;

        if (classe == Classe.TAI || classe == Classe.BUK) {
            jutsusDefault = new ArrayList<>(Arrays.asList(
                    new Jutsu(JutsuInfo.DEFESA_MAO.toString(), classe, 0, 5, 0,
                            3, 10, 3),
                    new Jutsu(JutsuInfo.DEFESA_ACROBATICA.toString(), classe, 0, 8, 0,
                            4, 15, 3),
                    new Jutsu(JutsuInfo.SOCO.toString(), classe, 5, 0, 0,
                            1, 8, 3),
                    new Jutsu(JutsuInfo.CHUTE.toString(), classe, 8, 0, 0,
                            2, 11, 3)
            ));
        } else {
            jutsusDefault = new ArrayList<>(Arrays.asList(
                    new Jutsu(JutsuInfo.DEFESA_MAO.toString(), classe, 0, 5, 0,
                            10, 3, 3),
                    new Jutsu(JutsuInfo.DEFESA_ACROBATICA.toString(), classe, 0, 8, 0,
                            15, 4, 3),
                    new Jutsu(JutsuInfo.SOCO.toString(), classe, 5, 0, 0,
                            8, 1, 3),
                    new Jutsu(JutsuInfo.CHUTE.toString(), classe, 8, 0, 0,
                            11, 2, 3)
            ));
        }

        return jutsusDefault;
    }

    public void filterJutsus(Classe classe, Callback<List<Jutsu>> callback) {
        List<Jutsu> jutsus = new ArrayList<>();

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            if (classe == Classe.TAI) {
                jutsus.add(new Jutsu(JutsuInfo.DYNAMIC_KICK.toString(), Classe.TAI,
                        16, 0, 10, 3, 18, 2));

                jutsus.add(new Jutsu(JutsuInfo.DYNAMIC_ENTRY.toString(), Classe.TAI,
                        20, 0, 14, 2, 22, 2));
                jutsus.add(new Jutsu(JutsuInfo.HORENGAN_PILL_I.toString(), Classe.TAI,
                        2, 0, 1, 2, 22));
                jutsus.add(new Jutsu(JutsuInfo.HORENGAN_PILL_II.toString(), Classe.TAI,
                        0, 2, 1, 2, 22));
                jutsus.add(new Jutsu(JutsuInfo.HARIITSUBA.toString(), Classe.TAI,
                        29, 0, 14, 6, 33, 2));
                jutsus.add(new Jutsu(JutsuInfo.KONOHA_FULL_KICK_SOCCER.toString(), Classe.TAI,
                        38, 0, 20, 7, 44));
                jutsus.add(new Jutsu(JutsuInfo.KONOHA_SENPUU.toString(), Classe.TAI,
                        38, 0, 20, 7, 44));
                jutsus.add(new Jutsu(JutsuInfo.GANGEKI.toString(), Classe.TAI,
                        44, 0, 24, 9, 51));
                jutsus.add(new Jutsu(JutsuInfo.KARENGAN_PILL_I.toString(), Classe.TAI,
                        4, 0, 2, 4, 51));
                jutsus.add(new Jutsu(JutsuInfo.KARENGAN_PILL_II.toString(), Classe.TAI,
                        0, 4, 2, 4, 51));
                jutsus.add(new Jutsu(JutsuInfo.SENSEI_DYNAMIC_ENTRY.toString(), Classe.TAI,
                        51, 0, 28, 10, 59));

            } else if (classe == Classe.BUK) {
                jutsus.add(new Jutsu(JutsuInfo.SOUFUUSHASAN_NO_TACHI.toString(), Classe.BUK,
                        16, 0, 10, 6, 18, 2));

                jutsus.add(new Jutsu(JutsuInfo.SOUSHURIKEN_NO_JUTSU.toString(), Classe.BUK,
                        20, 0, 14, 2, 22, 2));
                jutsus.add(new Jutsu(JutsuInfo.SOUSHUUJIN_I.toString(), Classe.BUK,
                        -2, 0, -1, 2, 22));
                jutsus.add(new Jutsu(JutsuInfo.SOUSHUUJIN_II.toString(), Classe.BUK,
                        0, -2, -1, 2, 22));
                jutsus.add(new Jutsu(JutsuInfo.RENSHA.toString(), Classe.BUK,
                        29, 0, 14, 6, 33, 2));
                jutsus.add(new Jutsu(JutsuInfo.JOURO_SENBON.toString(), Classe.BUK,
                        38, 0, 20, 7, 44));
                jutsus.add(new Jutsu(JutsuInfo.SHIKOMISHINDAN.toString(), Classe.BUK,
                        38, 0, 20, 7, 44));
                jutsus.add(new Jutsu(JutsuInfo.GEN_EI_TAJUU_SHURIKEN.toString(), Classe.BUK,
                        44, 0, 24, 9, 51));
                jutsus.add(new Jutsu(JutsuInfo.HIJUTSU_ISHIBARI_I.toString(), Classe.BUK,
                        -4, 0, -2, 4, 51));
                jutsus.add(new Jutsu(JutsuInfo.HIJUTSU_ISHIBARI_II.toString(), Classe.BUK,
                        0, -4, -2, 4, 51));
                jutsus.add(new Jutsu(JutsuInfo.SENSEI_SOUSHURIKEN_NO_JUTSU.toString(), Classe.BUK,
                        51, 0, 28, 10, 59));

            } else if (classe == Classe.NIN) {
                jutsus.add(new Jutsu(JutsuInfo.HENGE_NO_JUTSU.toString(), Classe.NIN,
                        16, 0, 10, 18, 6, 2));

                jutsus.add(new Jutsu(JutsuInfo.KONOHA_TZU.toString(), Classe.NIN,
                        20, 0, 14, 22, 2, 2));
                jutsus.add(new Jutsu(JutsuInfo.BUNSHIN_NO_JUTSU_I.toString(), Classe.NIN,
                        2, 0, 1, 22, 2));
                jutsus.add(new Jutsu(JutsuInfo.BUNSHIN_NO_JUTSU_II.toString(), Classe.NIN,
                        0, 2, 1, 22, 2));
                jutsus.add(new Jutsu(JutsuInfo.NINPOU.toString(), Classe.NIN,
                        29, 0, 14, 33, 6, 2));
                jutsus.add(new Jutsu(JutsuInfo.KAGE_SHURIKEN.toString(), Classe.NIN,
                        38, 0, 20, 44, 7));
                jutsus.add(new Jutsu(JutsuInfo.KAKUREMINO.toString(), Classe.NIN,
                        38, 0, 20, 44, 7));
                jutsus.add(new Jutsu(JutsuInfo.KAWARIMI.toString(), Classe.NIN,
                        44, 0, 24, 51, 9));
                jutsus.add(new Jutsu(JutsuInfo.KAGE_BUNSHIN_I.toString(), Classe.NIN,
                        4, 0, 2, 51, 4));
                jutsus.add(new Jutsu(JutsuInfo.KAGE_BUNSHIN_II.toString(), Classe.NIN,
                        0, 4, 2, 51, 4));
                jutsus.add(new Jutsu(JutsuInfo.SENSEI_KAGE_BUNSHIN_NO_JUTSU.toString(), Classe.NIN,
                        51, 0, 28, 59, 10));

            } else { // mClasseSelected == GEN
                jutsus.add(new Jutsu(JutsuInfo.KISHIBARI_NO_JUTSU.toString(), Classe.GEN,
                        16, 0, 10, 18, 6, 2));

                jutsus.add(new Jutsu(JutsuInfo.KASUMI_JUUHA.toString(), Classe.GEN,
                        20, 0, 14, 22, 2, 2));
                jutsus.add(new Jutsu(JutsuInfo.NEMURI_I.toString(), Classe.GEN,
                        -2, 0, -1, 22, 2));
                jutsus.add(new Jutsu(JutsuInfo.NEMURI_II.toString(), Classe.GEN,
                        0, -2, -1, 22, 2));
                jutsus.add(new Jutsu(JutsuInfo.KOKOROYOURU.toString(), Classe.GEN,
                        29, 0, 14, 33, 6, 2));
                jutsus.add(new Jutsu(JutsuInfo.TAZUNERU.toString(), Classe.GEN,
                        38, 0, 20, 44, 7));
                jutsus.add(new Jutsu(JutsuInfo.BAKUON.toString(), Classe.GEN,
                        38, 0, 20, 44, 7));
                jutsus.add(new Jutsu(JutsuInfo.UTSUSEMI.toString(), Classe.GEN,
                        44, 0, 24, 51, 9));
                jutsus.add(new Jutsu(JutsuInfo.HANA_I.toString(), Classe.GEN,
                        -4, 0, -2, 51, 4));
                jutsus.add(new Jutsu(JutsuInfo.HANA_II.toString(), Classe.GEN,
                        0, -4, -2, 51, 4));
                jutsus.add(new Jutsu(JutsuInfo.SENSEI_HANA.toString(), Classe.GEN,
                        51, 0, 28, 59, 10));
            }

            removeRepeatedJutsus(jutsus, CharOn.character.getJutsus());

            callback.call(jutsus);
        });
    }

    private void removeRepeatedJutsus(Collection<Jutsu> jutsus1, Collection<Jutsu> charJutsus) {
        Iterator<Jutsu> iterator = jutsus1.iterator();

        while (iterator.hasNext()) {
            if (charJutsus.contains(iterator.next())) {
                iterator.remove();
            }
        }
    }
}
