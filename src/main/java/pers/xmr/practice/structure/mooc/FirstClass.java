package pers.xmr.practice.structure.mooc;

import com.sun.xml.internal.ws.api.message.saaj.SaajStaxWriter;

/**
 * @author xmr
 * @date 2020/3/10 19:19
 * @description
 */
public class FirstClass {
    static double result = 0;
    public static void main(String[] args) {

//        printN(10000);
//        long startTime = System.currentTimeMillis();
//        printRecursive(10000);
//        long endTime = System.currentTimeMillis();
//        System.out.println(endTime - startTime);

        System.out.println(qinJiuShao( new double [] {2.0,3.0,4.0},2, 2));
        polynomial(new double [] {2.0,3.0,4.0}, 2, 2);
    }

    private static void printRecursive(int number) {
        if (number > 0) {
            System.out.print(number);
            printRecursive(-- number);
        }
        return;
    }

    private static void printN(int number) {
        long startTime = System.currentTimeMillis();
        for(int i = 1; i <= number; i++) {
            System.out.print(i);
        }
        System.out.println();
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }

    static double qinJiuShao(double a[], int n, double x) {
            double result = a[n];
        for (int i = n; i > 0; i--) {
            result = a[i -1] + result * x;
        }
        return result;
    }
    static double polynomial(double a[] , int n, double x) {
        double result = a[0];
        // a的长度为n+1
        for (int i = 1; i <= n; i++) {
            result += a[i] * Math.pow(x, i);
        }
        System.out.println(result);
        return result;
    }
}
