package sequence.tree;

import sequence.tree.bintree.BinNode;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 关于树的深度遍历算法
 */
public class TreeTraverse<T> {
    void travLevel(BinNode<T> binNode) {
        Queue<BinNode<T>> queue = new ConcurrentLinkedQueue();
        queue.add(binNode);//根节点先入队
        while (!queue.isEmpty()) {
            //取出头节点并移除
            binNode = queue.poll();
            Visit(binNode.getData());
            if (binNode.getlChild() != null)
                queue.add(binNode.getlChild());//左孩子入队
            if (binNode.getrChild() != null)
                queue.add(binNode.getrChild());//右孩子入队
        }

    }

    /**
     * 递归的方式遍历
     * 先序遍历
     *
     * @param treeNode
     */
    void traverse(BinNode<T> treeNode) {
        if (treeNode == null) {
            return;//递归基直接返回
        }
        Visit(treeNode.getData());
        //递归左子树
        traverse(treeNode.getlChild());
        //递归右子树
        traverse(treeNode.getrChild());
    }

    /**
     * 中序遍历
     *
     * @param treeNode
     */
    void traverse_2(BinNode<T> treeNode) {
        if (treeNode == null) {
            return;//递归基直接返回
        }
        //递归左子树
        traverse(treeNode.getlChild());
        Visit(treeNode.getData());
        //递归右子树
        traverse(treeNode.getrChild());
    }

    void traverse_I1(BinNode<T> treeNode) {
        //辅助栈
        Stack<BinNode> stack = new Stack<>();
        if (treeNode != null)
            stack.push(treeNode);//根节点入栈
        while (!stack.empty()) {
            BinNode<T> pop = stack.pop();
            Visit(pop.getData());
            if (pop.getrChild() != null) {
                stack.push(pop.getrChild());
            }
            if (pop.getlChild() != null) {
                stack.push(pop.getlChild());
            }
        }

    }

    /**
     * 先序遍历主算法
     *
     * @param treeNode
     */
    void traverse_I2(BinNode<T> treeNode) {
        Stack<BinNode> stack = new Stack<>();
        while (true) {
            VisitAlongLeftBranch(treeNode, stack);
            if (stack.empty())
                break;
            treeNode = stack.pop();//下一子树的根
        }
    }

    /**
     * 后序遍历主算法
     *
     * @param binNode
     */
    void traverse_I3(BinNode<T> binNode) {
        Stack<BinNode> stack = new Stack<>();
        while (true) {
            goAlongLeftBranch(binNode, stack);
            if (stack.empty())
                break;
            binNode = stack.pop();//下一子树的根
            Visit(binNode.getData());
            binNode = binNode.getrChild();
        }
    }

    /**
     * 从根节点开始，依次访问，并将右孩子入栈
     *
     * @param binNode
     * @param stack
     */
    void VisitAlongLeftBranch(BinNode<T> binNode, Stack<BinNode> stack) {
        while (binNode != null) {
            Visit(binNode.getData());
            stack.push(binNode.getrChild());//把右孩子入栈
            binNode = binNode.getlChild();//沿左侧链下行
        }
    }

    /**
     * 将左孩子入栈，用于中序遍历
     *
     * @param binNode
     * @param stack
     */
    void goAlongLeftBranch(BinNode<T> binNode, Stack<BinNode> stack) {
        while (binNode != null) {
            stack.push(binNode);
            binNode = binNode.getlChild();
        }
    }

    //访问当前节点数据，随便干啥，就先写成方法吧
    private void Visit(T data) {
    }
}
