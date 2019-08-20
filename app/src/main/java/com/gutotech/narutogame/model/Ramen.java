package com.gutotech.narutogame.model;

import java.io.Serializable;

public class Ramen implements Serializable {
    private int resIdImagem;
    private String nome;
    private String descricao;
    private int recupera;
    private int valor;
    private int quantidade;

    public Ramen() {
    }

    public Ramen(int resIdImagem, String nome, String descricao, int recupera, int valor, int quantidade) {
        this.resIdImagem = resIdImagem;
        this.nome = nome;
        this.descricao = descricao;
        this.recupera = recupera;
        this.valor = valor;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getRecupera() {
        return recupera;
    }

    public void setRecupera(int recupera) {
        this.recupera = recupera;
    }

    public int getResIdImagem() {
        return resIdImagem;
    }

    public void setResIdImagem(int resIdImagem) {
        this.resIdImagem = resIdImagem;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}
