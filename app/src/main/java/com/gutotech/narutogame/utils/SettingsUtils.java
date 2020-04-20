package com.gutotech.narutogame.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SettingsUtils {
    public static final String BG_MUSIC_KEY = "bgMusicEnabled";
    public static final String SOUND_KEY = "soundMusicEnabled";
    public static final String NOTIFICATIONS_KEY = "notificationsEnabled";

    private static final String PREFERENCE_FILE_KEY = "com.gutotech.narutogame.PREFERENCE_FILE";

    public static void set(Context context, String key, boolean enabled) {
        SharedPreferences sharedPref = context.getSharedPreferences(
                PREFERENCE_FILE_KEY, Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean(key, enabled);
        editor.apply();
    }

    public static boolean get(Context context, String key) {
        SharedPreferences sharedPref = context.getSharedPreferences(
                PREFERENCE_FILE_KEY, Context.MODE_PRIVATE);

        return sharedPref.getBoolean(key, true);
    }
}
