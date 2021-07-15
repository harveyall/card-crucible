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
public class EditSelectionActivity extends AppCompatActivity {
    RecyclerView rvEditItem;
    CardView cvEditItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_category);
       new Thread(new TestData(getApplicationContext())).start();


        rvEditItem = (RecyclerView) findViewById(R.id.rvEditItem);
        rvEditItem.setHasFixedSize(true);
        cvEditItem = (CardView) findViewById(R.id.cv_editableItem);


        rvEditItem.addItemDecoration( new DividerItemDecoration(rvEditItem.getContext(), DividerItemDecoration.VERTICAL));

        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        rvEditItem.setLayoutManager(manager);

        /* Create adapter passing in the sample user data */
        EditSelectionAdapter adapter = new EditSelectionAdapter(getApplicationContext());
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
