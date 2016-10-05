package lc334;

import java.util.*;

public class Solution {

    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) return false;
        int a, b, c = Integer.MAX_VALUE;
        int i = 0;
        while (i < nums.length-1 && nums[i+1] <= nums[i]) i++;
        if (i == nums.length-1) return false;
        a = nums[i];
        b = nums[i+1];
        for (int j = i+2; j < nums.length; j++) {
        	if (nums[j] > b) return true;
        	else if (c == Integer.MAX_VALUE && nums[j] > a && nums[j] < b) b = nums[j];
        	else if (c != Integer.MAX_VALUE && nums[j] > c && nums[j] < b) {
        		a = c;
        		b = nums[j];
        		c = Integer.MAX_VALUE;
        	}
        	else if (c != Integer.MAX_VALUE && nums[j] < c) c = nums[j];
        	else if (c == Integer.MAX_VALUE && nums[j] < a) c = nums[j];
        }
        return false;
    }

    public static void main(String[] args) {
    	Solution solution = new Solution();
    }
}
