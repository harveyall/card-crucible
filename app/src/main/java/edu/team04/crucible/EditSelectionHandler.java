package edu.team04.crucible;




import android.content.Context;
import android.util.Log;

public class EditSelectionHandler implements Runnable{
    //This class takes care of any requests made by the EditCategoryAdapter
    Context context;
    CategoryList categoryList;
    Card cardToDelete;
    public EditSelectionHandler(Context context, CategoryList savedCategoryList, Card cardToDelete){
        this.context = context;
        this.categoryList = savedCategoryList;
        this.cardToDelete = cardToDelete;
    }
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
