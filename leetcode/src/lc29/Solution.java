package lc29;

import java.util.*;
import java.lang.ArithmeticException;

public class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) return Integer.MAX_VALUE;
        if (dividend == 0) return 0;
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        if (dividend == Integer.MIN_VALUE && divisor == 1) return Integer.MIN_VALUE;
        long absDividend = Math.abs((long)dividend);
        long absDivisor = Math.abs((long)divisor);
        int step0 = 0;
        int step1 = 1;
        long s0 = 0;
        long s1 = absDivisor;
        while (absDividend - s0 > absDivisor) {
            step1 = 1;
            s1 = absDivisor;
            while (absDividend - s0 > s1) {
                s0 += s1;
                step0 += step1;
                if (Integer.MAX_VALUE - s1 >= s1) {
                    s1 += s1+s1+s1;
                    step1 += step1+step1+step1;
                } else {
                    break;
                }
            }
        }
        if (absDividend - s0 == absDivisor) step0++;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            return -step0;
        } else {
            return step0;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(5/(-3));
//        System.out.println((-5) / (-3));
//        System.out.println((-5) / (3));
//        System.out.println((-5) / (0));

        System.out.println(solution.divide(1100540749, -1090366779));
        System.out.println(solution.divide(-1010369383, -2147483648));

        System.out.println(solution.divide(Integer.MAX_VALUE, 2));
        System.out.println(solution.divide(Integer.MIN_VALUE, -2));
        System.out.println(solution.divide(1024, 2));
        System.out.println(solution.divide(1024, 3));
        System.out.println(solution.divide(1, 1));
        System.out.println(solution.divide(5, -3));
        System.out.println(solution.divide(-5, -3));
        System.out.println(solution.divide(-5, 3));
        System.out.println(solution.divide(-5, 0));
        System.out.println(solution.divide(Integer.MIN_VALUE, -1));
        System.out.println(solution.divide(Integer.MAX_VALUE, 1));
    }
}

