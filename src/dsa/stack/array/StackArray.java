package dsa.stack.array;


import dsa.stack.Stack;
import dsa.stack.StackEmptyException;

/**
 * @author talent
 */
public class StackArray implements Stack {
    /**
     * 栈默认大小
     */
    public static final int CAPACITY = 1024;

    /**
     * 栈中元素规模
     */
    protected int capacity;
    protected Object[] S;
    protected int top = -1;

    public StackArray() {
        this(CAPACITY);
    }

    public StackArray(int cap) {
        this.capacity = cap;
        S = new Object[cap];
    }

    /**
     * 栈中元素数目
     * @return int
     */
    @Override
    public int getSize() {
        return (this.top + 1);
    }

    /**
     * 判空
     * @return boolean
     */
    @Override
    public boolean isEmpty() {
        return (this.top < 0);
    }

    /**
     * 返回栈顶元素
     * @return Object
     * @throws StackEmptyException
     */
    @Override
    public Object top() throws StackEmptyException {
        if (isEmpty()) {
            throw new StackEmptyException("意外，栈空");
        }
        return S[this.top];
    }

    /**
     * 入栈
     * @param ele 入栈元素
     * @throws StackFullException
     */
    @Override
    public void push(Object ele) throws StackFullException {
        if (getSize() == CAPACITY) {
            throw new StackFullException("意外，栈满");
        }
        S[++this.top] = ele;
    }

    /**
     * 出栈
     * @return Object
     * @throws StackEmptyException
     */
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
