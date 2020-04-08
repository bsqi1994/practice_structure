package pers.xmr.practice.structure.linertable.array;

/**
 * @author xmr
 * @date 2019/11/23 18:40
 * @description
 */
public class Array {
    int [] scoreArray = {56,42,78,100,34,100,32,67,98,96};
    public static void main(String[] args) {
        Array array = new Array();
       //  System.out.println(    array.sequenceSearch(86));
        System.out.println( array.binarySearch(78));
    }
    /*
        数组顺序查找, 查找分数是100的第一个分数
     */
    public int sequenceSearch(int x) {
        for (int i = 0; i < scoreArray.length; i ++) {
            if (scoreArray[i] == x) {
                return i;
            }
        }
        return -1;
    }
    /*
        数组二分查找
     */
    public int binarySearch(int x) {
        java.util.Arrays.sort(scoreArray);
        for (int i = 0; i < scoreArray.length; i ++) {
            System.out.print(scoreArray[i] + " ");
        }
        System.out.println();
        /*
            二分查找
         */
        int beginIndex = 0;
        int endIndex = scoreArray.length - 1;
        int binaryIndex = (beginIndex + endIndex) / 2;
        while (endIndex > beginIndex) {
            if (scoreArray[binaryIndex] == x) {
                return binaryIndex;
            } else if (scoreArray[binaryIndex] > x) {
                endIndex = binaryIndex;
                binaryIndex = (endIndex + beginIndex) / 2 ;
                System.out.println("endIndex: " + endIndex);
            } else {
                beginIndex = binaryIndex;
                binaryIndex = (endIndex + beginIndex) % 2 == 0 ? (endIndex + beginIndex) / 2 : ((endIndex + beginIndex) / 2 +1) ;
                System.out.println("beginIndex: " + beginIndex);
            }
        }
        return -1;
    }
}
