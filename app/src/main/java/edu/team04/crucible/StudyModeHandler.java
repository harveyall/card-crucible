package edu.team04.crucible;

import android.content.Intent;

import com.google.gson.Gson;

public class StudyModeHandler<categoryList> {
    Gson gson = new Gson();
    String data = getIntent().getStringExtra(“CATEGORIES”);
    categoryList = gson.fromJson(data, CategoryList.class);
    private Intent getIntent() {
    }

    //This class takes care of any requests by the StudyModeHelper
}
