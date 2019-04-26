package dsa.queue;

/**
 * @author talent
 */
public class QueueEmptyException extends RuntimeException {
    public QueueEmptyException(String err) {
        super(err);
    }
}
