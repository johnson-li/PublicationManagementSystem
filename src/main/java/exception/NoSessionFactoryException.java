package exception;

/**
 * Created by johnson on 6/22/15.
 */
public class NoSessionFactoryException extends RuntimeException{
    public NoSessionFactoryException() {
        super();
    }

    public NoSessionFactoryException(String message) {
        super(message);
    }
}
