package edu.team04.crucible;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
//import androidx.preference.PreferenceFragmentCompat;

public class SettingsActivity extends AppCompatActivity {

    //TODO: When Begin button is pressed start EditCategoryActivity
    // and send it the selected Category's Card List

    //TODO: If add Category button is pressed add new Category
    // if this Activity needs to make any requests for information, do in handler/presenter class
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.settings_activity);
        }
    }