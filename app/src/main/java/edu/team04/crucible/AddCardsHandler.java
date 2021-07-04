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

            //Grab category list data from local storage
            CategoryList categoryList = lsMgr.loadCategoryList();

            //if categoryList file contains no data set categoryList = new CategoryList()
            if (categoryList == null) {
                categoryList = new CategoryList();
            }
            //TODO: Add code so the user doesn't add the same card twice to the same category
            //TODO: Do not allow card to be added with empty fields

            //Get category from category if it exists
            Category cardCategory = categoryList.getCategory(this.category);

            if (cardCategory == null && categoryList.canAddCategories()) {
                // create a new category
                cardCategory = new Category(this.category);
                //add category to list
                categoryList.addCategory(cardCategory);

                }


            //add card to category if it has less than 50 cards and there are less than 5 categories in the list
            if(cardCategory != null && cardCategory.canAddCards()){
                //add card to category
                cardCategory.addCard(newCard);
                toastOnUIThread("Card Saved");
            } else if(cardCategory == null && !categoryList.canAddCategories()){
                toastOnUIThread("-------------------Card NOT saved-------------------\n" +
                        "Max of 5 categories already reached");
            }else if(!cardCategory.canAddCards()){
                toastOnUIThread("-------------------Card NOT saved--------------------\n" +
                        "Max of 50 cards already reached for this category");
            }


            //Save edited Category List to local file
            Log.d("AddCardsHandler", "Calling LocalStorageManager to Save the Category List");
            Log.d("AddCardsHandler", "Category List is: " + categoryList.getCategories());
            lsMgr.saveCategoryList(categoryList);

            ((AddCardsActivity)this.activity).resetInput();


            //this part is here temporarily just to make sure cards are loading appropriately
            CategoryList loadedList = lsMgr.loadCategoryList();
            Log.d("AddCardsHandler", "Category List is: " + loadedList.getCategories());
        }

        public void toastOnUIThread(String message){
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(activity.getApplicationContext(), message, Toast.LENGTH_LONG).show();
                }
            });
        }
    }


