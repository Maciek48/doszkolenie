import java.util.Set;

public class Library {
    private Set<Book> books;
    private Set<Movie> movies;

    public Library(Set<Book> books, Set<Movie> movies) {
        this.books = books;
        this.movies = movies;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }
}
