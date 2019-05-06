package dsa;

/**
 * @author talent
 */
public class DLNode implements Position {
    /**
     * 数据对象
     */
    private Object element;
    /**
     * 前驱节点
     */
    private DLNode prev;
    /**
     * 后继节点
     */
    private DLNode next;

    /**
     * 返回存在该位置的元素
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
        Object oldElement = element;
        element = e;
        return oldElement;
    }

    /**
     * 找到前驱节点
     * @return 前驱节点
     */
    public DLNode getPrev() {
        return prev;
    }

    /**
     * 找到后继节点
     * @return 后继节点
     */
    public DLNode getNext() {
        return next;
    }

    /**
     * 修改前驱节点
     * @param prev 新的前驱节点
     */
    public void setPrev(DLNode prev) {
        this.prev = prev;
    }

    /**
     * 修改后继节点
     * @param next 新的后继节点
     */
    public void setNext(DLNode next) {
        this.next = next;
    }
}
