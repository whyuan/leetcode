package lc162;

import java.util.*;

public class Solution {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return 0;
        int h = 0, t = nums.length;
        while (h < t-1) {
        	int m = (h+t)/2;
        	if (nums[h] >= nums[m] && nums[t-1] >= nums[m]) {
        		if (nums[h] > nums[t-1]) {
        			t = m;
        		} else {
        			h = m;
        		}
        	} else if ((nums[h] >= nums[m] && nums[m] >= nums[t-1]) || (nums[h] <= nums[m] && nums[m] <= nums[t-1])) {
        		if (nums[h] > nums[t-1]) {
        			t = m;
        		} else {
        			h = m;
        		}
        	} else {
        		t--;
        	}
        }
        return h;
    }
    
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	System.out.println(solution.findPeakElement(new int[]{1,2,3,1,2,3,1}));
    }
}