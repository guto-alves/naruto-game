package com.gutotech.narutogame.model;

import java.util.List;

public class Ticket {
    private String categoria;
    private String titulo;
    private String dataOcorrido;
    private String horaOcorrido;
    private String descricao;
    private String imagem;


    private String status;
    private String dataCriacao;
    private String horaCriacao;
    private String dataAtualizacao;
    private String horaAtualizacao;
    private String email;
    private String ultimoAResponder;
    private List<RespostaTicket> respostas;

    public Ticket() {
    }

    public Ticket(String titulo, String categoria, String status, String dataCriacao, String dataAtualizacao, String descricao) {
        this.titulo = titulo;
        this.categoria = categoria;
        this.status = status;
        this.dataCriacao = dataCriacao;
        this.dataAtualizacao = dataAtualizacao;
        this.descricao = descricao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(String dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getHoraCriacao() {
        return horaCriacao;
    }

    public void setHoraCriacao(String horaCriacao) {
        this.horaCriacao = horaCriacao;
    }

    public String getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(String dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public String getHoraAtualizacao() {
        return horaAtualizacao;
    }

    public void setHoraAtualizacao(String horaAtualizacao) {
        this.horaAtualizacao = horaAtualizacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUltimoAResponder() {
        return ultimoAResponder;
    }

    public void setUltimoAResponder(String ultimoAResponder) {
        this.ultimoAResponder = ultimoAResponder;
    }

    public String getDataOcorrido() {
        return dataOcorrido;
    }

    public void setDataOcorrido(String dataOcorrido) {
        this.dataOcorrido = dataOcorrido;
    }

    public String getHoraOcorrido() {
        return horaOcorrido;
    }

    public void setHoraOcorrido(String horaOcorrido) {
        this.horaOcorrido = horaOcorrido;
    }

    public List<RespostaTicket> getRespostas() {
        return respostas;
    }

    public void setRespostas(List<RespostaTicket> respostas) {
        this.respostas = respostas;
    }

    private class RespostaTicket {
        private String resposta;
        private String respondidoPor;
        private String data;
        private String horario;

        public String getResposta() {
            return resposta;
        }

        public void setResposta(String resposta) {
            this.resposta = resposta;
        }

        public String getRespondidoPor() {
            return respondidoPor;
        }

        public void setRespondidoPor(String respondidoPor) {
            this.respondidoPor = respondidoPor;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public String getHorario() {
            return horario;
        }

        public void setHorario(String horario) {
            this.horario = horario;
        }
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
}
