package com.pluralsight;

public class Books {

    private int id;
    private String isbn;
    private String title;
    private String author;
    private boolean isCheckout;
    private String checkedOutTo;

    public Books(int id, String isbn, String title, String author, boolean isCheckout, String checkedOutTo) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.isCheckout = isCheckout;
        this.checkedOutTo = checkedOutTo;
    }

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

    public boolean isCheckout() {
        return isCheckout;
    }

    public void setCheckout(boolean checkout) {
        isCheckout = checkout;
    }

    public String getCheckedOutTo() {
        return checkedOutTo;
    }

    public void setCheckedOutTo(String checkedOutTo) {
        this.checkedOutTo = checkedOutTo;
    }
}
