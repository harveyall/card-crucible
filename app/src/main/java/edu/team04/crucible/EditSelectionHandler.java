package edu.team04.crucible;

import android.content.Context;

public class EditSelectionHandler implements Runnable{
    //This class takes care of any requests made by the EditCategoryAdapter
    Context context;
    CategoryList categoryList;
    Card cardToDelete;

    /** Construct an EditSelectionHandler with a specified context,
     * list of categories currently saved in local storage,
     * and a card to be deleted from that category list storage
     * @param context
     * @param savedCategoryList
     * @param cardToDelete*/
    public EditSelectionHandler(Context context, CategoryList savedCategoryList, Card cardToDelete){
        this.context = context;
        this.categoryList = savedCategoryList;
        this.cardToDelete = cardToDelete;
    }
    /** When this class is created get the category in the categoryList that is associated with the card to be deleted
     * Remove the card for that category
     * Is the category is now empty, remove it from the categoryList
     * Save the modified categoryList
     * */
    @Override
    public void run() {
        Category currentCategory = this.categoryList.getCategory(this.cardToDelete.getCategory());
        currentCategory.removeCard(cardToDelete);
        if (currentCategory.getCards().isEmpty()){
            categoryList.removeCategory(currentCategory);
        }
        new LocalStorageManager(this.context).saveCategoryList(categoryList);
    }



}
