package edu.team04.crucible;

import android.content.Context;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class takes care of any requests made by the SettingsActivity
 */
public class SettingsHandler implements Runnable {
    private SettingsActivity activity;
    private Context context;

    /** Class constructor, it would take the calling activity's name, to then return the
     * results on that activity's UI thread.
     * @param activity The calling activity's name.
     */
    public SettingsHandler(SettingsActivity activity) {
        this.activity = activity;
    }

    @Override
    public void run() {

    }
}
