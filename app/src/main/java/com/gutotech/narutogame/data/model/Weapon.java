package com.gutotech.narutogame.data.model;

public class Weapon extends ShopItem {
    private int atakOuDef;
    private int consomeChakra;
    private int consomeStamina;

    public enum Tipo {TAI_BUK, NIN_GEN, DEF}

    public enum Alcance {LONGO, CURTO}

    private Tipo tipo;
    private Alcance alcance;

    public Weapon() {
    }

//    // para armas de longo alcance
//    public Arma(String image, String nome, String descricao, int valor, int requerGraducao, int requerLevel, int atakOuDef, int consomeChakra, int consomeStamina, Tipo tipo) {
//        super(image, nome, descricao, new ArrayList<>(), valor, 0, requerGraducao, requerLevel);
//        this.atakOuDef = atakOuDef;
//        this.consomeChakra = consomeChakra;
//        this.consomeStamina = consomeStamina;
//        this.tipo = tipo;
//        this.alcance = Alcance.LONGO;
//    }
//
//    // para armas de curto alcance
//    public Arma(String image, String nome, String descricao, int valor, TipoPgto tipoPgto, int requerGraducao, int requerLevel, int atakOuDef, int consomeChakra, int consomeStamina, Tipo tipo) {
//        super(image, nome, descricao, TipoItem.ARMA, valor, tipoPgto, 0, requerGraducao, requerLevel);
//        this.atakOuDef = atakOuDef;
//        this.consomeChakra = consomeChakra;
//        this.consomeStamina = consomeStamina;
//        this.tipo = tipo;
//        this.alcance = Alcance.CURTO;
//    }

    public int getAtakOuDef() {
        return atakOuDef;
    }

    public void setAtakOuDef(int atakOuDef) {
        this.atakOuDef = atakOuDef;
    }

    public int getConsomeChakra() {
        return consomeChakra;
    }

    public void setConsomeChakra(int consomeChakra) {
        this.consomeChakra = consomeChakra;
    }

    public int getConsomeStamina() {
        return consomeStamina;
    }

    public void setConsomeStamina(int consomeStamina) {
        this.consomeStamina = consomeStamina;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Alcance getAlcance() {
        return alcance;
    }

    public void setAlcance(Alcance alcance) {
        this.alcance = alcance;
    }
}
