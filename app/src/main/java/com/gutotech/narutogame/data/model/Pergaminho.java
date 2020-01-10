package com.gutotech.narutogame.data.model;

public class Pergaminho extends ItemShop {
    private String vila;

    public Pergaminho() {
    }

    public Pergaminho(String image, String vila) {
        super(image, "Pergaminho de Teletransporte para " + vila, "Ao utilizar esse pergaminho seu character é automaticamamente teletransportado para o mapa da vila da " + vila, TipoItem.PERGAMINHO, 2, TipoPgto.CREDITO, 0, 1, 0);
        this.vila = vila;
    }

    public Pergaminho(String image, String nome, String descricao, TipoItem tipoItem, int inventario, String vila) {
        super(image, nome, descricao, tipoItem, 2, TipoPgto.CREDITO, inventario, 1, 0);
        this.vila = vila;
    }

    public Pergaminho(String image, String nome, String descricao, TipoItem tipoItem, int valor, TipoPgto tipoPgto, int inventario, int requerGraducao, int requerLevel, String vila) {
        super(image, nome, descricao, tipoItem, valor, tipoPgto, inventario, requerGraducao, requerLevel);
        this.vila = vila;
    }

    public String getVila() {
        return vila;
    }

    public void setVila(String vila) {
        this.vila = vila;
    }
}
