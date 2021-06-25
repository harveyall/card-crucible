package edu.team04.crucible;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;


public class StudyModeActivity extends AppCompatActivity {
    //TODO: Begin game with card list from selected category that is sent from SelectCategory Activity
    // use StudyModeHandler to handle requests from this activity
    final TextView frontCard = (TextView) findViewById(R.id.card_front);
    final TextView backCard = (TextView) findViewById(R.id.card_back);

    final Button aButton = findViewById(R.id.flip_btn);

    private AnimatorSet frontAnim;
    private AnimatorSet backAnim;

    private boolean isFront = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        float scale = getApplicationContext().getResources().getDisplayMetrics().density;

        frontCard.setCameraDistance(8000 * scale);
        backCard.setCameraDistance(8000 * scale);

        frontAnim = (AnimatorSet) AnimatorInflater.loadAnimator(getApplicationContext(),R.animator.front_animatior);
        backAnim = (AnimatorSet) AnimatorInflater.loadAnimator(getApplicationContext(),R.animator.back_animatior);

        aButton.setOnClickListener(view -> {

            if (isFront) {
                frontAnim.setTarget(frontCard);
                backAnim.setTarget(backCard);
                frontAnim.start();
                backAnim.start();
                isFront = false;
            }
            else {
                frontAnim.setTarget(backCard);
                backAnim.setTarget(frontCard);
                backAnim.start();
                frontAnim.start();
                isFront = true;
            }
        });
    }
}
