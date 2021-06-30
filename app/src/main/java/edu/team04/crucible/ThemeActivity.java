package edu.team04.crucible;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class ThemeActivity extends AppCompatActivity {
    private final static int THEME_DEFAULT = 1;
    private final static int THEME_BLUE = 2;
    private final static int THEME_RED = 3;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        updateTheme();
    }

    public void updateTheme(){
        if(SharedPreferenceManager.getTheme(getApplicationContext()) <= THEME_DEFAULT) {
            setTheme(R.style.AppTheme_Default);
        }else if(SharedPreferenceManager.getTheme(getApplicationContext()) == THEME_BLUE){
            setTheme(R.style.AppTheme_Blue);
        } else if(SharedPreferenceManager.getTheme(getApplicationContext()) == THEME_RED){
            setTheme(R.style.AppTheme_Red);
        }
    }
    public static int getThemeBlue() {
        return THEME_BLUE;
    }

    public static int getThemeRed() {
        return THEME_RED;
    }

    public static int getThemeDefault() {
        return THEME_DEFAULT;
    }

}
