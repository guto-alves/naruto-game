package com.gutotech.narutogame.data.model;

import java.io.Serializable;

public class Ramen extends ItemShop implements Serializable {
    private int recupera;

    public Ramen() {
    }

    public Ramen(String image, String nome, String descricao, int valor, TipoPgto tipoPgto, int requerGraducao, int requerLevel, int recupera) {
        super(image, nome, descricao, TipoItem.RAMEN, valor, tipoPgto, 0, requerGraducao, requerLevel);
        this.recupera = recupera;
    }

    public Ramen(String image, String nome, String descricao, int valor, TipoPgto tipoPgto, int inventario, int requerGraducao, int requerLevel, int recupera) {
        super(image, nome, descricao, TipoItem.RAMEN, valor, tipoPgto, inventario, requerGraducao, requerLevel);
        this.recupera = recupera;
    }

    public int getRecupera() {
        return recupera;
    }

    public void setRecupera(int recupera) {
        this.recupera = recupera;
    }
}
