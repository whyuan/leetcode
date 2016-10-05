package lc330;

import java.util.*;

public class Solution {
	
    public int minPatches(int[] nums, int n) {
    	int step = 0;
    	long max = 0;
    	int count = 0;
    	while (max < n) {
    		if (step >= nums.length || max < nums[step]-1) {
    			max += max + 1;
    			count++;
    		} else {
    			max += nums[step];
    			step++;
    		}
    	}
    	return count;
    }

    public static void main(String[] args) {
    	Solution solution = new Solution();
    }
}
