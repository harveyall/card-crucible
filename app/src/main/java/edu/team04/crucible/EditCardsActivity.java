package edu.team04.crucible;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * This activity displays the card's attributes and allows the user to edit them, then
 * saving the changes on top of the same card through its handler.
 */
public class EditCardsActivity extends AppCompatActivity {
    //These next four values are the keys that should be put into this activity's intent.
    //Index is a String for now, need to negotiate whether an Int or String.
    private static final String index = "Index";
    private static final String cat = "Cat";
    private static final String ques = "Ques";
    private static final String answ = "Answ";

    private final EditText category_field = findViewById( R.id.editCardTextCategory);
    private final EditText question_field = findViewById( R.id.editCardTextQuestion);
    private final EditText answer_field = findViewById( R.id.editCardTextAnswer);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new ThemeHandler(this, getApplicationContext()).updateTheme();
        setContentView(R.layout.activity_edit_cards);
           category_field.setText(cat, TextView.BufferType.NORMAL);
           question_field.setText(ques, TextView.BufferType.EDITABLE);
           answer_field.setText(answ, TextView.BufferType.EDITABLE);
    }
    /**
     * This button leads back to the Settings Activity.
     * @param button button
     */
    public void backToSettings(View button) {
        Intent addIntent = new Intent(this, SettingsActivity.class);
        startActivity(addIntent);
    }

    /**
     * When the button is pressed, the information on the EditText fields is captured and used
     * to replace the existing card info on the category & the entire category list is saved via
     * the EditCardsHandler.
     * @param view view
     */
    public void commit_edited_card(View view){
        EditText category = findViewById(R.id.editCardTextCategory);
        EditText question = findViewById(R.id.editCardTextQuestion);
        EditText answer = findViewById(R.id.editCardTextAnswer);

        //TODO Check if data has been changed, if true, save new data.
        /*if (question == question_field) {

        }*/

        EditCardsHandler editCardsHandler = new EditCardsHandler(this, index, category.getText().toString(), question.getText().toString(), answer.getText().toString());
        Log.d("EditCardsActivity", "Context is: " + this);
        Log.d("EditCardsActivity", "Calling EditCardsHandler on a background thread");
        new Thread(editCardsHandler).start();
    }
}