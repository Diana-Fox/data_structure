package algorithms;

/**
 * 放在写算法的时候可能会被重复使用的一些基础方法
 */
public class General {
    /**
     * 交换数组中的两个元素
     *
     * @param array 数组
     * @param i     元素i
     * @param j     元素j
     */
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
