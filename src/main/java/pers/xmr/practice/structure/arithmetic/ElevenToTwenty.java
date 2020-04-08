package pers.xmr.practice.structure.arithmetic;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author xmr
 * @date 2020/4/8 10:41
 * @description
 */
public class ElevenToTwenty {
    public static void main(String[] args) {
         eleven(6);
         twelve();
         thirteen();
         fourteen(2022, 2, 20);
         fifteen(16, 19, 13);
         sixteen();
         seventeen(1,10);
         nineteen(10);
         twenty(10);
    }

    /**
     * 题目：有1、2、3、4个数字，能组成多少个互不相同且无重复数字的三位数？都是多少？ 全排列减去不符合条件的
     */
    protected static void eleven(int number) {
        int sum = 0;
        for (int i = 1; i <= number; i++) {
            for (int j = 1; j <= number; j++) {
                if (i == j) {
                    continue;
                }
                for (int k = 1; k <= number; k++) {
                    if (k == i || k == j) {
                        continue;
                    }
                    sum++;
                    int threeDigits = i * 100 + k * 10 + j;
                    System.out.print(" " + threeDigits);
                    if (sum % 5 == 0) {
                        System.out.println();
                    }
                }
            }
        }
        System.out.println("互不相同且无重复数字的三位数共有" + sum + "个");
    }

