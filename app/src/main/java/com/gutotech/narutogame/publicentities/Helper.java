package com.gutotech.narutogame.publicentities;

public class Helper {

    public static boolean isValidIdProfile(int idProfile) {
        if (((
                idProfile >= 5 && idProfile <= 41) ||
                idProfile == 45 ||
                idProfile == 48 ||
                idProfile == 49 ||
                idProfile == 68 ||
                idProfile == 82 ||
                idProfile == 83 ||
                idProfile == 92 ||
                idProfile == 93 ||
                idProfile == 96 ||
                idProfile == 97 ||
                (idProfile >= 106 && idProfile <= 108) ||
                idProfile == 114 || // tirei
                idProfile == 124 || // tirei
                idProfile == 128 ||
                idProfile == 130 ||
                idProfile == 133 ||
                idProfile == 134 ||
                idProfile == 135 || // tirei
                idProfile == 144 || // tirei
                idProfile == 145 ||
                idProfile == 146 ||
                idProfile == 148 ||
                idProfile == 150 ||
                idProfile == 152 ||
                idProfile == 154 ||
                idProfile == 156 || // tirei
                idProfile == 157 || // tirei
                idProfile == 158 ||
                idProfile == 159 ||
                idProfile == 162  // tirei
        ))
            return false;

        return true;
    }

    public static String nomeDoPersonagem(int idProfile) {
        switch (idProfile) {
            case 1:
                return "Naruto Uzumaki";
            case 2:
                return "Sasuke Uchiha";
            case 3:
                return "Rock Lee";
            case 4:
                return "Sabaku no Gaara";
            case 42:
                return "Sakura Haruno";
            case 43:
                return "Zabuza Momochi";
            case 44:
                return "Haku";
            case 46:
                return "Kankurou";
            case 47:
                return "Temari";
            case 50:
                return "Suzumebachi Kamizuru";
            case 51:
                return "Yugito Nii";
            case 52:
                return "Deidara";
            case 53:
                return "Akasuna no Sasori";
            case 54:
                return "Kisame Hoshigaki";
            case 55:
                return "Itachi Uchiha";
            case 56:
                return "Tenten";
            case 57:
                return "Neji Hyuuga";
            case 58:
                return "Shino Aburame";
            case 59:
                return "Ino Yamanaka";
            case 60:
                return "Kakashi Hataki";
            case 61:
                return "Maito Gai";
            case 62:
                return "Shikamaru Nara";
            case 63:
                return "Jiraiya";
            case 64:
                return "Zaku Abumi";
            case 65:
                return "Baki";
            case 66:
                return "Ebisu";
            case 67:
                return "Hayate Gekkou";
            case 69:
                return "Hinata Hyuuga";
            case 70:
                return "Jiroubou";
            case 71:
                return "Kimimaro Kaguya";
            case 72:
                return "Kidoumaru";
            case 73:
                return "Konohamaru Sarutobi";
            case 74:
                return "Dosu Kinuta";
            case 75:
                return "Tobirama Senju";
            case 76:
                return "Orochimaru";
            case 77:
                return "Sakon e Ukon";
            case 78:
                return "Hashirama Senju";
            case 79:
                return "Asuma Sarutobi";
            case 80:
                return "Genma Shiranui";
            case 81:
                return "Shizune";
            case 84:
                return "Minato Namikaze";
            case 85:
                return "Zetsu";
            case 86:
                return "Ibiki Morino";
            case 87:
                return "Anko Mitarashi";
            case 88:
                return "Tayuya";
            case 89:
                return "Tsuchi Kin";
            case 90:
                return "Obito Uchiha";
            case 91:
                return "Kurenai Yuuhi";
            case 94:
                return "Chouji Akimichi";
            case 95:
                return "Kiba Inuzuka";
            case 98:
                return "Iruka Umino";
            case 99:
                return "Sai";
            case 100:
                return "Yamato";
            case 101:
                return "Kabuto Yakushi";
            case 102:
                return "Tsunade Senju";
            case 103:
                return "Pein Tendo";
            case 104:
                return "Tobi";
            case 105:
                return "Hidan";
            case 109:
                return "Kakuzu";
            case 110:
                return "Hiruzen Sarutobi";
            case 111:
                return "Sora";
            case 112:
                return "Rin Nohara";
            case 113:
                return "Konan";
            case 115:
                return "Guren";
            case 116:
                return "Juugo";
            case 117:
                return "Karin Uzumaki";
            case 118:
                return "Suigetsu Hoozuki";
            case 119:
                return "Killer Bee";
            case 120:
                return "Chiyo";
            case 121:
                return "Kakashi Jovem";
            case 122:
                return "Madara Uchiha";
            case 123:
                return "Chouza Akimichi";
            case 125:
                return "Ei";
            case 126:
                return "Kushina Uzumaki";
            case 127:
                return "Sakumo Hatake";
            case 129:
                return "Danzou Shimura";
            case 131:
                return "Hanabi Hyuuga";
            case 132:
                return "Hiashi Hyuuga";
            case 136:
                return "Inoichi Yamanaka";
            case 137:
                return "Nagato Uzumaki";
            case 138:
                return "Yahiko";
            case 139:
                return "Shikaku Nara";
            case 140:
                return "Mei Terumii";
            case 141:
                return "Oonoki";
            case 142:
                return "Yagura";
            case 143:
                return "Utakata";
            case 147:
                return "Shibi Aburame";
            case 151:
                return "Rikudou Sennin";
            case 155:
                return "Omoi";
            case 160:
                return "Pein Chikushodo";
            case 161:
                return "Pein Gakido";
            case 164:
                return "Pein Jigokudo";
            case 166:
                return "Pein Chikushodo";
            case 167:
                return "Mizuki Touji";
            case 168:
                return "Pein Ningendo";
            case 171:
                return "Pein Shurado";
            case 173:
                return "Darui";
            case 176:
                return "Dan Katou";
            case 185:
                return "Nawaki Senju";
            case 184:
                return "Moegi";
            case 188:
                return "Udon";
            case 203:
                return "Fuu";
            case 209:
                return "Mangetsu Hoozuki";
            case 211:
                return "Ensui Nara";
            case 212:
                return "Izuna Uchiha";
            case 221:
                return "Menma Uzumaki";
            case 230:
                return "Yukimaru";
            case 231:
                return "Mikoto Uchiha";
            case 235:
                return "Boruto Uzumaki";
            case 236:
                return "Sarada Uchiha";
            case 237:
                return "Mitsuki";
            case 245:
                return "Inojin Yamanaka";
            case 246:
                return "Shikadai Nara";
            case 247:
                return "Chouchou Akimichi";
            case 248:
                return "Metal Lee";
            case 249:
                return "Himawari Uzumaki";
            case 259:
                return "Ashura Ootsutsuki";
            case 260:
                return "Indra Ootsutsuki";
            case 261:
                return "Iwabee Yuino";
            case 265:
                return "Sumire";
            default:
                return null;
        }
    }

