package edu.team04.crucible;

import android.content.Context;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This class takes care of any requests made by the SettingsActivity
 */
public class SettingsHandler {

    /*public static void writeToFile(Context context, String fileName, String str) {
        try {
            fileOutputStream outstream = context.openFileOutput(fileName, context.MODE_PRIVATE);
            outstream.write(str.getBytes(), 0, str.length());
            outstream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void serializeData(View view) {
        Gson gson = new Gson();
        String JsonString = gson.toJson(categ);
        IOHelper.writeToFile(this, "CategoryData.txt", JsonString;
    }

    public void deSerializeData (View view) {
        Gson gson = new Gson();
        try {
            FileInputStream stream = openFileInput("CategoryData.txt");
            String data = IOHelper.stringFromStream(stream);
            Category fileCat = gson.fromJson(data, Category.class);
            Log.d("SettingsActivity", "id: " + fileCat.getId() + "Name: " + fileCat.getName() + "\n"
                    + "Cards: " + fileCat.getCards();
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } return fileCat;

    }
     */
}
