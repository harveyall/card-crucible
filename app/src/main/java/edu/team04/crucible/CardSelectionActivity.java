package edu.team04.crucible;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Card Selection Activity. In preparation for game/study mode, it displays a list of categories to
 * be used on the next activity. When the Begin button is pressed, the list gets sent to Card
 * Randomization, and comes back shuffled, and then fed into the next activity.
 */
public class CardSelectionActivity extends AppCompatActivity {
    public CategoryList categoryList;
    public CategoryList categories = new CategoryList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            new ThemeHandler(this, getApplicationContext()).updateTheme();
        setContentView(R.layout.activity_card_selection);
        Log.d("CardSelectionActivity", "Passing Activity: " + this + "Context: " + this);
        //CardSelectionHandler handleIt = new CardSelectionHandler(this, this);
        //new Thread((Runnable) handleIt).start();
        //callHandler();

        categoryList = new LocalStorageManager(this).loadCategoryList();
        ArrayList<String> nameList = new ArrayList<>();
        for(Category cat : categoryList.getCategories()) {
            String name = cat.getName();
            nameList.add(name);
        }
        populateListView(nameList);
    }

    /**
     * This button leads back to the Main Activity.
     * @param button
     */
    public void backHome(View button) {
        Intent addIntent = new Intent(this, MainActivity.class);
        startActivity(addIntent);
    }
    /*void callHandler() {

    }*/

    /**
     * This method takes the Category name ist from the Handler and displays it on the ListView,
     * it also handles the actual selection logic thanks to the new Selectable abstract class.
     * @param nameList List of category names from CardSelectionHandler
     */
    void populateListView(List<String> nameList) {
        Log.d("CardSelectionActivity", "Populating Category Listview with: " + nameList);
        ArrayAdapter<String> ListAdapter = new ArrayAdapter<>
                (this, android.R.layout.simple_list_item_multiple_choice, nameList);
        ListView listview = findViewById(R.id.category_view);
        listview.setAdapter(ListAdapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
                String row = nameList.get(position);
                Log.d("Card Selection Activity", "Selected row: " + row);
                Category selected = categoryList.getCategory(row);
                if (selected.isSelected()) {
                    selected.setSelected(false);
                    Log.d("Card Selection Activity", "Selected row: " + selected.getName());
                } else {
                    selected.setSelected(true);
                }
            }
        });
    }

    /**
     * This button takes the selected categories into the next Activity (Study or Game).
     * @param button
     */
    public void Begin(View button) {
        Intent studyModeActivity = new Intent(CardSelectionActivity.this, StudyModeActivity.class);
        for(Category selected : categoryList.getCategories()) {
            if (selected.isSelected()) {
                categories.addCategory(selected);
            }
        }
        Log.d("CardSelectionActivity", "About to pass intent to Next Activity with: " + categories);
        Gson gson = new Gson();
        String intentJson = gson.toJson(categories);
        studyModeActivity.putExtra("CATEGORIES", intentJson);
        //TODO: Figure out whether Study Mode or Game Activity comes next, and launch the right activity.
        //TODO: Communicate with Sean on the Json objects being passed to Studymodeactivity.
        startActivity(studyModeActivity);
    }
}