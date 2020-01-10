package com.gutotech.narutogame.data.model;

import com.google.firebase.database.DatabaseReference;
import com.gutotech.narutogame.data.firebase.FirebaseConfig;

public class Equipe {
    private String nome;
    private int level;
    private int expAtual;
    private int expUpar;

    private int posicao;
    private int pontos;
    private String vila;

    private Character lider;
    private Character integrante1;
    private Character integrante2;
    private Character integrante3;
    private int quantidadeMembros;

    public Equipe() {

    }

    public void salvar() {
        DatabaseReference reference = FirebaseConfig.getDatabase()
                .child("equipe")
                .child(nome);
        reference.setValue(this);
    }

    public Character getLider() {
        return lider;
    }

    public void setLider(Character lider) {
        this.lider = lider;
    }

    public Character getIntegrante1() {
        return integrante1;
    }

    public void setIntegrante1(Character integrante1) {
        this.integrante1 = integrante1;
    }

    public Character getIntegrante2() {
        return integrante2;
    }

    public void setIntegrante2(Character integrante2) {
        this.integrante2 = integrante2;
    }

    public Character getIntegrante3() {
        return integrante3;
    }

    public void setIntegrante3(Character integrante3) {
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
