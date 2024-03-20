package com.example.ebookmobilefe.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ebookmobilefe.R;
import com.example.ebookmobilefe.model.Book;

import java.util.List;

public class ListBookAdapter extends RecyclerView.Adapter<ListBookAdapter.ListBookViewHolder> {

    private final List<Book> listBook;

    public ListBookAdapter(List<Book> listBook) {
        this.listBook = listBook;
    }

    @NonNull
    @Override
    public ListBookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_book, parent, false);
        return new ListBookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListBookViewHolder holder, int position) {
        Book book = listBook.get(position);
        if (book == null) {
            return;
        }
        holder.tvName.setText(book.getTitle());
        holder.tvAuthor.setText(book.getAuthorID());
        holder.tvContent.setText(book.getDesc());
        holder.tvPrice.setText(book.getPrice());
    }

    @Override
    public int getItemCount() {
        if (listBook != null) {
            return listBook.size();
        }
        return 0;
    }

    public static class ListBookViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvAuthor, tvContent, tvPrice;
        public ListBookViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvTitle);
            tvAuthor = itemView.findViewById(R.id.tvAuthor);
            tvContent = itemView.findViewById(R.id.tvDesc);
            tvPrice = itemView.findViewById(R.id.tvPrice);
        }
    }
}
