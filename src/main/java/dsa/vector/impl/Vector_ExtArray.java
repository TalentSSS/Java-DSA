package dsa.vector.impl;

import dsa.vector.BoundaryViolationException;

public class Vector_ExtArray extends Vector_Array {
    /**
     * 数组的容量
     */
    private int N = 8;

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
    public Vector_ExtArray() {
        super();
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
            Object[] B = new Object[N * 2];
            N = N * 2;
            for (int i = 0; i < n; i++) {
                B[i] = A[i];
            }
            A = B;
        }
        for (int i = n; i > r; --i) {
            A[i] = A[i - 1];
        }
        A[r] = obj;
        n++;
        return obj;
    }
}
