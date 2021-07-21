package algorithms;

/***
 * 采用减而治之的方式，将问题的规模缩小并解决
 */
public class DivideAndconquer {

    /**
     * 计算任意长度的整数数组之和
     *
     * @param array
     * @return
     */
    public int Sum(int array[]) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            //每经过一个循环，问题的规模都缩减了
            sum += array[i];
        }
        return sum;
    }

    /**
     * 采用减而治之的方式求和
     *
     * @param array 需要求和的数字
     * @param n     需要求和数组的长度
     * @return 每个子递归需要的时间都是O(1), 所以整个算法的时间复杂度为O(n)
     * 递归方式是线性递归
     */
    public int Sum(int array[], int n) {
        //问题被分为当数组长度为0和长度不为0时两种情况
        return (0 < n) ?
                //求解非当前值的和，并将二者的结果合并
                0 : Sum(array, n - 1) + array[n - 1];
    }


    /**
     * 给定任意数组，将其前后颠倒,递归的实现
     *
     * @param array
     * @param lo
     * @param hi
     */
    public void ReverseRecursion(int[] array, int lo, int hi) {
        if (lo < hi) {
            General.swap(array, array[lo], array[hi]);
            //每次执行，将原来问题的规模缩小两个元素
            ReverseRecursion(array, lo - 1, hi - 1);
        }
    }
}
