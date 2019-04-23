package dsa.stack.list;

import dsa.Node;
import dsa.stack.Stack;
import dsa.stack.StackEmptyException;

public class Stack_List implements Stack {
    private Node top;
    private int size;
    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.top == null;
    }

    @Override
    public Object top() throws StackEmptyException {
        if (this.top == null) {
            throw new StackEmptyException("意外：栈空");
        }
        return this.top.getElem();
    }

    @Override
    public void push(Object ele) {
        Node v = new Node(ele, this.top);
        this.top = v;
        this.size++;
    }

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
