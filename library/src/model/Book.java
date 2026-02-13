package model;

public class Book {
    private static int counterBook;
    private final String title, author;
    private final int numberOfPages;
    private boolean isAvailable;

    public Book(String title, String author, int numberOfPages) {
        this.author = author;
        this.title = title;
        this.numberOfPages = numberOfPages;
        isAvailable = true;
        counterBook++;
    }

    public static int getCounterBook() {
        return counterBook;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}