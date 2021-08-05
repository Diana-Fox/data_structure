package graph;

import java.util.Queue;
import java.util.Vector;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 基于邻接矩阵，实现图结构
 */
public class GraphMatrix<Tv, Te> implements Graph {
    private Vector<Vertex<Tv>> v;//顶点集
    private Vector<Vector<Edge<Te>>> e;//边集

    //n=e=0
    @Override
    public Tv Vertex(int i) {
        return v.get(i).getData();
    }

    @Override
    public int InDegree(int i) {
        return v.get(i).getInDegree();
    }

    @Override
    public int OutDegree(int i) {
        return v.get(i).getOutDegree();
    }

    @Override
    public VStatus Status(int i) {
        return v.get(i).getStatus();
    }

    @Override
    public int DTime(int i) {
        return v.get(i).getdTime();
    }

    @Override
    public int FTime(int i) {
        return v.get(i).getfTime();
    }

    @Override
    public int Parent(int i) {
        return v.get(i).getParent();
    }

    @Override
    public int Priority(int i) {
        return v.get(i).getPriority();
    }

    /**
     * 第一个邻居
     *
     * @param i
     * @return
     */
    int FirstNbr(int i) {
        int n = 0;
        return NextNber(i, n);
    }

    /**
     * 对于任意顶点i，枚举其所有的邻接顶点neighbor
     * 若已枚举到邻居j，则转向下一邻居
     *
     * @param i
     * @param j
     * @return
     */
    public int NextNber(int i, int j) {
        while ((-1 < j) && existe(i, --j)) ;//逆向顺序查找
        return j;
    }

    /**
     * 判断对应边是否存在
     *
     * @param i
     * @param j
     * @return
     */
    private boolean existe(int i, int j) {
        //理论上i和j有个边界值判断
        Edge<Te> teEdge = e.get(i).get(j);
        return (teEdge.getData() != null);
    }

    /**
     * 返回对应边的信息
     *
     * @param i
     * @param j
     * @return
     */
    private Te Edge(int i, int j) {
        return e.get(i).get(j).getData();
    }

    /**
     * 边的状态信息，其他信息雷同，不写了
     *
     * @param i
     * @param j
     * @return
     */
    private EStatus Status(int i, int j) {
        return e.get(i).get(j).getStatus();
    }

    //插入一条边
    private void Insert(Te edge, int w, int i, int j) {
        if (existe(i, j))//忽略已存在的边
            return;
        //创建新边
        e.get(i).set(i, new Edge<Te>(edge, w));
        //总边数++更新边的计数，应该++一下
        //元素i的出度增加
        v.get(i).setOutDegree(v.get(i).getOutDegree() + 1);
        //元素j的入度增加
        v.get(j).setInDegree(v.get(j).getInDegree() + 1);
    }

    private Te Remove(int i, int j) {
        Te edgeBak = Edge(i, j);
        e.get(i).set(j, null);//把对应位置的元素置空
        //更新边计数,--
        //元素i的出度减少
        v.get(i).setOutDegree(v.get(i).getOutDegree() - 1);
        //元素j的入度减少
        v.get(j).setInDegree(v.get(j).getInDegree() - 1);
        return edgeBak;
    }

    //顶点插入
    private int Insert(Tv vertex) {
        //首先给e[n][]扩充一列,n为0-内数组长度,再给内数组扩充一行,
        //如果在给e外数组扩充一个元素,以及顶点数组增加一个节点
        return -1;
    }

    /**
     * 图的广度遍历，但是只能在连通域内
     *
     * @param v
     * @param clock
     */
    public void BFS(int v, int clock) {
        Queue<Integer> Q = new ConcurrentLinkedQueue();//先搞个队列
        //设置一下当前节点状态为DISCOVERED
        this.v.get(v).setStatus(VStatus.DISCOVERED);
        //入队
        Q.add(v);
        while (!Q.isEmpty()) {
            Vertex<Tv> tvVertex = this.v.get(Q.poll());
            tvVertex.setdTime(++clock);
            //找邻居节点，并处理
            for (int i = FirstNbr(v); -1 < i; i = NextNber(v, i)) {
                Vertex<Tv> tvVertex1 = this.v.get(i);
                //没遍历过，入队
                if (tvVertex1.getStatus() == VStatus.UNDISCOVERED) {
                    //状态转变为DISCOVERED
                    tvVertex1.setStatus(VStatus.DISCOVERED);
                    Q.add(i);
                    //设置树的父节点
                    tvVertex1.setParent(v);
                    //引入树边
                    this.e.get(v).get(i).setStatus(EStatus.TREE);
                } else {//已经在队列或者已经访问完毕，属于跨边
                    this.e.get(v).get(i).setStatus(EStatus.CROSS);
                }
            }
            //被访问过的节点
            tvVertex.setStatus(VStatus.VISITED);
        }
    }

    /**
     * 新的广度遍历算法，当图有多个连通域时也适用
     *
     * @param s
     */
    void NewBFS(int s) {//s为其实顶点
        int n = 1;//
        int clock = 0;
        int v = s;
        do {//逐一检查所有顶点，一旦遇到尚未发现的顶点
            if (this.v.get(v).getStatus() == VStatus.UNDISCOVERED) {
                BFS(v, clock);
            }
        }
        while (s != (v = (++v % n)));
    }
}
