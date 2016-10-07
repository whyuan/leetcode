package lc397;

import java.util.*;

public class Solution {

    public int integerReplacement(int n) {
    	if (n <= 1) return 0;
    	if (n == Integer.MAX_VALUE) return 32;
    	int count = 0;
    	while (n > 1) {
    		if ((n&1) == 1) {
    			if (((n+1)&3) == 0 && (n-1) != 2) n++;
    			else n--;
    		} else {
    			n = n>>1;
    		}
    		count++;
    	}
    	return count;
    }

    public int integerReplacement2(long n) {
    	if (n <= 1) return 0;
    	if ((n&1) == 1) {
    		return Math.min(integerReplacement2(n+1), integerReplacement2(n-1))+1;
    	} else {
    		return integerReplacement2(n/2)+1;
    	}
    }
	
    public int integerReplacement1(int n) {
    	cache = new HashMap<>();
    	return doIntegerReplacement(n);
    }
    
    private Map<Long, Integer> cache;
    private int doIntegerReplacement(long n) {
    	if (n <= 1) return 0;
    	if (cache.containsKey(n)) return cache.get(n);
    	if ((n&1) == 1) {
    		cache.put(n, Math.min(doIntegerReplacement(n+1), doIntegerReplacement(n-1))+1);
    	} else {
    		cache.put(n, doIntegerReplacement(n/2)+1);
    	}
    	return cache.get(n);
    }

    public static void main(String[] args) {
    	Solution solution = new Solution();
    }
}