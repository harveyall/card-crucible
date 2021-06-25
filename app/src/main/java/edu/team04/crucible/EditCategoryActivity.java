package edu.team04.crucible;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

/**
 * This Activity allows the user to edit an already existing card category.
 */
public class EditCategoryActivity extends AppCompatActivity {

    // TODO: Go to EditCardActivity if Edit button is pressed
    // TODO: Add Category to local storage file if add button is clicked

    // TODO: Take care of all request from this class using EditCategoryHandler

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_category);
    }

    /**
     * This button leads back to the Main Activity.
     * @param button
     */
    public void backHome(View button) {
        Intent addIntent = new Intent(this, MainActivity.class);
        startActivity(addIntent);
    }

}