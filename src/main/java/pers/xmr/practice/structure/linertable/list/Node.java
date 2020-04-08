package pers.xmr.practice.structure.linertable.list;

/**
 * @author xmr
 * @date 2019/03/23 22:38
 * @description 单链表 只能通过前驱节点找到后继节点,不能通过后继节点找到前驱节点
 */
public class Node {
    Object data; // 要存储的数据
    Node next; // 指向下一个节点的指针

    public Node(Object data) {
        super();
        this.data = data;
    }

    public Node(Object data, Node next) {
        super();
        this.data = data;
        this.next = next;
    }

    public Node() {

    }


    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
