package pers.xmr.practice.structure.stack;

/**
 * @author xmr
 * @date 2020/3/30 19:56
 * @description
 */
public interface Stack<E> {
    // 返回堆栈的大小
   int getSize();
   // 判断堆栈是否为空
   boolean isEmpty();
   // 数据元素e入栈
    void push(Object e);
    // 栈顶元素出栈
    E pop();

    // 取出栈顶元素
    E peek();
}
