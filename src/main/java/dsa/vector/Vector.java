package dsa.vector;

public interface Vector {

    /**
     * 返回向量中的元素数目
     *
     * @return 元素数目
     */
    int getSize();

    /**
     * 判断向量是否为空
     *
     * @return 判空标记
     */
    boolean isEmpty();

    /**
     * 获取秩为r的元素
     *
     * @param r 秩
     * @return 秩为r的元素
     * @throws BoundaryViolationException 秩超出边界时抛异常
     */
    public Object getAtRank(int r) throws BoundaryViolationException;

    /**
     * 将秩为r的元素替换为obj
     *
     * @param r 秩
     * @param obj 新元素
     * @return 原来的元素
     * @throws BoundaryViolationException 秩超出边界时抛异常
     */
    public Object replaceAtRank(int r, Object obj) throws BoundaryViolationException;

    /**
     * 插入obj作为秩为r的元素
     *
     * @param r   秩
     * @param obj 插入的元素
     * @return 返回被插入的元素
     * @throws BoundaryViolationException 秩超出边界时抛异常
     */
    public Object insertAtRank(int r, Object obj) throws BoundaryViolationException;

    /**
     * 移除秩为r的元素
     *
     * @param r 秩
     * @return 被移除的元素
     * @throws BoundaryViolationException 秩超出边界时抛异常
     */
    public Object removeAtRank(int r) throws BoundaryViolationException;


}
