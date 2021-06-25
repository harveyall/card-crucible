package edu.team04.crucible;

import android.content.Context;

public class AddCardsHandler {
    final private String filename = "./cardCrucible.txt";
    Context context;

    public AddCardsHandler(Context context){
        this.context = context;
    }

    public void manageCardAddition(String category, String question, String answer){
        //TODO: Create new card based on input

        final LocalStorageManager lsMgr = new LocalStorageManager(this.context, filename);

        Card newCard = new Card(question, answer);

        //TODO: Grab current category list from local storage
        CategoryList categoryList = lsMgr.loadCategoryList();
        //if categoryList file contains no data set categoryList = new CategoryList()
        if (categoryList == null){
            categoryList = new CategoryList();
        }
        //TODO: check if category already exists
        Category cardCategory = categoryList.getCategory(category);

        //TODO: if category does not exist add category
        if(cardCategory == null){

            Category newCategory = new Category(category);
            //add card to category
            newCategory.addCard(newCard);
            //add Category to list
            categoryList.addCategory(newCategory);
        }
        //TODO: add new card to category
        else{
            cardCategory.addCard(newCard);
        }

        //TODO: save edited Category List to local file
        lsMgr.saveCategoryList(categoryList);

    }
}
