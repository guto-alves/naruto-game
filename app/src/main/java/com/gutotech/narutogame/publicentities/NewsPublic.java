package com.gutotech.narutogame.publicentities;

import com.gutotech.narutogame.model.Noticia;

public class NewsPublic {
    public static Noticia noticia = new Noticia();

    public static void setNoticia(Noticia noticia) {
        NewsPublic.noticia = noticia;
    }

    public static Noticia getNoticia() {
        return noticia;
    }
}
