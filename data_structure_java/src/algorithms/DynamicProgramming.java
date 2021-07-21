package algorithms;

/**
 * 动态规划的方式解决问题
 */
public class DynamicProgramming {
    /**
     * 较慢版本求解fib数的方法
     *
     * @param n
     * @return
     */
    public int FibOne(int n) {
        return (2 > n) ? n : FibOne(n - 1) + FibOne(n - 2);
    }

    /**
     * 记忆法 memoization
     * 将已计算过的实例结果制表备查
     *
     * @param n
     * @return
     */
    public int FibTwo(int n) {

        return 0;
    }

    /**
     * 动态规划 dynamic programming
     * 颠倒计算方向，由自顶而下递归变为自底而上迭代
     *
     * @param n
     * @return
     */
    public int FibThree(int n) {
        int f = 0, g = 1;
        while (0 < n--) {
            g = g + f;
            f = g - f;
        }
        return g;
    }


}
