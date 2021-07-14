package edu.team04.crucible;

import android.content.Intent;
import android.os.Bundle;
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
        RecyclerView rvEditItem = (RecyclerView) findViewById(R.id.rvEditItem);

        categoryList = new LocalStorageManager(this).loadCategoryList();
        cardList = new CardList(categoryList);

        /* rvEditItem = (RecyclerView) findViewById(R.id.rvEditItem); */
        rvEditItem.setHasFixedSize(true);
        cvEditItem = (CardView) findViewById(R.id.cv_editableItem);
        rvEditItem.setHasFixedSize(true);


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

    /**
     * This edit icon button leads to Edit Cards Activity.
     * @param view
     */
    public void editSelectedCard(View view){

        //TODO: get Card- this info we could hopefully get just by clicking on the edit button next to the card info
        //temporarily hard coded
        Card card = this.categoryList.getCategory(0).getCard(0);
        //end of temporarily hard coded data

        String json = gson.toJson(card);

        Intent intent = new Intent(this, EditCardsActivity.class);
        //TODO: putExtra with info category name, question, answer info
        intent.putExtra("CARD_DATA", json);
        startActivity(intent);
    }

    /**
     * This trash icon button leads to Delete Cards Activity.
     * @param view
     */
    public void deleteSelectedCard(View view){
        //TODO: delete card on the same line as trash icon from Category,
        // save edited to local storage,
        // likely will need to reload activity after change
    }

//    public ArrayList<Card> makeCardList() {
//        ArrayList<Card> cards = new ArrayList<>();
//        if(categoryList != null) {
//            for (Category category : this.categoryList.getCategories()) {
//                for (Card card : category.getCards()) {
//                    cards.add(card);
//                }
//            }
//        }
//        else{
//            cards = null;
//        }
//        return cardList;
//    }
}