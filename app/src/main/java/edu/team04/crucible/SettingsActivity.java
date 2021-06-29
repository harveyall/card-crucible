package edu.team04.crucible;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

/**
 * This class displays a list of categories, and allows the user to add or edit them in specially
 * made categories for each of those purposes.
 */
public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);
    }

    /**
     * This button leads back to the Main Activity.
     * @param button
     */
    public void backHome(View button) {
        Intent addIntent = new Intent(this, MainActivity.class);
        startActivity(addIntent);
    }

    /**
     * This button leads to the Add Category Activity, to add a new Card Category.
     * @param button
     */
    public void addCategory(View button) {
        //TODO: this method adds category to local storage as well as to the current list displayed on this activity
        // May need to reload activity
    }

    /**
     * This button leads to the Edit Category Activity, to edit the currently
     * selected category via radio button.
     * @param button
     */
    public void editCategory(View button) {
        //TODO: Add selected category to be edited.
        Intent editIntent = new Intent(this, EditCategoryActivity.class);
        startActivity(editIntent);
    }
}