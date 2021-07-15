package edu.team04.crucible;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

/**
 * This class does the behind the scenes work (Array & file operations) for the Edit Cards Activity.
 */
public class EditCardsHandler implements Runnable {
    Activity activity;
    Context context;
    String category;
    String question;
    String answer;
    Card originalCard;
    int index;

    public EditCardsHandler(Context context, Card originalCard, String category, String question, String answer) {
        this.context = context;
        this.originalCard = originalCard;

        this.category = category;
        this.question = question;
        this.answer = answer;
    }

    /**
     * Override default method uses the provided index, category, question & answer to replace
     * the card in the same category, and saves the entire category list to storage.
     */
    @Override
    public void run() {
        // This will hopefully use the index of the existing card to be replaced by the edited card.
        final LocalStorageManager lsMgr = new LocalStorageManager(this.context);
        Card editedCard = new Card(this.category, this.question, this.answer);
        Log.d("EditCardsHandler", "Card Question: " + this.question + " Card Answer: " + this.answer);
        CategoryList categoryList = lsMgr.loadCategoryList();
        Category cardCategory = categoryList.getCategory(this.category);
        index = cardCategory.getCardIndex(originalCard);
        cardCategory.replaceCard(index, editedCard);
        Log.d("AddCardsHandler", "Calling LocalStorageManager to Save the Category List");
        Log.d("AddCardsHandler", "Category List is: " + categoryList.getCategories());
        lsMgr.saveCategoryList(categoryList);
    }
}