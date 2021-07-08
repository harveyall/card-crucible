package edu.team04.crucible;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

/**
 * The Main Activity, with buttons for Settings, Study Mode & Game Mode.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new ThemeHandler(this, getApplicationContext()).updateTheme();
        //((android.widget.Button)findViewById(R.id.button_begin)).setText(R.string.study_mode);
        //((android.widget.Button)findViewById(R.id.button_begin)).setText(R.string.game_mode);
        setContentView(R.layout.activity_main);

        TestData test = new TestData(this);
        new Thread(test, "TestCategoryList").start();
    }

    /**
     * Button to Settings Activity.
     * @param button Settings Activity button
     */
    public void settings (View button) {
        Intent settingsActivity = new Intent(this, SettingsActivity.class);
        startActivity(settingsActivity);
    }

    /**
     * Button to Card Selection Activity with Study Mode intent.
     * @param button Study Mode button
     */
    public void cardSelectForStudy (View button) {
        Intent cardSelectionActivity = new Intent(this, CardSelectionActivity.class);
        cardSelectionActivity.putExtra("ACTIVITY","Study");
        startActivity(cardSelectionActivity);
    }

    /**
     * Button to Card Selection Activity with Game Mode intent.
     * @param button Game Mode button
     */
    public void cardSelectForGame (View button) {
        Intent cardSelectionActivity = new Intent(this, CardSelectionActivity.class);
        cardSelectionActivity.putExtra("ACTIVITY","Game");
        startActivity(cardSelectionActivity);
    }
}