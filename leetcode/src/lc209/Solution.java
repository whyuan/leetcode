package lc209;

import java.util.*;

public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
    	if (nums == null || nums.length == 0) return 0;
    	int[] sums = new int[nums.length+1];
    	sums[0] = 0;
    	for (int i = 0; i < nums.length; i++) {
    		sums[i+1] = nums[i]+sums[i];
    	}
    	int j = 0;
    	int min = nums.length+1;
    	for (int i = 1; i < sums.length; i++) {
    		while (sums[i] - sums[j] >= s) {
    			if (i-j < min) min = i-j;
    			j++;
    		}
    	}
    	if (min != nums.length+1) return min;
    	else return 0;
    }

    public static void main(String[] args) {
    	Solution solution = new Solution();
    	System.out.println(solution.minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
    	System.out.println(solution.minSubArrayLen(7, new int[]{1,1,1,1,1,1}));
    }
}