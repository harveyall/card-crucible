package edu.team04.crucible;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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

    private CardList filteredList;
    private List<Card> filteredCards;
    private int cardFilterIndex;

    /** Constructs a EditSelectionAdapter with a specified context
     * @param context
     * */
    public EditSelectionAdapter(Context context) {
        this.context = context;
        this.lsm = new LocalStorageManager(context);
        this.categoryList = lsm.loadCategoryList();
        this.cardList = new CardList(categoryList);
        this.cards = cardList.getCards();
        this.filteredCards = this.cards;
        this.filteredList = new CardList(this.filteredCards);
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public CardView cv_editableItem;
        public Button editBtn;
        public Button deleteBtn;
        public TextView categoryText;
        public TextView questionText;
        public TextView answerText;

        /** Constructs a ViewHolder with a specified view
         * @param itemView
         * */
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

    /** When the viewHolder is created connect it to the specified layout.
     * @param parent
     * @param viewType
     * */
    @NonNull
    @Override
    public EditSelectionAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.edit_category_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    /** Access and manipulate layout items that are associated with the set ViewHolder.
     * @param holder
     * @param position
     * */
    @Override
    public void onBindViewHolder(@NonNull @NotNull EditSelectionAdapter.ViewHolder holder, int position) {
        Card card = filteredCards.get(position);
        holder.categoryText.setText("Category: " + card.getCategory());
        holder.questionText.setText("Question: " + card.getQuestion());
        holder.answerText.setText("Answer: " + card.getAnswer());
        holder.editBtn.setOnClickListener(new View.OnClickListener() {
            /** Upon click of edit button start the editCardActivity and send it the card to be edited*/
            @Override
            public void onClick(View v) {
                Intent editCardActivity = new Intent(context, EditCardsActivity.class);
                editCardActivity.putExtra("CARD", card);
                editCardActivity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(editCardActivity);
            }
        });

        holder.deleteBtn.setOnClickListener(new View.OnClickListener() {
            /** Upon click of the delete button remove the card from both the main and filtered lists, notify of the item removal, and remove card from stored data*/
            @Override
            public void onClick(View v) {
                Toast.makeText(context, String.format("DELETED:%nCategory: %s%nQuestion: %s",card.getCategory(),card.getQuestion()), Toast.LENGTH_SHORT).show();

                //delete card from filteredList and refresh filtered cardList
                cardFilterIndex = filteredList.getCardIndex(card);
                filteredList.deleteCard(cardFilterIndex);
                filteredCards = filteredList.getCards();

               //remove card from recycler view
                notifyItemRemoved(cardFilterIndex);

                cards.remove(card);

                Thread removeCardInHandler = new Thread(new EditSelectionHandler(context, categoryList, card));
                removeCardInHandler.start();
            }
        });
    }
    /** Return expected item count of recyclerView list* */
    @Override
    public int getItemCount() {
        if (filteredCards != null){
            return filteredCards.size();
        }
        return 0;
    }
/** Filter cards by category */
    public void filterCards(String categoryName) {
        Category filteredCategory = categoryList.getCategory(categoryName);
        if (!categoryName.isEmpty() && filteredCategory != null) {
            filteredCards = filteredCategory.getCards();
            filteredList.setCards(filteredCards);
        } else {
            filteredCards = cards;
        }
        notifyDataSetChanged();
    }

}