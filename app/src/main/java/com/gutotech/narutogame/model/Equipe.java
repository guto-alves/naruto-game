package com.gutotech.narutogame.model;

import com.google.firebase.database.DatabaseReference;
import com.gutotech.narutogame.config.ConfigFirebase;

public class Equipe {
    private String nome;
    private int level;
    private int expAtual;
    private int expUpar;

    private int posicao;
    private int pontos;
    private String vila;

    private Personagem lider;
    private Personagem integrante1;
    private Personagem integrante2;
    private Personagem integrante3;
    private int quantidadeMembros;

    public Equipe() {

    }

    public void salvar() {
        DatabaseReference reference = ConfigFirebase.getDatabase()
                .child("equipe")
                .child(nome);
        reference.setValue(this);
    }

    public Personagem getLider() {
        return lider;
    }

    public void setLider(Personagem lider) {
        this.lider = lider;
    }

    public Personagem getIntegrante1() {
        return integrante1;
    }

    public void setIntegrante1(Personagem integrante1) {
        this.integrante1 = integrante1;
    }

    public Personagem getIntegrante2() {
        return integrante2;
    }

    public void setIntegrante2(Personagem integrante2) {
        this.integrante2 = integrante2;
    }

    public Personagem getIntegrante3() {
        return integrante3;
    }

    public void setIntegrante3(Personagem integrante3) {
        this.integrante3 = integrante3;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExpAtual() {
        return expAtual;
    }

    public void setExpAtual(int expAtual) {

        this.expAtual = expAtual;
    }

    public int getExpUpar() {
        return expUpar;
    }

    public void setExpUpar(int expUpar) {
        this.expUpar = expUpar;
    }

    public int getQuantidadeMembros() {
        return quantidadeMembros;
    }

    public void setQuantidadeMembros(int quantidadeMembros) {
        this.quantidadeMembros = quantidadeMembros;
    }

    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public String getVila() {
        return vila;
    }

    public void setVila(String vila) {
        this.vila = vila;
    }
}
