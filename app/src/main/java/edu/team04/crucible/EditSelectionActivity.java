package edu.team04.crucible;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * This Activity allows the user to edit an already existing card category.
 */
public class EditSelectionActivity extends AppCompatActivity {
    private RecyclerView rvEditItem;
    private EditSelectionAdapter adapter;
    private CardView cvEditItem;
    private EditText categoryFilterInput;
    private String categoryName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new ThemeHandler(this, getApplicationContext()).updateTheme();
        setContentView(R.layout.activity_edit_category);
        categoryFilterInput = (EditText) findViewById(R.id.editTextCategoryFilter);

        rvEditItem = (RecyclerView) findViewById(R.id.rvEditItem);
        rvEditItem.setHasFixedSize(true);
        cvEditItem = (CardView) findViewById(R.id.cv_editableItem);


        rvEditItem.addItemDecoration( new DividerItemDecoration(rvEditItem.getContext(), DividerItemDecoration.VERTICAL));

        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        rvEditItem.setLayoutManager(manager);

        /* Create adapter passing in the sample user data */
        adapter = new EditSelectionAdapter(getApplicationContext());
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
     * Take the EditText input and convert it to a string. Pass that category string to the adapter filter method.
     * @param view
     */
    public void filterCategories(View view){
        categoryName = categoryFilterInput.getText().toString();
        adapter.filterCards(categoryName);
    }

}
