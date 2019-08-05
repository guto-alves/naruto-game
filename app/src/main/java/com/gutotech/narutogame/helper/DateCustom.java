package com.gutotech.narutogame.helper;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class DateCustom {

    public static String dataAtual() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        return simpleDateFormat.format(System.currentTimeMillis());
    }

    public static String horarioAtual() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
        return simpleDateFormat.format(System.currentTimeMillis());
    }

    public static String mesAno(String data) {
        String[] tokens = data.split("/");
        return tokens[1] + tokens[2];
    }

    public static String dia() {
        return dataAtual().split("/")[0];
    }
}
