package pers.xmr.practice.structure.arithmetic;

import java.util.Arrays;
import java.util.Random;

/**
 * @author xmr
 * @date 2020/4/8 22:46
 * @description
 */
public class TwentyOneToThirty {
    public static void main(String[] args) {
         twentyOne(20);
         twentyTwo(5);
         twentyThree(10,5);
         twentyFour(1234);
         twentyFive(12321);
         twentySix("sunday");
         twentySeven();
         twentyEight(39);
         twentyNine(1);
         thrity(30,5);
    }

    /**
     * 题目：求1+2!+3!+...+20!的和
     */
    protected static void twentyOne(int n) {
        int sum = 0;
        int factorial = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                factorial = factorial * j;
            }
            sum += factorial;
            factorial = 1;
        }
        System.out.println("1+2!+..." + n + "!" + "的和为" + sum);
    }

    /**
     * 题目：利用递归方法求5!
     */
    protected static void twentyTwo(int n) {
        int factorial = 1;
        for (int i = 1; i <= 5; i++) {
            factorial = factorial * i;
        }
        System.out.println(n + "的阶乘是:" + factorial);
    }

    /**
     * 题目：有5个人坐在一起，问第五个人多少岁？他说比第4个人大2岁。 问第4个人岁数，他说比第3个人大2岁。 问第三个人，又说比第2人大两岁。
     * 问第2个人，说比第一个人大两岁。 最后问第一个人，他说是10岁。请问第五个人多大？
     */
    protected static void twentyThree(int firstAge, int numbersOfPeople) {
        int lastAge = firstAge;
        for (int i = 1; i < numbersOfPeople; i++) {
            lastAge += 2;
        }
        System.out.println("最后一个人的年纪是:" + lastAge);
    }

    /**
     * 题目：给一个不多于5位的正整数， 要求：一、求它是几位数，二、逆序打印出各位数字。
     */
    protected static void twentyFour(Integer positiveInteger) {
        char[] integerCharArray = positiveInteger.toString().toCharArray();
        System.out.println("正整数" + positiveInteger + "的位数是:" + integerCharArray.length);
        for (int i = integerCharArray.length - 1; i >= 0; i--) {
            System.out.print(integerCharArray[i] + " ");
        }
    }

    /**
     * 题目：一个5位数，判断它是不是回文数。 即12321是回文数，个位与万位相同，十位与千位相同。
     */
    protected static void twentyFive(int numbers) {
        boolean flag = false;
        if ((numbers / 10000 == numbers % 10) && (numbers % 10000 / 1000 == numbers % 100 / 10)) {
            System.out.println(numbers + "是一个回文数");
            return;
        }
        System.out.println(numbers + "不是一个回文数");
    }

    /**
     * 题目：请输入星期几的第一个字母来判断一下是星期几， 如果第一个字母一样，则继续 判断第二个字母。 星期一:monday 星期二:tuesday
     * 星期三:wednesday 星期四:thursday 星期五:firday 星期六:saturday 星期日:sunday
     * 我觉得按照题目给定的方式并不能判断出是星期几...除非输入的参数是正确的.不过不管它,就这么算好了
     */
    protected static void twentySix(String week) {
        char[] weekCharArray = week.toCharArray();
        if (weekCharArray.length < 6) {
            System.out.println("输入的参数有误!");
            return;
        }
        if (weekCharArray[0] == 'm') {
            System.out.println(week + "是星期一");
            return;
        }
        if (weekCharArray[0] == 'w') {
            System.out.println(week + "是星期三");
            return;
        }
        if (weekCharArray[0] == 'f') {
            System.out.println(week + "是星期五");
            return;
        }
        if (weekCharArray[0] == 't') {
            if (weekCharArray[1] == 'u') {
                System.out.println(week + "是星期二");
                return;
            }
            System.out.println(week + "是星期五");
            return;
        }
        if (weekCharArray[0] == 's') {
            if (weekCharArray[1] == 'u') {
                System.out.println(week + "是星期日");
                return;
            }
            System.out.println(week + "是星期六");
        }

    }

    /**
     * 题目：求100之内的素数
     * 直接调用之前写的方法就好了(第二题的方法)
     */
    protected static void twentySeven() {
        OneToTen.second(0, 100);
    }

    /**
     * 题目：对10个数进行排序
     * 为了增加程序可扩展性,我实现的功能是对输入参数个随机数进行排序
     */
    protected static void twentyEight(int number) {
        int[] array = new int[number];
        for (int i = 0; i < array.length; i++) {
            array[i] = new Random().nextInt(500);
        }
        Arrays.sort(array);
        System.out.println("排序之后的结果为:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
            if ((i + 1) % 5 == 0) {
                System.out.println();
            }
        }

    }

    /**
     * 题目：求一个3*3矩阵对角线元素之和
     * 我写的程序是求n*n阶矩阵对角线元素之和
     */
    protected static void twentyNine(int number) {
        int[][] array = new int[number][number];

        //---------------对矩阵里的元素赋值----------------
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = new Random().nextInt(500);
            }
        }

        //---------遍历矩阵元素,求对角线元素之和-------------
        int sum = 0;
        for (int i = 0; i < number; i++) {
            for (int j = 0; j < number; j++) {
                if (i == j) {
                    sum += array[i][j];
                }
            }
        }
        System.out.println(number + "*" + number + "阶矩阵的对角线元素之和为" + sum);
    }

    /**
     * 题目：有一个已经排好序的数组。现输入一个数，要求按原来的规律将它插入数组中。
     */
    protected static void thrity(int number, int insertNumber) {
        int[] array = new int[number];
        //---------首先对长度为number的数组赋值并排序---------------
        for (int i = 0; i < array.length; i++) {
            array[i] = new Random().nextInt(500);
        }
        Arrays.sort(array);

        //---------重新定义一个数组,长度为当前数组加1,值为当前数组值,和新插入的值------------
        int[] newArray = new int[number + 1];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        newArray[newArray.length - 1] = insertNumber;
        Arrays.sort(newArray);

        //--------遍历排序好的数组,检验结果是否正确---------------
        for (int i = 0; i < newArray.length; i++) {
            System.out.print(newArray[i] + " ");
            if ((i + 1) % 5 == 0) {
                System.out.println();
            }
        }

    }
}
