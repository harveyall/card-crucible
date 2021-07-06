package edu.team04.crucible;

import android.content.Context;
import android.util.Log;

/**
 * This class takes care of any requests made by the CardSelectionActivity
 */
public class CardSelectionHandler implements Runnable {
    private CardSelectionActivity activity;
    private Context context;
    private CategoryList categories;

    public CardSelectionHandler(CardSelectionActivity activity, Context context, CategoryList categories) {
        this.activity = activity;
        this.context = context;
        this.categories = categories;
    }

    /**
     * This override method calls a LocalStorageManager to Load the Category List, then slices
     * the list for the individual category names, to then send back to the CardSelectionActivity.
     */
    @Override
    public void run() {
        Log.d("CardSelectionHandler", "Context is: " + context);

        CategoryList shuffledCards = new CategoryList();
        for(Category selected : categories.getCategories()) {
            Log.d("CardSelectionHandler", "Categories are: " + selected);
            selected.randomizeCategory(selected);
            Log.d("CardSelectionHandler", "Shuffled contents: " + selected);
            shuffledCards.addCategory(selected);
            Log.d("CardSelectionHandler", "Final CategoryList is: " + shuffledCards);
        }
        activity.nextActivity(shuffledCards);
    }
}