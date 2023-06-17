package com.orizen.gridviewapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import com.orizen.gridviewapp.R;
import com.orizen.gridviewapp.models.Book;

public class BookListAdapter extends ArrayAdapter<Book> {

    public BookListAdapter(@NonNull Context context, @NonNull List<Book> books) {
        super(context, 0, books);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View gridView = convertView;

        if(gridView == null) {
            gridView = LayoutInflater.from(getContext()).inflate(R.layout.book_list_item, parent,  false);
        }

        // get views and set to the current object values
        TextView title = gridView.findViewById(R.id.textViewBookTitle);
        TextView author = gridView.findViewById(R.id.textViewAuthorName);

        Book currentBook = getItem(position);

        title.setText(currentBook.getBookTitle());
        author.setText(currentBook.getAuthorName());

        return gridView;
    }
}
