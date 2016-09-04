package lc167;

import java.util.*;

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length == 1) return null;
        int h = 0, t = numbers.length-1;
        while (h < t) {
        	if (numbers[h] + numbers[t] < target) {
        		h++;
        	} else if (numbers[h] + numbers[t] > target) {
        		t--;
        	} else {
        		return new int[]{h+1, t+1};
        	}
        }
        return null;
    }
    
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	int[] result = solution.twoSum(new int[]{0,2,3,7}, 9);
    	System.out.println(result[0]);
    	System.out.println(result[1]);
    }
}