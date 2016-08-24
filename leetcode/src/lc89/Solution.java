package lc89;

import java.util.*;

public class Solution {
    public List<Integer> grayCode(int n) {
    	Integer[] result = new Integer[1<<n];
    	result[0] = 0;
    	int a = 1;
    	int t = 1;
    	for (int i = 0; i < n; i++) {
    		for (int j = a-1; j >= 0; j--) {
    			result[t++] = result[j] | a;
    		}
    		a = a << 1;
    	}
    	return Arrays.asList(result);
    }
    
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	System.out.println(solution.grayCode(2));
    }
}
