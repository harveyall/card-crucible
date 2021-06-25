package edu.team04.crucible;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class StudyModeActivity extends AppCompatActivity {
    //TODO: Begin game with card list from selected category that is sent from SelectCategory Activity
    // use StudyModeHandler to handle requests from this activity
    private TextView frontCard;
    private TextView backCard;

    private Button aButton;

    private AnimatorSet frontAnim;
    private AnimatorSet backAnim;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        float scale = getApplicationContext().getResources().getDisplayMetrics().density;
        initViews();

        frontCard.setCameraDistance(8000 * scale);
        backCard.setCameraDistance(8000 * scale);

        frontAnim = (AnimatorSet) AnimatorInflater.loadAnimator(getApplicationContext(),R.animator.front_animation);
        backAnim = (AnimatorSet) AnimatorInflater.loadAnimator(getApplicationContext(),R.animator.back_animation);

        aButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view){
                if (isFront) {
                    frontAnim.setTarget(frontCard);
                    backAnim.setTarget(backCard);
                    frontAnim.start();
                    backAnim.start();
                    boolean isFront = false;
                } else {
                    frontAnim.setTarget(backCard);
                    backAnim.setTarget(frontCard);
                    backAnim.start();
                    frontAnim.start();
                    boolean isFront = true;
                }
            }
        }
    }
}
