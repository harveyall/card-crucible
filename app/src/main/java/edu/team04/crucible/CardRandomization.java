package edu.team04.crucible;

import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;

/** Presenter class intended to be called from CardSelectionActivity in order to shuffle cards in
 * categories in preparation for study/game mode.
 */
public class CardRandomization {
    private ArrayList<Category> categoryList;

    public CardRandomization(ArrayList<Category> categoryList) {
        this.categoryList = categoryList;
    }

    /** Featuring a single method to do everything we need from this class.
     * Pulling the List of categories, and shuffling the cards on each category.
     * @return categoryList
     */
    public ArrayList<Category> run() {

        for(Category cat : categoryList ) {
            Log.d("CardSelection", "Original List on " + cat + cat.getCards());
            Log.d("CardSelection", "Shuffled List follows");
            Collections.shuffle(cat.getCards());
            Log.d("CardSelection", "Shuffled List on " + cat + cat.getCards());
        }
        //TODO Test randomization with actual cards & categories.
        return categoryList;
    }
}
