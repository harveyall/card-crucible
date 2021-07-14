package edu.team04.crucible;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EditSelectionAdapter extends
        RecyclerView.Adapter<EditSelectionAdapter.ViewHolder> {
    private Context context;
//    private CardList cardList;
    private List<Card> cards;


    public EditSelectionAdapter(CardList cardList) {
        this.context = context;
        this.cards = cardList.getCards();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public CardView cv_editableItem;
        public Button editBtn;
        public Button deleteBtn;
        public TextView categoryText;
        public TextView questionText;
        public TextView answerText;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            cv_editableItem = (CardView) itemView.findViewById(R.id.cv_editableItem);
            editBtn = (Button) itemView.findViewById(R.id.button_editCard);
            deleteBtn = (Button) itemView.findViewById(R.id.button_deleteCard);
            categoryText = (TextView) itemView.findViewById(R.id.textView_category);
            questionText = (TextView) itemView.findViewById(R.id.textView_question);
            answerText = (TextView) itemView.findViewById(R.id.textView_answer);
        }
    }

    @NonNull
    @Override
    public EditSelectionAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.edit_category_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull EditSelectionAdapter.ViewHolder holder, int position) {
        Card card = cards.get(position);
        holder.categoryText.setText("Category: " + card.getCategory());
        holder.questionText.setText("Question: " + card.getQuestion());
        holder.answerText.setText("Answer: " + card.getAnswer());
        holder.editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent editCardActivity = new Intent(context, EditCardsActivity.class);
//                editCardActivity.putExtra("CARD", card);
                editCardActivity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivities(new Intent[]{editCardActivity});

            }
        });

    }

    @Override
    public int getItemCount() {
        if (cards != null){
            return cards.size();
        }

        return 0;
    }


}