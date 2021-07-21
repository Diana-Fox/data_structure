package sequence.vector;

/**
 * 向量的接口，需要通过这些对向量进行操作
 */
public interface IVector<T> {

    /**
     * 报告向量当前的规模（元素总数）
     *
     * @return
     */
    int Size();

    /**
     * 获取秩为r的元素
     *
     * @param r
     * @return
     */
    T Get(int r);

    /**
     * 用e替换秩为r元素的数值
     *
     * @param r
     * @param e
     */
    void Put(int r, T e);

    /**
     * e作为秩为r元素插入，原后继元素依次后移
     *
     * @param r
     * @param e
     */
    void Insert(int r, T e);

    /**
     * 删除秩为r的元素，返回该元素中原存放的对象
     *
     * @param r
     */
    void Remove(int r);

    /**
     * 区间删除
     *
     * @param lo
     * @param hi
     */
    void Remove(int lo, int hi);

    /**
     * 判断所有元素是否以按非降序排列
     * @return 返回逆序对个数
     */
    int disordered();

    /**
     * 调整各元素的位置，使之按非降序排列
     */
    void Sort();

    /**
     * 无线向量中查找目标元素e，返回不大于e且秩最大的元素。
     *
     * @param e
     * @return
     */
    int Find(T e);

    /**
     * 有序向量中，查找目标元素e，返回不大于e且秩最大的元素
     *
     * @param e
     * @return
     */
    int Search(T e);

    /**
     * 无序向量剔除重复元素
     */
    void Deduplicate();

    /**
     * 有序向量剔除重复元素
     */
    void Uniquify();

    /**
     * 遍历向量并统一处理所有元素，处理方法由函数对象指定
     */
    void Traverse(Visit visit);
}
