package graph;

/**
 * 顶点的实现
 *
 * @param <Tv>
 */
public class Vertex<Tv> {

    private Tv data;//数据
    private int inDegree;//入度
    private int outDegree;//出度
    private VStatus status;//状态
    private int dTime;//时间标签
    private int fTime;//时间标签
    private int parent;//在遍历树中的父节点
    private int priority;//在遍历树中的优先级（最短路径、极短跨边等）

    public Vertex(Tv data) {
        this.data = data;
        this.inDegree = 0;
        this.outDegree = 0;
        this.dTime = -1;
        this.fTime = -1;
        this.parent = -1;
        this.status = VStatus.UNDISCOVERED;
        this.priority = Integer.MAX_VALUE;
    }

    public Tv getData() {
        return data;
    }

    public void setData(Tv data) {
        this.data = data;
    }

    public int getInDegree() {
        return inDegree;
    }

    public void setInDegree(int inDegree) {
        this.inDegree = inDegree;
    }

    public int getOutDegree() {
        return outDegree;
    }

    public void setOutDegree(int outDegree) {
        this.outDegree = outDegree;
    }

    public VStatus getStatus() {
        return status;
    }

    public void setStatus(VStatus status) {
        this.status = status;
    }

    public int getdTime() {
        return dTime;
    }

    public void setdTime(int dTime) {
        this.dTime = dTime;
    }

    public int getfTime() {
        return fTime;
    }

    public void setfTime(int fTime) {
        this.fTime = fTime;
    }

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
