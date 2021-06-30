package edu.team04.crucible;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class EditCardsActivity extends AppCompatActivity {
//This activity is called when an edit button is clicked from the EditCategoryActivity

    //TODO: edit card specified by EditCategoryActivity - change questions, answer, or category

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new ThemeHandler(this, getApplicationContext()).updateTheme();
        setContentView(R.layout.activity_edit_cards);
    }

    public void backToSettings(View button) {
        Intent addIntent = new Intent(this, SettingsActivity.class);
        startActivity(addIntent);
    }
}