package graph;

/**
 * 边的实现
 */
public class Edge <Te>{
    private Te data;//数据
    private int weight;//权重
    private EStatus status;

    public Edge(Te data, int weight) {
        this.data = data;
        this.weight = weight;
        this.status=EStatus.UNDETERMINED;
    }

    public Te getData() {
        return data;
    }

    public void setData(Te data) {
        this.data = data;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public EStatus getStatus() {
        return status;
    }

    public void setStatus(EStatus status) {
        this.status = status;
    }
}
