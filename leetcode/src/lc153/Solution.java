package lc153;

import java.util.*;

public class Solution {
    public int findMin(int[] nums) {
    	if (nums == null || nums.length == 0) return 0;
        int h = 0, t = nums.length; 
        while (h < t-1) {
        	int m = (h+t-1)/2;
        	if (nums[m] > nums[t-1]) {
        		h = m+1;
        	} else {
        		t = m+1;
        	}
        }
        return nums[h];
    }
    
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	System.out.println(solution.findMin(new int[]{4, 5, 6, 7, 0, 1, 2, 3}));
    }
 
}