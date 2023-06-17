package com.orizen.gridviewapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import com.orizen.gridviewapp.R;
import com.orizen.gridviewapp.adapters.BookListAdapter;
import com.orizen.gridviewapp.models.Book;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Book> books;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        books = Book.getDummyBooks();

        BookListAdapter adapter = new BookListAdapter(this, books);

        GridView gridView = (GridView)findViewById(R.id.bookGridView);

        // adapter will hold our data for us
        gridView.setAdapter(adapter);
    }
}