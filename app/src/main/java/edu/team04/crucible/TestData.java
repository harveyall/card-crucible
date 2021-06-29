package edu.team04.crucible;

import android.content.Context;
import android.util.Log;

public class TestData implements Runnable{
    final private String filename = "cardCrucible.txt";
    Context context;

    TestData(Context context){
        this.context = context;
    }
    /**
     * Reset the current file data to the test data everytime the app restarts
     */
    @Override
    public void run() {
        LocalStorageManager lsMgr = new LocalStorageManager(this.context, filename);

        CategoryList newCategoryList = new CategoryList();
        Category category1 = new Category("Category 1");
        category1.addCard(new Card("cat1question1", "cat1answer1"));
        category1.addCard(new Card("cat1question2", "cat1answer2"));
        category1.addCard(new Card("cat1question3", "cat1answer3"));
        category1.addCard(new Card("cat1question4", "cat1answer4"));

        Category category2 = new Category("Category 2");
        category2.addCard(new Card("cat2question1", "cat2answer1"));
        category2.addCard(new Card("cat2question2", "cat2answer2"));
        category2.addCard(new Card("cat2question3", "cat2answer3"));
        category2.addCard(new Card("cat2question4", "cat2answer4"));

        Category category3 = new Category("Category 3");
        category3.addCard(new Card("cat3question1", "cat3answer1"));
        category3.addCard(new Card("cat3question2", "cat3answer2"));
        category3.addCard(new Card("cat3question3", "cat3answer3"));
        category3.addCard(new Card("cat3question4", "cat3answer4"));
        category3.addCard(new Card("cat3question5", "cat3answer5"));
        category3.addCard(new Card("cat3question6", "cat3answer6"));
        category3.addCard(new Card("cat3question7", "cat3answer7"));
        category3.addCard(new Card("cat3question8", "cat3answer8"));

        Category category4 = new Category("Category 4");
        category4.addCard(new Card("cat4question1", "cat4answer1"));
        category4.addCard(new Card("cat4question2", "cat4answer2"));
        category4.addCard(new Card("cat4question3", "cat4answer3"));
        category4.addCard(new Card("cat4question4", "cat4answer4"));
        category4.addCard(new Card("cat4question5", "cat4answer5"));
        category4.addCard(new Card("cat4question6", "cat4answer6"));


        newCategoryList.addCategory(category1);
        newCategoryList.addCategory(category2);
        newCategoryList.addCategory(category3);
        newCategoryList.addCategory(category4);

        Log.d("TestData", "Calling LocalStorageManager to Load the Category List");
        CategoryList oldCategoryList = lsMgr.loadCategoryList();

        if (!oldCategoryList.equals(newCategoryList)) {
            Log.d("TestData", "Clearing current data Category List data");
            oldCategoryList.clearData();

            lsMgr.saveCategoryList(newCategoryList);
            Log.d("TestData", "Test data saved");
        }
        else{
            Log.d("TestData", "Test data not saved because it already exists");
        }
    }

    }

