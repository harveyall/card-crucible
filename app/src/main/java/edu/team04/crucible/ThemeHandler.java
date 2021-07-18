package edu.team04.crucible;

import android.app.Activity;
import android.content.Context;

public class ThemeHandler {
    Activity activity;
    Context context;
    /** Construct a Theme Handler that takes a specific activity and context
     * @param activity
     * @param context
     * */
    public ThemeHandler(Activity activity, Context context){
        this.context = context;
        this.activity = activity;
    }
    /** Update the current displaying theme to the theme saved in shared preferences*/
    public void updateTheme(){
        if(SharedPreferenceManager.getTheme(this.context) <= ThemeActivity.getThemeDefault()) {
            this.activity.setTheme(R.style.AppTheme_Default);
        }else if(SharedPreferenceManager.getTheme(this.context) == ThemeActivity.getThemeBlue()){
            this.activity.setTheme(R.style.AppTheme_Blue);
        } else if(SharedPreferenceManager.getTheme(this.context) == ThemeActivity.getThemeOrange()){
            this.activity.setTheme(R.style.AppTheme_Orange);
        }
    }
}
