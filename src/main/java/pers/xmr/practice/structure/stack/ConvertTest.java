package pers.xmr.practice.structure.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author xmr
 * @date 2020/3/30 20:31
 * @description 使用栈实现java中的进制转换
 */
public class ConvertTest {
    public static void main(String[] args) {
        // 实现java中的进制转换
        int n = 13;
        int t = n; // 被除数;
        // 定义一个空栈
        Deque<Integer> deque = new LinkedList<>();
        do {
            // 除以二求余
            int mod = t % 2;
            // 除以二得到商
            t = t >> 1;
           deque.push(mod);

        }while (t > 0);
        while (!deque.isEmpty()) {
            System.out.print( deque.pop());
        }

    }
}
