package com.example.example1;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class EmailAdapter<EmailViewHolder> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    ArrayList<Items> items;

    public EmailAdapter(ArrayList<Items> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_items , parent, false);
        return new EmailHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        EmailHolder viewHolder = (EmailHolder) holder;
        Items item = items.get(position);
        viewHolder.textLetter.setText(item.getName().substring(0, 1));
        Drawable background = viewHolder.textLetter.getBackground();
        background.setColorFilter(new PorterDuffColorFilter(item.getColor(), PorterDuff.Mode.SRC_ATOP));
        viewHolder.textName.setText(item.getName());
        viewHolder.textSubject.setText(item.getSubject());
        viewHolder.textContent.setText(item.getContent());
        viewHolder.textTime.setText(item.getTime());
        if (item.is_favourite())
            viewHolder.imageFavorite.setImageResource(R.drawable.ic_star_fill_black_24dp);
        else
            viewHolder.imageFavorite.setImageResource(R.drawable.ic_star_border_black_24dp);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class EmailHolder extends RecyclerView.ViewHolder{
        TextView textLetter;
        TextView textName;
        TextView textSubject;
        TextView textContent;
        TextView textTime;
        ImageView imageFavorite;

        public EmailHolder(@NonNull View itemView) {
            super(itemView);

            textLetter = itemView.findViewById(R.id.text_letter);
            textName = itemView.findViewById(R.id.text_name);
            textSubject = itemView.findViewById(R.id.text_subject);
            textContent = itemView.findViewById(R.id.text_content);
            textTime = itemView.findViewById(R.id.text_time);
            imageFavorite = itemView.findViewById(R.id.image_favourite);
            // action click farvourite
            imageFavorite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    boolean isFavorite = items.get(getAdapterPosition()).is_favourite();
                    items.get(getAdapterPosition()).setFavourite(!isFavorite);
                    notifyDataSetChanged();
                }
            });
        }
    }


    public void filtered(ArrayList<Items> filterList){
        items = filterList;
        notifyDataSetChanged();
    }

}
