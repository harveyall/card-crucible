package edu.team04.crucible;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class ThemeActivity extends AppCompatActivity {
    private final static int THEME_DEFAULT = 1;
    private final static int THEME_BLUE = 2;
    private final static int THEME_ORANGE = 3;


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
        } else if(SharedPreferenceManager.getTheme(getApplicationContext()) == THEME_ORANGE){
            setTheme(R.style.AppTheme_Orange);
        }
    }
    public static int getThemeBlue() {
        return THEME_BLUE;
    }

    public static int getThemeOrange() {
        return THEME_ORANGE;
    }

    public static int getThemeDefault() {
        return THEME_DEFAULT;
    }

}
