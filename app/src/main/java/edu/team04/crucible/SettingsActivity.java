package edu.team04.crucible;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

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
    public void addCardsActivity(View button) {
        Intent intent = new Intent(this, AddCardsActivity.class);
        startActivity(intent);
    }

    /**
     * This button leads to the Edit Category Activity, to edit cards and filter them by category
     * @param button
     */
    public void editCategoryActivity(View button) {
        Intent editIntent = new Intent(this, EditCategoryActivity.class);
        startActivity(editIntent);
    }
    /**
     * This button leads to the Edit Theme Activity, edit the currently displayed theme
     * @param button
     */
    public void editThemeActivity(View button) {
        Intent intent = new Intent(this, EditThemeActivity.class);
        startActivity(intent);
    }
}