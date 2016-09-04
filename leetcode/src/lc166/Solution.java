package lc166;

import java.util.*;

public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        long a = (long)numerator/(long)denominator;
        if (numerator%denominator != 0) {
        	boolean flag = false;
        	if ((numerator > 0 && denominator < 0) || (numerator < 0 && denominator > 0) && a == 0) {
        		flag = true;
        	}
        	long x = Math.abs((long)numerator);
        	long y = Math.abs((long)denominator);
        	String decimal = getFractionDecimal(x%y, y);
        	if (flag) {
        		return "-"+a+"."+decimal;
        	} else {
        		return a+"."+decimal;
        	}
        } else {
        	return Long.toString(a);
        }
    }
    
    private String getFractionDecimal(long numerator, long denominator) {
    	Map<Long, Integer> map = new HashMap<Long, Integer>();
		StringBuilder result = new StringBuilder();
		int step = 0;
		map.put(numerator, step++);
    	while (true) {
    		numerator *= 10;
    		if (numerator >= denominator) {
				long a = numerator / denominator;
				long b = numerator % denominator;
				numerator = b;
				result.append(a);
				if (b != 0) {
					if (map.containsKey(b)) {
						int i = map.get(b);
						result.insert(i, "(");
						result.append(")");
						return result.toString();
					}
					map.put(b, step);
				} else {
					return result.toString();
				}
    		} else {
    			result.append("0");
    			map.put(numerator, step);
    		}
    		step++;
    	}
    }
    
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	System.out.println(solution.fractionToDecimal(-1, -2147483648));
    	System.out.println(solution.fractionToDecimal(-1, 9));
    	System.out.println(solution.fractionToDecimal(-50, 9));
    	System.out.println(solution.fractionToDecimal(-50, 8));
    	System.out.println(solution.fractionToDecimal(1, 9));
    	System.out.println(solution.fractionToDecimal(0, 2));
    	System.out.println(solution.fractionToDecimal(4, 2));
    	System.out.println(solution.fractionToDecimal(2, 4));
    	System.out.println(solution.fractionToDecimal(2443, 923));
    }
}