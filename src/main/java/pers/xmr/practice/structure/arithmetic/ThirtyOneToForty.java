package pers.xmr.practice.structure.arithmetic;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * @author xmr
 * @date 2020/4/8 22:49
 * @description
 */
public class ThirtyOneToForty {
    public static void main(String[] args) {
         thirtyOne("你是我的眼带我阅读浩瀚的书海");
         thirtyTwo(432544553);
         thirtyThree(100);
         thirtyFour();
         thirtyFive(new int [] {6,2,76,43,54,34,5,8,14,15,16});
         thirtySix(20,4);
         thirtySeven(100);
         thirtyEight("多么无聊的一道题");
         thirtyNine(1000000000);
         forty(new String [] {"sdf","sas","sfds","23r","dsffg"});
    }

    /**
     * 题目：将一个数组逆序输出。 倒序遍历即可,为了方便起见，参数输入一个String， 在程序里将其转换为数组，对该数组进行逆序输出
     */
    protected static void thirtyOne(String args) {
        char[] argsCharArray = args.toCharArray();
        for (int i = argsCharArray.length - 1; i >= 0; i--) {
            System.out.print(argsCharArray[i] + " ");

        }
    }

    /**
     * 题目：取一个整数a从右端开始的4～7位。
     */
    protected static void thirtyTwo(int number) {
        if (number < 1000000) {
            System.out.println("输入的数字不符合要求");
            return;
        }
        char[] numberCharArray = new Integer(number).toString().toCharArray();
        System.out.println("整数" + number + "从右端开始的4—7位分别是：");
        for (int i = numberCharArray.length - 1 - 3; i >= numberCharArray.length - 7; i--) {
            System.out.print(numberCharArray[i] + "  ");
        }
    }

    /**
     * 题目：打印出杨辉三角形 1 1 1 1 2 1 1 3 3 1 1 4 4 6 1
     * 分析：两边的数字都为1，中间的数字等于上一行相对应位置和前一个数之和
     */
    protected static void thirtyThree(int rows) {
        int[][] yangHui = new int[rows][rows];
        // -----------对杨辉三角形赋值------------------
        for (int i = 0; i < rows; i++) {
            yangHui[i][0] = yangHui[i][i] = 1;
        }
        for (int i = 2; i < rows; i++) {
            for (int j = 1; j < i; j++) {
                yangHui[i][j] = yangHui[i - 1][j - 1] + yangHui[i - 1][j];
            }
        }
        // -----------输出杨辉三角形-------------------
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(yangHui[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * 题目：输入3个数a,b,c，按大小顺序输出。 题目同第15题,直接调用15题的方法即可
     */
    protected static void thirtyFour() {
        ElevenToTwenty.fifteen(34, 3, 2);
    }

    /**
     * 题目：输入数组，最大的与第一个元素交换，最小的与最后一个元素交换，输出数组。
     */
    protected static void thirtyFive(int[] array) {
        int[] arrayCopy = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            arrayCopy[i] = array[i];
        }
        Arrays.sort(array);
        // ---------最大的与第一个元素交换,最小的与最后一个元素交换----------
        int temp = 0;
        for (int i = 0; i < arrayCopy.length; i++) {
            if (arrayCopy[i] == array[array.length - 1]) {
                temp = arrayCopy[0];
                arrayCopy[0] = arrayCopy[i];
                arrayCopy[i] = temp;
            }
            if (arrayCopy[i] == array[0]) {
                temp = arrayCopy[arrayCopy.length - 1];
                arrayCopy[arrayCopy.length - 1] = arrayCopy[i];
                arrayCopy[i] = temp;
            }
        }

        // -----------------输出数组----------------------
        for (int i = 0; i < arrayCopy.length; i++) {
            System.out.print(arrayCopy[i] + " ");
            if ((i + 1) % 5 == 0) {
                System.out.println();
            }
        }
    }

    /**
     * 题目：有n个整数，使其前面各数顺序向后移m个位置，最后m个数变成最前面的m个数
     */
    protected static void thirtySix(int n, int m) {
        if (n < 2 * m) {
            System.out.println("输入参数有误!!!");
            return;
        }

        // --------------定义数组并赋值--------------
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = new Random().nextInt(500);
        }
        int[] arrayTailM = new int[m];
        for (int i = n - 1; i > n - 1 - m; i--) {
            arrayTailM[n - 1 - i] = array[i];
        }
        // ----------前面的向后移,后面的向前面补位--------
        for (int i = 0; i < n - m; i++) {
            array[i + m] = array[i];
        }
        for (int i = n - 1; i > n - 1 - m; i--) {
            array[i] = arrayTailM[n - i - 1];
        }
        // --------输出最终的数组-------------
        for (int i = 1; i <= array.length; i++) {
            System.out.print(array[i - 1] + "  ");
            if (i % 5 == 0) {
                System.out.println();
            }
        }
    }

    /**
     * 题目：有n个人围成一圈，顺序排号。从第一个人开始报数（从1到3报数）， 凡报到3的人退出圈子，问最后留下的是原来第几号的那位。
     */
    protected static void thirtySeven(int n) {
        // ---------定义数组变量标识某人是否还在圈内------------
        boolean[] isIn = new boolean[n];
        for (int i = 0; i < isIn.length; i++)
            isIn[i] = true;
        int inCount = n;
        int countNum = 0;
        int index = 0;
        while (inCount > 1) {
            if (isIn[index]) {
                countNum++;
                if (countNum == 3) {
                    countNum = 0;
                    isIn[index] = false;
                    inCount--;
                }
            }
            index++;
            if (index == n)
                index = 0;
        }
        for (int i = 0; i < n; i++)
            if (isIn[i])
                System.out.println("留下的是：" + (i + 1));
    }


    /**
     * 题目：写一个函数，求一个字符串的长度，在main函数中输入字符串，并输出其长度。 极其愚蠢的一个题....
     */
    protected static void thirtyEight(String str) {
        // System.out.println("输入的字符串的 长度为:" + str.length());
        System.out.println("输入的字符串的长度为:" + str.toCharArray().length);
    }

    /**
     * 编写一个函数，输入n为偶数时，调用函数求1/2+1/4+...+1/n, 当输入n为奇数时，调用函数1/1+1/3+...+1/n
     */
    protected static void thirtyNine(int n) {
        double sum = 0D;
        if (n % 2 == 0) {
            for (int i = 2; i <= n; i += 2) {
                sum = sum + ((double) 1 / (double) i);
            }
            System.out.println(n + "是一个偶数,和为" + sum);
            return;
        }
        if (n % 2 != 0) {
            for (int i = 1; i <= n; i += 2) {
                sum = sum + ((double) 1 / (double) i);
            }
            System.out.println(n + "是一个奇数,和为" + sum);
        }
    }

    /**
     * 题目：字符串排序。
     */
    protected static void forty(String[] args) {
        Set<String> set = new HashSet<String>();
        for (int i = 0; i < args.length; i++) {
            set.add(args[i]);
        }
        System.out.println("字符串数组排序过后的顺序是:");
        for (String str : set) {
            System.out.print(str + "  ");
        }
    }
}

