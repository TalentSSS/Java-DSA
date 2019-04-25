package dsa.queue;

public interface Queue {

    int getSize();

    boolean isEmpty();

    void enqueue(Object obj);

    Object dequeue() throws QueueEmptyException;

    Object front();

    void tranverse();

}
