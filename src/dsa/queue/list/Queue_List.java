package dsa.queue.list;

import dsa.Node;
import dsa.queue.Queue;
import dsa.queue.QueueEmptyException;

public class Queue_List implements Queue {
    protected Node head;
    protected Node tail;
    protected int size;

    public Queue_List() {
        head = tail = null;
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(Object obj) {
        Node node = new Node();
        node.setElem(obj);
        node.setNext(null);

        if (size == 0) {
            head = node;
        }
        else {
            tail.setNext(node);
        }

        tail = node;
        size++;
    }

    @Override
    public Object dequeue() throws QueueEmptyException {
        if(isEmpty()) {
            throw new QueueEmptyException("意外：队列空");
        }
        Object obj = head.getElem();
        head = head.getNext();
        size--;
        if(size == 0) tail = null;
        return obj;
    }

    @Override
    public Object front() {
        if (isEmpty()) {
            throw new QueueEmptyException("意外：队列空");
        }
        return head.getElem();
    }

    @Override
    public void tranverse() {
        Node p = head;
        while (p != null) {
            System.out.print(p.getElem() + " ");
            p = p.getNext();
        }
    }
}
