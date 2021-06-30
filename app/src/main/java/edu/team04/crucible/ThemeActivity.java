package edu.team04.crucible;

import android.os.Bundle;
import android.util.Log;

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
            Log.d("ThemeActivity", "Default Theme set");
        }else if(SharedPreferenceManager.getTheme(getApplicationContext()) == THEME_BLUE){
            setTheme(R.style.AppTheme_Blue);
            Log.d("ThemeActivity", "Blue Theme set");
        } else if(SharedPreferenceManager.getTheme(getApplicationContext()) == THEME_RED){
            setTheme(R.style.AppTheme_Red);
            Log.d("ThemeActivity", "Red Theme set");
        }
    }
}
