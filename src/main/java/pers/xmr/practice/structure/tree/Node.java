package pers.xmr.practice.structure.tree;

/**
 * @author xmr
 * @date 2020/3/30 17:22
 * @description 链式二叉树结点
 */
public class Node {
    Object value; // 数值域
    Node leftChild; // 左子树的引用
    Node rightChild; // 右子树的引用

    public Node(Object value, Node leftChild, Node rightChild) {
        super();
        this.value = value;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    @Override
    public String toString() {
        return "[ value = " + value + " leftChild = " + leftChild + " rightChild = " + rightChild + " ]";
    }
}
