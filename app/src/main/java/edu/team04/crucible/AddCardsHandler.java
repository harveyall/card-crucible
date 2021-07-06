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
            Log.d("AddCardsHandler", "Card Category: " + this.category + "Card Question: " + this.question + " Card Answer: " + this.answer);

            //Grab category list data from local storage
            CategoryList categoryList = lsMgr.loadCategoryList();

            //if categoryList file contains no data set categoryList = new CategoryList()
            if (categoryList == null) {
                categoryList = new CategoryList();
            }

            //Get category from category if it exists, if it does not exist cardCategory is null
            Category cardCategory = categoryList.getCategory(this.category);

            if (cardCategory == null && !inputIsEmpty() && categoryList.canAddCategory()) {
                //if category does not yet exist, the input fields are not empty, and the category max have not been met
                // create a new category
                cardCategory = new Category(this.category);
                //add category to list
                categoryList.addCategory(cardCategory); //category will not be added if there are already 5 categories in the list

                }



            if(inputIsEmpty()){
                toastOnUIThread("Please fill in ALL input fields");
            } else if(cardCategory == null){
                //cardCategory will be null if:
                // the input fields are not empty,
                // the category does not exit,
                // and new categories cannot be added

                toastOnUIThread("                   Card NOT saved\n" +
                        "Max of 5 categories already reached");
            }else if(cardCategory.containsCard(newCard)){
                toastOnUIThread("This card already exists in " + this.category);
            }else if(!cardCategory.canAddCards()){
                toastOnUIThread("                   Card NOT saved\n" +
                        "Max of 50 cards already reached for " + this.category);
            } else{
                //add card to category if it has < 50 cards and there are < 5 categories in the list
                //add card to category
                cardCategory.addCard(newCard); //card will not be added if 50 cards already in category
                toastOnUIThread("Card Saved");
            }


            //Save edited Category List to local file
            Log.d("AddCardsHandler", "Calling LocalStorageManager to Save the Category List");
            Log.d("AddCardsHandler", "Category List is: " + categoryList.getCategories());
            lsMgr.saveCategoryList(categoryList);

            //do not reset input if not all field were filled in before pushing the add button
            if(!inputIsEmpty()) {
                ((AddCardsActivity) this.activity).resetInput();
            }


            //this part is here temporarily just to make sure cards are loading appropriately
            CategoryList loadedList = lsMgr.loadCategoryList();
            Log.d("AddCardsHandler", "Category List is: " + loadedList.getCategories());
        }

    /** Return true if all input fields are field and false if one or more input field are empty */
        public boolean inputIsEmpty(){
            if(category.equals("") || question.equals("") || answer.equals("")){
                return true;
            }
            else{
                return false;
            }
        }

    /**
     * Make a toast on the main UI thread
     * @param message
     * */
        public void toastOnUIThread(String message){
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(activity.getApplicationContext(), message, Toast.LENGTH_LONG).show();
                }
            });
        }
    }


