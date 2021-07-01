package edu.team04.crucible;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import java.util.List;

/**
 * This Activity allows the user to edit an already existing card category.
 */
public class EditCardSelectionActivity extends AppCompatActivity {
    Gson gson = new Gson();
    CategoryList categoryList;

    // TODO: Go to EditCardActivity if Edit button is pressed
    // TODO: Add Category to local storage file if add button is clicked

    // TODO: Take care of all request from this class using EditCategoryHandler

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new ThemeHandler(this, getApplicationContext()).updateTheme();
        setContentView(R.layout.activity_edit_category);
        categoryList = new LocalStorageManager(this).loadCategoryList();
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
    public void editSelectedCard(View view){
        //TODO: get name of category card is in
        //temporarily hard coded
        String categoryName = "Category 1";
        //end of temporarily hard coded data

        //TODO: get Card- this info we could hopefully get just by clicking on the edit button next to the card info
        //temporarily hard coded
        String question = "Unedited Question";
        String answer = "Unedited Answer";
        Card card = new Card(question, answer);
        //end of temporarily hard coded data

        String json = gson.toJson(card);

        Intent intent = new Intent(this, EditCardsActivity.class);
        //TODO: putExtra with info category name, question, answer info
        intent.putExtra("CATEGORY_NAME", categoryName);
        intent.putExtra("CARD_DATA", json);
        startActivity(intent);
    }

    /**
     * This trash icon button leads to Delete Cards Activity.
     * @param view
     */
    public void deleteSelectedCard(View view){
        //TODO: delete card on the same line as trash icon from Category,
        // save edited to local storage,
        // likely will need to reload activity after change
    }
}