package lc233;

import java.util.*;

public class Solution {
    public int countDigitOne(int n) {
    	int a = n;
    	int step = 0;
    	int tens = 1;
    	int sum = 0;
    	while (a > 0) {
    		int cur = a % 10;
    		if (cur > 1) {
    			sum += tens/10*(step)*cur+tens;
    		} else if (cur == 1) {
    			sum += tens/10*(step)+(n % tens + 1);
    		}
    		tens *= 10;
    		step++;
    		a /= 10;
    	}
    	return sum;
    }
    
    private int f(int x) {
    	int c = 1;
    	int b = 1;
    	int sum = 0;
    	for (int i = 0; i < x; i++) {
    		sum += (x - i) * c * b;
    		b *= 9;
    		c = c * (x-i) / (i+1);
    	}
    	return sum;
    }

    public static void main(String[] args) {
    	Solution solution = new Solution();
    	System.out.println(solution.countDigitOne(1));
    	System.out.println(solution.countDigitOne(13));
    	System.out.println(solution.countDigitOne(211));
    	System.out.println(solution.countDigitOne(824883294));
    }
}
