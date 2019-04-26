package dsa.stack;


/**
 * @author talent
 */
public interface Stack {

    /**
     * 返回栈中元素数目
     * @return int
     */
    int getSize();

    /**
     * 数组判空
     * @return boolean
     */
    boolean isEmpty();

    /**
     * 取栈顶元素
     * @return Object
     * @throws StackEmptyException
     */
    Object top() throws StackEmptyException; // 取栈顶元素

    /**
     * 入栈
     * @param ele 入栈元素
     */
    void push(Object ele);   // 入栈

    /**
     * 出栈
     * @return Object 出栈元素
     * @throws StackEmptyException
     */
    Object pop() throws StackEmptyException; // 出栈
}
