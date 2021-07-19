package edu.team04.crucible;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * This activity lets the user choose from three different themes for the application.
 */
public class EditThemeActivity extends ThemeActivity implements View.OnClickListener{

    /** On creation of this activity update the theme and set the context view
     * Set an on clickListener for each button*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new ThemeHandler(this, getApplicationContext()).updateTheme();
        setContentView(R.layout.activity_edit_theme);
        ((Button)findViewById(R.id.default_theme_btn)).setOnClickListener(this);
        ((Button)findViewById(R.id.blue_theme_btn)).setOnClickListener(this);
        ((Button)findViewById(R.id.red_theme_btn)).setOnClickListener(this);
    }


    /**
     * This method gets called when the user presses the button.
     * @param view The current view
     */
    @Override
    public void onClick(View view){
        switch(view.getId()){
            case R.id.default_theme_btn:
                SharedPreferenceManager.setTheme(getApplicationContext(), 1);
                recreateActivity();
                break;
            case R.id.blue_theme_btn:
                SharedPreferenceManager.setTheme(getApplicationContext(), 2);
                recreateActivity();
                break;
            case R.id.red_theme_btn:
                SharedPreferenceManager.setTheme(getApplicationContext(), 3);
                recreateActivity();
                break;
        }

    }

    /**
     * This button leads back to the Settings Activity.
     * @param button button
     */
    public void backToSettings(View button) {
        Intent addIntent = new Intent(this, SettingsActivity.class);
        startActivity(addIntent);
    }


    /**
     * This method is called by onClick, and applies the theme to the current activity.
     */
    public void recreateActivity(){
        Intent intent = getIntent();
        startActivity(intent);
    }
}