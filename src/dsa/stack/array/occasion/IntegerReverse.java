package dsa.stack.array.occasion;


import dsa.stack.array.StackArray;

/**
 * @author talent
 */
public class IntegerReverse {
    public static Integer[] reverse(Integer[] a) {
        StackArray S = new StackArray(a.length);
        Integer[] b = new Integer[a.length];
        for(Integer i : a) {
            S.push(i);
        }
        for (int i = 0; i < a.length; i++) {
            b[i] = (Integer) (S.pop());
        }
        return b;
    }
}
