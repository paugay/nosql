package mynosql.domain.exception;

/**
 * @author paugay
 */
public class KeyNotFoundException extends Exception {

    public KeyNotFoundException(String message) {
        super(message);
    }
}
