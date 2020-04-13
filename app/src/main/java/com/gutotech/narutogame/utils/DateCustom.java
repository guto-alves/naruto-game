package com.gutotech.narutogame.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateCustom {

    public static int getDayOfWeek() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        return calendar.get(Calendar.DAY_OF_WEEK);
    }

    public static String getDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
        return simpleDateFormat.format(System.currentTimeMillis());
    }

    public static String getTime() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss", Locale.US);
        return simpleDateFormat.format(System.currentTimeMillis());
    }
}
