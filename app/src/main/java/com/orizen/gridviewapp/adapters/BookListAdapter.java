package com.orizen.gridviewapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

import com.orizen.gridviewapp.R;
import com.orizen.gridviewapp.models.Book;

public class BookListAdapter extends ArrayAdapter<Book> {
    int layoutId;

    public BookListAdapter(@NonNull Context context, @NonNull int resId, @NonNull List<Book> books) {
        super(context, resId, books);
        layoutId = resId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View gridView = convertView;

        if(gridView == null) {
            gridView = LayoutInflater.from(getContext()).inflate(layoutId, parent,  false);
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
