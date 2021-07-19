package edu.team04.crucible;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class ThemeActivity extends AppCompatActivity {
    private final static int THEME_DEFAULT = 1;
    private final static int THEME_BLUE = 2;
    private final static int THEME_ORANGE = 3;

    /** On creation of this activity update the theme and set the context view * */
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //Update theme upon creation of the activity
        updateTheme();
    }
/** Set theme based on the integer representation of the theme saved in shared preference*/
    public void updateTheme(){
        if(SharedPreferenceManager.getTheme(getApplicationContext()) <= THEME_DEFAULT) {
            setTheme(R.style.AppTheme_Default);
        }else if(SharedPreferenceManager.getTheme(getApplicationContext()) == THEME_BLUE){
            setTheme(R.style.AppTheme_Blue);
        } else if(SharedPreferenceManager.getTheme(getApplicationContext()) == THEME_ORANGE){
            setTheme(R.style.AppTheme_Orange);
        }
    }
    /** Return the integer representation of the blue theme*/
    public static int getThemeBlue() {
        return THEME_BLUE;
    }
    /** Return the integer representation of the orange theme*/
    public static int getThemeOrange() {
        return THEME_ORANGE;
    }
    /** Return the integer representation of the default theme*/
    public static int getThemeDefault() {
        return THEME_DEFAULT;
    }

}
