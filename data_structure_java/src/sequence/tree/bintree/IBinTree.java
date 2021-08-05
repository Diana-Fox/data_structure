package sequence.tree.bintree;

//不知道叫啥名好，先叫这个吧
public interface IBinTree<T> {
    /**
     * 更新节点binNode的高度
     *
     * @param binNode
     * @return
     */
    int UpdateHeight(BinNode<T> binNode);

    /**
     * @param binNode
     */
    void UpdateHeightAbove(BinNode<T> binNode);

    /**
     * 树的规模
     *
     * @return
     */
    int Size();

    /**
     * 是否为空树
     *
     * @return
     */
    boolean Empty();

    /**
     * 返回树根节点
     *
     * @return
     */
    BinNode<T> Root();
}
