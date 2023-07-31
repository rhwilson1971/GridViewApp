package com.orizen.gridviewapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.orizen.gridviewapp.R;
import com.orizen.gridviewapp.models.Book;

public class ManageBookItemActivity extends AppCompatActivity {

    EditText editTextAuthor;
    EditText editTextTitle;
    Button buttonSave;

    Book currentBook;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.manage_book_item);

        editTextAuthor = findViewById(R.id.editTextAuthor);
        editTextTitle = findViewById(R.id.editTextTitle);

        buttonSave = findViewById(R.id.buttonSave);

        buttonSave.setOnClickListener(v -> {

            currentBook.setBookTitle(editTextTitle.getText().toString());
            currentBook.setAuthorName(editTextAuthor.getText().toString());
            Intent result = new Intent(getApplicationContext(), MainActivity.class);
            result.putExtra("BOOK_TITLE", currentBook.getBookTitle());
            result.putExtra("BOOK_AUTHOR", currentBook.getAuthorName());
            result.putExtra("BOOK_ID", currentBook.getId());

            setResult(RESULT_OK, result);
            finish();
        });

        currentBook = new Book();

        Bundle extras = getIntent().getExtras();
        if(null != extras){

            currentBook.setBookTitle(extras.getString("BOOK_TITLE"));
            currentBook.setAuthorName(extras.getString("BOOK_AUTHOR"));
            currentBook.setId(extras.getLong("BOOK_ID"));
        }

        editTextAuthor.setText(currentBook.getAuthorName());
        editTextTitle.setText(currentBook.getBookTitle());
    }
}
