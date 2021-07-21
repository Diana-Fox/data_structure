package algorithms;

/**
 * 给定n个正整数，将它们按（非降）序排列
 * 交换扫描:依次比较每一对相邻元素，如有必要，交换之
 * 若整趟扫描都没有进行交换，则排序完成；否则，再做一趟扫描交换
 */
public class Bubble {
    /**
     * @param array sorted:有序标识
     */
    public void BubbleSortOne(int[] array) {
        int n = array.length;
        //初始设置本次扫描为无序
        // 只有当数组没有逆序对时，即sorted在反转前为true时，退出循环
        // 当所有扫描都结束时为有序
        //每一轮将最大的值沉淀到最低下，经过k次扫描，问题规模也缩减到n-k
        for (boolean sorted = false; sorted = !sorted; n--) {
            //自左向右，逐对检查数组内各相邻元素
            for (int i = 0; i < n; i++) {
                if (array[i - 1] > array[i]) {//发现逆序对
                    General.swap(array, i, i - 1);//交换逆序对
                    sorted = false;//有序标识设为false
                }
            }
        }
    }




}
