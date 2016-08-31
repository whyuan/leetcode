package lc137;

import java.util.*;

public class Solution {
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int a = 0, b = 0, a0 = 0, b0 = 0;
        for (int i = 0; i < nums.length; i++) {
        	a0 = a;
        	b0 = b;
        	a = nums[i] ^ a;
        	b = (nums[i] & a0) ^ b;
        	a = a - (nums[i] & b0);
        	b = b - (nums[i] & b0);
        }
        return a;
    }
    
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	System.out.println(solution.singleNumber(new int[]{1,1,1,14,3,3,3}));
    }
}
