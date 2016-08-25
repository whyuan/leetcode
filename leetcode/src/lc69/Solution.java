package lc69;

import java.util.*;
public class Solution {
    public int mySqrt(int y) {
        if (y < 0) return -1;
        if (y == 0) return 0;
        double x0 = 1, x1 = 1, temp;
        while (!((x1*x1<=y && (x1+1)*(x1+1)>y) || (x1*x1>=y && (x1-1)*(x1-1)<y))) {
            temp = x1;
            x1 = x0-((x0*x0-y)/(2*x0));
            x0 = temp;
        }
        int a = (int)x1;
        if (a*a>y) {
        return a-1;
        } else {
            return a;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.mySqrt(2));
    }
}
