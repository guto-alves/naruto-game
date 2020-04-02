package com.gutotech.narutogame.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class MusicSettingsUtils {
    private static final String PREFERENCE_FILE_KEY = "com.gutotech.narutogame.PREFERENCE_FILE";

    private static final String MUSIC_ENABLED_KEY = "musicEnabled";

    public static void set(Context context, boolean enable) {
        SharedPreferences sharedPref = context.getSharedPreferences(
                PREFERENCE_FILE_KEY, Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean(MUSIC_ENABLED_KEY, enable);
        editor.apply();
    }

    public static boolean enabled(Context context) {
        SharedPreferences sharedPref = context.getSharedPreferences(
                PREFERENCE_FILE_KEY, Context.MODE_PRIVATE);

        return sharedPref.getBoolean(MUSIC_ENABLED_KEY, true);
    }
}
