package dsa.vector.impl;

import dsa.vector.BoundaryViolationException;
import dsa.vector.Vector;

public class VectorArray implements Vector {

    /**
     * 数组的容量
     */
    private final int N = 1024;

    /**
     * 向量实际规模
     */
    private int n = 0;

    /**
     * 对象数组
     */
    private Object[] A;

    /**
     * 构造函数
     */
    public VectorArray() {
        A = new Object[N];
        n = 0;
    }

    /**
     * 返回向量中元素个数
     *
     * @return 向量中元素个数
     */
    @Override
    public int getSize() {
        return n;
    }

    /**
     * 向量是否为空
     *
     * @return 判空标记
     */
    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    /**
     * 取秩为r的元素
     *
     * @param r 秩
     * @return 秩为r的元素
     * @throws BoundaryViolationException 秩超出边界时抛异常
     */
    @Override
    public Object getAtRank(int r) throws BoundaryViolationException {
        if (0 > r || r >= n) {
            throw new BoundaryViolationException("意外：秩越界");
        }
        return A[r];
    }

    /**
     * 将秩为r的元素替换为obj
     *
     * @param r   秩
     * @param obj 新元素
     * @return 原来的元素
     * @throws BoundaryViolationException 秩超出边界时抛异常
     */
    @Override
    public Object replaceAtRank(int r, Object obj) throws BoundaryViolationException {
        if (0 > r || r >= n) {
            throw new BoundaryViolationException("意外：秩越界");
        }
        Object bak = A[r];
        A[r] = obj;
        return bak;
    }

    /**
     * 插入obj作为秩为r的元素
     *
     * @param r   秩
     * @param obj 插入的元素
     * @return 返回被插入的元素
     * @throws BoundaryViolationException 秩超出边界时抛异常
     */
    @Override
    public Object insertAtRank(int r, Object obj) throws BoundaryViolationException {
        if (0 > r || r > n) {
            throw new BoundaryViolationException("意外错：秩越界");
        }
        if (n >= N) {
            throw new BoundaryViolationException("意外错：数组越界");
        }
        for (int i = n; i > r; --i) {
            A[i] = A[i - 1];
        }
        A[r] = obj;
        n++;
        return obj;
    }

    /**
     * 溢出秩为r的元素
     *
     * @param r 秩
     * @return 被移除的元素
     * @throws BoundaryViolationException 秩超出边界时抛异常
     */
    @Override
    public Object removeAtRank(int r) throws BoundaryViolationException {
        if (0 > r || r >= n) {
            throw new BoundaryViolationException("意外错：秩越界");
        }
        Object bak = A[r];
        for (int i = r; i + 1 < n; ++i) {
            A[i] = A[i + 1];
        }
        n--;
        return bak;
    }
}
