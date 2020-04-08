package pers.xmr.practice.structure.linertable.list;

import java.util.LinkedList;

/**
 * @author xmr
 * @date 2020/03/26 22:36
 * @description 使用java语言实现单链表的基本功能
 */
public class SingleLinkedList implements List {
    private Node head = new Node(); // 头结点,不存储数据,为了编码方便,以方便对空链表和只有一个节点的链表进行处理
    private int size; // 单链表的节点个数

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        List list = new SingleLinkedList();
        list.add(0, "32");
        list.add(1, null);
        list.addBefore("64", "32");
        // list.remove(2);
        list.replace(1, "18");
        System.out.println(list.get(0));
        System.out.println(list.size());
        System.out.println(list.toString());
        System.out.println(list.indexOf(null));
    }
    @Override
    public int size() {
        return size;
    }

    @Override
    public Object get(int i) {
        if (i < 0 || i >= size) {
            throw new RuntimeException("指针越界! " + i);
        }
        Node p = head;
       for (int j = 0; j <= i; j++) {
           p = p.next;
       }
       return p.data;
    }

    @Override
    public boolean contains(Object e) {
        return indexOf(e) >= 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int indexOf(Object e) {
        Node p = head.next;
      for (int i = 0; i < size; i++) {
          if (e == null) {
              if (p.data == null) {
                  return i;
              }
          } else {
              if (e.equals(p.data)) {
                  return i;
              }
          }
          p = p.next;
      }
      return -1;
    }

    @Override
    public void add(int i, Object e) {
        if (i >  size) {
            throw new RuntimeException("指针越界! " + i);
        }
        // 找到前一个节点,从head节点开始
        Node p = head;
        for (int j = 0; j < i; j++) {
            p = p.next;
        }
        // 新创建一个节点
        Node newNode = new Node(e);
        newNode.data = e;
        newNode.next = p.next;
        // 指明新节点的直接后继节点
        // 指明新节点的直接前驱节点
        p.next = newNode;
        size ++;
    }

    @Override
    public void add(Object e) {
        this.add(size, e);
    }

    @Override
    public boolean addBefore(Object obj, Object e) {
       // 首先寻找到该元素,找不到就返回false
        int index = indexOf(e);
        if (index < 0) {
            return false;
        }
        // 找到该元素的前一个节点
        Node p = head;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        Node node = new Node(obj);
        // 修改e前一个节点的指针,使其指向obj
        node.data = obj;
        node.next = p.next;
        // 让obj的指针指向e的后继节点
        p.next = node;
        size++;
        return true;
    }

    @Override
    public boolean addAfter(Object obj, Object e) {
        // 首先寻找到该元素,找不到就返回false
        int index = indexOf(e);
        if (index < 0) {
            return false;
        }
        // 找到该元素的后一个节点
        Node p = head.next;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        Node node = new Node(obj);
        // 修改e前一个节点的指针,使其指向obj
        node.data = obj;
        node.next = p.next;
        // 让obj的指针指向e的后继节点
        p.next = node;
        size++;
        return true;
    }

    @Override
    public Object remove(int i) {
        if (i >= size || i < 0) {
            throw new RuntimeException("指针越界! " + i);
        }
        Node p = head;
        // 找到索引i的前一个元素
        for (int j = 0 ; j < i; j++) {
            p = p.next;
        }
        Node node = p.next; // 索引i所在位置的元素
        System.out.println(node.data);
        // 将前一个元素的指针指向 索引i的后一个元素
        p.next = p.next.next;
        System.out.println(node);
        size --;
        return node;
    }

    @Override
    public boolean remove(Object e) {
        int i = indexOf(e);
        if (i < 0 || i >= size) {
            return false;
        }
        remove(i);
        return true;
    }

    @Override
    public Object replace(int i, Object e) {
        if (i < 0 || i >= size) {
            throw new RuntimeException("指针越界! " + i);
        }
        Node p = head;
        for (int j = 0; j < i; j++) {
            p = p.next;
        }

        // 将前一个元素的指针指向node
        Node oldValue = p.next;
        p.next.data = e;
        return oldValue;
    }
    /*
        单链表 :
        数据, 指向后面节点的指针
     */

    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node p = head.next;
        for (int i = 0; i < size; i++) {
            if (i != size - 1) {
                sb.append(p.data).append(",");
            } else {
                sb.append(p.data);
            }
            p = p.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
