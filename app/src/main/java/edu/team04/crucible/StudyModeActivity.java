package edu.team04.crucible;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


/**
 * Study Mode Activity, iterate through cards, flip them over to show the other side with the answer.
 */
public class StudyModeActivity extends AppCompatActivity {
    //TODO: Begin game with card list from selected category that is sent from SelectCategory Activity
    // use StudyModeHandler to handle requests from this activity
    private boolean back_card_visible = false;
    private boolean prev_button_visible = true;
    private boolean next_button_visible = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new ThemeHandler(this, getApplicationContext()).updateTheme();
        setContentView(R.layout.activity_study);
        float scale = getApplicationContext().getResources().getDisplayMetrics().density;

        TextView frontCard = (TextView)findViewById(R.id.card_front);
        TextView backCard = (TextView)findViewById(R.id.card_back);

        backCard.setVisibility(View.INVISIBLE);  // For Invisible/Disappear

        frontCard.setText("Front");
        backCard.setText("Back");

        View btn_prev = findViewById(R.id.prev_btn);
        btn_prev.setVisibility(View.VISIBLE);

        View btn_next = findViewById(R.id.next_btn);
        btn_next.setVisibility(View.VISIBLE);
    }

    /**
     * This button flips the card over to show the other side.
     * @param button
     */
    public void flip(View button) {
        TextView backCard = (TextView)findViewById(R.id.card_back);
        if(back_card_visible) {
            backCard.setVisibility(View.INVISIBLE);  // For Invisible/Disappear
            back_card_visible = false;
        }
        else {
            backCard.setVisibility(View.VISIBLE); // For Visible/Appear
            back_card_visible = true;
        }
    }

    /**
     * This button moves to the previous side and will set the card to being face up.
     * @param button
     */
    public void prev(View button) {
        TextView backCard = (TextView)findViewById(R.id.card_back);
        View btn_prev = findViewById(R.id.prev_btn);

        if(!prev_button_visible) { //Remove the ! in latter version
            btn_prev.setVisibility(View.GONE);
            prev_button_visible = false;
        }
        if(back_card_visible) {
            backCard.setVisibility(View.INVISIBLE);  // For Invisible/Disappear
            back_card_visible = false;
        }
    }

    /**
     * This button moves to the next side and will set the card to being face up.
     * @param button
     */
    public void next(View button) {
        TextView backCard = (TextView)findViewById(R.id.card_back);
        View btn_next = findViewById(R.id.next_btn);

        if(!next_button_visible) { //Remove the ! in latter version
            btn_next.setVisibility(View.GONE);
            next_button_visible = false;
        }
        if(back_card_visible) {
            backCard.setVisibility(View.INVISIBLE);  // For Invisible/Disappear
            back_card_visible = false;
        }
    }

    /**
     * This button sends the user back to the home menu.
     * @param button
     */
    public void backHome(View button) {
        Intent addIntent = new Intent(this, MainActivity.class);
        startActivity(addIntent);
    }
}
