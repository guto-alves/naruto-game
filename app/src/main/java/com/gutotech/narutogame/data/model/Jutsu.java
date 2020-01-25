package com.gutotech.narutogame.data.model;

public class Jutsu {
    public enum Tipo {ATK, DEF, BUFF, DEBUFF}

    private int id;
    private String image;
    private String name;
    private String description;

    private int quantidade;
    private int atkTaiBuk;
    private int atkNinGen;
    private int defesaBase;
    private int precisao;
    private int intervaloDeUso;
    private int consomeChakra;
    private int consomeStamina;
    private String tipo;
    private String classe;

    public Tipo mTipo;

    public Jutsu() {
    }

    public Jutsu(String name, String image, String description, int quantidade, int atkTaiBuk, int atkNinGen, int defesaBase, int precisao, int intervaloDeUso, int consomeChakra, int consomeStamina, String tipo, String classe) {
        this.image = image;
        this.name = name;
        this.description = description;
        this.quantidade = quantidade;
        this.atkTaiBuk = atkTaiBuk;
        this.atkNinGen = atkNinGen;
        this.defesaBase = defesaBase;
        this.precisao = precisao;
        this.intervaloDeUso = intervaloDeUso;
        this.consomeChakra = consomeChakra;
        this.consomeStamina = consomeStamina;
        this.tipo = tipo;
        this.classe = classe;
    }

    public Jutsu(int id, String name, int quantidade, int atkTaiBuk, int atkNinGen, int defesaBase, int precisao, int intervaloDeUso, int consomeChakra, int consomeStamina, String tipo, String classe) {
        this.id = id;
        this.name = name;
        this.quantidade = quantidade;
        this.atkTaiBuk = atkTaiBuk;
        this.atkNinGen = atkNinGen;
        this.defesaBase = defesaBase;
        this.precisao = precisao;
        this.intervaloDeUso = intervaloDeUso;
        this.consomeChakra = consomeChakra;
        this.consomeStamina = consomeStamina;
        this.tipo = tipo;
        this.classe = classe;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int vezes) {
        this.quantidade = vezes;
    }

    public int getAtkTaiBuk() {
        return atkTaiBuk;
    }

    public void setAtkTaiBuk(int atkTaiBuk) {
        this.atkTaiBuk = atkTaiBuk;
    }

    public int getAtkNinGen() {
        return atkNinGen;
    }

    public void setAtkNinGen(int atkNinGen) {
        this.atkNinGen = atkNinGen;
    }

    public int getDefesaBase() {
        return defesaBase;
    }

    public void setDefesaBase(int defesaBase) {
        this.defesaBase = defesaBase;
    }

    public int getIntervaloDeUso() {
        return intervaloDeUso;
    }

    public void setIntervaloDeUso(int intervaloDeUso) {
        this.intervaloDeUso = intervaloDeUso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrecisao() {
        return precisao;
    }

    public void setPrecisao(int precisao) {
        this.precisao = precisao;
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

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
