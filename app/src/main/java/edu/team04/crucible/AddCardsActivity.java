package edu.team04.crucible;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class AddCardsActivity extends AppCompatActivity {
    //This activity is called when an add button is clicked from the EditCategoryActivity

    //TODO: gather input for Category, question, answer and add card to local storage

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_cards);
    }
}