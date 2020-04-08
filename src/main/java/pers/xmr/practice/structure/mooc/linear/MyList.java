package pers.xmr.practice.structure.mooc.linear;

/**
 * @author xmr
 * @date 2020/3/13 15:22
 * @description 手写List集合
 */
public class MyList {
    int size = 0; // 集合大小
    MyList myList = null;
    public static void main(String[] args) {
        // 创建集合
        MyList myList = new MyList(); // 创建一个初始元素为0的集合
        MyList myList2 = new MyList(10); // 创建一个初始元素为10的集合
        myList.isEmpty(); // 判断集合是否非空,非空返回true,否则返回false
        myList2.isEmpty();
        // 返回某个元素的索引
        myList2.getIndex(2);
    }

    public boolean getIndex(int i) {
        for (int j = 0; j < myList.size; j++) {
        }
        return false;
    }

    MyList() {
        this.myList = new MyList();
    }

    MyList(int size) {
        this.size = size;
        this.myList = new MyList(size);
    }
    boolean isEmpty() {
        return this.size == 0;
    }
}
