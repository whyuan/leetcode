package lc169;

import java.util.*;

public class Solution {
    public int majorityElement(int[] nums) {
    	if (nums == null || nums.length == 0) return 0;
        int h = 0, t = nums.length-1;
        int count = 0;
        while (h < t) {
        	if (nums[h] == nums[t]) {
        		count++;
        	} else {
        		if (count > 0) {
        			count--;
        		} else {
        			h++;
        		}
        	}
        	t--;
        }
        return nums[h];
    }

    public static void main(String[] args) {
    	Solution solution = new Solution();
    	System.out.println(solution.majorityElement(new int[]{2,2,2,3,2,1,1}));
    }
}