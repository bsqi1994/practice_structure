package pers.xmr.practice.structure.stackandqueue;

/**
 * @author xmr
 * @date 2020/3/30 20:05
 * @description
 */
public interface Queue<E> {
    // 返回队列的大小
    int getSize();
    // 队列是否为空
    boolean isEmpty();
    // 数据元素e入队
    void enqueue(Object e);
    // 数据元素出队
    E dequeue();
    // 取队首元素
    E peek();
}
