package edu.team04.crucible;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

/**
 * Card Selection Activity. In preparation for game/study mode, it displays a list of categories to
 * be used on the next activity. When the Begin button is pressed, the list gets sent to Card
 * Randomization, and comes back shuffled, and then fed into the next activity.
 */
public class CardSelectionActivity extends AppCompatActivity {
    //TODO: When begin button is clicked send selected category to StudyModeActivity

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            new ThemeHandler(this, getApplicationContext()).updateTheme();
        //((android.widget.Button)findViewById(R.id.button_begin)).setText(R.string.study_mode);
        setContentView(R.layout.activity_card_selection);
        callHandler();
    }

    /**
     * This button leads back to the Main Activity.
     * @param button
     */
    public void backHome(View button) {
        Intent addIntent = new Intent(this, MainActivity.class);
        startActivity(addIntent);
    }
    void callHandler() {
        Log.d("CardSelectionActivity", "Passing Activity: " + this + "Context: " + this);
        CardSelectionHandler handleIt = new CardSelectionHandler(this, this);
        new Thread((Runnable) handleIt).start();
    }

    void populateListView(List<String> categoryList) {
        Log.d("CardSelectionActivity", "Populating Category Listview with: " + categoryList);
        ArrayAdapter<String> ListAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, categoryList);
        ListView listview = (ListView) findViewById(R.id.category_view);
        listview.setAdapter(ListAdapter);
    }

    /**
     * This button takes the selected categories into the next Activity (Study or Game).
     * @param button
     */
    public void Begin(View button) {
        Intent studyModeActivity = new Intent(CardSelectionActivity.this, StudyModeActivity.class);
        //TODO: Populate Listview/Recyclerview with Card Categories.
        //TODO: Add selected Categories to intent.
        startActivity(studyModeActivity);
    }
}