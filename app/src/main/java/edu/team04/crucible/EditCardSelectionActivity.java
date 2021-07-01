package edu.team04.crucible;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

/**
 * This Activity allows the user to edit an already existing card category.
 */
public class EditCardSelectionActivity extends AppCompatActivity {

    // TODO: Go to EditCardActivity if Edit button is pressed
    // TODO: Add Category to local storage file if add button is clicked

    // TODO: Take care of all request from this class using EditCategoryHandler

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new ThemeHandler(this, getApplicationContext()).updateTheme();
        setContentView(R.layout.activity_edit_category);
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
     * This button leads to the Add Card Activity.
     * @param view
     */
    public void filterCategories(View view){
     //TODO: this function will filter editable cards by categories
    }

    /**
     * This edit icon button leads to Edit Cards Activity.
     * @param view
     */
    public void editCardActivity(View view){
        Intent addIntent = new Intent(this, EditCardsActivity.class);
        startActivity(addIntent);
    }

    /**
     * This trash icon button leads to Delete Cards Activity.
     * @param card
     */
    public void deleteCardFromFile(Card card){
        //TODO: delete card on the same line as trash icon from Category,
        // save edited to local storage,
        // likely will need to reload activity after change
    }
}