package dsa.deque;

import dsa.queue.QueueEmptyException;

/**
 * @author talent
 */
public interface Deque {

    /**
     * 返回队列中元素数目
     * @return 元素数目
     */
    int getSize();

    /**
     * 判断队列是否为空
     * @return 空标记
     */
    boolean isEmpty();

    /**
     * 取队首元素，但不删除
     * @return 队首元素
     * @throws QueueEmptyException 队列空异常
     */
    Object first() throws QueueEmptyException;

    /**
     * 取队尾元素，但不删除
     * @return 队尾元素
     * @throws QueueEmptyException 队列空异常
     */
    Object last() throws QueueEmptyException;

    /**
     * 将新元素作为队首元素插入
     * @param obj 新元素
     */
    void insertFirst(Object obj);

    /**
     * 将新元素作为队尾元素插入
     * @param obj 新元素
     */
    void insertLast(Object obj);


    /**
     * 删除队首元素
     * @return 被删除元素
     * @throws QueueEmptyException 队列空异常
     */
    Object removeFirst() throws QueueEmptyException;

    /**
     * 删除队尾元素
     * @return 被删除元素
     * @throws QueueEmptyException 队列空异常
     */
    Object removeLast() throws QueueEmptyException;

    /**
     * 遍历
     */
    void Traversal();
}
