package dsa.queue.array.occasion;


import dsa.queue.Queue;
import dsa.queue.array.QueueArray;

/**
 * @author talent
 */
public class Josephus {

    /**
     * 利用队列结构模拟Josephus环
     *
     * @param Q 队列
     * @param k 每轮传递几次
     * @return Object 最后剩下的孩子
     */
    public static Object Josephus(Queue Q, int k) {
        if (Q.isEmpty()) {
            return null;
        }
        while (Q.getSize() > 1) {
            Q.Traversal();
            for (int i = 0; i < k; i++) {
                Q.enqueue(Q.dequeue());
            }
            Object e = Q.dequeue();
            System.out.println("\n\t" + e + "退出");
        }
        return Q.front();
    }

    /**
     * 将一组对象组织为一个队列
     *
     * @param a 一组对象
     * @return Queue 对象组织成的队列
     */
    public static Queue buildQueue(Object a[]) {
        Queue Q = new QueueArray();
        for (int i = 0; i < a.length; i++) {
            Q.enqueue(a[i]);
        }
        return Q;
    }

    public static void main(String[] args) {
        String[] kid = {"Alice", "Bob", "Cindy", "Doug", "Ed",
                "Fred", "Gene", "Hope", "Irene", "Jack",
                "Kim", "Lance", "Mike", "Nancy", "Ollie"};
        System.out.println("最终幸运者是" + Josephus(buildQueue(kid), 5));
    }
}