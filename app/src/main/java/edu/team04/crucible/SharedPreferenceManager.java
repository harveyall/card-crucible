package edu.team04.crucible;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.preference.PreferenceManager;

public class SharedPreferenceManager {
    public static void setTheme(Context context, int theme){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        sp.edit().putInt("theme", theme);
    }
    public static int getTheme(Context context) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        return sp.getInt("theme", -1);
    }
}
