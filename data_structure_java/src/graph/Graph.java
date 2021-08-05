package graph;

/**
 * 图的模板
 */
public interface Graph<Tv, Te> {//顶点类型和边类型

    private void Reset(int n) {
        //n就是e
        for (int i = 0; i < n; i++) {//顶点
            //取顶点的状态信息
            //取顶点的时间信息
            //取顶点的父节点
            //取顶点的优先级数
            //判断两个点之间是否存在邻边
            //设置查询边的状态
        }
    }

    /**
     * 数据
     *
     * @param i
     * @return
     */
    Tv Vertex(int i);

    /**
     * 入度
     *
     * @param i
     * @return
     */
    int InDegree(int i);

    /**
     * 出度
     *
     * @param i
     * @return
     */
    int OutDegree(int i);

    /**
     * 状态
     *
     * @param i
     * @return
     */
    VStatus Status(int i);

    /**
     * 时间标签dTime
     *
     * @param i
     * @return
     */
    int DTime(int i);

    /**
     * 时间标签fTime
     *
     * @param i
     * @return
     */
    int FTime(int i);

    /**
     * 在遍历树中的父亲
     *
     * @param i
     * @return
     */
    int Parent(int i);

    /**
     * 优先级数
     *
     * @param i
     * @return
     */
    int Priority(int i);
}
