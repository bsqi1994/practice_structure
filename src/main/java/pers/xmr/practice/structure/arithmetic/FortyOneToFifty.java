package pers.xmr.practice.structure.arithmetic;

import java.io.*;
import java.util.List;
import java.util.Random;

/**
 * @author xmr
 * @date 2020/4/8 22:50
 * @description
 */
public class FortyOneToFifty {
    public static void main(String[] args) throws IOException {
         fortyOne(5);
         fortyTwo();
         fortyThree();
         fortyFour(100);
         fortyFive(23);
         fortySix("I love you","money");
         fortySeven(20);
         fortyEight(1000);
         fortyNine("I am a pig");
         fifty(1);

    }

    /**
     * 题目：海滩上有一堆桃子，五只猴子来分。 第一只猴子把这堆桃子凭据分为五份，多了一个，这只猴子把多的一个扔入海中，拿走了一份。
     * 第二只猴子把剩下的桃子又平均分成五份，又多了一个，它同样把多的一个扔入海中，拿走了一份，
     * 第三、第四、第五只猴子都是这样做的，问海滩上原来最少有多少个桃子？
     */
    protected static void fortyOne(int monkeys) {
        int sum = 1;
        for (int i = 1; i <= monkeys; i++) {
            sum = sum * 5 + 1;
        }
        System.out.println("海滩上原来桃子的个数是:" + sum);
    }

    /**
     * 题目：809*??=800*??+9*??+1 其中??代表的两位数,8*??的结果为两位数，9*??的结果为3位数。
     * 求??代表的两位数，及809*??后的结果。 出这道题的人怕是个弱智吧???
     */
    protected static void fortyTwo() {
        int number = 0;
        for (int i = 10; i <= 99; i++) {
            if (8 * i > 99) {
                continue;
            }
            if (9 * i < 100) {
                continue;
            }
            if ((809 * i == 800 * i + 9 * i + 1)) {
                number = i;
                int result = 809 * number;
                System.out.println("??代表的两位数是:" + number + "    809*??的结果是:" + result);
            }
        }
        if (number == 0) {
            System.out.println("没有符合要求的数!!!");
        }

    }

    /**
     * 题目：求0—7所能组成的奇数个数。 奇数,末位为1,3,5,7
     */
    protected static void fortyThree() {
        int n = 8;
        int sum = 0;
        sum += n / 2;
        sum += (n - 1) * n / 2;
        sum += (n - 1) * n * n / 2;
        sum += (n - 1) * n * n * n / 2;
        sum += (n - 1) * n * n * n * n / 2;
        sum += (n - 1) * n * n * n * n * n / 2;
        sum += (n - 1) * n * n * n * n * n * n / 2;
        System.out.println("0--7所能组成的奇数个数为:" + sum);
    }

    /**
     * 题目：一个偶数总能表示为两个素数之和。 这个题同样是一道弱智题....我他娘的能证明出这个东西还敲代码干嘛, 早成了世界最顶尖的数学大师了...
     * 因此,我只能尝试证明小于我输入的偶数范围内的全部偶数都能表示成两个素数的和 或者是任何一个输入的整数都能表示成两个素数的和
     */
    protected static void fortyFour(int even) {
        // ----证明我输入偶数能表示成为两个素数的和,素数通过第二题写的方法得到
        List<Integer> list = OneToTen.second(0, even);
        boolean flag = false;
        int mark = 0;
        for (int j = 0; j < list.size(); j++) {
            int outer = list.get(mark);
            for (int k = 0; k < list.size(); k++) {
                int inner = list.get(k);
                if (outer + inner == even) {
                    flag = true;
                    System.out.println("输入的偶数" + even + "能够表示为两个素数之和!");
                    return ;
                }
            }
            mark++;
        }
        System.out.println("输入的偶数" + even + "不能够表示为两个素数之和!");
    }

    /**
     * 题目：判断一个素数能被几个9整除
     */
    protected static void fortyFive(int primeNumber) {
        // 因为前面已经有好几个筛选素数的方法,所以就不加以筛选,默认输入进来的数是素数
        int result = primeNumber / 9;
        System.out.println("该素数" + primeNumber + "能被" + result + "个9整除");
    }

    /**
     * 题目：两个字符串连接程序
     */
    protected static void fortySix(String str1, String str2) {
        StringBuffer sb = new StringBuffer();
        String str = sb.append(str1).append(str2).toString();
        System.out.println("两个字符串拼接的结果为:" + str);
    }

    /**
     * 题目：读取7个数（1—50）的整数值，每读取一个值，程序打印出该值个数的*。
     */
    protected static void fortySeven(int n) {
        for (int i = 0; i < n; i++) {
            int number = new Random().nextInt(49) + 1;
            for (int j = 0; j <= number; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    /**
     * 题目：某个公司采用公用电话传递数据，数据是四位的整数，在传递过程中是加密的，
     * 加密规则如下：每位数字都加上5,然后用和除以10的余数代替该数字，再将第一位和第四位交换，第二位和第三位交换。
     */
    protected static void fortyEight(Integer number) {
        int encryption = 0;
        int temp = 0;
        int bit = number % 10;
        int ten = number % 100 / 10;
        int hundreds = number % 1000 /100;
        int thousands = number / 1000;
        bit = (bit + 5) % 10;
        ten = (ten + 5) % 10;
        hundreds = (hundreds + 5) % 10;
        thousands =(thousands +5) % 10;
        temp = bit ;
        bit = thousands;
        thousands =temp;
        temp = ten;
        ten = hundreds;
        hundreds = temp;
        encryption = thousands * 1000 + hundreds * 100 +ten * 10 +bit;
        System.out.println(number + "加密之后的结果为:" +encryption);
    }

    /**
     * 题目：计算字符串中子串的个数
     */
    protected static void fortyNine(String fatherStr) {
        char[] strCharArray = fatherStr.toCharArray();
        int count = 1;
        for (char c : strCharArray) {
            if (c == ' ') {
                count++;
            }
        }
        System.out.println("字符串" + fatherStr + "的子串个数为:" + count);
    }

    /**
     * 题目：有五个学生，每个学生有3门课的成绩，从键盘输入以上数据（包括学生号，姓名，三门课成绩），计算出平均成绩，
     * 将原有的数据和计算出的平均分数存放在磁盘文件"stud"中。
     * @throws IOException
     */
    protected static void fifty(int studentNumber) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] sutdentID = new String [studentNumber];
        String [] name = new String [studentNumber];
        String [] chinese = new String [studentNumber];
        String [] math = new String [studentNumber];
        String [] english = new String [studentNumber];
        int [] average = new int [studentNumber];
        for (int i = 0; i < studentNumber; i++) {
            System.out.println("请输入第" + i + 1 + "个同学的学号");
            sutdentID[i] =br.readLine();
            System.out.println("请输入第" + i + 1 + "个同学的姓名");
            name[i] = br.readLine();
            System.out.println("请输入第" + i + 1 + "个同学的成绩");
            chinese [i]= br.readLine();
            math [i] = br.readLine();
            english [i] = br.readLine();
            average [i]= Integer.valueOf(chinese [i] + math [i] + english [i]) / 3;
        }
        try {
            FileWriter fw = new FileWriter("d://stud");
            BufferedWriter bw =new BufferedWriter(fw);
            for(int i = 0 ;i < studentNumber ; i ++) {
                bw.write(sutdentID[i]+" ");
                bw.write(name [i] + " ");
                bw.write(chinese [i] + " ");
                bw.write(math [i]+" ");
                bw.write(english [i] +" ");
                bw.write(average [i] + " ");
                bw.flush();
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
