package edu.team04.crucible;

public class AddCardsHandler {
    final private String filename = "./cardCrucible.txt";
    final LocalStorageManager lsMgr= new LocalStorageManager(filename);


    public void addCard(String category, String question, String answer){
        //TODO: Create new card based on input
        Card newCard = new Card(0, question, answer);

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

            //TODO: fix id (currently hard-coded)
            Category newCategory = new Category(1, category);
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
