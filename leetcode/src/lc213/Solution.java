package lc213;

import java.util.*;

public class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int[] f = new int[nums.length+1];
        f[1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
        	f[i+1] = Math.max(f[i], f[i-1]+nums[i]);
        }
        int max = f[nums.length-1];
        f[1] = 0;
        for (int i = 1; i < nums.length; i++) {
        	f[i+1] = Math.max(f[i], f[i-1]+nums[i]);
        }
        return Math.max(f[nums.length], max);
    }

    public static void main(String[] args) {
    	Solution solution = new Solution();
    }
}