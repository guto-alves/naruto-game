package com.gutotech.narutogame.data.model;

import androidx.annotation.NonNull;

public enum Ninja {
    NARUTO(1, "Naruto Uzumaki", 200),
    SASUKE(2, "Sasuke Uchiha", 215),
    ROCK_LEE(3, "Rock Lee", 44),
    GAARA(4, "Sabaku no Gaara", 83),
    SAKURA(42, "Sakura Haruno", 97),
    ZABUZA(43, "Zabuza Momochi", 16),
    HAKU(44, "Haku", 16),
    KANKURO(46, "Kankurou", 36),
    TEMARI(47, "Temari", 35),
    SUZUMEBACHI(50, "Suzumebachi Kamizuru", 4),
    YUGITO(51, "Yugito Nii", 18),
    DEIDARA(52, "Deidara", 62),
    AKASUNA_SASORI(53, "Akasuna no Sasori", 51),
    KISAME(54, "Kisame Hoshigaki", 32),
    ITACHI(55, "Itachi Uchiha", 86),
    TENTEN(56, "Tenten", 31),
    NEJI(57, "Neji Hyuuga", 29),
    SHINO(58, "Shino Aburame", 21),
    INO(59, "Ino Yamanaka", 41),
    KAKASHI(60, "Kakashi Hataki", 69),
    GAI(61, "Maito Gai", 29),
    SHIKAMARU(62, "Shikamaru Nara", 34),
    JIRAIYA(63, "Jiraiya", 45),
    ZAKU(64, "Zaku Abumi", 8),
    BAKI(65, "Baki", 3),
    EBISU(66, "Ebisu", 5),
    HAYATE(67, "Hayate Gekkou", 6),
    HINATA(69, "Hinata Hyuuga", 52),
    JIROUBOU(70, "Jiroubou", 9),
    KIMIMARO(71, "Kimimaro Kaguya", 17),
    KIDOMARU(72, "Kidoumaru", 10),
    KONOHAMARU(73, "Konohamaru Sarutobi", 16),
    DOSU(74, "Dosu Kinuta", 5),
    TOBIRAMA(75, "Tobirama Senju", 31),
    OROCHIMARU(76, "Orochimaru", 46),
    SAKON_UKON(77, "Sakon e Ukon", 10),
    HASHIRAMA(78, "Hashirama Senju", 30),
    ASUMA(79, "Asuma Sarutobi", 23),
    GENMA(80, "Genma Shiranui", 2),
    SHIZUNE(81, "Shizune", 15),
    MINATO(84, "Minato Namikaze", 63),
    ZETSU(85, "Zetsu", 18),
    IBIKI(86, "Ibiki Morino", 2),
    ANKO(87, "Anko Mitarashi", 11),
    TAYUYA(88, "Tayuya", 17),
    TSUCHI(89, "Tsuchi Kin", 3),
    OBITO(90, "Obito Uchiha", 24),
    KURENAI(91, "Kurenai Yuuhi", 24),
    CHOUJI(94, "Chouji Akimichi", 34),
    KIBA(95, "Kiba Inuzuka", 35),
    IRUKA(98, "Iruka Umino", 12),
    SAY(99, "Sai", 32),
    YAMATO(100, "Yamato", 19),
    KABUTO(101, "Kabuto Yakushi", 48),
    TSUNADE(102, "Tsunade Senju", 41),
    PEIN(103, "Pein Tendo", 27),
    TOBI(104, "Tobi", 74),
    HIDAN(105, "Hidan", 32),
    KAZUZU(109, "Kakuzu", 23),
    SARUTOBI(110, "Hiruzen Sarutobi", 23),
    SORA(111, "Sora", 4),
    RIN(112, "Rin Nohara", 10),
    KONAN(113, "Konan", 34),
    GUREN(115, "Guren", 5),
    JUUGO(116, "Juugo", 20),
    KARIN(117, "Karin Uzumaki", 22),
    SUIGETSU(118, "Suigetsu Hoozuki", 18),
    KILLER_BEE(119, "Killer Bee", 36),
    CHIYOU(120, "Chiyo", 17),
    KAKASHI_JOVEM(121, "Kakashi Jovem", 26),
    MADARA(122, "Madara Uchiha", 55),
    CHOUZA(123, "Chouza Akimichi", 2),
    EI(125, "Ei", 22),
    KUSHINA(126, "Kushina Uzumaki", 22),
    SAKUMO(127, "Sakumo Hatake", 6),
    DANZOU(129, "Danzou Shimura", 16),
    HANABI(131, "Hanabi Hyuuga", 10),
    HIASHI(132, "Hiashi Hyuuga", 6),
    INOICHI(136, "Inoichi Yamanaka", 3),
    NAGATO(137, "Nagato Uzumaki", 29),
    YAHIKO(138, "Yahiko", 12),
    SHIKAKU(139, "Shikaku Nara", 3),
    MEI(140, "Mei Terumii", 21),
    OONOKI(141, "Oonoki", 22),
    YAGURA(142, "Yagura", 13),
    UTAKATA(143, "Utakata", 16),
    SHIBI(147, "Shibi Aburame", 4),
    RIKUDOU(151, "Rikudou Sennin", 9),
    OMOI(155, "Omoi", 11),
    PEIN_CHIKUSHODO1(160, "Pein Chikushodo", 8),
    PEIN_GAKIDO(161, "Pein Gakido", 6),
    PEIN_JIGOKUDO(164, "Pein Jigokudo", 7),
    PEIN_CHIKUSHODO2(166, "Pein Chikushodo", 5),
    MIZUKI(167, "Mizuki Touji", 5),
    PEIN_NINGENDO(168, "Pein Ningendo", 6),
    PEIN_SHURADO(171, "Pein Shurado", 9),
    DARUI(173, "Darui", 16),
    DAN(176, "Dan Katou", 5),
    MOEGI(184, "Moegi", 5),
    NAWAKI(185, "Nawaki Senju", 4),
    UDON(188, "Udon", 5),
    FUU(203, "Fuu", 15),
    MANGETSU(209, "Mangetsu Hoozuki", 9),
    ENSUI(211, "Ensui Nara", 3),
    IZUNA(212, "Izuna Uchiha", 5),
    MENMA(221, "Menma Uzumaki", 11),
    YUKIMARU(230, "Yukimaru", 2),
    MIKOTO(231, "Mikoto Uchiha", 2),
    BORUTO(235, "Boruto Uzumaki", 30),
    SARADA(236, "Sarada Uchiha", 13),
    MITSUKI(237, "Mitsuki", 7),
    KAGUYA(238, "Kaguya Ootsutsuki", 2),
    SHIRA(240, "Shira", 6),
    INOJIN(245, "Inojin Yamanaka", 7),
    SHIKADI(246, "Shikadai Nara", 2),
    CHOUCHOU(247, "Chouchou Akimichi", 5),
    METAL(248, "Metal Lee", 5),
    HIMAWARI(249, "Himawari Uzumaki", 4),
    ASHURA(259, "Ashura Ootsutsuki", 3),
    INDRA(260, "Indra Ootsutsuki", 4),
    IWABEE(261, "Iwabee Yuino", 5),
    SUMIRE(265, "Sumire", 5);

    private final int id;
    private final String name;
    private final int totalProfiles;

    Ninja(int id, String name, int totalProfiles) {
        this.id = id;
        this.name = name;
        this.totalProfiles = totalProfiles;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getTotalProfiles() {
        return totalProfiles;
    }

    @NonNull
    @Override
    public String toString() {
        return name;
    }
}
