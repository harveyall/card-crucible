package edu.team04.crucible;

import android.util.Log;

import java.util.Collections;

/** With the addition of the randomizeCards() method to Category,
 * THIS CLASS IS OBSOLETE and should be deprecated
 *
 * Presenter class intended to be called from CardSelectionActivity in order to shuffle cards in
 * categories in preparation for study/game mode.
 */
public class CardRandomization {
    public CategoryList categoryList;

    public CardRandomization(CategoryList categoryList) {
        this.categoryList = categoryList;
    }

    /** Featuring a single method to do everything we need from this class.
     * Pulling the List of categories, and shuffling the cards on each category.
     * @return categoryList
     */
    public CategoryList run() {

        for (Category cat : categoryList.getCategories()){
            Log.d("CardSelection", "Original List on " + cat + cat.getCards());
            Log.d("CardSelection", "Shuffled List follows");
            Collections.shuffle(cat.getCards());
            Log.d("CardSelection", "Shuffled List on " + cat + cat.getCards());
        }
            return categoryList;

    }
}
