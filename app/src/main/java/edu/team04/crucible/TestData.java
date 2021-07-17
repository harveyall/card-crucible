package edu.team04.crucible;

import android.content.Context;
import android.util.Log;

public class TestData implements Runnable{
    Context context;
    int count;

    TestData(Context context){
        this.context = context;
        this.count = 0;
    }
    /**
     * Reset the current file data to the test data everytime the app restarts
     */
    @Override
    public void run() {
        if(this.count == 0) {
            LocalStorageManager lsMgr = new LocalStorageManager(this.context);

            CategoryList newCategoryList = new CategoryList();
            Category category1 = new Category("Science");
            category1.addCard(new Card(category1.getName(), "Hg is the chemical symbol of which element?", "Mercury"));
            category1.addCard(new Card(category1.getName(), "About how many taste buds does the average human tongue have?", "10,000"));
            category1.addCard(new Card(category1.getName(), "Pure water has a pH level of around?", "Seven"));
            category1.addCard(new Card(category1.getName(), "Which scientist was awarded the 1921 Nobel Prize in Physics?", "Albert Einstein"));

            Category category2 = new Category("Cats");
            category2.addCard(new Card(category2.getName(), "What is the proper term for a group of kittens?", "kindle, litter or intrigue"));
            category2.addCard(new Card(category2.getName(), "All cats are born with what color eyes?", "blue"));
            category2.addCard(new Card(category2.getName(), "What percentage of a cat's bones are in its tail?", "10%"));
            category2.addCard(new Card(category2.getName(), "What breed of cat has a reputation for being cross-eyed?", "Siamese cats"));

            Category category3 = new Category("Computers");
            category3.addCard(new Card(category3.getName(), "When was the first computer invented?", "1943"));
            category3.addCard(new Card(category3.getName(), "What was the name of the first computer invented?", "Electronic Numerical Integrator and Computer (ENIAC)"));
            category3.addCard(new Card(category3.getName(), "Who is known as the father of computers?", "Charles Babbage"));
            category3.addCard(new Card(category3.getName(), "What was the first computer system that used color display?", "Apple 1"));
            category3.addCard(new Card(category3.getName(), "What was the first mass-produced computer?", "IBM 650"));
            category3.addCard(new Card(category3.getName(), "When was the first 1 GB disk drive released in the world?", "1980"));
            category3.addCard(new Card(category3.getName(), "What was the name of the first computer programmer?", "Ada Lovelace"));
            category3.addCard(new Card(category3.getName(), "Who is called the inventor of the first modern electronic computer?", "Konrad Zuse"));

            Category category4 = new Category("Geography");
            category4.addCard(new Card(category4.getName(), "What is Earth's largest continent?", "Asia"));
            category4.addCard(new Card(category4.getName(), "What razor-thin country accounts for more than half of the western coastline of South America?", "Chile"));
            category4.addCard(new Card(category4.getName(), "What is the driest place on Earth?", "McMurdo Dry Valleys in Antactica"));
            category4.addCard(new Card(category4.getName(), "Which African nation has the most pyramids?", "Sudan. It is home to over 200 pyramids, more than twice that of Egypt"));
            category4.addCard(new Card(category4.getName(), "What is the largest country in South America?", "Brazil"));
            category4.addCard(new Card(category4.getName(), "What is the smallest independent country on Earth?", "Vatican City. It has an area of just 0.44 kilometers"));


            newCategoryList.addCategory(category1);
            newCategoryList.addCategory(category2);
            newCategoryList.addCategory(category3);
            newCategoryList.addCategory(category4);

            lsMgr.saveCategoryList(newCategoryList);
            Log.d("TestData", "Test data saved");
            this.count += 1;
        }
    }
}