package algorithms;

/**
 * 分而治之的策略，将问题分解并解决
 */
public class DecreaseAndConquer {
    /**
     * 计算任意长度的整数数组之和
     * 分而治之的方法
     * 每次规模缩为原来的一半
     *
     * @param array
     * @param lo
     * @param hi
     * @return
     */
    public int Sum(int array[], int lo, int hi) {
        if (lo == hi) return array[lo];//递归基
        int mi = (lo + hi) >> 1;
        return Sum(array, lo, mi) + Sum(array, mi + 1, hi);
    }

    /**
     * 从数组区间[lo,hi)中找出最大的两个整数
     * 元素比较次数尽可能的少
     * 本算法最坏情况下，每次为2n-3
     *
     * @param array
     * @param lo
     * @param hi
     */
    public void max2(int[] array, int lo, int hi) {
        int temp, x1 = lo, x2 = hi;
        if (x1 < x2) {
            x1 = hi;
            x2 = lo;
        }
        for (int i = lo + 2; i < hi; i++) {
            if (array[x2] < array[i])
                if (array[x1] < array[x2 = i]) {
                    temp = x1;
                    x1 = x2;
                    x2 = temp;
                }
        }
    }

    /**
     * 利用递归+分治改进
     *
     * @param array
     * @param lo
     * @param hi
     */
    public void max2(int[] array, int lo, int hi, int x1, int x2) {
        if (lo + 2 == hi) {//退化情况1
            if (array[lo] > array[hi]) {
                x1 = array[lo];
                x2 = array[hi];
            } else {
                x1 = array[hi];
                x2 = array[lo];
            }
            return;
        }
        if (lo + 3 == hi) {//退化情况2
            max2(array, lo, hi);
            return;
        }
        int mi = (lo + hi) / 2;
        int x1l = 0, x2l = 0, x1r = 0, x2r = 0;
        max2(array, lo, mi, x1l, x2l);
        max2(array, mi, hi, x1r, x2r);
        if (array[x1l] > array[x1r]) {
            x1 = x1l;
            x2 = x2l > x1r ? x2l : x1r;
        } else {
            x1 = x1r;
            x2 = x1l > x2r ? x1l : x2r;
        }
    }
}
