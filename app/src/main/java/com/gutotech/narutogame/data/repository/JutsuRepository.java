package com.gutotech.narutogame.data.repository;

import com.gutotech.narutogame.data.model.CharOn;
import com.gutotech.narutogame.data.model.Classe;
import com.gutotech.narutogame.data.model.Jutsu;
import com.gutotech.narutogame.data.model.JutsuInfo;
import com.gutotech.narutogame.data.model.Requirement;

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
                // Student
                jutsus.add(new Jutsu(JutsuInfo.DYNAMIC_KICK.toString(), Classe.TAI,
                        16, 0, 6, 3, 18, 2));

                // Genin
                jutsus.add(new Jutsu(JutsuInfo.DYNAMIC_ENTRY.toString(), Classe.TAI,
                        20, 0, 7, 2, 22, 2));
                jutsus.add(new Jutsu(JutsuInfo.HORENGAN_PILL_I.toString(), Classe.TAI,
                        2, 0, 1, 2, 22));
                jutsus.add(new Jutsu(JutsuInfo.HORENGAN_PILL_II.toString(), Classe.TAI,
                        0, 2, 1, 2, 22));
                jutsus.add(new Jutsu(JutsuInfo.HARIITSUBA.toString(), Classe.TAI,
                        29, 0, 10, 6, 33, 2));
                jutsus.add(new Jutsu(JutsuInfo.KONOHA_FULL_KICK_SOCCER.toString(), Classe.TAI,
                        38, 0, 12, 7, 44));
                jutsus.add(new Jutsu(JutsuInfo.KONOHA_SENPUU.toString(), Classe.TAI,
                        38, 0, 12, 7, 44));
                jutsus.add(new Jutsu(JutsuInfo.GANGEKI.toString(), Classe.TAI,
                        44, 0, 13, 9, 51));
                jutsus.add(new Jutsu(JutsuInfo.KARENGAN_PILL_I.toString(), Classe.TAI,
                        4, 0, 2, 4, 51));
                jutsus.add(new Jutsu(JutsuInfo.KARENGAN_PILL_II.toString(), Classe.TAI,
                        0, 4, 2, 4, 51));
                jutsus.add(new Jutsu(JutsuInfo.SENSEI_DYNAMIC_ENTRY.toString(), Classe.TAI,
                        51, 0, 17, 10, 59));

                // Chuunin
                jutsus.add(new Jutsu(JutsuInfo.KONOHA_DAI_SENKOU.toString(), Classe.TAI,
                        55, 0, 30, 10, 62));
                jutsus.add(new Jutsu(JutsuInfo.SENNEN_GOROSHI.toString(), Classe.TAI,
                        61, 0, 30, 18, 70));
                jutsus.add(new Jutsu(JutsuInfo.AIAN_KUROU.toString(), Classe.TAI,
                        69, 2, 30, 20, 79));
                jutsus.add(new Jutsu(JutsuInfo.KONOHA_REPPUU.toString(), Classe.TAI,
                        64, 0, 30, 12, 74));
                jutsus.add(new Jutsu(JutsuInfo.TONGARASHIGAN_PILL_I.toString(), Classe.TAI,
                        6, 0, 3, 6, 74));
                jutsus.add(new Jutsu(JutsuInfo.TONGARASHIGAN_PILL_II.toString(), Classe.TAI,
                        0, 6, 3, 6, 74));
                jutsus.add(new Jutsu(JutsuInfo.KONGOURIKI_FUDOU.toString(), Classe.TAI,
                        75, 0, 30, 22, 87));
                jutsus.add(new Jutsu(JutsuInfo.SHISHI_RENDAN.toString(), Classe.TAI,
                        73, 0, 30, 14, 84));
                jutsus.add(new Jutsu(JutsuInfo.PANCHI.toString(), Classe.TAI,
                        83, 0, 30, 24, 96));
                jutsus.add(new Jutsu(JutsuInfo.KONOHA_KAGE_BUYOU.toString(), Classe.TAI,
                        79, 0, 30, 15, 92));
                jutsus.add(new Jutsu(JutsuInfo.SENSEI_SENNEN_GOROSHI.toString(), Classe.TAI,
                        86, 0, 35, 17, 99));

                // Jounin
                jutsus.add(new Jutsu(JutsuInfo.RAKANKEN.toString(), Classe.TAI,
                        61, 0, 30, 18, 70));
                jutsus.add(new Jutsu(JutsuInfo.JUUKEN_SHINAN.toString(), Classe.TAI,
                        69, 0, 30, 20, 79));
                jutsus.add(new Jutsu(JutsuInfo.DOROPPU_KIKKU.toString(), Classe.TAI,
                        75, 0, 3, 22, 87));
                jutsus.add(new Jutsu(JutsuInfo.CHOKUGEKI_RAIKOU.toString(), Classe.TAI,
                        83, 6, 3, 24, 96));
                jutsus.add(new Jutsu(JutsuInfo.KONOHA_GOURIKI_SENPUU.toString(), Classe.TAI,
                        90, 0, 30, 17, 103));
                jutsus.add(new Jutsu(JutsuInfo.ERUBOU.toString(), Classe.TAI,
                        104, 0, 30, 30, 120));
                jutsus.add(new Jutsu(JutsuInfo.KONOHA_DAIRETSUKUU.toString(), Classe.TAI,
                        104, 0, 30, 30, 120));
                jutsus.add(new Jutsu(JutsuInfo.KOSA_HO.toString(), Classe.TAI,
                        99, 0, 30, 19, 114));
                jutsus.add(new Jutsu(JutsuInfo.SUIKEN_I.toString(), Classe.TAI,
                        9, 0, 5, 20, 114));
                jutsus.add(new Jutsu(JutsuInfo.SUIKEN_II.toString(), Classe.TAI,
                        0, 9, 5, 20, 114));
                jutsus.add(new Jutsu(JutsuInfo.OBOROZUKIYO.toString(), Classe.TAI,
                        116, 0, 35, 20, 114));
                jutsus.add(new Jutsu(JutsuInfo.KONOHA_KAIGANSHOU.toString(), Classe.TAI,
                        116, 0, 35, 33, 133));
                jutsus.add(new Jutsu(JutsuInfo.HAYABUSA_OTOSHI.toString(), Classe.TAI,
                        108, 0, 35, 25, 125));
                jutsus.add(new Jutsu(JutsuInfo.RAIGYAKU_SUIHEI.toString(), Classe.TAI,
                        124, 0, 35, 35, 142));
                jutsus.add(new Jutsu(JutsuInfo.DOUBLE_DYNAMIC_ENTRY.toString(), Classe.TAI,
                        124, 0, 35, 35, 142));
                jutsus.add(new Jutsu(JutsuInfo.KONOHA_GOUHOURAIRAKU.toString(), Classe.TAI,
                        114, 0, 35, 22, 132));
                jutsus.add(new Jutsu(JutsuInfo.KYAKU_KICK.toString(), Classe.TAI,
                        114, 0, 35, 22, 132));
                jutsus.add(new Jutsu(JutsuInfo.SENSEI_KONOHA_GOURIKI_SENPUU.toString(), Classe.TAI,
                        121, 0, 35, 23, 140));

                // ANBU
                jutsus.add(new Jutsu(JutsuInfo.GOURAI_RENGE.toString(), Classe.TAI,
                        125, 0, 30, 24, 143));
                jutsus.add(new Jutsu(JutsuInfo.HEDDO_BATTO.toString(), Classe.TAI,
                        138, 0, 30, 20, 79));
                jutsus.add(new Jutsu(JutsuInfo.GIROCHIN_DOROPPU.toString(), Classe.TAI,
                        144, 0, 3, 42, 166));
                jutsus.add(new Jutsu(JutsuInfo.KONOHA_TSUMUJI_SENPUU.toString(), Classe.TAI,
                        144, 6, 3, 42, 166));
                jutsus.add(new Jutsu(JutsuInfo.TSUUTENKYAKU.toString(), Classe.TAI,
                        134, 0, 30, 26, 155));
                jutsus.add(new Jutsu(JutsuInfo.BUNSHIN_KAITEN_KAKATO_OTOSHI_I.toString(), Classe.TAI,
                        13, 0, 7, 13, 155));
                jutsus.add(new Jutsu(JutsuInfo.BUNSHIN_KAITEN_KAKATO_OTOSHI_II.toString(), Classe.TAI,
                        0, 13, 7, 13, 155));
                jutsus.add(new Jutsu(JutsuInfo.HIKEN_TSUKIKAGE.toString(), Classe.TAI,
                        155, 0, 30, 45, 179));
                jutsus.add(new Jutsu(JutsuInfo.RARIATTO.toString(), Classe.TAI,
                        155, 0, 5, 45, 179));
                jutsus.add(new Jutsu(JutsuInfo.KONOHA_SHOUFUU.toString(), Classe.TAI,
                        155, 9, 5, 45, 179));
                jutsus.add(new Jutsu(JutsuInfo.TAIHOU_SENTOU.toString(), Classe.TAI,
                        143, 0, 35, 28, 165));
                jutsus.add(new Jutsu(JutsuInfo.RAIKEN.toString(), Classe.TAI,
                        143, 0, 35, 28, 165));
                jutsus.add(new Jutsu(JutsuInfo.RAIGA_BOMU.toString(), Classe.TAI,
                        165, 0, 35, 48, 191));
                jutsus.add(new Jutsu(JutsuInfo.AOI_SHOUGEKI.toString(), Classe.TAI,
                        165, 0, 35, 48, 191));
                jutsus.add(new Jutsu(JutsuInfo.TATSUMAKI_KYAKU.toString(), Classe.TAI,
                        150, 0, 35, 29, 173));
                jutsus.add(new Jutsu(JutsuInfo.SENSEI_RAIGA_BOMU.toString(), Classe.TAI,
                        156, 0, 35, 30, 180));

                // Sannin
                jutsus.add(new Jutsu(JutsuInfo.KONGOURIKI.toString(), Classe.TAI,
                        160, 0, 35, 31, 184));
                jutsus.add(new Jutsu(JutsuInfo.PANCHI.toString(), Classe.TAI,
                        160, 0, 35, 31, 184));
                jutsus.add(new Jutsu(JutsuInfo.DABURU_RARIATTO.toString(), Classe.TAI,
                        181, 0, 35, 52, 208));
                jutsus.add(new Jutsu(JutsuInfo.JIGOKUZUKI.toString(), Classe.TAI,
                        183, 0, 35, 53, 212));
                jutsus.add(new Jutsu(JutsuInfo.KONOHA_NEPPUU.toString(), Classe.TAI,
                        183, 0, 35, 53, 212));
                jutsus.add(new Jutsu(JutsuInfo.KONOHA_DAI_SENPUU.toString(), Classe.TAI,
                        169, 0, 35, 33, 195));
                jutsus.add(new Jutsu(JutsuInfo.SOLDIER_PILL_I.toString(), Classe.TAI,
                        16, 0, 9, 16, 195));
                jutsus.add(new Jutsu(JutsuInfo.SEINSHUN_BURUPAPUA.toString(), Classe.TAI,
                        169, 0, 35, 33, 195));
                jutsus.add(new Jutsu(JutsuInfo.SOLDIER_PILL_II.toString(), Classe.TAI,
                        0, 16, 9, 16, 195));
                jutsus.add(new Jutsu(JutsuInfo.SHICHIKENBU.toString(), Classe.TAI,
                        195, 0, 35, 56, 225));
                jutsus.add(new Jutsu(JutsuInfo.YONHON_NUKITE.toString(), Classe.TAI,
                        195, 0, 35, 56, 225));
                jutsus.add(new Jutsu(JutsuInfo.CHOUHARITE.toString(), Classe.TAI,
                        195, 0, 35, 56, 225));
                jutsus.add(new Jutsu(JutsuInfo.KANADZUCHI_DAGEKI.toString(), Classe.TAI,
                        178, 0, 35, 34, 206));
                jutsus.add(new Jutsu(JutsuInfo.SANBON_NUKITE.toString(), Classe.TAI,
                        205, 0, 35, 59, 237));
                jutsus.add(new Jutsu(JutsuInfo.KONOHA_RYUUJIN.toString(), Classe.TAI,
                        205, 0, 35, 59, 237));
                jutsus.add(new Jutsu(JutsuInfo.MYU_SENPUU.toString(), Classe.TAI,
                        185, 0, 35, 36, 213));
                jutsus.add(new Jutsu(JutsuInfo.SENSEI_SHICHIKENBU.toString(), Classe.TAI,
                        191, 0, 35, 37, 221));

                // Hero
                jutsus.add(new Jutsu(JutsuInfo.IPPON_NUKITE.toString(), Classe.TAI,
                        220, 0, 35, 63, 254));
                jutsus.add(new Jutsu(JutsuInfo.SENSEI_MYU_SENPUU.toString(), Classe.TAI,
                        204, 0, 35, 39, 236));

            } else if (classe == Classe.BUK) {
                jutsus.add(new Jutsu(JutsuInfo.SOUFUUSHASAN_NO_TACHI.toString(), Classe.BUK,
                        16, 0, 6, 3, 18, 2));

                jutsus.add(new Jutsu(JutsuInfo.SOUSHURIKEN_NO_JUTSU.toString(), Classe.BUK,
                        20, 0, 7, 2, 22, 2));
                jutsus.add(new Jutsu(JutsuInfo.SOUSHUUJIN_I.toString(), Classe.BUK,
                        -2, 0, -1, 2, 22));
                jutsus.add(new Jutsu(JutsuInfo.SOUSHUUJIN_II.toString(), Classe.BUK,
                        0, -2, -1, 2, 22));
                jutsus.add(new Jutsu(JutsuInfo.RENSHA.toString(), Classe.BUK,
                        29, 0, 10, 6, 33, 2));
                jutsus.add(new Jutsu(JutsuInfo.JOURO_SENBON.toString(), Classe.BUK,
                        38, 0, 12, 7, 44));
                jutsus.add(new Jutsu(JutsuInfo.SHIKOMISHINDAN.toString(), Classe.BUK,
                        38, 0, 12, 7, 44));
                jutsus.add(new Jutsu(JutsuInfo.GENEI_TAJUU_SHURIKEN.toString(), Classe.BUK,
                        44, 0, 13, 9, 51));
                jutsus.add(new Jutsu(JutsuInfo.HIJUTSU_ISHIBARI_I.toString(), Classe.BUK,
                        -4, 0, -2, 4, 51));
                jutsus.add(new Jutsu(JutsuInfo.HIJUTSU_ISHIBARI_II.toString(), Classe.BUK,
                        0, -4, -2, 4, 51));
                jutsus.add(new Jutsu(JutsuInfo.SENSEI_SOUSHURIKEN_NO_JUTSU.toString(), Classe.BUK,
                        51, 0, 17, 10, 59));

                // Chuunin
                jutsus.add(new Jutsu(JutsuInfo.SHIKOMI_KUGUTSU_SHINSHIN_HAPPA.toString(), Classe.BUK,
                        55, 0, 18, 10, 62));
                jutsus.add(new Jutsu(JutsuInfo.NADESHIKORYUU_SHINKU_ENBU.toString(), Classe.BUK,
                        61, 0, 19, 18, 70));
                jutsus.add(new Jutsu(JutsuInfo.SAMEDARE_KEKKA.toString(), Classe.BUK,
                        69, 2, 22, 20, 79));
                jutsus.add(new Jutsu(JutsuInfo.KAWARA_SHURIKEN.toString(), Classe.BUK,
                        64, 0, 23, 12, 74));
                jutsus.add(new Jutsu(JutsuInfo.RAIKOU_KENKA_I.toString(), Classe.BUK,
                        -6, 0, -3, 3, 74));
                jutsus.add(new Jutsu(JutsuInfo.RAIKOU_KENKA_II.toString(), Classe.BUK,
                        0, -6, -3, 3, 74));
                jutsus.add(new Jutsu(JutsuInfo.AKAHIGI_KIKI_SANKAKU.toString(), Classe.BUK,
                        75, 0, 22, 22, 87));
                jutsus.add(new Jutsu(JutsuInfo.KUMO_SENKYUU_SUZAKU.toString(), Classe.BUK,
                        73, 0, 22, 14, 84));
                jutsus.add(new Jutsu(JutsuInfo.SOUSHUUGA.toString(), Classe.BUK,
                        83, 0, 23, 24, 96));
                jutsus.add(new Jutsu(JutsuInfo.HADAN.toString(), Classe.BUK,
                        79, 0, 22, 15, 92));
                jutsus.add(new Jutsu(JutsuInfo.SENSEI_SOUSHUUGA.toString(), Classe.BUK,
                        86, 0, 25, 17, 99));

                // Jounin
                jutsus.add(new Jutsu(JutsuInfo.SAKURA_FUBUKI_NO_JUTSU.toString(), Classe.TAI,
                        61, 0, 30, 18, 70));
                jutsus.add(new Jutsu(JutsuInfo.KUGUTSU_NO_JUTSU_GISHU_SENBON.toString(), Classe.TAI,
                        69, 0, 30, 20, 79));
                jutsus.add(new Jutsu(JutsuInfo.KUGUTSU_SAKURA_NO_MAI.toString(), Classe.TAI,
                        75, 0, 3, 22, 87));
                jutsus.add(new Jutsu(JutsuInfo.SETSUNA.toString(), Classe.TAI,
                        83, 6, 3, 24, 96));
                jutsus.add(new Jutsu(JutsuInfo.SENMOUFUU.toString(), Classe.TAI,
                        90, 0, 30, 17, 103));
                jutsus.add(new Jutsu(JutsuInfo.TAKIGAKURERYUU_MIZUKIRI_NO_YAIBA.toString(), Classe.TAI,
                        104, 0, 30, 30, 120));
                jutsus.add(new Jutsu(JutsuInfo.SHINKUUKEN.toString(), Classe.TAI,
                        104, 0, 30, 30, 120));
                jutsus.add(new Jutsu(JutsuInfo.RAISOU_IKAZUCHI_NO_UTAGE.toString(), Classe.TAI,
                        99, 0, 30, 19, 114));
                jutsus.add(new Jutsu(JutsuInfo.KONOHARYUU_YANAGI_II.toString(), Classe.TAI,
                        0, -9, -5, 12, 114));
                jutsus.add(new Jutsu(JutsuInfo.KONOHARYUU_YANAGI_I.toString(), Classe.TAI,
                        -9, 0, -5, 12, 114));
                jutsus.add(new Jutsu(JutsuInfo.KAMAITACHI_NO_JUTSU.toString(), Classe.TAI,
                        116, 0, 35, 33, 133));
                jutsus.add(new Jutsu(JutsuInfo.KAKEAMI.toString(), Classe.TAI,
                        116, 0, 35, 33, 133));
                jutsus.add(new Jutsu(JutsuInfo.KUMORYUU_URAGIRI.toString(), Classe.TAI,
                        108, 0, 35, 25, 125));
                jutsus.add(new Jutsu(JutsuInfo.SUISHOU_TOU.toString(), Classe.TAI,
                        124, 0, 35, 35, 142));
                jutsus.add(new Jutsu(JutsuInfo.KUSARIGAMA_NO_JUTSU.toString(), Classe.TAI,
                        124, 0, 35, 35, 142));
                jutsus.add(new Jutsu(JutsuInfo.RAIKYUU.toString(), Classe.TAI,
                        114, 0, 35, 22, 132));
                jutsus.add(new Jutsu(JutsuInfo.KUMORYUU_MIKAZUKIGIRI.toString(), Classe.TAI,
                        114, 0, 35, 22, 132));
                jutsus.add(new Jutsu(JutsuInfo.SENSEI_KUMORYUU_MIKAZUKIGIRI.toString(), Classe.TAI,
                        121, 0, 35, 23, 140));

                // ANBU
                jutsus.add(new Jutsu(JutsuInfo.KUROHIGI_KIKI_IPPATSU.toString(), Classe.TAI,
                        125, 0, 30, 18, 70));
                jutsus.add(new Jutsu(JutsuInfo.KUROHIGI_KIKI_NIHATSU.toString(), Classe.TAI,
                        138, 0, 30, 20, 79));
                jutsus.add(new Jutsu(JutsuInfo.IKAZUCHI_NO_KIBA.toString(), Classe.TAI,
                        144, 0, 3, 22, 87));
                jutsus.add(new Jutsu(JutsuInfo.REIJINGU_SANDAA.toString(), Classe.TAI,
                        144, 6, 3, 24, 96));
                jutsus.add(new Jutsu(JutsuInfo.KUMORYUU_KAENGIRI.toString(), Classe.TAI,
                        134, 0, 30, 17, 103));
                jutsus.add(new Jutsu(JutsuInfo.MUGEN_KOUGAI_II.toString(), Classe.TAI,
                        0, -13, -7, 20, 155));
                jutsus.add(new Jutsu(JutsuInfo.MUGEN_KOUGAI_I.toString(), Classe.TAI,
                        -13, 0, -7, 20, 155));
                jutsus.add(new Jutsu(JutsuInfo.KUROHIGI_KIKI_SANPATSU.toString(), Classe.TAI,
                        155, 0, 30, 45, 179));
                jutsus.add(new Jutsu(JutsuInfo.AKAHIGI_KAENHOUSHAKI.toString(), Classe.TAI,
                        155, 0, 5, 45, 179));
                jutsus.add(new Jutsu(JutsuInfo.DOKUKIRI_JIGOKU_BARIBARI_HYAKU_RENPATSU.toString(), Classe.TAI,
                        155, 9, 5, 45, 179));
                jutsus.add(new Jutsu(JutsuInfo.KONGOU_ROUHEKI.toString(), Classe.TAI,
                        143, 0, 35, 28, 165));
                jutsus.add(new Jutsu(JutsuInfo.SOUNINSHUU.toString(), Classe.TAI,
                        143, 0, 35, 28, 165));
                jutsus.add(new Jutsu(JutsuInfo.SHURIKEN_SHINKUUJIN.toString(), Classe.TAI,
                        165, 0, 35, 48, 191));
                jutsus.add(new Jutsu(JutsuInfo.KIBAKU_FUDA_NO_JUTSU.toString(), Classe.TAI,
                        165, 0, 35, 48, 191));
                jutsus.add(new Jutsu(JutsuInfo.GUNBAI_KAZE_AEKOUSHA.toString(), Classe.TAI,
                        150, 0, 35, 29, 173));
                jutsus.add(new Jutsu(JutsuInfo.SENSEI_AKAHIGI_KAENHOUSHAKI.toString(), Classe.TAI,
                        156, 0, 35, 35, 142));

                // Sannin
                jutsus.add(new Jutsu(JutsuInfo.KUMORYUU_OMOTEGIRI.toString(), Classe.TAI,
                        160, 0, 35, 22, 132));
                jutsus.add(new Jutsu(JutsuInfo.OOKAKEAMI.toString(), Classe.TAI,
                        160, 0, 35, 22, 132));
                jutsus.add(new Jutsu(JutsuInfo.CHOU_BIBURAATO_RAITONTOU.toString(), Classe.TAI,
                        181, 0, 35, 23, 140));
                jutsus.add(new Jutsu(JutsuInfo.KUNAI_SHINKUUJIN.toString(), Classe.TAI,
                        183, 0, 35, 23, 140));
                jutsus.add(new Jutsu(JutsuInfo.IAIGIRI.toString(), Classe.TAI,
                        121, 0, 35, 23, 140));
                jutsus.add(new Jutsu(JutsuInfo.HOUSENKA_TSUMABENI.toString(), Classe.TAI,
                        121, 0, 35, 23, 140));
                jutsus.add(new Jutsu(JutsuInfo.UCHIHAGAESHI.toString(), Classe.TAI,
                        121, 0, 35, 23, 140));
                jutsus.add(new Jutsu(JutsuInfo.NANATSU_BUTOUKAI_KEN_II.toString(), Classe.TAI,
                        0, -16, -9, 23, 140));
                jutsus.add(new Jutsu(JutsuInfo.NANATSU_BUTOUKAI_KEN_I.toString(), Classe.TAI,
                        -16, 0, -9, 23, 140));
                jutsus.add(new Jutsu(JutsuInfo.CHIYU_KETSUEKI.toString(), Classe.TAI,
                        195, 0, 35, 56, 225));
                jutsus.add(new Jutsu(JutsuInfo.TSUIRAKU_KABUTO.toString(), Classe.TAI,
                        195, 0, 35, 56, 225));
                jutsus.add(new Jutsu(JutsuInfo.SANDAAGEETO.toString(), Classe.TAI,
                        195, 0, 35, 56, 225));
                jutsus.add(new Jutsu(JutsuInfo.BAKUTOU_JUTSU_HAPPA_ROKUJUUSHI.toString(), Classe.TAI,
                        178, 0, 35, 34, 206));
                jutsus.add(new Jutsu(JutsuInfo.KAIHOU.toString(), Classe.TAI,
                        205, 0, 35, 59, 237));
                jutsus.add(new Jutsu(JutsuInfo.CHOUTOU_NINPOU_JIGUMO_NUI.toString(), Classe.TAI,
                        205, 0, 35, 59, 237));
                jutsus.add(new Jutsu(JutsuInfo.CHAKURAHIRU_WANIZAME.toString(), Classe.TAI,
                        185, 0, 35, 36, 213));
                jutsus.add(new Jutsu(JutsuInfo.SENSEI_CHOU_BIBURAATO_RAITONTOU.toString(), Classe.TAI,
                        191, 0, 35, 37, 221));

                jutsus.add(new Jutsu(JutsuInfo.BAKUHATSUTEKI_IAIKAI.toString(), Classe.TAI,
                        220, 0, 35, 63, 254));
                jutsus.add(new Jutsu(JutsuInfo.SENSEI_KAIHOU.toString(), Classe.TAI,
                        204, 0, 35, 39, 236));

            } else if (classe == Classe.NIN) {
                jutsus.add(new Jutsu(JutsuInfo.HENGE_NO_JUTSU.toString(), Classe.NIN,
                        16, 0, 6, 18, 6, 2));

                // Genin
                jutsus.add(new Jutsu(JutsuInfo.KONOHA_TZU.toString(), Classe.NIN,
                        20, 0, 7, 22, 2, 2));
                jutsus.add(new Jutsu(JutsuInfo.BUNSHIN_NO_JUTSU_I.toString(), Classe.NIN,
                        2, 0, 1, 22, 2));
                jutsus.add(new Jutsu(JutsuInfo.BUNSHIN_NO_JUTSU_II.toString(), Classe.NIN,
                        0, 2, 1, 22, 2));
                jutsus.add(new Jutsu(JutsuInfo.NINPOU_MUSHOU_DE_HITEI.toString(), Classe.NIN,
                        29, 0, 10, 33, 6, 2));
                jutsus.add(new Jutsu(JutsuInfo.KAGE_SHURIKEN_NO_JUTSU.toString(), Classe.NIN,
                        38, 0, 12, 44, 7));
                jutsus.add(new Jutsu(JutsuInfo.KAKUREMINO_NO_JUTSU.toString(), Classe.NIN,
                        38, 0, 12, 44, 7));
                jutsus.add(new Jutsu(JutsuInfo.KAWARIMI_NO_JUTSU.toString(), Classe.NIN,
                        44, 0, 13, 51, 9));
                jutsus.add(new Jutsu(JutsuInfo.KAGE_BUNSHIN_NO_JUTSU_I.toString(), Classe.NIN,
                        4, 0, 2, 51, 4));
                jutsus.add(new Jutsu(JutsuInfo.KAGE_BUNSHIN_NO_JUTSU_II.toString(), Classe.NIN,
                        0, 4, 2, 51, 4));
                jutsus.add(new Jutsu(JutsuInfo.SENSEI_KAGE_BUNSHIN_NO_JUTSU.toString(), Classe.NIN,
                        51, 0, 17, 59, 10));

                // Chuunin
                jutsus.add(new Jutsu(JutsuInfo.RASENGAN.toString(), Classe.NIN,
                        55, 0, 18, 62, 10));
                jutsus.add(new Jutsu(JutsuInfo.KURO_TATSUMAKI.toString(), Classe.NIN,
                        64, 0, 19, 74, 12));
                jutsus.add(new Jutsu(JutsuInfo.MEISAI_GAKURE_NO_JUTSU_I.toString(), Classe.NIN,
                        6, 0, 3, 74, 3));
                jutsus.add(new Jutsu(JutsuInfo.MEISAI_GAKURE_NO_JUTSU_II.toString(), Classe.NIN,
                        0, 6, 3, 74, 3));
                jutsus.add(new Jutsu(JutsuInfo.TAJUU_TAKI_RASENGAN.toString(), Classe.NIN,
                        73, 0, 22, 84, 14));
                jutsus.add(new Jutsu(JutsuInfo.BUNSHIN_BAKURETSU.toString(), Classe.NIN,
                        79, 0, 23, 92, 15));
                jutsus.add(new Jutsu(JutsuInfo.SENSEI_RASENGAN.toString(), Classe.NIN,
                        86, 0, 25, 99, 17));

                // jounin
                jutsus.add(new Jutsu(JutsuInfo.MIKAZUKI_NO_MAI.toString(), Classe.NIN,
                        90, 0, 30, 103, 17));
                jutsus.add(new Jutsu(JutsuInfo.TATSUMAKI_RASENGAN.toString(), Classe.NIN,
                        99, 0, 30, 114, 19));
                jutsus.add(new Jutsu(JutsuInfo.AYATSUITO_NO_JUTSU_I.toString(), Classe.NIN,
                        9, 0, 5, 114, 12));
                jutsus.add(new Jutsu(JutsuInfo.AYATSUITO_NO_JUTSU_II.toString(), Classe.NIN,
                        0, 9, 5, 114, 12));
                jutsus.add(new Jutsu(JutsuInfo.OODAMA_RASENGAN.toString(), Classe.NIN,
                        108, 0, 30, 125, 22));
                jutsus.add(new Jutsu(JutsuInfo.GOKAN_SAKUSOU.toString(), Classe.NIN,
                        114, 0, 30, 132, 21));
                jutsus.add(new Jutsu(JutsuInfo.SHIHOUHAPPOU_SHURIKEN.toString(), Classe.NIN,
                        114, 0, 35, 132, 22));
                jutsus.add(new Jutsu(JutsuInfo.SENSEI_MIKAZUKI_NO_MAI.toString(), Classe.NIN,
                        121, 0, 35, 140, 23));

                // anbu
                jutsus.add(new Jutsu(JutsuInfo.RANJI_SHIGUMI_NO_JUTSU.toString(), Classe.NIN,
                        125, 0, 30, 62, 10));
                jutsus.add(new Jutsu(JutsuInfo.TAJUU_KAGE_BUNSHIN_NO_JUTSU_I.toString(), Classe.NIN,
                        13, 0, 7, 155, 20));
                jutsus.add(new Jutsu(JutsuInfo.KAKUAN_NITTEN_SUISHU.toString(), Classe.NIN,
                        134, 0, 30, 155, 26));
                jutsus.add(new Jutsu(JutsuInfo.TAJUU_KAGE_BUNSHIN_NO_JUTSU_II.toString(), Classe.NIN,
                        0, 13, 7, 155, 20));
                jutsus.add(new Jutsu(JutsuInfo.CHOU_OODAMA_RASENGAN.toString(), Classe.NIN,
                        143, 0, 30, 165, 28));
                jutsus.add(new Jutsu(JutsuInfo.MINIRASENSHURIKEN.toString(), Classe.NIN,
                        143, 0, 30, 165, 28));
                jutsus.add(new Jutsu(JutsuInfo.NINPOU_GYORAISHIN.toString(), Classe.NIN,
                        150, 0, 35, 173, 29));
                jutsus.add(new Jutsu(JutsuInfo.SENSEI_CHOU_OODAMA_RASENGAN.toString(), Classe.NIN,
                        156, 0, 35, 180, 30));

                // sanin
                jutsus.add(new Jutsu(JutsuInfo.SENPOU_OODAMA_RASENGAN.toString(), Classe.NIN,
                        160, 0, 30, 184, 31));
                jutsus.add(new Jutsu(JutsuInfo.CHOU_OODAMA_RASEN_TARENGAN.toString(), Classe.NIN,
                        160, 0, 30, 184, 31));
                jutsus.add(new Jutsu(JutsuInfo.REIKA_NO_JUTSU.toString(), Classe.NIN,
                        169, 0, 30, 195, 33));
                jutsus.add(new Jutsu(JutsuInfo.HIRAISHIN_NO_JUTSU_I.toString(), Classe.NIN,
                        16, 0, 9, 195, 16));
                jutsus.add(new Jutsu(JutsuInfo.RASENKYUUGAN.toString(), Classe.NIN,
                        169, 6, 3, 195, 33));
                jutsus.add(new Jutsu(JutsuInfo.HIRAISHIN_NO_JUTSU_II.toString(), Classe.NIN,
                        16, 0, 9, 195, 16));
                jutsus.add(new Jutsu(JutsuInfo.WAKUSEI_RASENGAN.toString(), Classe.NIN,
                        178, 0, 30, 206, 33));
                jutsus.add(new Jutsu(JutsuInfo.OYAKO_RASENGAN.toString(), Classe.NIN,
                        185, 0, 35, 213, 36));
                jutsus.add(new Jutsu(JutsuInfo.SENSEI_HIRAISHIN_NO_JUTSU.toString(), Classe.NIN,
                        191, 0, 30, 221, 37));

                // hero
                jutsus.add(new Jutsu(JutsuInfo.SENSEI_OYAKO_RASENGAN.toString(), Classe.NIN,
                        204, 0, 30, 236, 39));

            } else { // mClasseSelected == GEN
                jutsus.add(new Jutsu(JutsuInfo.KISHIBARI_NO_JUTSU.toString(), Classe.GEN,
                        16, 0, 6, 18, 6, 2));

                jutsus.add(new Jutsu(JutsuInfo.KASUMI_JUUHA_NO_JUTSU.toString(), Classe.GEN,
                        20, 0, 7, 22, 2, 2));
                jutsus.add(new Jutsu(JutsuInfo.NEMURI_I.toString(), Classe.GEN,
                        -2, 0, -1, 22, 2));
                jutsus.add(new Jutsu(JutsuInfo.NEMURI_II.toString(), Classe.GEN,
                        0, -2, -1, 22, 2));
                jutsus.add(new Jutsu(JutsuInfo.KOKOROYORU_NO_JUTSU.toString(), Classe.GEN,
                        29, 0, 10, 33, 6, 2));
                jutsus.add(new Jutsu(JutsuInfo.TAZUNERU_NO_JUTSU.toString(), Classe.GEN,
                        38, 0, 12, 44, 7));
                jutsus.add(new Jutsu(JutsuInfo.BAKUON_NO_JUTSU.toString(), Classe.GEN,
                        38, 0, 12, 44, 7));
                jutsus.add(new Jutsu(JutsuInfo.UTSUSEMI_NO_JUTSU.toString(), Classe.GEN,
                        44, 0, 13, 51, 9));
                jutsus.add(new Jutsu(JutsuInfo.HANA_KYOUKA_SAI_I.toString(), Classe.GEN,
                        -4, 0, -2, 51, 4));
                jutsus.add(new Jutsu(JutsuInfo.HANA_KYOUKA_SAI_II.toString(), Classe.GEN,
                        0, -4, -2, 51, 4));
                jutsus.add(new Jutsu(JutsuInfo.SENSEI_HANA_KYOUKA_SAI.toString(), Classe.GEN,
                        51, 0, 17, 59, 10));

                // Chuunin
                jutsus.add(new Jutsu(JutsuInfo.NINPOU_HYAKKA_RYORAN.toString(), Classe.GEN,
                        55, 0, 18, 62, 10));
                jutsus.add(new Jutsu(JutsuInfo.KORI_SHINCHUU_NO_JUTSU.toString(), Classe.GEN,
                        64, 0, 19, 74, 12));
                jutsus.add(new Jutsu(JutsuInfo.MAGEN_NARAKUMI_NO_JUTSU_I.toString(), Classe.GEN,
                        -6, 0, -3, 74, 3));
                jutsus.add(new Jutsu(JutsuInfo.MAGEN_NARAKUMI_NO_JUTSU_II.toString(), Classe.GEN,
                        0, -6, -3, 74, 3));
                jutsus.add(new Jutsu(JutsuInfo.OTO_NO_GEN.toString(), Classe.GEN,
                        73, 0, 22, 84, 14));
                jutsus.add(new Jutsu(JutsuInfo.KOKOHI_NO_JUTSU.toString(), Classe.GEN,
                        79, 0, 23, 92, 15));
                jutsus.add(new Jutsu(JutsuInfo.SENSEI_OTO_NO_GEN.toString(), Classe.GEN,
                        86, 0, 25, 99, 17));

                // Jounin
                jutsus.add(new Jutsu(JutsuInfo.AN_NO_GENJUTSU.toString(), Classe.GEN,
                        90, 0, 30, 62, 10));
                jutsus.add(new Jutsu(JutsuInfo.KARASU_NO_GENJUTSU.toString(), Classe.GEN,
                        99, 0, 30, 74, 12));
                jutsus.add(new Jutsu(JutsuInfo.MAGEN_KOKUNI_ARAZU_NO_JUTSU_I.toString(), Classe.GEN,
                        -9, 0, -5, 114, 12));
                jutsus.add(new Jutsu(JutsuInfo.MAGEN_KOKUNI_ARAZU_NO_JUTSU_II.toString(), Classe.GEN,
                        0, -9, -5, 114, 12));
                jutsus.add(new Jutsu(JutsuInfo.NEHAN_SHOUJA_NO_JUTSU.toString(), Classe.GEN,
                        108, 0, 30, 125, 22));
                jutsus.add(new Jutsu(JutsuInfo.MATEKI_MUGEN_ONKI.toString(), Classe.GEN,
                        114, 0, 30, 132, 21));
                jutsus.add(new Jutsu(JutsuInfo.HYAKKA_NINPOU_HANACHIRI_NUKO.toString(), Classe.GEN,
                        114, 0, 35, 132, 22));
                jutsus.add(new Jutsu(JutsuInfo.SENSEI_KOKOHI_DEBOA.toString(), Classe.GEN,
                        121, 0, 35, 140, 23));

                // ANBU
                jutsus.add(new Jutsu(JutsuInfo.YUBI_NO_GENJUTSU.toString(), Classe.GEN,
                        125, 0, 30, 143, 24));
                jutsus.add(new Jutsu(JutsuInfo.GENJUTSU_NO_KIRI_I.toString(), Classe.GEN,
                        -13, 0, -7, 155, 20));
                jutsus.add(new Jutsu(JutsuInfo.RAIGEN_RAIKOUCHUU.toString(), Classe.GEN,
                        134, 0, -3, 155, 26));
                jutsus.add(new Jutsu(JutsuInfo.GENJUTSU_NO_KIRI_II.toString(), Classe.GEN,
                        0, -13, -7, 155, 20));
                jutsus.add(new Jutsu(JutsuInfo.MAGEN_KASEGUI_NO_JUTSU.toString(), Classe.GEN,
                        143, 0, 30, 165, 28));
                jutsus.add(new Jutsu(JutsuInfo.MUGEN_MAROU.toString(), Classe.GEN,
                        143, 0, 30, 165, 28));
                jutsus.add(new Jutsu(JutsuInfo.SHINU_NO_GENJUTSU.toString(), Classe.GEN,
                        150, 0, 35, 173, 29));
                jutsus.add(new Jutsu(JutsuInfo.SENSEI_MATEKI_MUGEN_ONKI.toString(), Classe.GEN,
                        156, 0, 35, 180, 30));

                // Sannin
                jutsus.add(new Jutsu(JutsuInfo.MAGEN_GAMARINSHOU.toString(), Classe.GEN,
                        160, 0, 30, 184, 31));
                jutsus.add(new Jutsu(JutsuInfo.HANA_NINPOU_BAKUHATSU_KEMURI_NO_HANABIRA.toString(), Classe.GEN,
                        160, 0, 30, 184, 31));
                jutsus.add(new Jutsu(JutsuInfo.GENJUTSU_SHIBARI.toString(), Classe.GEN,
                        169, 0, -3, 195, 33));
                jutsus.add(new Jutsu(JutsuInfo.UTAKATA_I.toString(), Classe.GEN,
                        -16, 0, -9, 195, 16));
                jutsus.add(new Jutsu(JutsuInfo.KOKOHI_TATAKAI.toString(), Classe.GEN,
                        169, 0, 30, 195, 33));
                jutsus.add(new Jutsu(JutsuInfo.UTAKATA_II.toString(), Classe.GEN,
                        0, -16, -9, 195, 16));
                jutsus.add(new Jutsu(JutsuInfo.KOBURABIJON_ITO_SASSHIN.toString(), Classe.GEN,
                        178, 0, 35, 206, 33));
                jutsus.add(new Jutsu(JutsuInfo.SHIRANO.toString(), Classe.GEN,
                        185, 0, 35, 213, 36));
                jutsus.add(new Jutsu(JutsuInfo.SENSEI_MAGEN_KASEGUI_NO_JUTSU.toString(), Classe.GEN,
                        191, 0, 35, 221, 37));

                // Hero
                jutsus.add(new Jutsu(JutsuInfo.SENSEI_GENJUTSU_NO_KIRI.toString(), Classe.GEN,
                        204, 0, 35, 236, 39));
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

    private void sort(Collection<Jutsu> jutsus) {

    }
}
