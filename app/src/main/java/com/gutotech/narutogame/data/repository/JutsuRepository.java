package com.gutotech.narutogame.data.repository;

import com.gutotech.narutogame.data.model.CharOn;
import com.gutotech.narutogame.data.model.Classe;
import com.gutotech.narutogame.data.model.Jutsu;
import com.gutotech.narutogame.data.model.Jutsus;

import java.util.ArrayList;
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

    public void filterJutsus(Classe classe, Callback<List<Jutsu>> callback) {
        List<Jutsu> jutsus = new ArrayList<>();

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            if (classe == Classe.TAI) {
                jutsus.add(new Jutsu(Jutsus.DYNAMIC_KICK.toString(), 16, 0, 10,
                        3, 18));

                jutsus.add(new Jutsu(Jutsus.DYNAMIC_ENTRY.toString(), 20, 0, 14,
                        2, 22));
                jutsus.add(new Jutsu(Jutsus.HORENGAN_PILL_I.toString(), 2, 0, 1,
                        2, 22));
                jutsus.add(new Jutsu(Jutsus.HORENGAN_PILL_II.toString(), 0, 2, 1,
                        2, 22));
                jutsus.add(new Jutsu(Jutsus.HARIITSUBA.toString(), 29, 0, 14,
                        6, 33));
                jutsus.add(new Jutsu(Jutsus.KONOHA_FULL_KICK_SOCCER.toString(), 38, 0, 20,
                        7, 44));
                jutsus.add(new Jutsu(Jutsus.KONOHA_SENPUU.toString(), 38, 0, 20,
                        7, 44));
                jutsus.add(new Jutsu(Jutsus.GANGEKI.toString(), 44, 0, 24,
                        9, 51));
                jutsus.add(new Jutsu(Jutsus.KARENGAN_PILL_I.toString(), 4, 0, 2,
                        4, 51));
                jutsus.add(new Jutsu(Jutsus.KARENGAN_PILL_II.toString(), 0, 4, 2,
                        4, 51));
                jutsus.add(new Jutsu(Jutsus.SENSEI_DYNAMIC_ENTRY.toString(), 51, 0, 28,
                        10, 59));

            } else if (classe == Classe.BUK) {
                jutsus.add(new Jutsu(Jutsus.SOUFUUSHASAN_NO_TACHI.toString(), 16, 0, 10,
                        6, 18));

                jutsus.add(new Jutsu(Jutsus.SOUSHURIKEN_NO_JUTSU.toString(), 20, 0, 14,
                        2, 22));
                jutsus.add(new Jutsu(Jutsus.SOUSHUUJIN_I.toString(), 2, 0, 1,
                        2, 22));
                jutsus.add(new Jutsu(Jutsus.SOUSHUUJIN_II.toString(), 0, 2, 1,
                        2, 22));
                jutsus.add(new Jutsu(Jutsus.RENSHA.toString(), 29, 0, 14,
                        6, 33));
                jutsus.add(new Jutsu(Jutsus.JOURO_SENBON.toString(), 38, 0, 20,
                        7, 44));
                jutsus.add(new Jutsu(Jutsus.SHIKOMISHINDAN.toString(), 38, 0, 20,
                        7, 44));
                jutsus.add(new Jutsu(Jutsus.GEN_EI_TAJUU_SHURIKEN.toString(), 44, 0, 24,
                        9, 51));
                jutsus.add(new Jutsu(Jutsus.HIJUTSU_ISHIBARI_I.toString(), 4, 0, 2,
                        4, 51));
                jutsus.add(new Jutsu(Jutsus.HIJUTSU_ISHIBARI_II.toString(), 0, 4, 2,
                        4, 51));
                jutsus.add(new Jutsu(Jutsus.SENSEI_SOUSHURIKEN_NO_JUTSU.toString(), 51, 0, 28,
                        10, 59));

            } else if (classe == Classe.NIN) {
                jutsus.add(new Jutsu(Jutsus.HENGE_NO_JUTSU.toString(), 0, 16, 10,
                        18, 6));

                jutsus.add(new Jutsu(Jutsus.KONOHA_TZU.toString(), 20, 0, 14,
                        22, 2));
                jutsus.add(new Jutsu(Jutsus.BUNSHIN_NO_JUTSU_I.toString(), 2, 0, 1,
                        22, 2));
                jutsus.add(new Jutsu(Jutsus.BUNSHIN_NO_JUTSU_II.toString(), 0, 2, 1,
                        22, 2));
                jutsus.add(new Jutsu(Jutsus.NINPOU.toString(), 29, 0, 14,
                        33, 6));
                jutsus.add(new Jutsu(Jutsus.KAGE_SHURIKEN.toString(), 38, 0, 20,
                        44, 7));
                jutsus.add(new Jutsu(Jutsus.KAKUREMINO.toString(), 38, 0, 20,
                        44, 7));
                jutsus.add(new Jutsu(Jutsus.KAWARIMI.toString(), 44, 0, 24,
                        51, 9));
                jutsus.add(new Jutsu(Jutsus.KAGE_BUNSHIN_I.toString(), 4, 0, 2,
                        51, 4));
                jutsus.add(new Jutsu(Jutsus.KAGE_BUNSHIN_II.toString(), 0, 4, 2,
                        51, 4));
                jutsus.add(new Jutsu(Jutsus.SENSEI_KAGE_BUNSHIN_NO_JUTSU.toString(), 51, 0, 28,
                        59, 10));

            } else { // mClasseSelected == GEN
                jutsus.add(new Jutsu(Jutsus.KISHIBARI_NO_JUTSU.toString(), 0, 16, 10,
                        18, 6));

                jutsus.add(new Jutsu(Jutsus.KASUMI_JUUHA.toString(), 20, 0, 14,
                        22, 2));
                jutsus.add(new Jutsu(Jutsus.NEMURI_I.toString(), 2, 0, 1,
                        22, 2));
                jutsus.add(new Jutsu(Jutsus.NEMURI_II.toString(), 0, 2, 1,
                        22, 2));
                jutsus.add(new Jutsu(Jutsus.KOKOROYOURU.toString(), 29, 0, 14,
                        33, 6));
                jutsus.add(new Jutsu(Jutsus.TAZUNERU.toString(), 38, 0, 20,
                        44, 7));
                jutsus.add(new Jutsu(Jutsus.BAKUON.toString(), 38, 0, 20,
                        44, 7));
                jutsus.add(new Jutsu(Jutsus.UTSUSEMI.toString(), 44, 0, 24,
                        51, 9));
                jutsus.add(new Jutsu(Jutsus.HANA_I.toString(), 4, 0, 2,
                        51, 4));
                jutsus.add(new Jutsu(Jutsus.HANA_II.toString(), 0, 4, 2,
                        51, 4));
                jutsus.add(new Jutsu(Jutsus.SENSEI_HANA.toString(), 51, 0, 28,
                        59, 10));
            }

            removeRepeatedJutsus(jutsus, CharOn.character.getJutsus());

            callback.call(jutsus);
        });
    }

    private void removeRepeatedJutsus(Collection<Jutsu> jutsus1, Collection<Jutsu> jutsus2) {
        Iterator<Jutsu> iterator = jutsus1.iterator();

        while (iterator.hasNext()) {
            if (jutsus2.contains(iterator.next())) {
                iterator.remove();
            }
        }
    }
}
