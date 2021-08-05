package sequence.tree.bintree;

//二叉树节点
public class BinNode<T> {
    //左子节点
    private BinNode lChild;
    //父节点
    private BinNode parent;
    //右子节点
    private BinNode rChild;
    //数据节点
    private T data;
    //高度指标
    private int height;

    public BinNode getlChild() {
        return lChild;
    }

    public void setlChild(BinNode lChild) {
        this.lChild = lChild;
    }

    public BinNode getParent() {
        return parent;
    }

    public void setParent(BinNode parent) {
        this.parent = parent;
    }

    public BinNode getrChild() {
        return rChild;
    }

    public void setrChild(BinNode rChild) {
        this.rChild = rChild;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    //    //左啥堆指标
//    private int npl;
//    //颜色，对红黑树
//    private int color;
    //子树规模
    int size;

    public BinNode() {

    }


    //构造函数
    public BinNode(T e, T tBinNode) {
        //父节点的指向
        parent = (BinNode) tBinNode;
    }

    //作为左孩子插入新节点
    BinNode<T> InsertAsLC(T e) {
        this.lChild = new BinNode<T>(e, (T) this);
        return lChild;
    }

    //作为右孩子插入新节点
    BinNode<T> InsertAsRC(T e) {
        this.rChild = new BinNode<T>(e, (T) this);
        lChild.parent = this;
        return rChild;
    }

    //返回当前节点在内，所有后代的总数
    public int Size() {
        int s = 1;//计入本身
        //递归计入左子树的规模
        if (lChild != null) s += lChild.Size();
        //递归计入右子树的规模
        if (rChild != null) s += rChild.Size();
        return s;
    }

    //中序遍历意义下，当前节点的直接后继
    BinNode<T> succ() {
        return null;
    }

    //子树层次遍历
    void TravLevel() {

    }

    //子树先序遍历
    void travPre() {

    }

    //子树中序遍历
    void travIn() {

    }

    //子树后序遍历
    void travPost() {

    }
}
