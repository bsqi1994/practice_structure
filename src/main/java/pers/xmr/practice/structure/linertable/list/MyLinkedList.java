package pers.xmr.practice.structure.linertable.list;


/**
 * @author xmr
 * @date 2020/3/25 18:16
 * @description
 */
public class MyLinkedList<E> implements MyList<E> {
    public static void main(String[] args) {
        MyList<String> myList = new MyLinkedList<>();
        myList.add("12");
        myList.add("23");
        myList.add("34");
    }
    Node<E> first; // 集合的首节点
    Node<E> last; // 集合的尾结点
    int size; // 集合大小
    private  static class Node<E> {
        Node<E> prev; // 指向前一个节点的指针
        Node<E> next; // 指向后一个节点的指针
        E data; // 数据域
        Node(Node<E> prev, E element, Node<E> next) {
            this.data = element;
            this.prev = prev;
            this.next = next;

        }

    }
    @Override
    public int size() {
        return size;
    }

    @Override
    public  E get(int i) {
        checkIndex(i);
        // 按照惯性,我们会想到从头开始遍历链表,但对于双向循环链表来说? 这种方式真的合适?
        // 我们判断索引离首节点近还是离尾结点近,离哪个节点近就从哪个节点开始遍历

        if (i < (size >> 1)) {
            // 证明离首结点更近,从首节点开始向后遍历
            Node<E> p = first;
            for (int j = 0; j < i; j++) {
                p = p.next;
            }
            return p.data;
        } else {
            // 证明离尾结点更近,从尾结点开始向前遍历
            Node<E> p = last;
            for (int j = size - 1; j > i; j--) {
                p = p.prev;
            }
            return p.data;
        }
    }

    private void checkIndex(int i) {
        if (i < 0 || i >= size) {
            throw new RuntimeException("指针越界! " + i);
        }
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
        Node<E> p = first;
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
    public boolean add(E e) {

        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
        return true;
    }


    @Override
    public E remove(int i) {
     return null;
    }
    E unlink(Node<E> x) {
        // assert x != null;
        final E element = x.data;
        final Node<E> next = x.next;
        final Node<E> prev = x.prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.data = null;
        size--;
        return element;
    }
    @Override
    public boolean remove(Object e) {
        if (e == null) {
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.data == null) {
                    unlink(x);
                    return true;
                }
            }
        } else {
            for (Node<E> x = first; x != null; x = x.next) {
                if (e.equals(x.data)) {
                    unlink(x);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public E replace(int index, E e) {
        Node<E> p = first;
        for (int i = 0; i < index; i++) {
            p = p.next;
            }
        E oldValue = p.data;
        p.data = e;
        return oldValue;
    }

}
