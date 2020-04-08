package pers.xmr.practice.structure.tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author xmr
 * @date 2020/3/30 17:43
 * @description 使用链表实现二叉树
 */
public class LinkedBinaryTree implements BinaryTree {
    Node root; // 根节点

    LinkedBinaryTree(Node root) {
        this.root = root;
    }

    LinkedBinaryTree() {

    }

    public static void main(String[] args) {

        Node nodeD = new Node("D", null, null);
        Node nodeB = new Node("B", nodeD, null);
        Node nodeE = new Node("E", null, null);
        Node nodeF = new Node("F", null, null);
        Node noedC = new Node("C", nodeE, nodeF);
        Node nodeA = new Node("A", nodeB, noedC);
        LinkedBinaryTree linkedBinaryTree = new LinkedBinaryTree(nodeA);

        System.out.println("树是否是空树: " + linkedBinaryTree.isEmpty()); // 树是否为空
        linkedBinaryTree.preOrderTraverse(); // 前序遍历(递归)
        linkedBinaryTree.inOrderTraverse(); // 中序遍历(递归)
        linkedBinaryTree.inOrderByStack(); // 中序遍历(非递归)
        linkedBinaryTree.pastOrderTraverse(); // 后续遍历(递归)
       System.out .println(linkedBinaryTree.findKey("F")); // 查找值"F"对应的节点
        linkedBinaryTree.size(); // 二叉树节点个数
        linkedBinaryTree.getHeight(); // 二叉树高度
        linkedBinaryTree.levelOrderByStack(); // 层次遍历

    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public int size() {
        System.out.println("二叉树结点个数: ");
        int size = this.size(root);
        System.out.println(size);
        System.out.println();
        return size;
    }

    private int size(Node root) {
        if (root == null) {
            return 0;
        }
        int leftSize = size(root.leftChild);
        int rightSize = size(root.rightChild);
        return leftSize + rightSize + 1;

    }

    @Override
    public int getHeight() {
        System.out.println("二叉树的高度为: ");
        int high = this.getHeight(root);
        System.out.println(high);
        return high;
    }

    private int getHeight(Node node) {
        if (node == null) {
            return 0;
        }
        // 获取左子树的高度
        int leftHigh = this.getHeight(node.leftChild);
        // 获取右子树的高度
        int rightHigh = this.getHeight(node.rightChild);
        // 返回左子树,右子树较大高度并加1

        return leftHigh > rightHigh ? (leftHigh + 1) : (rightHigh + 1);
    }

    private Node findKey(Object value, Node node) {
        if (value == null) {
            if (node == null || node.value == null) {
                return node;
            } else {
                Node leftChild = this.findKey(value, node.leftChild);
                Node rightChild = this.findKey(value, root.rightChild);
                if (leftChild == null || leftChild.value == null) {
                    return leftChild;
                } else if (rightChild == null || rightChild.value == null) {
                    return rightChild;
                } else {

                    return null;
                }
            }
        }
        if (node == null) {
            return null;

        } else if ( value.equals(node.value)) {
            return node;
        } else {
            Node leftChild = this.findKey(value, node.leftChild);
            Node rightChild = this.findKey(value, node.rightChild);
            if (leftChild != null && value.equals(leftChild.value)) {
                return leftChild;
            } else if (rightChild != null && value.equals(rightChild.value)) {
                return rightChild;
            } else {
                return null;
            }
        }
    }

    @Override
    public Node findKey(Object value) {
        // 对树进行遍历
        return findKey(value, root);

    }

    private void preOrderTraverse(Node node) {
        if (node != null) {
            // 根
            System.out.print(node.value + " ");
            // 对左子树进行先序遍历
            preOrderTraverse(node.leftChild);
            // 对右子树进行先序遍历
            preOrderTraverse(node.rightChild);
        }
    }

    @Override
    public void preOrderTraverse() {
        System.out.println("先序遍历(递归): ");
        preOrderTraverse(root);
        System.out.println();


    }

    @Override
    public void inOrderTraverse() {
        System.out.println("中序遍历(递归): ");
        inOrderTraverse(root);
        System.out.println();
    }

    private void inOrderTraverse(Node node) {
        if (node != null) {
            // 遍历左子树
            this.inOrderTraverse(node.leftChild);
            // 输出根的值
            System.out.print(node.value + " ");
            // 遍历右子树
            this.inOrderTraverse(node.rightChild);
        }
    }

    @Override
    public void pastOrderTraverse() {
        System.out.println("后续遍历(递归): ");
        pastOrderTraverse(root);
        System.out.println();
    }

    private void pastOrderTraverse(Node node) {
        if (node != null) {
            // 遍历左子树
            pastOrderTraverse(node.leftChild);
            // 遍历右子树
            pastOrderTraverse(node.rightChild);
            // 输出根节点
            System.out.print(node.value + " ");
        }

    }

    @Override
    public void inOrderByStack() {
        System.out.println("中序遍历(非递归): ");
        Deque<Node> stack = new LinkedList<>(); // 创建栈
        Node current = root;
        while (current != null|| !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.leftChild;
            }
            if (!stack.isEmpty()) {
                current = stack.pop();
                System.out.print(current.value + " ");
                current = current.rightChild;
            }
        }
        System.out.println();

    }

    @Override
    public void preOrderByStack() {

    }

    @Override
    public void postOrderByStack() {

    }

    @Override
    public void levelOrderByStack() {
        System.out.println("按照层次遍历二叉树: ");
        if (root == null) { // 空树直接返回
            return;
        }
        Queue<Node> queue = new LinkedList<>(); // 创建队列
        queue.add(root); // 把根节点添加进队列
        while (queue.size() != 0) {
            int length = queue.size();
            for (int i= 0; i < length; i++) { // 将一层的值全部添加进来
                Node temp = queue.poll(); // 出队
                System.out.print(temp.value + " "); // 输出出队元素的值
                if (temp.leftChild != null) {
                    queue.add(temp.leftChild);
                }
                if (temp.rightChild != null) {
                    queue.add(temp.rightChild);
                }
            }
        }
        System.out.println();
    }


}
