package edu.team04.crucible;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class EditSelectionAdapter extends
        RecyclerView.Adapter<EditSelectionAdapter.ViewHolder> {
    private final LocalStorageManager lsm;
    private Context context;
    private CategoryList categoryList;
    private CardList cardList;
    private List<Card> cards;
    private int cardIndex;


    public EditSelectionAdapter(Context context) {
        this.context = context;
        this.lsm = new LocalStorageManager(context);
        this.categoryList = lsm.loadCategoryList();
        this.cardList = new CardList(categoryList);
        this.cards = cardList.getCards();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public CardView cv_editableItem;
        public Button editBtn;
        public Button deleteBtn;
        public Button filterBtn;
        public TextView categoryText;
        public TextView questionText;
        public TextView answerText;
        public EditText categoryFilter;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            categoryFilter = (EditText)itemView.findViewById(R.id.editTextTextCategoryFilter);
            cv_editableItem = (CardView) itemView.findViewById(R.id.cv_editableItem);
            editBtn = (Button) itemView.findViewById(R.id.button_editCard);
            deleteBtn = (Button) itemView.findViewById(R.id.button_deleteCard);
            filterBtn = (Button) itemView.findViewById(R.id.button_cardFilter);
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
                editCardActivity.putExtra("CARD", card);
                editCardActivity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(editCardActivity);
            }
        });

        holder.deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "deleted: " + card.toString(), Toast.LENGTH_LONG).show();
                cardIndex = cardList.getCardIndex(card);
                //remove card from recycler view
                cards.remove(cardIndex);
                notifyItemRemoved(cardIndex);

                //remove card from internally stored categoryList
                Log.d("EditSelectionAdapter", "Beginning removeCardHandler thread");
                Thread removeCardInHandler = new Thread(new EditSelectionHandler(context, categoryList, card));
                removeCardInHandler.start();
            }
        });
        holder.filterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String categoryName = holder.categoryFilter.getText().toString();
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