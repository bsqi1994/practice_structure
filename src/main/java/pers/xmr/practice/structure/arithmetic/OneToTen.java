package pers.xmr.practice.structure.arithmetic;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * @author xmr
 * @date 2020/4/8 22:38
 * @description java经典50题1~10
 */
public class OneToTen {
    public static void main(String[] args) {
         first(-5);
         second(2,2000);
         third();
         fourth(400000);
         fifth(10);
         sixth(10,15);
         seventh("sadfsadf sdf sd dss34df re [] \\ \\]\\[ \\]\\ \\");
         eighth(1);
         nineth(1000);
         tenth(100L,1);
    }

    /**
     * 题目：古典问题：有一对兔子，从出生后第3个月起每个月都生一对兔子，小兔子长到第四个月后每个月又生一对兔子，
     * 假如兔子都不死，问每个月的兔子总数为多少？ 1,1,2,3,5,8 f(n)=f(n-1)+f(n-2)
     *
     * @param month 月份 1~12
     */
    protected static void first(int month) {
        int sum = 0;
        if (month <= 0) {
            System.out.println("请输入正确的月份");
        } else if (month <= 2) {
            sum = 1;
        } else {
            int[] num = new int[month];
            num[0] = 1;
            num[1] = 1;
            for (int i = 2; i < month; i++) {
                num[i] = num[i - 1] + num[i - 2];
                sum = num[month - 1];
            }

        }
        System.out.println(sum);
    }

