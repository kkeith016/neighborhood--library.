package com.pluralsight;

public class Books {

    private int id;
    private String isbn;
    private String title;
    private String author;
    private boolean checkedOut;   // keep private
    private String checkedOutTo;

    public Books(int id, String isbn, String title, String author, boolean checkedOut, String checkedOutTo) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.checkedOut = checkedOut;
        this.checkedOutTo = checkedOutTo;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isCheckedOut() {   // getter for boolean
        return checkedOut;
    }

    public void setCheckedOut(boolean checkedOut) {  // setter
        this.checkedOut = checkedOut;
    }

    public String getCheckedOutTo() {
        return checkedOutTo;
    }

    public void setCheckedOutTo(String checkedOutTo) {
        this.checkedOutTo = checkedOutTo;
    }

    // Methods for checking out/in
    public void checkOut(String name) {
        this.checkedOut = true;
        this.checkedOutTo = name;
    }

    public void checkIn() {
        this.checkedOut = false;
        this.checkedOutTo = "";
    }

    public String toString() {
        return "Books{" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", checkedOut=" + checkedOut +
                ", checkedOutTo='" + checkedOutTo + '\'' +
                '}';
    }
}

