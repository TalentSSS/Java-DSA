package dsa.queue.list;

import dsa.Node;
import dsa.queue.Queue;
import dsa.queue.QueueEmptyException;

public class Queue_List implements Queue {

    /**
     * head 队列头
     */
    protected Node head;
    /**
     * 队列尾
     */
    protected Node tail;
    /**
     * 队列大小
     */
    protected int size;

    public Queue_List() {
        head = tail = null;
        size = 0;
    }

    /**
     * 返回队列大小
     * @return int
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * 判空
     * @return boolean
     */
    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    /**
      入队
     * @param obj 入队元素
     */
    @Override
    public void enqueue(Object obj) {
        Node node = new Node(obj, null);

        // 保证head得到更新
        if (size == 0) {
            head = node;
        }
        else {
            tail.setNext(node);
        }

        // 无论如何tail都会得到更新
        tail = node;

        size++;
    }

    /**
     * 出队
     * @return Object
     * @throws QueueEmptyException
     */
    @Override
    public Object dequeue() throws QueueEmptyException {
        if (isEmpty()) {
            throw new QueueEmptyException("意外：队列空");
        }
        Object obj = head.getElem();
        head = head.getNext();
        size--;
        if (getSize() == 0) {
            tail = null;
        }
        return obj;
    }

    /**
     * 查看队首元素
     * @return Object
     */
    @Override
    public Object front() {
        if(isEmpty()) {
            throw new QueueEmptyException("意外：队列空");
        }
        return head.getElem();
    }

    /**
     * 遍历队列（不属于ADT）
     */
    public void traverse() {
        Node p = head;
        while (p != null) {
            System.out.println(p.getElem() + " ");
            p = p.getNext();
        }
    }
}
