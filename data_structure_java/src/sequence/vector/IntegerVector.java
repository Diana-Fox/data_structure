package sequence.vector;

import java.util.Random;
import java.util.stream.IntStream;

public class IntegerVector implements IVector<Integer> {
    private int DEFAULT_CAPACITY = 16;
    //元素个数
    private int size;
    //总容量
    private int capacity;
    //元素
    private int[] elem;

    /**
     * 没有传入任何参数
     */
    public IntegerVector() {
        elem = new int[DEFAULT_CAPACITY];
        size = 0;
    }

    /**
     * 从数组区间复制
     *
     * @param elem
     * @param lo
     * @param hi
     */
    public IntegerVector(int[] elem, int lo, int hi) {
        copyForm(elem, lo, hi);
    }

    /**
     * 利用已有的向量，生成一个新向量
     *
     * @param elem
     * @param lo
     * @param hi
     * @return
     */
    private void copyForm(int[] elem, int lo, int hi) {
        //初始化的时候设置为2倍的hi-lo
        this.elem = new int[capacity = 2 * (hi - lo)];
        this.size = 0;
        while (lo < hi)
            //拷贝
            this.elem[size++] = elem[lo++];
    }

    /**
     * 扩容方法
     */
    private void Expand() {
        //没满，不居然
        if (size < capacity)
            return;
        int[] oldElem = this.elem;
        //容量加倍
        this.elem = new int[capacity <<= 1];
        for (int i = 0; i < size; i++) {
            elem[i] = oldElem[i];
        }
    }

    @Override
    public int Size() {
        return size;
    }


    @Override
    public Integer Get(int r) {

        return elem[r];
    }

    @Override
    public void Put(int r, Integer e) {
        //因为可能需要扩容
        Expand();
        //先把r-r后的元素都往后移一位,自后向前移动
        for (int i = size; i < r; i--) {
            elem[i] = elem[i - 1];
        }
        elem[r] = e;
        size++;
    }

    @Override
    public void Insert(int r, Integer e) {

    }

    @Override
    public void Remove(int r) {
        Remove(r, r + 1);
    }

    @Override
    public void Remove(int lo, int hi) {
        if (lo == hi)
            return;
        while (hi < size) {
            elem[lo++] = elem[hi++];
        }
        size = lo;
        shrink();//更新规模，看是否要缩容
    }

    /**
     * 缩容算法，先不写了
     */
    private void shrink() {
    }

    @Override
    public int disordered() {
        int n = 0;
        for (int i = 0; i < size; i++) {
            if (elem[i - 1] > elem[i]) {
                n++;
            }
        }
        return n;
    }

    @Override
    public void Sort() {

    }

    /**
     * 归并排序
     *
     * @param lo
     * @param hi
     */
    public void MergeSort(int lo, int hi) {
        if (hi - lo < 2)
            return;
        //中点为界
        int mi = (lo + hi) >> 1;
        //对前半段排序
        MergeSort(lo, mi);
        //对后半段排序
        MergeSort(mi, hi);
        //归并
        Merge(lo, mi, hi);
    }

    /**
     * 归并算法
     *
     * @param lo
     * @param mi
     * @param hi
     */
    private void Merge(int lo, int mi, int hi) {
        //计算lo到mi的数据量
        int lb = mi - lo;
        //定义一个向量B，存放要归并元素的前半段
        int[] b = new int[lb];
        //把前半段的元素复制到b
        for (int i = 0; i < lb; b[i] = elem[i++]) ;
        //后半段的数据量
        int lc = hi - mi;
        //定义i为在elem的下标，j为b的下标，k为后段的下标
        for (int i = 0, j = 0, k = 0; j < lb || k < lc; ) {
            //要是j在lb内，且后半段越界或者目前指向的下标值比b[j]小
            if ((j < lb) && (lc <= k || b[j] <= elem[mi + k]))
                //将b中的元素归并到元素中
                elem[i++] = b[j++];
            //k在lc的合法范围内，但是b已经越界或者后半段当前下标值小于b
            if ((k < lc) && (lb <= j || (elem[mi + k] < b[j])))
                elem[i++] = elem[mi + k++];
        }
    }

