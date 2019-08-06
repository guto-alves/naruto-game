package com.gutotech.narutogame.model;

import java.io.Serializable;

public class Noticia implements Serializable {
    private String id;
    private String data;
    private String titulo;
    private String mensagem;
    private String por;
    private int likes;

    public Noticia() {
    }

    public Noticia(String data, String titulo, String mensagem) {
        this.data = data;
        this.titulo = titulo;
        this.mensagem = mensagem;
    }

    public Noticia(String data, String titulo, String mensagem, String por) {
        this.data = data;
        this.titulo = titulo;
        this.mensagem = mensagem;
        this.por = por;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getPor() {
        return por;
    }

    public void setPor(String por) {
        this.por = por;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
