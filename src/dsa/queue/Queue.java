package dsa.queue;

public interface Queue {

    int getSize();

    boolean isEmpty();

    void enqueue(Object obj) throws QueueFullException;

    Object dequeue() throws QueueEmptyException;

    Object front();

    void tranverse();

}
