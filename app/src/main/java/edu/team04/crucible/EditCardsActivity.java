package edu.team04.crucible;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*  *
 * This activity displays the card's attributes and allows the user to edit them, then
 * saving the changes on top of the same card through its handler.
 */
public class EditCardsActivity extends AppCompatActivity {
    //These next four values are the keys that should be put into this activity's intent.
    //Index is a String for now, need to negotiate whether an Int or String.
    private static  String index = "Index";
    private static  String cat = "Cat";
    private static  String ques = "Ques";
    private static  String answ = "Answ";

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
        //Checking if question is not empty.
        //TODO Test regexes with user inputs.
        question.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String new_question = s.toString();
                Pattern pattern = Pattern.compile("^[a-zA-Z0-9_]+( [a-zA-Z0-9_]+)*$|\\?$", Pattern.CASE_INSENSITIVE);
                Matcher matcher = pattern.matcher(new_question);
                boolean matchFound = matcher.find();
                if(!matchFound) {
                    String message = "Card NOT saved \nNo empty fields allowed.";
                    send_toast(message);
                }
            }
        });
        //Checking if answer is not empty.
        answer.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String new_answer = s.toString();
                Pattern pattern = Pattern.compile("^[a-zA-Z0-9_]+( [a-zA-Z0-9_]+)*$", Pattern.CASE_INSENSITIVE);
                Matcher matcher = pattern.matcher(new_answer);
                boolean matchFound = matcher.find();
                if(!matchFound) {
                    String message = "Card NOT saved \nNo empty fields allowed.";
                    send_toast(message);
                }
            }
        });
        //Calling EditCardsHandler to save the now edited card.
        EditCardsHandler editCardsHandler = new EditCardsHandler(this, index, category.getText().toString(), question.getText().toString(), answer.getText().toString());
        Log.d("EditCardsActivity", "Context is: " + this);
        Log.d("EditCardsActivity", "Calling EditCardsHandler on a background thread");
        new Thread(editCardsHandler).start();
    }

    /**
     * Allows the activity to send toasts to the user.
     * @param message Message string
     */
    public void send_toast(String message){
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}