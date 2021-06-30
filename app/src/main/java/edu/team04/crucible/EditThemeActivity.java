package edu.team04.crucible;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class EditThemeActivity extends ThemeActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_theme);
        ((Button)findViewById(R.id.default_theme_btn)).setOnClickListener(this);
        ((Button)findViewById(R.id.blue_theme_btn)).setOnClickListener(this);
        ((Button)findViewById(R.id.red_theme_btn)).setOnClickListener(this);
    }


    public void onClick(View view){
        switch(view.getId()){
            case R.id.default_theme_btn:
                Log.d("EditThemeActivity", "Default button pressed");
                SharedPreferenceManager.setTheme(getApplicationContext(), 1);
                recreateActivity();
                break;
            case R.id.blue_theme_btn:
                Log.d("EditThemeActivity", "Blue button pressed");
                SharedPreferenceManager.setTheme(getApplicationContext(), 2);
                recreateActivity();
                break;
            case R.id.red_theme_btn:
                Log.d("EditThemeActivity", "Red button pressed");
                SharedPreferenceManager.setTheme(getApplicationContext(), 3);
                recreateActivity();
                break;
        }

    }

    public void backToSettings(View button) {
        Intent addIntent = new Intent(this, SettingsActivity.class);
        startActivity(addIntent);
    }

    public void recreateActivity(){
        Intent intent = getIntent();
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        finish();
        overridePendingTransition(0,0);
        startActivity(intent);
        overridePendingTransition(0,0);
    }
}