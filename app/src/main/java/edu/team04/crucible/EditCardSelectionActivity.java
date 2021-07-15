package edu.team04.crucible;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

import java.util.ArrayList;

/**
 * This Activity allows the user to edit an already existing card category.
 */
public class EditCardSelectionActivity extends AppCompatActivity {
    Gson gson = new Gson();
    CategoryList categoryList;
    CardList cardList;
    RecyclerView rvEditItem;
    CardView cvEditItem;

    // TODO: Go to EditCardActivity if Edit button is pressed
    // TODO: Add Category to local storage file if add button is clicked

    // TODO: Take care of all request from this class using EditCategoryHandler

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_category);
       new Thread(new TestData(getApplicationContext())).start();


        categoryList = new LocalStorageManager(this).loadCategoryList();
        cardList = new CardList(categoryList);


        rvEditItem = (RecyclerView) findViewById(R.id.rvEditItem);
        rvEditItem.setHasFixedSize(true);
        cvEditItem = (CardView) findViewById(R.id.cv_editableItem);


        rvEditItem.addItemDecoration( new DividerItemDecoration(rvEditItem.getContext(), DividerItemDecoration.VERTICAL));

        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        rvEditItem.setLayoutManager(manager);

        /* Create adapter passing in the sample user data */
        EditSelectionAdapter adapter = new EditSelectionAdapter(cardList);
        /* Attach the adapter to the recyclerview to populate items */
        rvEditItem.setAdapter(adapter);
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

}
