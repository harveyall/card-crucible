package edu.team04.crucible;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class CardSelectionActivity extends AppCompatActivity {
    //TODO: When begin button is clicked send selected category to StudyModeActivity

    public void Begin(View view) {
    Intent intent = new Intent(CardSelectionActivity.this, StudyModeActivity.class);
    //TODO: Populate Recyclerview with Card Categories.
    //TODO: Add selected Categories to intent.
        ((android.widget.Button)findViewById(R.id.button_begin)).setText(R.string.study_mode);
        startActivity(intent);
    }
        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_selection);
    }
}