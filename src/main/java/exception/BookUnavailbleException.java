package exception;

/**
 * Created by johnson on 6/5/15.
 */
public class BookUnavailbleException extends RuntimeException{

    public BookUnavailbleException(String message) {
        super(message);
    }
}
