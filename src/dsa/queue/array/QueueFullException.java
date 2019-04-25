package dsa.queue.array;

public class QueueFullException extends RuntimeException {
    public QueueFullException(String err) {
        super(err);
    }
}
