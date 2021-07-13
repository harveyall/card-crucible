package edu.team04.crucible;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Objects;

public class EditSelectionAdapter extends RecyclerView.Adapter<EditSelectionAdapter.ViewHolder> {
    private Context context;
    private CardList cardList;

    public EditSelectionAdapter(Context context, CardList cardList) {
        this.context = context;
        this.cardList = cardList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
          public CardView cv_editableItem;
          public Button editBtn;
          public Button trashBtn;
          public TextView categoryText;
          public EditText multiLine;

        public ViewHolder(View view) {
            super(view);
        }
    }
    public void ViewHolder(@NonNull View itemView) {
        //super(itemView);
        Button editBtn = (Button) itemView.findViewById(R.id.edit_button);
        Button deletBin = (Button) itemView.findViewById(R.id.trash_button);
        TextView categoryText = (TextView) itemView.findViewById(R.id.category_text);
        EditText multiline = (EditText) itemView.findViewById(R.id.MultiLine);

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.edit_category, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull  EditSelectionAdapter.ViewHolder holder, int position) {
        Card card = cardList.getCards().get(position);
        holder.categoryText.setText("Category: " + card.getCategory());
        holder.multiLine.setText("Q:" + card.getQuestion() +
                "A:" + card.getAnswer());
    }

    @Override
    public int getItemCount() {
        return 0;
    }


}
