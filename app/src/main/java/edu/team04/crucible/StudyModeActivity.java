package edu.team04.crucible;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import java.util.List;


/**
 * Study Mode Activity, iterate through cards, flip them over to show the other side with the answer.
 */
public class StudyModeActivity extends AppCompatActivity {
    //TODO: Begin game with card list from selected category that is sent from SelectCategory Activity
    // use StudyModeHandler to handle requests from this activity
    Gson gson = new Gson();
    CardList cardList;
    private boolean back_card_visible = false;
    List<Card> cards;
    int size;
    int i = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new ThemeHandler(this, getApplicationContext()).updateTheme();
        setContentView(R.layout.activity_study);


        String data = getIntent().getStringExtra("CATEGORIES");
        cardList= gson.fromJson(data, CardList.class);
        //each card contains information about the category it belongs to, question and answer.
        //You can view the data in the cardList in the Logcat
        Log.d("StudyModeActivity", cardList.toString());

        this.cards = cardList.getCards();
        this.size = cards.size();

        StudyModeHandler studyModeHandler = new StudyModeHandler(this, this, cardList);
        Thread thread1 = new Thread(studyModeHandler, "StudyModeHandler");
        Log.d("StudyModeActivity", "Context is: " + this);
        Log.d("StudyModeActivity", "Calling StudyModeHandler on a background thread");
        thread1.start();

        float scale = getApplicationContext().getResources().getDisplayMetrics().density;

        Card card = cards.get(i);

        String category = card.getCategory();
        String question = card.getQuestion();
        String answer = card.getAnswer();

        TextView categoryText = (TextView)findViewById(R.id.category_text);
        TextView frontCard = (TextView)findViewById(R.id.card_front);
        TextView backCard = (TextView)findViewById(R.id.card_back);


        backCard.setVisibility(View.INVISIBLE);  // For Invisible/Disappear

        categoryText.setText(category);
        frontCard.setText(question);
        backCard.setText(answer);

        View btn_prev = findViewById(R.id.prev_btn);
        btn_prev.setVisibility(View.INVISIBLE);

        View btn_next = findViewById(R.id.next_btn);
        if(i > size) { //initialize next button to visible if there is more than one card
            btn_next.setVisibility(View.VISIBLE);
        }else{
            btn_next.setVisibility(View.INVISIBLE);
        }
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
        i--;
        updateCard();
        updateButton();
    }

    /**
     * This button moves to the next side and will set the card to being face up.
     * @param button
     */
    public void next(View button) {
        TextView backCard = (TextView)findViewById(R.id.card_back);
        i++;
        updateCard();
        updateButton();
    }

    public void updateCard(){
        List<Card> cards = cardList.getCards();

        Card card = cards.get(i);

        String category = card.getCategory();
        String question = card.getQuestion();
        String answer = card.getAnswer();

        TextView categoryText = (TextView)findViewById(R.id.category_text);
        TextView frontCard = (TextView)findViewById(R.id.card_front);
        TextView backCard = (TextView)findViewById(R.id.card_back);

        categoryText.setText(category);
        frontCard.setText(question);
        backCard.setText(answer);
    }

    public void updateButton(){
        TextView backCard = (TextView)findViewById(R.id.card_back);
        View btn_next = findViewById(R.id.next_btn);
        View btn_prev = findViewById(R.id.prev_btn);


        if(i < size - 1) { //Needs to be for when there is no next card
            btn_next.setVisibility(View.VISIBLE);
        }
        else{
            btn_next.setVisibility(View.INVISIBLE);
        }

        if(i > 0) { //Needs to be for when there is no previous card
            btn_prev.setVisibility(View.VISIBLE);
        }
        else{
            btn_prev.setVisibility(View.INVISIBLE);
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
