package dsa;

public interface Position {
    Object getElem();    // 返回存放于该位置的元素
    Object setElem(Object e);    // 将给定元素存放于该位置，返回之前存放的元素
}
