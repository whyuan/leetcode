package lc410;

import java.util.*;

public class Solution {
	
    public int splitArray(int[] nums, int m) {
    	if (nums == null || nums.length == 0) return 0;
    	int sum = nums[0];
    	int max = nums[0];
    	for (int i = 1; i < nums.length; i++) {
    		sum += nums[i];
    		max = Math.max(nums[i], max);
    	}
    	int l = max, r = sum;
    	while (l < r) {
    		int mid = l+(r-l)/2;
    		if (isValid(mid, nums, m)) {
    			r = mid;
    		} else {
    			l = mid+1;
    		}
    	}
    	return l;
    }
    
    private boolean isValid(int max, int[] nums, int m) {
    	int sum = 0;
    	for (int i = 0; i < nums.length; i++) {
    		sum += nums[i];
    		if (sum > max) {
    			sum = nums[i];
    			m--;
    			if (m <= 0) return false;
    		}
    	}
    	return true;
    }

    public static void main(String[] args) {
    	Solution solution = new Solution();
    }
}