    /**
     * 题目：企业发放的奖金根据利润提成。利润(I)低于或等于10万元时，奖金可提10%；
     * 利润高于10万元，低于20万元时，低于10万元的部分按10%提成，高于10万元的部分，可可提成7.5%；
     * 20万到40万之间时，高于20万元的部分，可提成5%；40万到60万之间时高于40万元的部分，可提成3%；
     * 60万到100万之间时，高于60万元的部分，可提成1.5%， 高于100万元时，超过100万元的部分按1%提成
     * 从键盘输入当月利润I，求应发放奖金总数？
     */
    protected static void twelve() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入企业当月的利润");
        Double profit = sc.nextDouble();
        double bonus = 0;
        if (profit <= 100000 && profit >= 0) {
            bonus = profit * 0.1;
        } else if (profit <= 200000) {
            bonus = 100000 * 0.1 + (profit - 100000) * 0.075;
        } else if (profit <= 400000) {
            bonus = 100000 * 0.1 + (200000 - 10) * 0.75 + (profit - 200000) * 0.05;
        } else if (profit <= 600000) {
            bonus = 100000 * 0.1 + (200000 - 10) * 0.75 + (400000 - 200000) * 0.05 + (profit - 400000) * 0.03;
        } else if (profit <= 1000000) {
            bonus = 100000 * 0.1 + (200000 - 10) * 0.75 + (400000 - 200000) * 0.05 + (600000 - 400000) * 0.03
                    + (profit - 600000) * 0.015;
        } else if (profit >= 1000000) {
            bonus = 100000 * 0.1 + (200000 - 10) * 0.75 + (400000 - 200000) * 0.05 + (600000 - 400000) * 0.03
                    + (1000000 - 600000) * 0.015 + (profit - 1000000) * 0.001;
        } else {
            System.out.println("利润不正确");
        }
        System.out.println("应发放的奖金总额为:" + bonus);
    }

    /**
     * 题目：一个整数，它加上100后是一个完全平方数，再加上168又是一个完全平方数，请问该数是多少？ 完全平方数:开根号所得的值为整数
     */
    protected static void thirteen() {
        for (int i = 0; i <= 100000; i++) {
            if (isCompletelysquare(i + 100) && isCompletelysquare(i + 268)) {
                System.out.println("该数为" + i);
            }
        }
    }

    protected static boolean isCompletelysquare(int x) {
        boolean flag = false;

        for (int j = 1; j <= x; j++) {
            if (j * j == x) {
                flag = true;
            }
        }

        return flag;
    }

    /**
     * 题目：输入某年某月某日，判断这一天是这一年的第几天？ 注意: 闰年的二月多一天
     */
    protected static void fourteen(int year, int month, int day) {
        int daysOfYear = 0;
        if (month == 1) {
            daysOfYear = day;
        } else {
            if (isLeapYear(year)) {
                switch (month) {
                    case 2:
                        daysOfYear = 31 + day;
                        break;
                    case 3:
                        daysOfYear = 31 + 29 + day;
                        break;
                    case 4:
                        daysOfYear = 31 + 29 + 31 + day;
                        break;
                    case 5:
                        daysOfYear = 31 + 29 + 31 + 30 + day;
                        break;
                    case 6:
                        daysOfYear = 31 + 29 + 31 + 30 + 31 + day;
                        break;
                    case 7:
                        daysOfYear = 31 + 29 + 31 + 30 + 31 + 30 + day;
                        break;
                    case 8:
                        daysOfYear = 31 + 29 + 31 + 30 + 31 + 30 + 31 + day;
                        break;
                    case 9:
                        daysOfYear = 31 + 29 + 31 + 30 + 31 + 30 + 31 + 31 + day;
                        break;
                    case 10:
                        daysOfYear = 31 + 29 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + day;
                        break;
                    case 11:
                        daysOfYear = 31 + 29 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + day;
                        break;
                    case 12:
                        daysOfYear = 31 + 29 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + 30 + day;
                        break;
                    default:
                        ;
                }

            }
            if (!isLeapYear(year)) {
                switch (month) {
                    case 2:
                        daysOfYear = 31 + day;
                        break;
                    case 3:
                        daysOfYear = 31 + 28 + day;
                        break;
                    case 4:
                        daysOfYear = 31 + 28 + 31 + day;
                        break;
                    case 5:
                        daysOfYear = 31 + 28 + 31 + 30 + day;
                        break;
                    case 6:
                        daysOfYear = 31 + 28 + 31 + 30 + 31 + day;
                        break;
                    case 7:
                        daysOfYear = 31 + 28 + 31 + 30 + 31 + 30 + day;
                        break;
                    case 8:
                        daysOfYear = 31 + 28 + 31 + 30 + 31 + 30 + 31 + day;
                        break;
                    case 9:
                        daysOfYear = 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + day;
                        break;
                    case 10:
                        daysOfYear = 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + day;
                        break;
                    case 11:
                        daysOfYear = 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + day;
                        break;
                    case 12:
                        daysOfYear = 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + 30 + day;
                        break;
                    default:
                        ;
                }
            }
        }
        System.out.println("这是一年的第" + daysOfYear + "天");
    }

    protected static boolean isLeapYear(int year) {
        boolean flag = false;
        if (year % 400 == 0) {
            flag = true;
        } else if (year % 100 == 0) {
            flag = false;
        } else if (year % 4 == 0) {
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    /**
     * 题目：输入三个整数x,y,z，请把这三个数由小到大输出。 令x,y,z依次递增
     */
    protected static void fifteen(int x, int y, int z) {
        int temp = 0;
        if (x >= y) {
            temp = x;
            x = y;
            y = temp;
        }
        if (x >= z) {
            temp = x;
            x = z;
            z = temp;
        }
        if (y >= z) {
            temp = y;
            y = z;
            z = temp;
        }
        System.out.println("from small to large:" + x + "," + y + "," + z);
    }

    /**
     * 题目：输出9*9口诀。
     */
    protected static void sixteen() {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + "*" + j + "=" + i * j + "  ");
            }
            System.out.println();
        }
    }

    /**
     * 题目：猴子吃桃问题：猴子第一天摘下若干个桃子，当即吃了一半，还不过瘾，又多吃了一个 第二天早上又将剩下的桃子吃掉一半，又多吃了一个。
     * 以后每天早上都吃了前一天剩下的一半零一个。 到第10天早上想再吃时，见只剩下一个桃子了。 求第一天共摘了多少。
     */
    protected static void seventeen(int remaining, int days) {
        for (int i = 1; i < days; i++) {
            remaining = (remaining + 1) * 2;
        }
        System.out.println("第一天摘了" + remaining + "个");
    }



    /**
     * 题目：打印出如下图案（菱形）
     */
    protected static void nineteen(int rows) {
        // ---------------打印菱形的上半部分-----------------
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows * 2; j++) {
                if (j < rows - i) {
                    System.out.print(" ");
                }
                if ((j >= rows - i) && (j <= rows + i)) {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
        // ---------------打印菱形的下半部分------------------
        for (int i = 0; i < rows; i++) {
            System.out.print(" ");
            for (int j = 0; j < 2 * rows - i - 1; j++) {
                if (j < i)
                    System.out.print(" ");
                if (j >= i && j < 2 * rows - i - 2)
                    System.out.print("*");
            }
            System.out.println();
        }
    }

    /**
     * 题目：有一分数序列：2/1，3/2，5/3，8/5，13/8，21/13... 求出这个数列的前20项之和。
     * 注意分析分子分母的规律(分子的值是前一项的分母...后一项的分子分母是前两项的和)
     */
    protected static void twenty(int n) {
        int[] molecular = new int[n];
        int[] denominator = new int[n];
        double sum = 0;
        if (n == 1) {
            molecular[0] = 1;
            denominator[0] = 2;
            sum = denominator[0] / molecular[0];
            System.out.println("前" + n + "项的结果为" + sum);
            return;
        }

        molecular[0] = 1;
        denominator[0] = 2;
        molecular[1] = denominator[0];
        denominator[1] = 3;
        sum = ((double) denominator[0] / (double) molecular[0]) + ((double) denominator[1] / (double) molecular[1]);
        for (int i = 2; i < n; i++) {
            molecular[i] = molecular[i - 1] + molecular[i - 2];
            denominator[i] = denominator[i - 1] + denominator[i - 2];
            sum = sum + ((double) denominator[i] / (double) molecular[i]);
        }
        System.out.println("前" + n + "项的结果为" + sum);
        System.out.println((double) 3 / (double) 2);
    }

}
class Eighteen {
    // ========c-->y
    // ========a-->z
    // ========b-->x
    // 看起来非常简单的题,转换成程序语言却没那么简单,只能换一种解决思路
    String a;
    String b;
    String c;

    public static void main(String [] args) {
        String[] teamB = { "x", "y", "z" };
        ArrayList<Eighteen> list = new ArrayList<Eighteen>();
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                for (int k = 0; k < 3; k++) {
                    Eighteen eighteen = new Eighteen(teamB[i], teamB[j], teamB[k]);
                    if (!eighteen.a.equals(eighteen.b) && !eighteen.a.equals(eighteen.c)
                            && !eighteen.b.equals(eighteen.c) && !eighteen.a.equals("x") && !eighteen.c.equals("x")
                            && !eighteen.c.equals("z"))
                        list.add(eighteen);
                }
        for (Object obj : list)
            System.out.println(obj);
    }

    private Eighteen(String a, String b, String c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public String toString(){
        return "a的对手是"+a+"  "+"b的对手是"+b+"  "+"c的对手是"+c;
    }

}

