package model;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return numberOfPages == book.numberOfPages && isAvailable == book.isAvailable && Objects.equals(title, book.title) && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, numberOfPages, isAvailable);
    }
}