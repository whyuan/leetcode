package lc386;

import java.util.*;

public class Solution {
    public List<Integer> lexicalOrder(int n) {
    	Integer[] res = new Integer[n];
    	if (n <= 0) return Arrays.asList(res);
    	int cur = 1;
    	res[0] = cur;
    	for (int i = 1; i < n; i++) {
    		if (cur * 10 <= n) {
    			cur *= 10;
    		} else if (cur % 10 != 9 && cur < n) {
    			cur++;
    		} else {
    			while (!(cur % 10 != 9 && cur < n)) {
    				cur /= 10;
    			}
    			cur++;
    		}
    		res[i] = cur;
    	}
    	return Arrays.asList(res);
    }
}