    /**
     * 冒泡的调用
     */
    private void Bubble() {
        //如果无序就一直扫描交换,但是如果其中某段是有序的，也会重新扫描
        //while (!OldBubbleSort(elem, 0, size)) ;
        //最开始的时候需要扫描全部
        int hi = size;
        int lo = 0;
        //当找到每次扫描的最后一组逆序对时，我们只需要将逆序对前的进行扫描交换即可
        //所以hi为上一次扫描的逆序对位置
        while (lo < (hi = NewBubbleSort(elem, 0, size))) ;
    }

    public int NewBubbleSort(int[] elem, int lo, int hi) {
        int last = lo;//标记最后一对逆序对位置
        int temp = 0;
        while (++lo < hi) {
            if (elem[lo - 1] > elem[lo]) {
                last = lo;
                temp = elem[lo - 1];
                elem[lo - 1] = elem[lo];
                elem[lo] = temp;
            }
        }
        return last;
    }

    /**
     * 冒泡排序，并且用标志位判断之前是否逆序
     *
     * @param elem
     * @param lo
     * @param hi
     * @return
     */
    public boolean OldBubbleSort(int[] elem, int lo, int hi) {
        //整体有序标识
        boolean sorted = true;
        int temp = 0;
        while (++lo < hi) {//自左向右，逐一比较
            if (elem[lo - 1] > elem[lo]) {//逆序
                sorted = false;//曾经逆序过
                //调整逆序对，变为有序
                temp = elem[lo - 1];
                elem[lo - 1] = elem[lo];
                elem[lo] = temp;
            }
        }
        return sorted;
    }


    /**
     * 认为只支持判等
     * 算法输入敏感
     *
     * @param e
     * @return
     */
    @Override
    public int Find(Integer e) {
        for (int i = 0; i < size; i++) {
            if (e.equals(elem[i])) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 有序向量，可进行比较
     * 利用二分查找
     *
     * @param e
     * @return
     */
    @Override
    public int Search(Integer e) {
        Random r = new Random();
        int i = r.nextInt(10);
        if (i % 2 == 0) {
            return BinSearch(elem, e, 0, size);
        } else {
            return FibSearch(elem, e, 0, size);
        }
    }

    /**
     * 利用二分法查找指定元素
     *
     * @param elem 数组
     * @param e
     * @param lo
     * @param hi
     * @return
     */
    private int BinSearch(int[] elem, Integer e, int lo, int hi) {

        return -1;
    }

    /**
     * 斐波那契查找指定元素
     * 因为二分法的左右判断次数不一致，转向左边比转向右边成本低
     * 因为长度n=fib(k)-1，所以当mi=fib(k-2)-1时
     * 前后子向量的长度分别为fib(k-1)-1、fib(k-2)-1
     *
     * @param elem
     * @param e
     * @return
     */
    private int FibSearch(int[] elem, Integer e, int lo, int hi) {

//        Fib fib(hi-lo);
//        while (lo < hi) {
//            while (hi - lo < fib.get()) {
//                fib.prev();
//            }
//            int mi = lo + fib.get() - 1;
//            //后面用二分查找即可
//        }
        return -1;
    }


    @Override
    public void Deduplicate() {
        int i = 1;//从第一个元素开始
        while (i < size) {
            if (Find(elem[i]) < 0) {//如果查找没有发现相同元素就查找下一个值
                i++;
            } else {
                Remove(i);//发现向量中存在其他相同元素则删除
            }
        }
    }

    @Override
    public void Uniquify() {
        int i = 0, j = 0;
        while (++j < size) {
            if (elem[i] != elem[j]) {
                elem[++i] = elem[j];
            }
        }
        size = ++i;
        shrink();

    }

    @Override
    public void Traverse(Visit visit) {
        for (int i = 0; i < size; i++) {
            //想干啥就在visit类里面整方法
            visit = new Visit(elem[i]);
        }
    }
}
