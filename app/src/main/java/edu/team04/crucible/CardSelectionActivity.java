package edu.team04.crucible;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Card Selection Activity. In preparation for game/study mode, it displays a list of categories to
 * be used on the next activity. When the Begin button is pressed, the list gets sent to Card
 * Randomization, and comes back shuffled, and then fed into the next activity.
 */
public class CardSelectionActivity extends AppCompatActivity {
    //TODO: When begin button is clicked send selected category to StudyModeActivity

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //((android.widget.Button)findViewById(R.id.button_begin)).setText(R.string.study_mode);
        setContentView(R.layout.activity_card_selection);
    }

    /**
     * This button takes the selected categories into the next Activity (Study or Game).
     * @param view
     */
    public void Begin(View view) {
        Intent intent = new Intent(CardSelectionActivity.this, StudyModeActivity.class);
        //TODO: Populate Listview/Recyclerview with Card Categories.
        //TODO: Add selected Categories to intent.
        startActivity(intent);
    }

    /**
     * This button leads back to the Main Activity.
     * @param button
     */
    public void backHome(View button) {
        Intent addIntent = new Intent(this, MainActivity.class);
        startActivity(addIntent);
    }

}