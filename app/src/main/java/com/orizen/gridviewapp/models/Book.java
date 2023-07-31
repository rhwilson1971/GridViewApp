package com.orizen.gridviewapp.models;

import java.util.ArrayList;

public class Book {

    long id;
    private String bookTitle;
    private String authorName;

    public Book(long id, String bookTitle, String authorName) {
        this.authorName = authorName;
        this.bookTitle = bookTitle;
        this.id  = id;
    }

    public Book() {
        authorName = "";
        bookTitle = "";
        id= 0;
    }

    public boolean isEmpty() {
        return id == 0 && authorName.isEmpty() && bookTitle.isEmpty();
    }

    public void setBookTitle(String title){
        this.bookTitle = title;
    }
    public void setAuthorName(String author) {
        this.authorName = author;
    }
    public void setId(long id){
        this.id = id;
    }
    public String getBookTitle() { return bookTitle; }
    public String getAuthorName() { return authorName; }
    public long getId() { return id; }

    public static ArrayList<Book> getDummyBooks() {

        ArrayList<Book> dummyBooks = new ArrayList<>();

        dummyBooks.add(new Book(1, "Atomic Habits", "James Clear"));
        dummyBooks.add(new Book(2, "Arguing with Zombies", "Paul Krugman"));
        dummyBooks.add(new Book(3, "A Tale of Two Cities", "Charles Dickens"));
        dummyBooks.add(new Book(4, "Parable of the Sower", "Octavia E. Butler"));
        dummyBooks.add(new Book(5, "Originals", "Adam Grant"));
        dummyBooks.add(new Book(6, "Beasts of Prey", "Ayana Gray"));
        dummyBooks.add(new Book(7, "Diffusion of Innovations", "E. M. Rogers"));
        dummyBooks.add(new Book(8, "The World We Make", "M. K. Jemisin"));

        return dummyBooks;
    }
}
