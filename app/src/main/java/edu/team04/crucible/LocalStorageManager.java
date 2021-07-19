package edu.team04.crucible;

import android.content.Context;
import android.util.Log;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This class deals with editing and adding to local json file for app
 */
public class LocalStorageManager {
    Gson gson = new Gson();
    final private String FILENAME = "cardCrucible.txt";;
    Context context;
    //TODO: Figure out how to store local file on android device

    /** Construct a LocalStorageManager with a specified context
     * @param context*/
    public LocalStorageManager(Context context){
        this.context = context;
    }

    // Info on local data storage to android device
    // https://developer.android.com/training/data-storage/app-specific

    /**
     * This method loads the Category file from Shared Preferences and returns the list of categories.
     * @return The list of Categories
     */
    public CategoryList loadCategoryList() {
        Log.d("LocalStorageManager", "Retrieving cards");

        //Read data from file
        Log.d("LocalStorageManager", "Context is: " + context);
        String data = "";
        CategoryList categoryList = null;
        try{

            File file = new File(context.getFilesDir(), FILENAME);
            FileInputStream fis = this.context.openFileInput(file.getName());
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));

            String text;
            while((text = br.readLine()) != null){
                data += text;
            }

            } catch (IOException e) {
            e.printStackTrace();
        }
        categoryList = gson.fromJson(data, CategoryList.class);
            // deserialize json that was read from file to create CategoryList

        return categoryList;
    }

    /**
     * This method saves the list of categories on the Category file from Shared Preferences.
     */
    public void saveCategoryList(CategoryList categoryList){
        //TODO: before saving to device query available space on device
        //https://developer.android.com/training/data-storage/app-specific#query-free-space
        String json = gson.toJson(categoryList);

        try{
            FileOutputStream fos = this.context.openFileOutput(FILENAME, Context.MODE_PRIVATE);
            fos.write(json.getBytes());
            Log.d("LocalStorageManager", "File Saved");
            fos.close();
            //Toast.makeText(this.context, "Card saved to " + this.context.getFilesDir() + "/" + FILENAME, Toast.LENGTH_SHORT).show();
        } catch(IOException ioe){
            ioe.printStackTrace();
            Log.d("LocalStorageManager", "File Save Exception caught!");
            //Toast.makeText(this.context, "Error: Card not saved", Toast.LENGTH_SHORT).show();
        }
    }
}
