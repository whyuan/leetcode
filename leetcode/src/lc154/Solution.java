package lc154;

import java.util.*;

public class Solution {
    public int findMin(int[] nums) {
    	if (nums == null || nums.length == 0) return 0;
        int h = 0, t = nums.length; 
        while (h < t-1) {
        	int m = (h+t-1)/2;
        	if (nums[m] > nums[t-1]) {
        		h = m+1;
        	} else if (nums[m] < nums[t-1]) {
        		t = m+1;
        	} else {
        		t--;
        	}
        }
        return nums[h];
    }

    public static void main(String[] args) {
    	Solution solution = new Solution();
    	System.out.println(solution.findMin(new int[]{0, 0, 0, 0, 5, 0, 0}));
    }
}