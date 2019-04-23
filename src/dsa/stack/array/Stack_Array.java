package dsa.stack.array;


import dsa.stack.Stack;
import dsa.stack.StackEmptyException;

public class Stack_Array implements Stack {
    public static final int CAPCITY = 1024;
    protected int capacity;
    protected Object[] S;
    protected int top = -1;

    public Stack_Array() {
        this(CAPCITY);
    }

    public Stack_Array(int cap) {
        this.capacity = cap;
        S = new Object[cap];
    }

    @Override
    public int getSize() {
        return (this.top + 1);
    }

    @Override
    public boolean isEmpty() {
        return (this.top < 0);
    }

    @Override
    public Object top() throws StackEmptyException {
        if (isEmpty()) {
            throw new StackEmptyException("意外，栈空");
        }
        return S[this.top];
    }

    @Override
    public void push(Object ele) throws StackFullException {
        if (getSize() == CAPCITY) {
            throw new StackFullException("意外，栈满");
        }
        S[++this.top] = ele;
    }

    @Override
    public Object pop() throws StackEmptyException {
        if (isEmpty()) {
            throw new StackEmptyException("意外，栈空");
        }
        Object ele = S[this.top];
        S[this.top--] = null;
        return ele;
    }
}
