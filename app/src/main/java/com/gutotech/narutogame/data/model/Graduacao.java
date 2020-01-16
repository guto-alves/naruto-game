package com.gutotech.narutogame.data.model;

public class Graduacao {
    private int idGraducao;

    public Graduacao() {
    }

    public Graduacao(int idGraducao) {
        this.idGraducao = idGraducao;
    }

    public int getIdGraducao() {
        return idGraducao;
    }

    public void setIdGraducao(int idGraducao) {
        this.idGraducao = idGraducao;
    }

    public static String getGraducao(int idGraducao) {
        String vila = PersonagemOn.character.getVillage().name;

//        if (vila.equals(Vila.FOLHA)) {
//            switch (idGraducao) {
//                case 0:
//                    return "Estudante";
//                case 1:
//                    return "Genin";
//                case 2:
//                    return "Chuunin";
//                case 3:
//                    return "Jounin";
//                case 4:
//                    return "ANBU";
//                case 5:
//                    return "Sannin da Folha";
//                case 6:
//                    return "Herói";
//            }
//        } else if (vila.equals(Vila.AREIA)) {
//            switch (idGraducao) {
//                case 0:
//                    return "Estudante";
//                case 1:
//                    return "Genin";
//                case 2:
//                    return "Chuunin";
//                case 3:
//                    return "Jounin";
//                case 4:
//                    return "ANBU";
//                case 5:
//                    return "Sannin da Folha";
//                case 6:
//                    return "Herói";
//            }
//        } else if (vila.equals(Vila.NEVOA)) {
//            switch (idGraducao) {
//                case 0:
//                    return "Estudante";
//                case 1:
//                    return "Genin";
//                case 2:
//                    return "Chuunin";
//                case 3:
//                    return "Jounin";
//                case 4:
//                    return "ANBU";
//                case 5:
//                    return "Caçador da Névoa";
//                case 6:
//                    return "Herói";
//            }
//        } else if (vila.equals(Vila.PEDRA)) {
//            switch (idGraducao) {
//                case 0:
//                    return "Estudante";
//                case 1:
//                    return "Genin";
//                case 2:
//                    return "Chuunin";
//                case 3:
//                    return "Jounin";
//                case 4:
//                    return "ANBU";
//                case 5:
//                    return "Caçador da Pedra";
//                case 6:
//                    return "Herói";
//            }
//        } else if (vila.equals(Vila.NUVEM)) {
//            switch (idGraducao) {
//                case 0:
//                    return "Estudante";
//                case 1:
//                    return "Genin";
//                case 2:
//                    return "Chuunin";
//                case 3:
//                    return "Jounin";
//                case 4:
//                    return "ANBU";
//                case 5:
//                    return "Capitão da Nuvem";
//                case 6:
//                    return "Herói";
//            }
//        } else if (vila.equals(Vila.AKATSUKI)) {
//            switch (idGraducao) {
//                case 0:
//                    return "Fugitivo";
//                case 1:
//                    return "Nukenin D";
//                case 2:
//                    return "Nukenin C";
//                case 3:
//                    return "Nukenin B";
//                case 4:
//                    return "Nukenin A";
//                case 5:
//                    return "Caçador de Recompensas";
//                case 6:
//                    return "Vilão";
//            }
//        } else if (vila.equals(Vila.SOM)) {
//            switch (idGraducao) {
//                case 0:
//                    return "Cobaia";
//                case 1:
//                    return "Genin";
//                case 2:
//                    return "Chuunin";
//                case 3:
//                    return "Jounin";
//                case 4:
//                    return "ANBU";
//                case 5:
//                    return "Cientista do Som";
//                case 6:
//                    return "Amaldiçoado";
//            }
//        } else if (vila.equals(Vila.CHUVA)) {
//            switch (idGraducao) {
//                case 0:
//                    return "Órfão";
//                case 1:
//                    return "Genin";
//                case 2:
//                    return "Chuunin";
//                case 3:
//                    return "Jounin";
//                case 4:
//                    return "ANBU";
//                case 5:
//                    return "Guardião da Chuva";
//                case 6:
//                    return "Deus";
//            }
//        }

        return null;
    }

