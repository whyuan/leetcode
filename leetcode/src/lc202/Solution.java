package lc202;

import java.util.*;

public class Solution {
    public boolean isHappy(int n) {
    	if (n == 1) return true;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(n, 1);
        while (true) {
        	int newN = 0;
        	while (n > 0) {
        		int cur = n%10;
        		newN = newN+cur*cur;
        		n /= 10;
        	}
        	n = newN;
        	if (n == 1) {
        		return true;
        	} else if (map.containsKey(n)) {
        		return false;
        	} else {
        		map.put(n, 1);
        	}
        }
    }

    public static void main(String[] args) {
    	Solution solution = new Solution();
    	System.out.println(solution.isHappy(19));
    	System.out.println(solution.isHappy(1));
    	System.out.println(solution.isHappy(2));
    	System.out.println(solution.isHappy(3));
    	System.out.println(solution.isHappy(33));
    }
}