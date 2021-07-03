package edu.team04.crucible;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

/**
 * This class processes the logic of adding cards to a category, either existing or brand new.
 */
public class AddCardsHandler implements Runnable {
    Activity activity;
    Context context;
    String category;
    String question;
    String answer;

        public AddCardsHandler(Activity activity, Context context, String category, String question, String answer) {
            this.activity = activity;
            Log.d("AddCardsHandler", "Activity is: " + this.activity);
            this.context = context;
            Log.d("AddCardsHandler", "Context is: " + this.context);
            this.category = category;
            this.question = question;
            this.answer = answer;
        }

        @Override
        public void run() {

            final LocalStorageManager lsMgr = new LocalStorageManager(this.context);

            //Create new card based on input
            Card newCard = new Card(this.category, this.question, this.answer);
            Log.d("AddCardsHandler", "Card Question: " + this.question + " Card Answer: " + this.answer);

            //Grab current category list from local storage
            CategoryList categoryList = lsMgr.loadCategoryList();

            //if categoryList file contains no data set categoryList = new CategoryList()
            if (categoryList == null) {
                categoryList = new CategoryList();
            }

            //Check if category already exists
            Category cardCategory = categoryList.getCategory(this.category);
            //If category does not exist add category
            if (cardCategory == null) {

                Category newCategory = new Category(this.category);
                //add card to category
                newCategory.addCard(newCard);
                //add Category to list
                categoryList.addCategory(newCategory);
            }
            //Add new card to category
            else {
                cardCategory.addCard(newCard);
            }

            //Save edited Category List to local file
            Log.d("AddCardsHandler", "Calling LocalStorageManager to Save the Category List");
            Log.d("AddCardsHandler", "Category List is: " + categoryList.getCategories());
            lsMgr.saveCategoryList(categoryList);

            ((AddCardsActivity)this.activity).resetInput();

            //TODO: add toast if card is save successfully

            //TODO: add toast to tell user if they have already exceeded # of categories or cards/category
            //if categoryList.canAddCategories() == false
            //if category.canAddCards() == false

            //this part is here temporarily just to make sure cards are loading appropriately
            CategoryList loadedList = lsMgr.loadCategoryList();
            Log.d("AddCardsHandler", "Category List is: " + loadedList.getCategories());
        }
    }


