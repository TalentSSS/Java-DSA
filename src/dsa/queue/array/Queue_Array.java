package dsa.queue.array;

import dsa.queue.Queue;
import dsa.queue.QueueEmptyException;

public class Queue_Array implements Queue {
    /**
     * 最大容量
     */
    public static final int MAX_CAPACITY = 1000;

    /**
     * 数组实际容量
     */
    protected int capacity;

    /**
     * 对象数组
     */
    protected Object[] Q;

    /**
     * 队首元素位置
     */
    protected int f = 0;

    /**
     * 队尾元素位置
     */
    protected int r = 0;

    /**
     * 构造方法（空队列）
     */
    public Queue_Array() {
        this(MAX_CAPACITY);
    }

    /**
     * 按指定容量创建对象
     * @param cap 容量
     */
    public Queue_Array(int cap) {
        this.capacity = cap;
        Q = new Object[cap];
    }

    /**
     * 查询当前队列规模
     * @return int
     */
    @Override
    public int getSize() {
        return (capacity - f + r) % capacity;
    }

    /**
     * 队列判空
     * @return boolean
     */
    @Override
    public boolean isEmpty() {
        return (f == r);
    }

    /**
     * 入队
     * @param obj 入队对象
     * @throws QueueFullException 队列满异常
     */
    @Override
    public void enqueue(Object obj) throws QueueFullException {
        if(getSize() == capacity - 1) {
            throw new QueueFullException("意外：队列满");
        }
        Q[r] = obj;
        r = (r + 1) % capacity;
    }

    /**
     * 出队
     * @return Object 出队元素
     * @throws QueueEmptyException 队列空异常
     */
    @Override
    public Object dequeue() throws QueueEmptyException {
        Object elem;
        if (isEmpty()) {
            return new QueueEmptyException("意外：队列空");
        }
        elem = Q[f];
        Q[f] = null;
        f = (f + 1) % capacity;
        return elem;
    }

    /**
     * 查看队首元素
     * @return Object
     */
    @Override
    public Object front() {
        if (isEmpty()) {
            return new QueueEmptyException("意外：队列空");
        }
        return Q[f];
    }

    /**
     * 遍历队列（不属于ADT）
     */
    public void traverse() {
        for (int i = f; i < r - 1; i++) {
            System.out.print(Q[i] + " ");
        }
        System.out.println(Q[r-1]);
    }
}
