package pers.xmr.practice.structure.queue;

import java.util.Arrays;

/**
 * @author xmr
 * @date 2020/4/13 19:27
 * @description 通过数组实现队列
 */
public class ArrayQueue implements Queue{
    private Object[] elementData; // 底层数据结构是数组
    private int size; // 队列长度

    public static void main(String[] args) {
        Queue queue = new ArrayQueue();
        queue.dequeue(); // 在队列为长度为0的时候,尝试出队
        queue.enqueue("3"); // 数据入队
        System.out.println(queue.getSize());
        queue.enqueue("4");
        queue.enqueue("5");
        for (int i = 0; i < 100; i ++) {
            queue.enqueue(i); // 数据入队,用于检测数组扩容机制是否正常
        }
        System.out.println(queue.dequeue());
        System.out.println(queue.getSize());
        System.out.println(queue.peek()); // 获取队列首端元素

    }
    public ArrayQueue() {
       this(10);
    }
    public ArrayQueue(int size) {
        elementData = new Object[size];
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
        if (size == elementData.length) {
            // 首先队列满时,应该对队列进行扩容
            elementData = Arrays.copyOf(elementData, elementData.length * 3 / 2);
        }
        elementData[size] = e;
        size++;
    }

    @Override
    public Object dequeue() {
        if (isEmpty()) {
            System.out.println("队列长度为0,无法出队! ");
            return null;
        }
        /*
            先进先出,将后面的元素向前移位,原首元素置为空值
         */
        Object first = elementData[0];
        Object temp = elementData[size - 1];
        for (int i = size - 1 ; i > 0; i --) {
            Object data = elementData[i - 1];
            elementData [i - 1] = temp;
            temp = data;
        }
        elementData[size - 1] = null;
        size --;
        return first;
    }

    @Override
    public Object peek() {
        return size > 0 ? elementData[0] : null;
    }
}
