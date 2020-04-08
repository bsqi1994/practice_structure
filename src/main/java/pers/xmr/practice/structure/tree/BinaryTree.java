package pers.xmr.practice.structure.tree;

/**
 * @author xmr
 * @date 2020/3/30 17:34
 * @description 二叉树接口
 */
public interface BinaryTree {
    boolean isEmpty(); // 判断二叉树是否为空树
    int size(); // 返回二叉树的结点数量
    int getHeight(); // 获取二叉树高度
    Node findKey(Object value); // 查找指定结点
    void preOrderTraverse(); // 前序遍历(递归)
    void inOrderTraverse(); // 中序遍历(递归)
    void pastOrderTraverse(); // 后序遍历(递归)
    void inOrderByStack(); // 中序遍历(非递归)
    void preOrderByStack(); // 前序遍历(非递归)
    void postOrderByStack(); // 后序遍历(非递归)
    void levelOrderByStack(); // 按照层次遍历
}
