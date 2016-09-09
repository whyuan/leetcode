package lc204;

import java.util.*;

public class Solution {
    public int countPrimes(int n) {
    	if (n <= 2) return 0;
        boolean[] flag = new boolean[n+1];
        int result = 0;
        for (int i = 2; i < n; i++) {
        	if (flag[i] == false) {
        		int step = i;
        		result++;
				while (step < n) {
					flag[step] = true;
					step += i;
				}
        	}
        }
        return result;
    }

    public static void main(String[] args) {
    	Solution solution = new Solution();
    	System.out.println(solution.countPrimes(4));
    	System.out.println(solution.countPrimes(5));
    	System.out.println(solution.countPrimes(6));
    	System.out.println(solution.countPrimes(7));
    	System.out.println(solution.countPrimes(8));
    }
}