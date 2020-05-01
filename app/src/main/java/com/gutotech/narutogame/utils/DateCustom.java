package com.gutotech.narutogame.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public abstract class DateCustom {

    public static int getDayOfWeek(long timestamp) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timestamp);
        return calendar.get(Calendar.DAY_OF_WEEK);
    }

    public static String getDate() {
        return getDate(System.currentTimeMillis());
    }

    public static String getDate(long timestamp) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
        return simpleDateFormat.format(timestamp);
    }

    public static String getTime() {
        return getTime(System.currentTimeMillis());
    }

    public static String getTime(long timestamp) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss", Locale.US);
        return simpleDateFormat.format(timestamp);
    }
}