    public static String getDescricao(int idGraducao) {
//        String vila = PersonagemOn.character.getVillage();
//
//        if (vila.equals("Folha") || vila.equals("Areia") || vila.equals("Névoa") || vila.equals("Pedra") || vila.equals("Nuvem") || vila.equals("Som") || vila.equals("Chuva")) {
//            switch (idGraducao) {
//                case 1:
//                    return "Seu primeiro dia depois da academia ninja, hoje você vai receber sua bandana e graduar-se com um ninja da aldeia. Com esta graduação é possível explorar o que esta além do portão da Vila, combater inimigos, fazer aliados, executar diferentes tipos de missões, aprender golpes básicos e ajudar a proteger sua vila. Não se esqueça de continuar o seu treinamento para assim alcançar a próxima graduação.";
//                case 2:
//                    return "Ninja graduado e com elevado nível de confiança na Vila, possui grande conhecimento na arte ninja e possui habilidades como controlar o primeiro elemento, fazer missões mais arriscadas Rank C, pode participar de equipes e organizações e participar dos torneios ninjas.";
//                case 3:
//                    return "Ninja com grande nível de conhecimento sobre a arte ninja e batalhas, possui diversas especialidades como controlar o segundo elemento, fazer missões mais perigosas de nível Rank B, pode ser responsável por uma Organização e pode também participar de diversos torneios entre jounins.";
//                case 4:
//                    return "São conhecidos como Caçadores Especiais ANBU, ou (Esquadrão Especial de Assassinato e Tática). Tornar-se um ANBU é ter o reconhecimento de ser um ninja respeitável dentro de sua Vila. Pode aprender diversos golpes diferentes, fazer missões de nível A, pode participar de torneios e eventos, pode aprender o ultimo nível do selo ou mode sennin.";
//                case 5:
//                    return "São ninjas extraordinários, ninjas capazes de usar uma quantidade muito grande de jutsus e levar uma batalha há durar muito tempo. Podem aprender a última habilidade de clã e invocação, participar de torneios, liderar equipes e organizações a invadirem e guerrear contra outras Vilas, é o único capaz de realizar missões de nível S e os mais próximos de se tornarem Kages.";
//                case 6:
//                    return "Todo ninja sonha em se tornar um Herói. Uma pessoa conhecida e adorada por todas as pessoas da vila, e muitas vezes mundialmente conhecidas. Heróis podem fazer todos os tipos de missões, tem o maior número de habilidades Ninjutsu, Taijutsu, Genjutsu treinadas. Realiza missões S ou SS que são as mais arriscadas e defendem a Vila com todas as forças e caso necessário com a própria Vida.";
//            }
//        } else if (vila.equals("Akatsuki")) {
//            switch (idGraducao) {
//                case 1:
//                    return "Você começa a roubar vilas e fazendeiros, e se torna um procurado rank D.";
//                case 2:
//                    return "Com suas habilidades aprimoradas, você começa a sentir o poder e a insanidade dentro de você, sendo capaz de fazer alguns assassinatos se preciso.";
//                case 3:
//                    return "Equivalente à força de um Jounin, você se torna mais habilidoso e capaz de controlar dois elementos com perfeição, destruindo vilas inteiras.";
//                case 4:
//                    return "São movidos pela escuridão, agindo sorrateiramente e matando todos que entrarem em seu caminho. É capaz de rastrear alvos, assim como os ANBUs.";
//                case 5:
//                    return "Tão forte quanto um Sannin, se tornando praticamente o renegado mais forte da Akatsuki. Sua cabeça é procurada em todas as vilas, com uma recompensa altíssima.";
//                case 6:
//                    return "É o ninja mais forte da Akatsuki, seus conhecimentos e poder não se comparam a nenhuma outra graduação. Para se tornar um Líder, o ninja precisa passar por todas as graduações e ainda assim se tornar o melhor entre os melhores. Podem fazer todos os tipos de missões, tem o maior número de habilidades Ninjutsu, Taijutsu e Genjutsu treinadas. Realiza missões S ou SS que são as mais arriscadas e defendem a Akatsuki com todas as forças e caso necessário com a própria vida.";
//            }
//        }

        return null;
    }
}
