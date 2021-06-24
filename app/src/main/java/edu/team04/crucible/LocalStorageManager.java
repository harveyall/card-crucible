package edu.team04.crucible;

import android.util.Log;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class LocalStorageManager {
    Gson gson = new Gson();
    final private String filename;
    //This class deals with editing and adding to local json file for app

    public LocalStorageManager(String filename){
        this.filename = filename;
    }

    public CategoryList loadCategoryList() {
        Log.d("LocalStorageManager", "Retrieving cards");

        //Read data from file
        String data = "";
        CategoryList categoryList = null;
        try{
            BufferedReader br = new BufferedReader(new FileReader(this.filename));
            String line = br.readLine();
            while(line != null){
                data += line;
                line = br.readLine();
            }
            categoryList = gson.fromJson(data, CategoryList.class);
            // deserialize json that was read from file to create CategoryList


        } catch(IOException ioe){
            ioe.printStackTrace();
        }
        return categoryList;
    }

    public void saveCategoryList(CategoryList categoryList){
        String json = gson.toJson(categoryList);

        try{
            PrintWriter pw = new PrintWriter(new FileWriter(this.filename));
            pw.print(json);
            pw.close();
        } catch(IOException ioe){
            ioe.printStackTrace();
        }

    }

}