package lc70;

import java.util.*;
public class Solution {
    public int climbStairs(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
            int a = 1;
        int b = 2;
        int c = 0;
        for (int i = 2; i < n; i++) {
            c = a+b;
            a = b;
            b = c;
        }
        return c;
        }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.climbStairs(4));
    }
}
