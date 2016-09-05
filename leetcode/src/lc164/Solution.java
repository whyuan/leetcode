package lc164;

import java.util.*;

public class Solution {
    public int maximumGap(int[] nums) {
    	if (nums == null || nums.length == 0 || nums.length == 1) return 0;
    	int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    	for (int i = 0; i < nums.length; i++) {
    		if (nums[i] < min) min = nums[i];
    		if (nums[i] > max) max = nums[i]; 
    	}
    	int gap = Math.max((max-min)/(nums.length-1), 1);
    	int[] mins = new int[(max-min)/gap+1];
    	int[] maxs = new int[mins.length];
    	for (int i = 0; i < nums.length; i++) {
    		int index = (nums[i]-min)/gap;
    		if (nums[i] > maxs[index]) maxs[index] = nums[i];
    		if (mins[index] == 0 || nums[i] < mins[index]) mins[index] = nums[i];
    	}
    	int cur = maxs[0];
    	int result = 0;
    	for (int i = 1; i < mins.length; i++) {
    		if (mins[i] - cur > result) result = mins[i] - cur;
    		if (maxs[i] > 0) cur = maxs[i];
    	}
    	return result;
    }
    
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	System.out.println(solution.maximumGap(new int[]{1,3,6,9}));
    	System.out.println(solution.maximumGap(new int[]{66}));
    }
}