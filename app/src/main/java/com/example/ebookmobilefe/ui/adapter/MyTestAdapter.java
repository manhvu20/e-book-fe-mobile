package com.example.ebookmobilefe.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ebookmobilefe.R;
import com.example.ebookmobilefe.model.TestItem;

import java.util.List;

public class MyTestAdapter extends RecyclerView.Adapter<MyTestAdapter.ItemViewHolder>{
    private List<TestItem> items;

    public MyTestAdapter(List<TestItem> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.test_item_layout, parent, false);
        return new ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        TestItem item = items.get(position);
        holder.title.setText(item.getTitle());
        holder.description.setText(item.getDescription());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView title, description;

        ItemViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title_txt);
            description = itemView.findViewById(R.id.description_text);
        }
    }
}
