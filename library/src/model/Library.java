package model;

import exception.BookAlreadyBorrowedException;
import exception.BookNotFoundException;
import exception.MovieAlreadyBorrowedException;
import exception.MovieNotFoundException;

import java.util.Set;

public class Library {
    private Set<Book> books;
    private Set<Movie> movies;

    public Library(Set<Book> books, Set<Movie> movies) {
        this.books = books;
        this.movies = movies;
    }

    public void showAvailableAndBorrowedElements() {
        System.out.println("=== Dostępne książki ===");
        books.stream()
                .filter(Book::isAvailable)
                .forEach(book -> System.out.println(book.getTitle() + " - " + book.getAuthor()));

        System.out.println("\n=== Wypożyczone książki ===");
        books.stream()
                .filter(book -> !book.isAvailable())
                .forEach(book -> System.out.println(book.getTitle() + " - " + book.getAuthor()));

        System.out.println("\n=== Dostępne filmy ===");
        movies.stream()
                .filter(Movie::isAvailable)
                .forEach(movie -> System.out.println(movie.getTitle() + " - " + movie.getDirector()));

        System.out.println("\n=== Wypożyczone filmy ===");
        movies.stream()
                .filter(movie -> !movie.isAvailable())
                .forEach(movie -> System.out.println(movie.getTitle() + " - " + movie.getDirector()));
    }

    public void borrowBook(String name) {
        Book book = books.stream()
                .filter(b -> b.getTitle().equals(name))
                .findFirst()
                .orElseThrow(() ->
                        new BookNotFoundException("Nie znaleziono książki: " + name));
        if (!book.isAvailable()) {
            throw new BookAlreadyBorrowedException("Książka jest już wypożyczona: " + name);
        }
        book.setAvailable(false);
        System.out.println("Wypożyczono książkę: " + name);
    }

    public void borrowMovie(String name) {
        Movie movie = movies.stream()
                .filter(m -> m.getTitle().equals(name))
                .findFirst()
                .orElseThrow(() ->
                        new MovieNotFoundException("Nie znaleziono filmu: " + name));
        if (!movie.isAvailable()) {
            throw new MovieAlreadyBorrowedException("Film jest już wypożyczony: " + name);
        }
        movie.setAvailable(false);
        System.out.println("Wypożyczono film: " + name);
    }

    public Book returnBookByTitle(String title) {
        Book book = books.stream()
                .filter(b -> b.getTitle().equals(title))
                .findFirst()
                .orElseThrow(() ->
                        new BookNotFoundException("Nie znaleziono książki: " + title));
        book.setAvailable(true);
        return book;
    }

    public Movie returnMovieByTitle(String title) {
        Movie movie = movies.stream()
                .filter(m -> m.getTitle().equals(title))
                .findFirst()
                .orElseThrow(() ->
                        new MovieNotFoundException("Nie znaleziono filmu: " + title));
        movie.setAvailable(true);
        return movie;
    }

    public void printHowManyBooksAndMoviesAreInLibrary() {
        System.out.printf("W systemie jest %d książek oraz %d filmów",
                Book.getCounterBook(),
                Movie.getCounterMovie());
    }
}