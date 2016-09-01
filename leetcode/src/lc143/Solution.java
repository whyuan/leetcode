package lc143;

import java.util.*;

public class Solution {
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int a = 0, b = 0, a0 = 0;
        for (int i = 0; i < nums.length; i++) {
        	a0 = a;
        	a = (nums[i] ^ a) ^ (nums[i] & b);
        	b = ((a0 | b) & nums[i]) ^ b;
        }
        return a;
    }
    
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	System.out.println(solution.singleNumber(new int[]{0,1,0,1,0,1,98}));
    }
}
