package pers.xmr.practice.structure.linertable.list;

import java.util.Arrays;

/**
 * @author xmr
 * @date 2020/3/22 19:16
 * @description 顺序表
 * 底层采用
 */
public class ArrayList implements List {
    public static void main(String[] args) {
        List list = new ArrayList(12);
        list.add("3");
        list.add(4);
        list.add("4");
        list.add("7");
        list.add("8");
        list.addAfter("6", "3");
        list.remove("7");
        System.out.println("集合遍历: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        list.replace(4, 10);
        System.out.println("集合大小: " + list.size());
        System.out.println("集合是否为空: " + list.isEmpty());
        System.out.println("集合是否包含整数4: " + list.contains(4) );
        System.out.println("集合遍历: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }

        System.out.println();
        System.out.println(list.toString());

    }

    private Object[] elementData; //底层是一个数据,没有确定长度
    private int size; // 不是数组分配了几个空间,而是元素的个数

    /**
     * @param intialCapacity 执行数组的初始长度
     */
    public ArrayList(int intialCapacity) {
        // 给数组分配指定数量的空间
        elementData = new Object[intialCapacity];
        // 指定顺序表的元素个数,默认为0
        // size = 0;
    }

    public ArrayList() {
        // 没有指定长度,默认长度为10
        this(10);
        // 没有指定长度,长度为0
        elementData = new Object[]{10};
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object get(int i) {
        if (i < 0 || i >= size) {
            throw new RuntimeException("数组索引越界异常: " + i);
        }
        return elementData[i];
    }

    @Override
    public boolean contains(Object e) {
        for (Object element : elementData) {
            if (e == null) {
                if (e == element) {
                    return true;
                }
            } else {
                if (e.equals(element)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < size; i++) {
            if (e == null) {
                if (elementData[i] == null) {
                    return i;
                }
            } else {
                if (e.equals(elementData[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(elementData[i] + ",");
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public void add(int i, Object e) {
        if (size == elementData.length) {
//            // 新创建一个新的数组,长度是旧数组的2倍
//            Object [] newArr = new Object[elementData.length * 2];
//            // 将旧数组的数据拷贝到新数组
//            for (int i = 0; i < size; i++) {
//                newArr[i] = elementData[i];
//            }
//            // 让elementData执向新数组
//            elementData = newArr;
            elementData = Arrays.copyOf(elementData, elementData.length * 2);
        }
        // 添加元素到最后
        elementData[size] = e;
        // 元素个数+1
        size++;

        // 后移i后面元素,从最后一个元素开始
        for (int j = size; j > i; j--) {
            elementData[j] = elementData[j - 1];
        }
        // 给数组的第i个位置赋值
        elementData[i] = e;
    }

    @Override
    public void add(Object e) {
        // 扩容策略(数组满了,需要进行扩容 )
        if (size == elementData.length) {
//            // 新创建一个新的数组,长度是旧数组的2倍
//            Object [] newArr = new Object[elementData.length * 2];
//            // 将旧数组的数据拷贝到新数组
//            for (int i = 0; i < size; i++) {
//                newArr[i] = elementData[i];
//            }
//            // 让elementData执向新数组
//            elementData = newArr;
            elementData = Arrays.copyOf(elementData, elementData.length * 2);
        }
        // 添加元素到最后
        elementData[size] = e;
        // 元素个数+1
        size++;

    }

    @Override
    public boolean addBefore(Object obj, Object e) {
        // 把obj添加到元素e的前面
        // 首先,数组满了要对数组进行扩容
        if (size == elementData.length) {
            elementData = Arrays.copyOf(elementData, elementData.length * 2);
        }
        // 获取元素e的索引
        int index = indexOf(e);
        if (index == -1) {
            elementData[size] = obj;
            size++;
            return true;
        } else {
            // 从最后一个数开始向前赋值
            for (int i = size - 1; i >= index + 1; i--) {
                elementData[i + 1] = elementData[i];
            }
            elementData[index] = obj;
            elementData[index + 1] = e;
            size++;
            return true;
        }
    }

    @Override
    public boolean addAfter(Object obj, Object e) {
        if (size == elementData.length) {
            Arrays.copyOf(elementData, size * 2);
        }
        int index = indexOf(e);
        if (index == -1) {
            elementData[size] = obj;
            size++;
            return true;
        } else {
            for (int i = size - 1; i > index + 1; i--) {
                elementData[i + 1] = elementData[i];
            }
            elementData[index + 1] = obj;
            size++;
            return true;
        }
    }

    @Override
    public Object remove(int i) {
        // 索引取值应该合理,否则会引起数组越界
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException("指定的索引越界，集合大小为:" + size + ",您指定的索引大小为:" + i);
        }
        Object oldValue = elementData[i];

        int numMoved = size - i - 1;
        if (numMoved > 0)
            System.arraycopy(elementData, i + 1, elementData, i,
                    numMoved);
        elementData[--size] = null; // clear to let GC do its work

        return oldValue;
    }

    /*
        删除集合里指定的元素
     */
    @Override
    public boolean remove(Object e) {
        // 遍历集合
        for (int i = 0; i < size; i++) {
            if (e == null) {
                if (elementData[i] == null) {
                    remove(i);
                    return true;
                }
            } else {
                if (e.equals(elementData[i])) {
                    remove(i);
                    return true;
                }
            }
        }
        return false;
    }

    /*
        将集合指定索引的元素替换为特定的值
     */
    @Override
    public Object replace(int i, Object e) {
        if (i < 0 || i >= size) {
            throw new ArrayIndexOutOfBoundsException("索引越界!");
        }
        elementData[i] = e;
        return elementData;
    }
}
