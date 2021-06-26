package edu.team04.crucible;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;
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
    final private String FILENAME;
    Context context;
    //TODO: Figure out how to store local file on android device

    public LocalStorageManager(Context context, String filename){
        this.context = context;
        this.FILENAME = filename;
    }

    // Info on local data storage to android device
    // https://developer.android.com/training/data-storage/app-specific

    public CategoryList loadCategoryList() {
        Log.d("LocalStorageManager", "Retrieving cards");

        //Read data from file
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

    public void saveCategoryList(CategoryList categoryList){
        //TODO: before saving to device query available space on device
        //https://developer.android.com/training/data-storage/app-specific#query-free-space
        String json = gson.toJson(categoryList);

        try{
            FileOutputStream fos = this.context.openFileOutput(FILENAME, Context.MODE_PRIVATE);
            fos.write(json.getBytes());
            fos.close();
            Toast.makeText(this.context, "Card saved to " + this.context.getFilesDir() + "/" + FILENAME, Toast.LENGTH_SHORT).show();
        } catch(IOException ioe){
            ioe.printStackTrace();
            Toast.makeText(this.context, "Error: Card not saved", Toast.LENGTH_SHORT).show();
        }
    }

}
