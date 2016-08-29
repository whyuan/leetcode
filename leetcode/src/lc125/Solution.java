package lc125;

import java.util.*;

public class Solution {
    public List<Integer> getRow(int rowIndex) {
    	Integer[] result = new Integer[rowIndex+1];
    	int half = result.length/2;
    	for (int i = 0; i <= half; i++) {
    		if (i == 0) result[i] = 1;
    		else {
    			result[i] = (int)((((long)result[i-1]*(rowIndex-i+1)))/(i));
    		}
    	}
    	for (int i = half+1; i < result.length; i++) {
    		result[i] = result[result.length-i-1];
    	}
    	return Arrays.asList(result);
    }
    
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	System.out.println(solution.getRow(30));
    }
}
