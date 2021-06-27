package edu.team04.crucible;

import android.content.Context;
import android.util.Log;

/**
 * This class processes the logic of adding cards to a category, either existing or brand new.
 */
public class AddCardsHandler implements Runnable {
    final private String filename = "cardCrucible.txt";
    Context context;
    String category;
    String question;
    String answer;

        public AddCardsHandler(Context context, String category, String question, String answer) {
            this.context = context;
            Log.d("AddCardsHandler", "Context is: " + this.context);
            this.category = category;
            this.question = question;
            this.answer = answer;
        }

        @Override
        public void run() {
            //TODO: Create new card based on input

            final LocalStorageManager lsMgr = new LocalStorageManager(this.context, filename);

            Card newCard = new Card(this.question, this.answer);
            Log.d("AddCardsHandler", "Card Question: " + this.question + " Card Answer: " + this.answer);

            //TODO: Grab current category list from local storage
            CategoryList categoryList = lsMgr.loadCategoryList();
            //if categoryList file contains no data set categoryList = new CategoryList()
            if (categoryList == null) {
                categoryList = new CategoryList();
            }
            //TODO: check if category already exists
            Category cardCategory = categoryList.getCategory(this.category);

            //TODO: if category does not exist add category
            if (cardCategory == null) {

                Category newCategory = new Category(this.category);
                //add card to category
                newCategory.addCard(newCard);
                //add Category to list
                categoryList.addCategory(newCategory);
            }
            //TODO: add new card to category
            else {
                cardCategory.addCard(newCard);
            }

            //TODO: save edited Category List to local file
            Log.d("AddCardsHandler", "Calling LocalStorageManager to Save the Category List");
            Log.d("AddCardsHandler", "Category List is: " + categoryList.getCategories());
            lsMgr.saveCategoryList(categoryList);

            //this part is here temporarily just to make sure cards are loading appropriately
            CategoryList loadedList = lsMgr.loadCategoryList();
            Log.d("AddCardsHandler", "Category List is: " + loadedList.getCategories());
        }
    }


