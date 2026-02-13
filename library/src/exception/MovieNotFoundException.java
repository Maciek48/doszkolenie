package exception;

public class MovieNotFoundException extends LibraryException  {
    public MovieNotFoundException(String message) {
        super(message);
    }
}
