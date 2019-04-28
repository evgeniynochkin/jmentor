package exception;

/**
 * @author Evgeniy Nochkin
 * @since 1.1
 */

public class DBException extends Exception {
    public DBException(Throwable throwable) {
        super(throwable);
    }
}
