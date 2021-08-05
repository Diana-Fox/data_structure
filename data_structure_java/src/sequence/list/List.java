package sequence.list;

public interface List<T> {
    //通过秩找到对应元素
    int Get(int r);

    //list大小
    int Size();

    //首节点
    int First();

    //尾节点
    int Last();

    //在首节点前插入
    void InsertAsFirst(T e);

    //在尾节点后插入
    void InsertAsLast(T e);

    //在指定节点前插入
    void InsertBefore(int p, T e);

    //在指定节点后插入
    void InsertAfter(int p, T e);

    //移除p处节点
    void remove(int p);

    //判断节点是否已经按非降序排列
    void disordered();

    //调整各节点的位置，使之按非降序排列
    void sort();

    //查询指定元素，找不到就返回null
    Node<T> find(int e);

    //查找指定目标元素，找不到就返回不大于e的秩的节点
    int search(T e);

    //无序列表剔除重复元素
    int deduplicate();

    //有序向量剔除重复元素
    void uniquify();

    //遍历列表
    void traverse();
}
