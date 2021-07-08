package edu.team04.crucible;

import android.content.Context;
import android.util.Log;

/**
 * This class takes care of any requests made by the CardSelectionActivity
 */
public class CardSelectionHandler implements Runnable {
    private CardSelectionActivity activity;
    private Context context;
    private CategoryList categoryList;

    public CardSelectionHandler(CardSelectionActivity activity, Context context, CategoryList categoryList) {
        this.activity = activity;
        this.context = context;
        this.categoryList = categoryList;
    }

    /**
     * This override method finds the selected cards by the user, adds them to a new ad-hoc category,
     * shuffles those cards, and sends them to the next Activity via CardSelectionActivity.
     */
    @Override
    public void run() {
        CategoryList category = new CategoryList();
        Category shuffledCards = new Category("Shuffled");
        for (int i = 0; i < categoryList.getCategories().size(); i++) {
            if (categoryList.getCategory(i).isSelected()) {
                for (int j = 0; j < categoryList.getCategory(i).getCards().size(); j++) {
                    shuffledCards.addCard(categoryList.getCategory(i).getCard(j));

                }
            categoryList.getCategory(i).setSelected(false);
            }
        }
        Log.d("CardSelectionHandler", "Original contents: " + shuffledCards);
        shuffledCards.randomizeCategory(shuffledCards);
        Log.d("CardSelectionHandler", "Shuffled contents: " + shuffledCards);
        category.addCategory(shuffledCards);

        activity.nextActivity(category);
    }
}
