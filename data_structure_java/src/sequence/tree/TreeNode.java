package sequence.tree;

import java.util.List;

//树节点，父母兄弟表示法
public class TreeNode<T> {
    //要存储当前节点的秩
    private int rank;
    //当前节点存储数据
    private T data;
    //用父节点对象，对应到数据库可以用ID
    private TreeNode ParentId;
    //子节点的集合
    private List children;

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public TreeNode getParentId() {
        return ParentId;
    }

    public void setParentId(TreeNode parentId) {
        ParentId = parentId;
    }

    public List getChildren() {
        return children;
    }

    public void setChildren(List children) {
        this.children = children;
    }
}
