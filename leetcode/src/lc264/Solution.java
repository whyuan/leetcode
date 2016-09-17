package lc264;

import java.util.*;

public class Solution {
    public int[] singleNumber(int[] nums) {
    	if (nums == null) return null;
    	if (nums.length == 0) return new int[]{};
        int x = 0;
        for (int i = 0; i < nums.length; i++) {
        	x = x^nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
        	if ((nums[i]^(x^nums[i])) == 0) return new int[]{nums[i], x^nums[i]};
        }
        return null;
    }

    public static void main(String[] args) {
    	Solution solution = new Solution();
    	System.out.println(solution.singleNumber(new int[]{1,1,2,2,3,4}));
    }
}
