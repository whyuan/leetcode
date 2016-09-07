package lc198;

import java.util.*;

public class Solution {
    public int rob(int[] nums) {
    	if (nums == null || nums.length == 0) return 0;
    	if (nums.length == 1) return nums[0];
    	int[] f = new int[nums.length];
    	f[0] = nums[0];
    	f[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < f.length; i++) {
        	if (f[i-2]+nums[i]>f[i-1]) {
        		f[i] = f[i-2]+nums[i];
        	} else {
        		f[i] = f[i-1];
        	}
        }
        return f[f.length-1];
    }

    public static void main(String[] args) {
    	Solution solution = new Solution();
    	System.out.println(solution.rob(new int[]{1,2,3,4,5}));
    	System.out.println(solution.rob(new int[]{}));
    }
}