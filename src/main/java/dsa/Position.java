package dsa;

/**
 * @author talent
 */
public interface Position {

    /**
     * 返回存放于该位置的数据
     * @return 该位置的元素
     */
    Object getElem();

    /**
     * 将给定元素存放于该位置，返回之前存放的元素
     * @param e 给定的元素
     * @return 之前存放的元素
     */
    Object setElem(Object e);
}
