package edu.team04.crucible;

import android.app.Activity;
import android.content.Context;

public class StudyModeHandler implements Runnable{
    Activity activity;
    Context context;
    CardList cards;
    public StudyModeHandler(Activity activity, Context context, CardList cards){
        this.activity = activity;
        this.context = context;
        this.cards = cards;
    }

    @Override
    public void run() {

    }
    //This class takes care of any requests by the StudyModeHelper

}
