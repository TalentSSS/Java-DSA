package dsa.queue;

/**
 * @author talent
 */
public interface Queue {
    /**
     * 返回队列中元素数目
     * @return int 队列元素数目
     */
    int getSize();

    /**
     * 判断队列是否为空
     * @return boolean 判空标记
     */
    boolean isEmpty();

    /**
     * 入队
     * @param obj 入队元素
     */
    void enqueue(Object obj);

    /**
     * 出队
     * @return Object 出队元素
     * @throws QueueEmptyException 队列空异常
     */
    Object dequeue() throws QueueEmptyException;

    /**
     * 取队首元素
     * @return Object 队首元素
     */
    Object front();

}
