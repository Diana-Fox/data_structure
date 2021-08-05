package sequence.tree;

import sequence.list.Node;

import java.util.List;

//树接口
public interface Tree<T> {
    //树的根节点
    Node<T> Root();

    //父节点
    Node<T> Parent();

    //为了不相互影响，用Java的list，不用自己写的list
    List<Node> FirstChild();

    //长子节点
    Node<T> firstChild();

    //兄弟节点
    Node<T> nextSibling();

    //将e作为第i个孩子插入
    boolean Insert(int i, T e);

    //移除第i个孩子
    void Remove(int i);

    //遍历
    void Traverse();
}
