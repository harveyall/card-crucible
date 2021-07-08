package edu.team04.crucible;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.google.gson.Gson;

public class StudyModeHandler<categoryList> implements Runnable{
    Activity activity;
    CategoryList categoryList;
    public StudyModeHandler(Activity activity, Context context, CategoryList categoryList){
        this.categoryList = categoryList;
    }

    @Override
    public void run() {

    }
    //This class takes care of any requests by the StudyModeHelper
}
