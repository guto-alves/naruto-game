package com.gutotech.narutogame.model;

import com.gutotech.narutogame.myinterface.MissaoAceitaListener;

import java.io.Serializable;

public class Missao implements Serializable {
    private int id;
    private String titulo;
    private String descricao;
    private String graduacao;
    private int level;
    private String rank;
    private String dataConcluida;
    private String horarioConcluido;
    private MissaoAceitaListener listener;

    public Missao() {

    }

    public Missao(int id, String titulo, String descricao, String graduacao, int level, String rank, String dataConcluida, String horarioConcluido, MissaoAceitaListener listener) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.graduacao = graduacao;
        this.level = level;
        this.rank = rank;
        this.dataConcluida = dataConcluida;
        this.horarioConcluido = horarioConcluido;
        this.listener = listener;
    }

    public void aceitarMissao(int idMissao) {
        listener.callback(idMissao);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getGraduacao() {
        return graduacao;
    }

    public void setGraduacao(String graduacao) {
        this.graduacao = graduacao;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getDataConcluida() {
        return dataConcluida;
    }

    public void setDataConcluida(String dataConcluida) {
        this.dataConcluida = dataConcluida;
    }

    public String getHorarioConcluido() {
        return horarioConcluido;
    }

    public void setHorarioConcluido(String horarioConcluido) {
        this.horarioConcluido = horarioConcluido;
    }

    public MissaoAceitaListener getListener() {
        return listener;
    }

    public void setListener(MissaoAceitaListener listener) {
        this.listener = listener;
    }
}
