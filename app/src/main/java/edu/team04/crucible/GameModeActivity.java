package edu.team04.crucible;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Card Selection Activity. In preparation for game/study mode, it displays a list of categories to
 * be used on the next activity. When the Begin button is pressed, the list gets sent to Card
 * Randomization, and comes back shuffled, and then fed into the next activity.
 */
public class GameModeActivity extends AppCompatActivity {

    /** On creation of this activity update the theme and set the context view*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new ThemeHandler(this, getApplicationContext()).updateTheme();
        setContentView(R.layout.activity_game_mode);
    }
}