package dsa.stack;

public interface Stack {

    int getSize();   // 返回栈中元素数目

    boolean isEmpty();   // 判断数组是否为空

    Object top() throws StackEmptyException; // 取栈顶元素

    void push(Object ele);   // 入栈

    Object pop() throws StackEmptyException; // 出栈
}
