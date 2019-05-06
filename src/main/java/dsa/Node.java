package dsa;

/**
 * @author talent
 */
public class Node implements Position {
    /**
     * element 数据对象
     */
    private Object element;
    /**
     * next 指向后继节点
     */
    private Node next;

    public Node() {
        this(null, null);
    }

    public Node(Object e, Node n) {
        element = e;
        next = n;
    }

    /**
     * 返回存放于该位置的数据
     * @return 该位置的元素
     */
    @Override
    public Object getElem() {
        return element;
    }

    /**
     * 将给定元素存放于该位置，返回之前存放的元素
     * @param e 给定的元素
     * @return 之前存放的元素
     */
    @Override
    public Object setElem(Object e) {
        Object oldElem = element;
        element = e;
        return oldElem;
    }

    /**
     * 找到后继节点
     * @return 后继节点
     */
    public Node getNext() {
        return next;
    }

    /**
     * 修改后继节点
     * @param newNext 新的后继节点
     */
    public void setNext(Node newNext) {
        next = newNext;
    }
}
