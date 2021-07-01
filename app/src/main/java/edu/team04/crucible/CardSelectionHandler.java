package edu.team04.crucible;

import android.content.Context;
import android.util.Log;
import java.util.ArrayList;

/**
 * This class takes care of any requests made by the CardSelectionActivity
 */
public class CardSelectionHandler implements Runnable {
    private CardSelectionActivity activity;
    private Context context;

    public CardSelectionHandler(CardSelectionActivity activity, Context context) {
    }

    /**
     * This override method calls a LocalStorageManager to Load the Category List, then slices
     * the list for the individual category names, to then send back to the CardSelectionActivity.
     */
    @Override
    public void run() {
        // TODO App crashes entering the CardSelectionActivity!
        //  Need to figure out the correct context argument for the LocalStorageManager call.
        Log.d("CardSelectionHandler", "Context is: " + context);
        //Log.d("CardSelectionHandler", "App context is: " + context.getApplicationContext());
        CategoryList categoryList = new LocalStorageManager(context).loadCategoryList();
        ArrayList<String> nameList = new ArrayList<>();
        for(Category cat : categoryList.getCategories()) {
            String name = cat.getName();
            nameList.add(name);
        }
        activity.populateListView(nameList);
    }
}