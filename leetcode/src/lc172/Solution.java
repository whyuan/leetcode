package lc172;

import java.util.*;

public class Solution {
    public int trailingZeroes(int n) {
    	if (n <= 0) return 0;
    	int result = 0;
    	while (n >= 5) {
    		result += n / 5;
    		n /= 5;
    	}
    	return result;
    }
    
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	System.out.println(solution.trailingZeroes(1));
    	System.out.println(solution.trailingZeroes(2));
    	System.out.println(solution.trailingZeroes(3));
    	System.out.println(solution.trailingZeroes(4));
    	System.out.println(solution.trailingZeroes(5));
    	System.out.println(solution.trailingZeroes(6));
    	System.out.println(solution.trailingZeroes(24));
    	System.out.println(solution.trailingZeroes(25));
    	System.out.println(solution.trailingZeroes(26));
    	System.out.println(solution.trailingZeroes(30));
    	System.out.println(solution.trailingZeroes(35));
    	System.out.println(solution.trailingZeroes(625));
    }
}