    /**
     * 题目：判断两个数之间有多少个素数，并输出所有素数。
     */
    protected static List<Integer> second(int startInt, int endInt) {
        List<Integer> list = new ArrayList<Integer>();
        int sum = 0;
        for (int i = startInt; i <= endInt; i++) {
            double num = i / 1;
            boolean flag = true;
            if (i < 2) {
                flag = false;
            }
            for (int j = 2; j <= Math.sqrt(num); j++) {
                if (num % j == 0) {
                    flag = false;
                    break;
                }

            }
            if (flag == true) {
                sum++;
                list.add(i);
            }

        }
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + ",");
            if (i % 10 == 9) {
                System.out.println();
            }
        }
        System.out.println();
        System.out.println(startInt + "到" + endInt + "之间的素数个数为:" + sum);
        return list;
    }

    /**
     * 题目：打印出所有的 水仙花数 ，
     * 所谓 水仙花数 是指一个三位数，其各位数字立方和等于该数本身。
     *  某三位数的百位 i / 100,十位 i % 100 / 10,个位 i % 10
     */
    protected static void third() {
        int sum = 0;
        for (int i = 100; i <= 999; i++) {
            int hundred = i / 100;
            int ten = i % 100 / 10;
            int bits = i % 10;
            int cubicNum = hundred * hundred * hundred + ten * ten * ten + bits * bits * bits;
            if (cubicNum == i) {
                sum++;
                System.out.print(i + "    ");
            }
        }
        System.out.println();
        System.out.println("水仙花数的个数为:" + sum);
    }

    /**
     * 题目四:将一个数分解质因数
     *
     * @param n
     */
    protected static void fourth(int n) {
        // 首先获取到小于这个数的全部素数
        List<Integer> list = second(2, n);
        List<Integer> resultList = new ArrayList<Integer>();
        result(list, resultList, n);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < resultList.size(); i++) {
            sb.append(resultList.get(i)).append("*");
        }
        sb.delete(sb.length() - 1, sb.length());
        System.out.println(n + "=" + sb.toString());
    }

    protected static List<Integer> result(List<Integer> list, List<Integer> resultList, int n) {

        if (n < 2) {
            return resultList;
        }
        for (int i = 0; i < list.size(); i++) {
            if (n % list.get(i) == 0) {
                n = n / list.get(i);
                resultList.add(list.get(i));
            }
        }
        result(list, resultList, n);
        return resultList;
    }

    /**
     * 利用条件运算符的嵌套来完成此题：学习成绩>=90分的同学用A表示，60-89分之间的用B表示，60分以下的用C表示。
     */
    protected static void fifth(int grade) {
        if (grade >= 90 && grade <= 100) {
            System.out.println("A");
            return;
        }
        if (grade >= 60 && grade < 90) {
            System.out.println("B");
            return;
        }
        if (grade >= 0 && grade < 60) {
            System.out.println("C");
            return;
        }
        System.out.println("grade is error");
    }

    /**
     * 题目：输入两个正整数m和n，求其最大公约数和最小公倍数。 辗转相除余数为0时，除数就是最大公约数
     */
    protected static void sixth(int m, int n) {
        int biggestConvention;
        int leastMultiple = m * n;
        int temp;
        if (n < m) {
            temp = n;
            n = m;
            m = temp;
        }
        int smallInt = m;
        int bigInt = n;
        while (n % m != 0) {
            temp = n % m;
            n = m;
            m = temp;
        }
        biggestConvention = m;
        leastMultiple = leastMultiple / m;
        System.out.println(smallInt + "," + bigInt + "的最大公约数为" + biggestConvention);
        System.out.println(smallInt + "," + bigInt + "的最小公倍数为" + leastMultiple);
    }

    /**
     * 题目：输入一行字符，分别统计出其中英文字母、空格、数字和其它字符的个数。 String的toCharArray方法，可以把字符串转换为数组
     */
    protected static void seventh(String str) {
        int number = 0;
        int english = 0;
        int space = 0;
        int others = 0;
        char[] strCharArray = str.toCharArray();
        for (char chars : strCharArray) {
            if (chars >= '0' && chars <= '9') {
                number++;
            } else if ((chars >= 'a' && chars <= 'z') || (chars >= 'A' && chars <= 'Z')) {
                english++;
            } else if (chars == ' ') {
                space++;
            } else {
                others++;
            }
        }
        System.out.println(str + "含有数字" + number + "  含有字母" + english + "  含有空格" + space + "  其他" + others);
    }

    /**
     * 题目：求s=a+aa+aaa+aaaa+aa...a的值，其中a是一个数字。
     * 例如2+22+222+2222+22222(此时共有5个数相加)，几个数相加有键盘控制。
     */
    protected static void eighth(int a) {
        Scanner sc = new Scanner(System.in);
        System.out.println("你希望几个数相加呢？");
        int number = sc.nextInt();
        int sum = 0;
        int addition = 0;
        for (int i = 0; i < number; i++) {
            addition += (int) (a * Math.pow(10, i));
            sum = sum + addition;
        }
        System.out.println(number + "个数相加的和为：" + sum);
    }

    /**
     * 题目：一个数如果恰好等于它的因子之和，这个数就称为"完数"。例如6=1＋2＋3.编程找出1000以内的所有完数。
     */
    protected static void nineth(int number) {
        List<ArrayList<Integer>> outerList = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> innerList = null;
        for (int i = 1; i <= number; i++) {
            innerList = new ArrayList<Integer>();
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    innerList.add(j);
                }

            }
            outerList.add(innerList);

        }
        System.out.println(number + "以内的完数有：");
        for (int i = 1; i <= outerList.size(); i++) {
            int sum = 0;
            for (int j = 1; j <= outerList.get(i - 1).size(); j++) {
                sum += outerList.get(i - 1).get(j - 1);
                if (sum == i) {
                    System.out.print(i + ",");
                }
            }
        }
    }

    /**
     * 题目：一球从100米高度自由落下，每次落地后反跳回原高度的一半； 再落下，求它在 第10次落地时，共经过多少米？第10次反弹多高？
     */
    protected static void tenth(Long highth, int bounceNumber) {
        Long distance = 0L;
        Long bounceHigh = highth;
        for (int i = 0; i < bounceNumber; i++) {
            distance = bounceHigh + distance;
            bounceHigh = bounceHigh / 2;
        }
        System.out.println("第" + bounceNumber + "次落地，球共经过" + distance + "米");
        System.out.println("第" + bounceNumber + "次反弹的高度为：" + bounceHigh);
    }
}