    public static int quantasImagens(int idProfile) {
        switch (idProfile) {
            case 1:
                return 20; // 200
            case 2:
                return 20; // 215
            case 3:
                return 20; // 44
            case 4:
                return 10; // 83
            case 42:
                return 10; // 97
            case 43:
                return 16;
            case 44:
                return 16;
            case 46:
                return 36;
            case 47:
                return 34;
            case 50:
                return 4;
            case 51:
                return 18;
            case 52:
                return 62;
            case 53:
                return 51;
            case 54:
                return 31;
            case 55:
                return 86;
            case 56:
                return 31;
            case 57:
                return 29;
            case 58:
                return 21;
            case 59:
                return 41;
            case 60:
                return 69;
            case 61:
                return 2;
            case 62:
                return 2;
            case 63:
                return 2;
            case 64:
                return 2;
            case 65:
                return 2;
            case 66:
                return 2;
            case 67:
                return 2;
            case 69:
                return 2;
            case 70:
                return 2;
            case 71:
                return 2;
            case 72:
                return 2;
            case 73:
                return 2;
            case 74:
                return 2;
            case 75:
                return 2;
            case 76:
                return 2;
            case 77:
                return 2;
            case 78:
                return 2;
            case 79:
                return 2;
            case 80:
                return 2;
            case 81:
                return 2;
            case 84:
                return 2;
            case 85:
                return 2;
            case 86:
                return 2;
            case 87:
                return 2;
            case 88:
                return 2;
            case 89:
                return 2;
            case 90:
                return 2;
            case 91:
                return 2;
            case 94:
                return 2;
            case 95:
                return 2;
            case 98:
                return 2;
            case 99:
                return 2;
            case 100:
                return 2;
            case 101:
                return 2;
            case 102:
                return 2;
            case 103:
                return 2;
            case 104:
                return 74;
            case 105:
                return 2;
            case 109:
                return 2;
            case 110:
                return 2;
            case 111:
                return 2;
            case 112:
                return 2;
            case 113:
                return 2;
            case 115:
                return 2;
            case 116:
                return 2;
            case 117:
                return 2;
            case 118:
                return 2;
            case 119:
                return 2;
            case 120:
                return 2;
            case 121:
                return 2;
            case 122:
                return 55;
            case 123:
                return 2;
            case 125:
                return 2;
            case 126:
                return 2;
            case 129:
                return 2;
            case 127:
                return 2;
            case 131:
                return 2;
            case 132:
                return 2;
            case 136:
                return 2;
            case 137:
                return 2;
            case 138:
                return 2;
            case 139:
                return 2;
            case 140:
                return 2;
            case 141:
                return 2;
            case 142:
                return 2;
            case 143:
                return 2;
            case 147:
                return 2;
            case 151:
                return 2;
            case 155:
                return 2;
            case 160:
                return 2;
            case 161:
                return 2;
            case 164:
                return 2;
            case 166:
                return 2;
            case 167:
                return 2;
            case 168:
                return 2;
            case 171:
                return 2;
            case 173:
                return 2;
            case 176:
                return 2;
            case 185:
                return 2;
            case 184:
                return 2;
            case 188:
                return 2;
            case 203:
                return 2;
            case 209:
                return 2;
            case 211:
                return 2;
            case 212:
                return 2;
            case 221:
                return 2;
            case 230:
                return 2;
            case 231:
                return 2;
            case 235:
                return 2;
            case 236:
                return 2;
            case 237:
                return 2;
            case 245:
                return 2;
            case 246:
                return 2;
            case 247:
                return 2;
            case 248:
                return 2;
            case 249:
                return 2;
            case 259:
                return 3;
            case 260:
                return 4;
            case 261:
                return 5;
            case 265:
                return 5;
            default:
                return -1;
        }
    }

}
