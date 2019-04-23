package dsa;

public class Node implements Position {
    private Object element; // 数据对象
    private Node next;  // 指向后继节点

    /********************构造方法********************/
    public Node() {
        this(null, null);
    }

    public Node(Object e, Node n) {
        element = e;
        next = n;
    }

    /********************Position接口方法********************/
    @Override
    public Object getElem() {
        return element;
    }

    @Override
    public Object setElem(Object e) {
        Object oldElem = element;
        element = e;
        return oldElem;
    }
    /********************单链表节点方法********************/
    public Node getNext() {
        return next;
    }

    public void setNext(Node newNext) {
        next = newNext;
    }

}
