package pers.xmr.practice.structure.linertable.array;

/**
 * @author xmr
 * @date 2020/3/31 19:36
 * @description
 */
public class BinarySearch {


    public static void main(String[] args) {
        int [] array = {1,2,3,4,5,6,7,8,9,10};
        BinarySearch binarySearch = new BinarySearch();
        System.out.println(binarySearch.binarySearch(array, 6));
    }
    public int binarySearch(int [] array, int data) {
        int min = 0;
        int max = array.length - 1;
        int middle = (min + max) / 2;
        do {
            if (array[middle] > data) {
                max = middle;
            } else if (array[middle] < data) {
                min = middle;
            } else {
                return middle;
            }
            middle = (min + max) / 2;
        } while (min >= max);
        return -1;
    }
}
