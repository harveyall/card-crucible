package edu.team04.crucible;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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
    public CategoryList categories;
    //TODO: When begin button is clicked send selected category to StudyModeActivity

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            new ThemeHandler(this, getApplicationContext()).updateTheme();
        setContentView(R.layout.activity_card_selection);
        Log.d("CardSelectionActivity", "Passing Activity: " + this + "Context: " + this);
        //CardSelectionHandler handleIt = new CardSelectionHandler(this, this);
        //new Thread((Runnable) handleIt).start();
        //callHandler();

        CategoryList categoryList = new LocalStorageManager(this).loadCategoryList();
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
        Log.d("CardSelectionActivity", "About to create intent with " + categoryList);
        categories = new CategoryList();
        categories.addCategory(categoryList.getCategory(0));
        categories.addCategory(categoryList.getCategory(1));
        Gson gson = new Gson();
        String intentJson = gson.toJson(categoryList);
        studyModeActivity.putExtra("CATEGORIES", intentJson);
        //TODO: Add selected Categories to intent.
        startActivity(studyModeActivity);
    }
}