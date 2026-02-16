package exception;

public class MovieAlreadyBorrowedException extends LibraryException  {
    public MovieAlreadyBorrowedException(String message) {
        super(message);
    }
}
