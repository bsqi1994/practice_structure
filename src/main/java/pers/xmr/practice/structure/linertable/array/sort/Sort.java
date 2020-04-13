package pers.xmr.practice.structure.linertable.array.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xmr
 * @date 2020/1/9 20:03
 * @description
 */
public class Sort {

    public static void main(String[] args) {
        int [] array = {16,43,265,76,354,3,2,67,3456,45,23234,32,23};
        int [] sortedArray = {2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        int [] binaryArray = {2,3,4,5,6,7,8,9,10,10,10,10,11,12,13,14,15,16,17,18,19,20};
        Sort sort = new Sort();
//        sort.bubbleSort(array);
//        System.out.println( sort.binarySearch(sortedArray, 2));
        // sort.binarySearchList(binaryArray, 20);
        // int [] fastSortArray = sort.fastSort(array,0, array.length - 1);
        // Sort.arrayPrint(fastSortArray);
        int [] mergeArray = sort.mergeSort(array, 0 , array.length - 1);
        Sort.arrayPrint(mergeArray);
    }

    /**
     * 冒泡排序法
     * @param array 需要排序的数组
     *  思路 : 需要进行 i - 1次比较 , 每次需要比较 i - 1 - j次
     */
    private void bubbleSort(int [] array) {
        int temp = 0;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i; j < array.length - 1; j++) {
                if (array[i] > array [j + 1]) {
                    temp = array[j + 1];
                    array [j + 1] = array[i];
                    array[i] = temp;
                }
            }
        }
        Sort.arrayPrint(array);
    }

    /**
     * 二分查找法
     * @param array 需要查找的有序数组
     * @param i 查找的数
     */
    private int binarySearch(int [] array, int i) {
        if (i < array[0] || i > array[array.length - 1]) {
            return -1;
        }
        int small = 0;
        int large = array.length - 1;
        int middle = (small + large) / 2;
        while (large > small) {
            if (i == array[middle]) {
                return middle;
            } else if (i < array[middle]) {
                large = middle ;
                middle = (small + large) / 2;
            } else {
                small = middle + 1;
                middle = (small + large) / 2;
            }
        }
      return middle;
    }

    /**
     * 二分查找法扩展: 找到一个有序数组里面所有等于指定值的索引
     * @param array 有序数组
     * @param i 指定值
     * @return List<Integer>
     */
    private void binarySearchList(int [] array, int i) {
        List<Integer> list = new ArrayList<>();
        Sort sort = new Sort();
        int index = sort.binarySearch(array, i);
        if (index == -1) {
            System.out.println("找不到与输入值相同的索引!");
            return ;
        }
        list.add(index);
        for (int j = index + 1; j <array.length; j++) {
            if (array[j] == i) {
                list.add(j);
            } else {
                break;
            }
        }
        for (int k = index - 1; k > 0; k--) {
            if (array[k] == i) {
                list.add(k);
            }else {
                break;
            }
        }

        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
        System.out.println();
    }


    /**
     * 数组打印
     * @param array 需要打印的数组
     */
    private static void arrayPrint(int [] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "  ");
        }
        System.out.println();
    }

    /**
     * 快速排序
     * 思路 : 对于要排序的数组,选择一个基准值,将数组分成左右两边,保证基准值左边的值全部小于右边的值
     * 对于左右两边的数组继续按照上述方法排序,直到数组完全有序为止
     * @param array 需要排序的数组
     */
    private int []  fastSort(int [] array,int start, int end) {
        // 首先确定一个基准值
        int benchMark = array[start];
        // 确定起始点
        int i = start;
        // 确定结束点
        int j = end;
        // 开始进行快排第一轮排序,目的:将数组的数分成两部分,小于基准数的在左边,大于基准数的在右边
        while(i < j) { // 当i = j的时候,左右两侧相遇,证明第一轮排序完成
            while (i < j && (array[j] > benchMark)) { // 此种情况下无需交换位置,继续向下遍历即可
                j--;
            }
            while (i < j &&(array[i] < benchMark)) { // 此种情况下无需交换位置,继续向上遍历
                i ++;
            }
            if (array[i] == array[j] && (i < j)) { // 对于相等的场景也无需交换位置,继续向前遍历即可
                i++;
            } else { // 其它场景下,我们需要交换两个数的位置,以保证大的数在右侧,小的数在左侧
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        // 对分出来的两个数组采用分而治之的思路,对于每一组,使用递归的方式完成排序
        if (i - 1 > start) { // 将i - 1 的索引值作为左侧数组排序的结束点
            array = fastSort(array, start, i - 1);
        }
        if (j + 1 < end) { // 将j + 1的索引值作为右侧数组排序的起始点
            array = fastSort(array, j + 1, end);
        }
        return array;
    }

    /**
     * 对传入的数组进行归并排序
     * @param array 需要排序的数组
     * @param begin 起始
     * @param end 结束
     * @return 排好序的数组
     */
    public int [] mergeSort(int [] array, int begin, int end) {
        // 首先,如果数组的元素只有一个,那么一定是有序的,直接返回该元素即可
        if(begin == end) {
            return new int [] {array[begin]};
        }
        // 如果数组的元素超过一个,就要采取分而治之的思想
        int middle = (begin + end - 1) / 2; // 通过确定中间值的方式将数组拆封成两个
        // 继续拆分,直到最终数组只包含一个元素为止
        int [] leftArray = mergeSort(array, begin, middle); // 对左边的数组进行分治
        int [] rightArray = mergeSort(array, middle + 1, end); // 对右边的数组进行分治
        int [] newArray = new int [leftArray.length + rightArray.length]; // 对得到的两个数组进行归并操作
        // 开始对新数组的元素进行赋值
        int i = 0; // 用于给数组进行赋值
        int j = 0; // 用于左边数组的元素自增
        int k = 0; // 用于右边数组的元素自增
        while (j < leftArray.length && k < rightArray.length) {
            newArray[i++] = leftArray[j] < rightArray[k] ? leftArray[j++] : rightArray[k++];
        }
        // 对左边的数组进行赋值处理
        while (j < leftArray.length) {
            newArray[i++] = leftArray[j++];
        }
        while (k < rightArray.length) {
            newArray[i++] = rightArray[k++];
        }
        Sort.arrayPrint(newArray);
        return newArray;
    }

}
