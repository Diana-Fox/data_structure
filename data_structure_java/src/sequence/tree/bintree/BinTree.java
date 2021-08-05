package sequence.tree.bintree;

//二叉树
public class BinTree implements IBinTree<Integer> {
    //规模,设置初始但是-1
    private int size = -1;
    //首节点
    private BinNode<Integer> root;


    @Override
    public int UpdateHeight(BinNode<Integer> binNode) {
        int height = 0;
        height = 1 + Max(Stature(binNode.getlChild()), Stature(binNode.getrChild()));
        binNode.setHeight(height);
        return 0;
    }

    private int Max(int stature, int stature1) {
        return stature > stature1 ? stature : stature1;
    }

    /**
     * 应该是要遍历节点的孩子情况
     *
     * @param child
     * @return
     */
    private int Stature(BinNode child) {
        return 0;
    }

    @Override
    public void UpdateHeightAbove(BinNode<Integer> binNode) {
        while (binNode != null) {
            UpdateHeight(binNode);
            binNode = binNode.getParent();
        }

    }

    /**
     * 给节点插入左孩子
     *
     * @param binNode
     * @param e
     */
    public void InsertAsRC(BinNode<Integer> binNode, Integer e) {
        size++;//增加整体规模
        binNode.InsertAsRC(e);//去插入
        //更新节点高度
        UpdateHeightAbove(binNode);
    }

    @Override
    public int Size() {
        return 0;
    }

    @Override
    public boolean Empty() {
        return false;
    }

    @Override
    public BinNode<Integer> Root() {
        return null;
    }
}
