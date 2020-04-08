package pers.xmr.practice.structure.mooc;

/**
 * @author xmr
 * @date 2020/3/11 17:22
 * @description
 */
public class SecondClass {
    public static void main(String[] args) {
        chooseSort();
    }
    private static void chooseSort() {
        int [] array = {43,54,32,3,54,657,45,76589,98,4,342,3456};
        for (int i = 0; i < array.length; i++) {
            int small = array[i];
            int index = i;
            for (int j = i; j < array.length; j++){
                if (array[j] < small) {
                    small = array[j];
                    index = j;
                }
            }
            int temp = array[i];
            array[i] = small;
            array[index] = temp;
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
