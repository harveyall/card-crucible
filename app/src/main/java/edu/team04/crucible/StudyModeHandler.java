package edu.team04.crucible;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class StudyModeHandler<categoryList> implements Runnable{
    Activity activity;
    Context context;
    CategoryList categoryList;
    List<Card> cards;
    public StudyModeHandler(Activity activity, Context context, CategoryList categoryList){
        this.activity = activity;
        this.context = context;
        this.categoryList = categoryList;
        this.cards = createCardList();
    }

    @Override
    public void run() {

    }
    //This class takes care of any requests by the StudyModeHelper


    //TODO: remove this method later if it gets used instead in the CardSelectionActivity.
    /** Takes the categoryList returned by the cardSelectionActivity and turns it into a cardList*/
    public ArrayList<Card> createCardList(){
        ArrayList<Card> cards = new ArrayList<>();
        if(categoryList != null) {
            for (Category category : this.categoryList.getCategories()) {
                cards.addAll(category.getCards());
            }
        }
        else{
            cards = null;
        }
        return cards;
    }
}
