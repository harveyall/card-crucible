package edu.team04.crucible;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class GameModeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new ThemeUpdate(this, getApplicationContext()).updateTheme();
        setContentView(R.layout.activity_game_mode);
    }
}