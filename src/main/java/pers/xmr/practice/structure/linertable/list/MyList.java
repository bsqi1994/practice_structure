package pers.xmr.practice.structure.linertable.list;

/**
 * @author xmr
 * @date 2020/3/25 21:46
 * @description
 */


public interface MyList<E> {
    // 返回线性表的大小,即数据元素的个数
    int size();
    // 返回线性表序号为i的数据元素
    E get(int i);
    // 判断线性表是否包含数据元素e
    boolean contains(Object e);
    // 线性表为空返回true,否则返回false
    boolean isEmpty();
    // 返回数据元素e在线性表中的序号
    int indexOf(Object e);

    // 将元素e插入到线性表末尾
    boolean add(E e);


    // 删除线性表中序号为i的元素,并返回
    E remove(int i);
    // 删除线性表中第一个与a相同的元素
    boolean remove(Object e);
    // 替换线性表中序号为i的数据元素为e,返回原数据元素
    E replace(int i, E e);
}
