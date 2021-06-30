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
        new ThemeUpdate(this, getApplicationContext()).updateTheme();
        //((android.widget.Button)findViewById(R.id.button_begin)).setText(R.string.study_mode);
        //((android.widget.Button)findViewById(R.id.button_begin)).setText(R.string.game_mode);
        setContentView(R.layout.activity_main);

        TestData test = new TestData(this);
        new Thread(test, "TestCategoryList").start();
    }

    /**
     * Button to Settings Activity.
     * @param button
     */
    public void settings (View button) {
        Intent settingsActivity = new Intent(this, SettingsActivity.class);
        startActivity(settingsActivity);
    }

    /**
     * Button to Card Selection Activity with Study Mode intent.
     * @param button
     */
    public void cardSelectForStudy (View button) {
        //TODO: Pass the Study mode intent.
        Intent cardSelectionActivity = new Intent(this, CardSelectionActivity.class);
        startActivity(cardSelectionActivity);
    }

    /**
     * Button to Card Selection Activity with Game Mode intent.
     * @param button
     */
    public void cardSelectForGame (View button) {
        //TODO: Pass the Game mode intent.
        Intent cardSelectionActivity = new Intent(this, CardSelectionActivity.class);
        startActivity(cardSelectionActivity);
    }

}