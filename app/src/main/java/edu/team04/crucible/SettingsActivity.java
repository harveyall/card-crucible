package edu.team04.crucible;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
//import androidx.preference.PreferenceFragmentCompat;

public class SettingsActivity extends AppCompatActivity {

    //TODO: When Begin button is pressed start EditCategoryActivity
    // and send it the selected Category's Card List

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //((android.widget.Button)findViewById(R.id.button_category_add)).setText(R.string.add_category);
        //((android.widget.Button)findViewById(R.id.button_category_edit)).setText(R.string.edit_category);
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
        Intent addIntent = new Intent(this, AddCardsActivity.class);
          startActivity(addIntent);
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