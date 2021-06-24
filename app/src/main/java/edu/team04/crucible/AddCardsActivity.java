package edu.team04.crucible;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddCardsActivity extends AppCompatActivity {
    //This activity is called when an add button is clicked from the EditCategoryActivity
    AddCardsHandler addCardsHandler = new AddCardsHandler();

    //TODO: gather input for Category, question, answer and add card to local storage

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_cards);
    }

    public void AddNewCard(View view){
        //TODO: figure out how we plan to set and use ID, temporarily hard-coding id to 0
        EditText category = (EditText) findViewById(R.id.editTextCategory);
        EditText question = (EditText) findViewById(R.id.editTextQuestion);
        EditText answer = (EditText) findViewById(R.id.editTextAnswer);

        addCardsHandler.addCard(category.getText().toString(), question.getText().toString(), answer.getText().toString());

    }
}