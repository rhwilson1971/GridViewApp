package com.orizen.gridviewapp.activities;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.orizen.gridviewapp.R;
import com.orizen.gridviewapp.adapters.BookListAdapter;
import com.orizen.gridviewapp.models.Book;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Book> books;
    GridView booksGridView;
    FloatingActionButton fabAdd;

    private BookListAdapter adapter;

    ActivityResultLauncher manageBookActivitiesLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        books = Book.getDummyBooks();
        adapter = new BookListAdapter(this, R.layout.book_list_item, books);

        booksGridView = (GridView)findViewById(R.id.bookGridView);
        // adapter will hold our data for us
        booksGridView.setAdapter(adapter);

        fabAdd = findViewById(R.id.fabAdd);
        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchManageBookItemActivity(new Book());
            }
        });

        initLauncher();
    }

    private void launchManageBookItemActivity(Book book) {
        Intent intent = new Intent(getApplicationContext(), ManageBookItemActivity.class);

        intent.putExtra("BOOK_AUTHOR", book.getAuthorName());
        intent.putExtra("BOOK_TITLE", book.getBookTitle());
        intent.putExtra("BOOK_ID", book.getId());

        manageBookActivitiesLauncher.launch(intent);
    }

    private void initLauncher() {
        manageBookActivitiesLauncher  =
                registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                        result ->
                        {
                           if(result.getResultCode()== Activity.RESULT_OK){
                               Intent intent = result.getData();
                               if(null != intent) {
                                   Book book = new Book();

                                   book.setBookTitle(intent.getStringExtra("BOOK_TITLE"));
                                   book.setAuthorName(intent.getStringExtra("BOOK_AUTHOR"));
                                   book.setId(intent.getLongExtra("BOOK_ID", 0));

                                   Log.d("debug", "Received book information " + book.getAuthorName());

                                   if(book.getId() == 0) {
                                       adapter.add(book);
                                   }
                               }
                           }
                        });
    }
}