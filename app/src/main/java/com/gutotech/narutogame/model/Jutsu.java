package com.gutotech.narutogame.model;

import java.io.Serializable;

public class Jutsu implements Serializable {
    private int id;
    private String nomeImagem;
    private String nome;
    private int quantidade;
    private int atkTaiBuk;
    private int atkNinGen;
    private int defesa_base;
    private int precisao;
    private int intervaloDeUso;
    private int consomeChakra;
    private int consomeStamina;
    private String tipo;
    private String classe;
    private String descricao;

    public Jutsu() {
    }

    public Jutsu(String nome, String nomeImagem, String descricao, int quantidade, int atkTaiBuk, int atkNinGen, int defesa_base, int precisao, int intervaloDeUso, int consomeChakra, int consomeStamina, String tipo, String classe) {
        this.nomeImagem = nomeImagem;
        this.nome = nome;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.atkTaiBuk = atkTaiBuk;
        this.atkNinGen = atkNinGen;
        this.defesa_base = defesa_base;
        this.precisao = precisao;
        this.intervaloDeUso = intervaloDeUso;
        this.consomeChakra = consomeChakra;
        this.consomeStamina = consomeStamina;
        this.tipo = tipo;
        this.classe = classe;
    }

    public Jutsu(int id, String nome, int quantidade, int atkTaiBuk, int atkNinGen, int defesa_base, int precisao, int intervaloDeUso, int consomeChakra, int consomeStamina, String tipo, String classe) {
        this.id = id;
        this.nome = nome;
        this.quantidade = quantidade;
        this.atkTaiBuk = atkTaiBuk;
        this.atkNinGen = atkNinGen;
        this.defesa_base = defesa_base;
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

    public String getNomeImagem() {
        return nomeImagem;
    }

    public void setNomeImagem(String nomeImagem) {
        this.nomeImagem = nomeImagem;
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

    public int getDefesa_base() {
        return defesa_base;
    }

    public void setDefesa_base(int defesa_base) {
        this.defesa_base = defesa_base;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
