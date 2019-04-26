package dsa.queue.array;

/**
 * @author talent
 */
public class QueueFullException extends RuntimeException {
    public QueueFullException(String err) {
        super(err);
    }
}
