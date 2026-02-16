import exception.LibraryException;
import model.Book;
import service.LibraryService;
import model.Movie;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Book> books = new HashSet<>();
        books.add(new Book("Hobbit", "J.R.R. Tolkien", 300));
        books.add(new Book("Władca Pierścieni", "J.R.R. Tolkien", 1000));
        books.add(new Book("Harry Potter", "J.K. Rowling", 500));

        Set<Movie> movies = new HashSet<>();
        movies.add(new Movie("Incepcja", "Christopher Nolan", 148));
        movies.add(new Movie("Titanic", "James Cameron", 195));
        movies.add(new Movie("Matrix", "Wachowscy", 136));

        LibraryService library = new LibraryService(books, movies);

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n===== MENU BIBLIOTEKI =====");
            System.out.println("1. Wyświetl dostępne i wypożyczone elementy");
            System.out.println("2. Wypożycz książkę po tytule");
            System.out.println("3. Wypożycz film po tytule");
            System.out.println("4. Zwróć książkę po tytule");
            System.out.println("5. Zwróć film po tytule");
            System.out.println("6. Wyświetl liczbę książek i filmów w systemie");
            System.out.println("7. Wyjście");
            System.out.print("Wybierz opcję: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (choice) {
                    case 1 -> library.showAvailableAndBorrowedElements();
                    case 2 -> {
                        System.out.print("Podaj tytuł książki do wypożyczenia: ");
                        String bookToBorrow = scanner.nextLine();
                        library.borrowBook(bookToBorrow);
                    }
                    case 3 -> {
                        System.out.print("Podaj tytuł filmu do wypożyczenia: ");
                        String movieToBorrow = scanner.nextLine();
                        library.borrowMovie(movieToBorrow);
                    }
                    case 4 -> {
                        System.out.print("Podaj tytuł książki do zwrotu: ");
                        String bookToReturn = scanner.nextLine();
                        Book returnedBook = library.returnBookByTitle(bookToReturn);
                        System.out.println("Zwrócono książkę: " + returnedBook.getTitle());
                    }
                    case 5 -> {
                        System.out.print("Podaj tytuł filmu do zwrotu: ");
                        String movieToReturn = scanner.nextLine();
                        Movie returnedMovie = library.returnMovieByTitle(movieToReturn);
                        System.out.println("Zwrócono film: " + returnedMovie.getTitle());
                    }
                    case 6 -> {
                        library.printHowManyBooksAndMoviesAreInLibrary();
                        System.out.println();
                    }
                    case 7 -> {
                        System.out.println("Zamykanie programu...");
                        running = false;
                    }
                    default -> System.out.println("Niepoprawna opcja!");
                }
            } catch (LibraryException e) {
                System.out.println("Błąd: " + e.getMessage());
            }
        }
        scanner.close();
    }
}