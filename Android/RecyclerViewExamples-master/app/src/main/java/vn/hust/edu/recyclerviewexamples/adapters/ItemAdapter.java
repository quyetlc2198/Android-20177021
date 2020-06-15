package vn.hust.edu.recyclerviewexamples.adapters;

import android.app.Activity;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import vn.hust.edu.recyclerviewexamples.ItemClickListener;
import vn.hust.edu.recyclerviewexamples.MainActivity;
import vn.hust.edu.recyclerviewexamples.R;
import vn.hust.edu.recyclerviewexamples.models.ItemModel;

public class ItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<ItemModel> items;
    ItemClickListener listener;

    public ItemAdapter(List<ItemModel> items) {
        this.items = items;
    }

    public ItemAdapter(List<ItemModel> items, ItemClickListener listener) {
        this.items = items;
        this.listener = listener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ItemModel item = items.get(position);
        ItemViewHolder viewHolder = (ItemViewHolder) holder;

        viewHolder.textView.setText(item.getTitle());
        viewHolder.imageView.setImageResource(item.getImageResource());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.text_view);
            imageView = itemView.findViewById(R.id.image_view);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null)
                        listener.OnItemClick(getAdapterPosition());
                }
            });
        }
    }
}
