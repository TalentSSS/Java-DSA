package dsa.stack.list;

import dsa.Node;
import dsa.stack.Stack;
import dsa.stack.StackEmptyException;

/**
 * @author talent
 */
public class StackList implements Stack {
    /**
     * 栈顶节点
     */
    private Node top;

    /**
     * 栈大小
     */
    private int size;

    /**
     * 返回栈大小
     * @return int
     */
    @Override
    public int getSize() {
        return this.size;
    }

    /**
     * 栈判空
     * @return boolean
     */
    @Override
    public boolean isEmpty() {
        return this.top == null;
    }

    /**
     * 返回栈顶元素
     * @return Object
     * @throws StackEmptyException
     */
    @Override
    public Object top() throws StackEmptyException {
        if (this.top == null) {
            throw new StackEmptyException("意外：栈空");
        }
        return this.top.getElem();
    }

    /**
     * 元素入栈
     * @param ele 入栈元素
     */
    @Override
    public void push(Object ele) {
        Node v = new Node(ele, this.top);
        this.top = v;
        this.size++;
    }

    /**
     * 元素出栈
     * @return Object
     * @throws StackEmptyException
     */
    @Override
    public Object pop() throws StackEmptyException {
        if (this.top == null) {
            throw new StackEmptyException("意外：栈空");
        }
        Object temp = this.top.getElem();
        this.top = this.top.getNext();
        size--;
        return temp;
    }
}
