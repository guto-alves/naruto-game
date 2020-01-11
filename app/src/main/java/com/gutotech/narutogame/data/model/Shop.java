package com.gutotech.narutogame.data.model;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    private List<ItemShop> itensList;

    public Shop() {
        itensList = new ArrayList<>();
    }

    public List<ItemShop> getRamens() {
        itensList.clear();

        itensList.add(new Ramen("nissin", "Merenda Ninja",
                "Super macarrão reforçado para uso nos intervalos das tarefas ninjas",
                25, ItemShop.TipoPgto.RYOUS, 0, 1, 100));

        itensList.add(new Ramen("ramen", "Misso Gyoza-Ramen",
                "Ramen de frutos do mar, com pasta de soja",
                35, ItemShop.TipoPgto.RYOUS, 1, 5, 150));

        itensList.add(new Ramen("ramen_duplo", "Shoyu Gyoza-Ramen",
                "Ramen de frutos do mar, temperado especialmente com molho de soja",
                70, ItemShop.TipoPgto.RYOUS, 1, 10, 300));

        itensList.add(new Ramen("ramen_g", "Shio Gyoza-Ramen",
                "Ramen de frutos do mar, temperado com sal",
                105, ItemShop.TipoPgto.RYOUS, 2, 15, 450));

        itensList.add(new Ramen("Shio_Tyashu-Ramen", "Shio Tyashu-Ramen",
                "Ramen com carne de porco, temperado com sal",
                140, ItemShop.TipoPgto.RYOUS, 2, 20, 600));

        itensList.add(new Ramen("Shoyu_Tyashu-Ramen", "Shoyu Tyashu-Ramen ",
                "Ramen com carne de porco, temperado com sal",
                175, ItemShop.TipoPgto.RYOUS, 3, 25, 750));

        itensList.add(new Ramen("Misso_Tyashu-Ramen", "Misso Tyashu-Ramen",
                "Ramen com carne de porco, acompanhando pasta de soja",
                210, ItemShop.TipoPgto.RYOUS, 3, 30, 900));

        itensList.add(new Ramen("Shio_Yasai-Ramen", "Shio Yasai-Ramen",
                "Ramen com carne de porco, acompanhando pasta de soja",
                245, ItemShop.TipoPgto.RYOUS, 4, 35, 1050));

        itensList.add(new Ramen("Shoyu_Yasai-Ramen", "Shoyu Yasai-Ramen",
                "Ramen de verduras e legumes, com pasta de soja",
                315, ItemShop.TipoPgto.RYOUS, 4, 40, 1200));

        itensList.add(new Ramen("Misso_Yasai-Ramen", "Misso Yasai-Ramen",
                "amen de camarão, temperado especialmente com molho de soja",
                315, ItemShop.TipoPgto.RYOUS, 5, 45, 1350));

        itensList.add(new Ramen("Shio_Ebi-Ramen", "Shio Ebi-Ramen ",
                "amen de camarão, temperado especialmente com molho de soja",
                350, ItemShop.TipoPgto.RYOUS, 5, 50, 1500));

        itensList.add(new Ramen("Shoyu_Ebi-Ramen", "Shoyu Ebi-Ramen",
                "Ramen de camarão, temperado especialmente com molho de soja",
                385, ItemShop.TipoPgto.RYOUS, 6, 55, 1650));

        itensList.add(new Ramen("Misso_Ebi-Ramen", "Misso Ebi-Ramen",
                "Ramen de camarão, com pasta de soja",
                420, ItemShop.TipoPgto.RYOUS, 6, 60, 1800));
        return itensList;
    }

    public List<ItemShop> getArmasLongoAlcance() {
        itensList.clear();
        itensList.add(new Arma("shuriken", "Shuriken",
                "Você arremessa uma shuriken em seu inimigo",
                7, 0, 2, 2, 1, 4, Arma.Tipo.TAI_BUK));

        itensList.add(new Arma("shuriken-chakra", "Shuriken de Chakra",
                "Você arremessa uma shuriken em seu inimigo",
                7, 0, 2, 2, 4, 1, Arma.Tipo.NIN_GEN));
        return itensList;
    }

    public List<ItemShop> getArmasCurtoAlcance() {
        itensList.clear();

        itensList.add(new Arma("nunchaku", "Nunchaku",
                "Consiste de dois bastões pequenos conectados em seus fins por uma corda ou corrente. Muito uitilizado para golpear a curta distância e aumentar o dano no oponente.",
                700, ItemShop.TipoPgto.RYOUS, 1, 5, 21, 4, 22, Arma.Tipo.TAI_BUK));

        itensList.add(new Arma("pincel2", "Pincel Gigante",
                "Alguns Shinobis utilizam suas técnicas por meio de pinturas, como Kurama Yakumo que com sua Kekkei Genkai pode tornar suas pinturas praticamente reais.",
                1, ItemShop.TipoPgto.CREDITO, 1, 5, 25, 25, 4, Arma.Tipo.NIN_GEN));

        itensList.add(new Arma("pincel", "Pincel",
                "Alguns Shinobis utilizam suas técnicas por meio de pinturas, como Kurama Yakumo que com sua Kekkei Genkai pode tornar suas pinturas praticamente reais.",
                700, ItemShop.TipoPgto.RYOUS, 1, 5, 21, 22, 3, Arma.Tipo.NIN_GEN));

        itensList.add(new Arma("nunchaku2", "Nunchaku Energizado",
                "Consiste de dois bastões pequenos conectados em seus fins por uma corda ou corrente. Muito uitilizado para golpear a curta distância e aumentar o dano no oponente.",
                1, ItemShop.TipoPgto.CREDITO, 1, 5, 25, 3, 25, Arma.Tipo.TAI_BUK));

        return itensList;
    }

    public List<ItemShop> getPergaminhos() {
        itensList.clear();
//        itensList.add(new Pergaminho("1", Vilas.FOLHA));
//        itensList.add(new Pergaminho("2", Vilas.FONTES_TERMAIS));
//        itensList.add(new Pergaminho("3", Vilas.NEVE));
//        itensList.add(new Pergaminho("4", Vilas.CACHOEIRA));
//        itensList.add(new Pergaminho("5", Vilas.CHUVA));
//        itensList.add(new Pergaminho("6", Vilas.SOM));
//        itensList.add(new Pergaminho("7", Vilas.AKATSUKI));
//        itensList.add(new Pergaminho("8", Vilas.NUVEM));
//        itensList.add(new Pergaminho("9", Vilas.PEDRA));
//        itensList.add(new Pergaminho("10", Vilas.NEVOA));
//        itensList.add(new Pergaminho("11", Vilas.AREIA));
//        itensList.add(new Pergaminho("12", Vilas.GRAMA));
        return itensList;
    }
}
