package pers.xmr.practice.structure.queue;

/**
 * @author xmr
 * @date 2020/4/13 19:39
 * @description 使用循环单链表实现队列
 */
public class LinkedQueue implements Queue {
    Node head;
    Node tail;
    int size;
    public static void main(String[] args) {
        Queue queue = new ArrayQueue();
        queue.dequeue(); // 在队列为长度为0的时候,尝试出队
        queue.enqueue("3"); // 数据入队
        System.out.println(queue.getSize());
        queue.enqueue("4");
        queue.enqueue("5");
        for (int i = 0; i < 100; i ++) {
            queue.enqueue(i); // 数据入队
            queue.dequeue(); // 后面的数据入队,前面的数据出队
        }

        System.out.println(queue.dequeue());
        System.out.println(queue.getSize());
        System.out.println(queue.peek()); // 获取队列首端元素

    }
    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(Object e) {
        Node t = tail;
        Node node = new Node(e, head);
        if (t == null) {
            head = node;
        } else {
            t.next = node;
            tail = node;
        }
        size++;
    }

    @Override
    public Object dequeue() {
        if (isEmpty()) {
            System.out.println("队列长度为0,无法出队! ");
            return null;
        }
        // 队列长度为1也属于特殊场景,需要单独处理
        if (size == 1) {
            Object data = head.data;
            head = null;
            size --;
            return data;
        }
        Node h = head;
        head = null;
        size --;
        head = h.next;
        tail.next = h.next;
        return h;
    }

    @Override
    public Object peek() {
        return head == null ? null : head.data;
    }
}
