package sequence.list;

public class IntegerList implements List<Integer> {
    //列表总长
    private int size;
    //列表头节点，与生俱来的，对外不可见
    private Node<Integer> header;
    //列表尾节点，与生俱来的，对外不可见
    private Node<Integer> trailer;

    @Override
    public int Get(int r) {
        Node<Integer> succ = header.Succ();
        while (0 < r--) {
            succ = succ.getSucc();
        }
        return succ.data();
    }

    @Override
    public int Size() {
        return 0;
    }

    @Override
    public int First() {
        return 0;
    }

    @Override
    public int Last() {
        return 0;
    }

    @Override
    public void InsertAsFirst(Integer e) {

    }

    @Override
    public void InsertAsLast(Integer e) {

    }

    @Override
    public void InsertBefore(int p, Integer e) {
        Node node = header.getSucc();
        while (0 < p--) {//定位到秩为P的位置
            node = node.getSucc();
        }
        //先取出原先的后继
        Node oldSucc = node.getSucc();
        //创建一个新节点
        Node<Integer> integerNode = new Node<>();
        //将e封装起来
        integerNode.setData(e);
        //改变原节点的后继
        node.setSucc(integerNode);
        //新节点的前驱为node节点
        integerNode.setPred(node);
        //新节点的后继为原来的后继
        integerNode.setSucc(oldSucc);
        //原后继的前驱为新节点
        oldSucc.setPred(integerNode);
    }

    @Override
    public void InsertAfter(int p, Integer e) {

    }

    @Override
    public void remove(int p) {

    }

    @Override
    public void disordered() {

    }

    @Override
    public void sort() {

    }

    @Override
    public Node<Integer> find(int e) {
        int size = this.size;
        //这次从后往前找
        Node<Integer> pred = trailer.getPred();
        while (0 < size--) {
            if (pred.data().equals(e)) {
                return pred;
            } else {
                pred = pred.getPred();
            }
        }
        return null;
    }

    @Override
    public int search(Integer e) {
        return 0;
    }

    @Override
    public void deduplicate() {

    }

    @Override
    public void uniquify() {

    }

    @Override
    public void traverse() {

    }
}
