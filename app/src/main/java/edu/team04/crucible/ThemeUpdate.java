package edu.team04.crucible;

import android.app.Activity;
import android.content.Context;

public class ThemeUpdate {
    Activity activity;
    Context context;
    public ThemeUpdate(Activity activity, Context context){
        this.context = context;
        this.activity = activity;
    }
    public void updateTheme(){
        if(SharedPreferenceManager.getTheme(this.context) <= ThemeActivity.getThemeDefault()) {
            this.activity.setTheme(R.style.AppTheme_Default);
        }else if(SharedPreferenceManager.getTheme(this.context) == ThemeActivity.getThemeBlue()){
            this.activity.setTheme(R.style.AppTheme_Blue);
        } else if(SharedPreferenceManager.getTheme(this.context) == ThemeActivity.getThemeRed()){
            this.activity.setTheme(R.style.AppTheme_Red);
        }
    }
}
