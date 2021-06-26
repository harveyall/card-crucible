package edu.team04.crucible;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class StudyModeActivity extends AppCompatActivity {
    //TODO: Begin game with card list from selected category that is sent from SelectCategory Activity
    // use StudyModeHandler to handle requests from this activity
    private boolean visible = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study);
        float scale = getApplicationContext().getResources().getDisplayMetrics().density;
        TextView backCard = (TextView)findViewById(R.id.card_back);
        backCard.setText("Back");
        backCard.setVisibility(View.INVISIBLE);  // For Invisible/Disappear
        TextView frontCard = (TextView)findViewById(R.id.card_front);
        frontCard.setText("Front");
    }

    /**
     * This button leads back to the Main Activity.
     * @param button
     */
    public void flip(View button) {
        TextView backCard = (TextView)findViewById(R.id.card_back);
        if(visible) {
            backCard.setVisibility(View.INVISIBLE);  // For Invisible/Disappear
            visible = false;
        }
        else {
            backCard.setVisibility(View.VISIBLE); // For Visible/Appear
            visible = true;
        }
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
