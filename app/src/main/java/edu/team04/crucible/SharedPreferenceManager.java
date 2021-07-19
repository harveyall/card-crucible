package edu.team04.crucible;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.preference.PreferenceManager;

public class SharedPreferenceManager {
    /** Set the specified integer representation of the theme in shared preferences
     * @param context
     * @param theme
     * */
    public static void setTheme(Context context, int theme){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        sp.edit().putInt("theme", theme).apply();
    }
    /** Return the integer representation of the theme saved in shared preferences * */
    public static int getTheme(Context context) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        return sp.getInt("theme", -1);
    }
}
