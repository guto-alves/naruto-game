package com.gutotech.narutogame.model;

import java.io.Serializable;

public class ItemShop implements Serializable {
    private String image;
    private String nome;
    private String descricao;

    public enum TipoItem {RAMEN, ARMA, PERGAMINHO}

    private TipoItem tipoItem;

    private int valor;

    public enum TipoPgto {RYOUS, CREDITO}

    private TipoPgto tipoPgto;
    private int inventario;

    private int requerGraducao;
    private int requerLevel;

    public ItemShop() {
    }

    public ItemShop(String image, String nome, String descricao, TipoItem tipoItem, int valor, TipoPgto tipoPgto, int inventario, int requerGraducao, int requerLevel) {
        this.image = image;
        this.nome = nome;
        this.descricao = descricao;
        this.tipoItem = tipoItem;
        this.valor = valor;
        this.tipoPgto = tipoPgto;
        this.inventario = inventario;
        this.requerGraducao = requerGraducao;
        this.requerLevel = requerLevel;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public TipoItem getTipoItem() {
        return tipoItem;
    }

    public void setTipoItem(TipoItem tipoItem) {
        this.tipoItem = tipoItem;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public TipoPgto getTipoPgto() {
        return tipoPgto;
    }

    public void setTipoPgto(TipoPgto tipoPgto) {
        this.tipoPgto = tipoPgto;
    }

    public int getInventario() {
        return inventario;
    }

    public void setInventario(int inventario) {
        this.inventario = inventario;
    }

    public int getRequerGraducao() {
        return requerGraducao;
    }

    public void setRequerGraducao(int requerGraducao) {
        this.requerGraducao = requerGraducao;
    }

    public int getRequerLevel() {
        return requerLevel;
    }

    public void setRequerLevel(int requerLevel) {
        this.requerLevel = requerLevel;
    }
}


