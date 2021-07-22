package sequence.list;

/**
 * 列表节点类,节点元素的关键三个就是前驱、后继和元素存储单元
 */
public class Node<T> {
    //因为Java的指针被封装，所以我们需要用对象做指向
    private Node pred;
    private Node succ;
    private T data;

    public Node getPred() {
        return pred;
    }

    public void setPred(Node pred) {
        this.pred = pred;
    }

    public Node getSucc() {
        return succ;
    }

    public void setSucc(Node succ) {
        this.succ = succ;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    //前驱节点的位置
    public void Pred() {

    }

    //后继节点的位置
    public Node Succ() {
        return succ;
    }

    //当前节点的数据
    public T data() {
        return data;
    }

    //插入前驱节点，存入被引用对象e，返回新节点位置
    public void InsertAsPred(T e) {

    }

    //插入后继节点，存入被引用对象e，返回新节点位置
    public void InsertAsSucc() {

    }
}
