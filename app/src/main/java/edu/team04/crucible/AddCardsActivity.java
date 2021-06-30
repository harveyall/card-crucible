package edu.team04.crucible;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

/**
 * This activity is called when an add button is clicked from the EditCategoryActivity
 */
public class AddCardsActivity extends AppCompatActivity{

    //TODO: gather input for Category, question, answer and add card to local storage

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new ThemeUpdate(this, getApplicationContext()).updateTheme();
        setContentView(R.layout.activity_add_cards);
    }

    /**
     * This button leads back to the Main Activity.
     * @param button
     */
    public void backToSettings(View button) {
        Intent addIntent = new Intent(this, SettingsActivity.class);
        startActivity(addIntent);
    }

    /**
     * This button captured the text fields, and creates a new card with said fields' information.
     * @param view
     */
    public void AddNewCard(View view){
        EditText category = (EditText) findViewById(R.id.editTextCategory);
        EditText question = (EditText) findViewById(R.id.editTextQuestion);
        EditText answer = (EditText) findViewById(R.id.editTextAnswer);

        AddCardsHandler addCardsHandler = new AddCardsHandler(this, category.getText().toString(), question.getText().toString(), answer.getText().toString());
        Thread thread1 = new Thread(addCardsHandler, "AddCardsHandler");
        Log.d("AddCardsActivity", "Context is: " + this);
        Log.d("AddCardsActivity", "Calling AddCardsHandler on a background thread");
        thread1.start();
    }
}