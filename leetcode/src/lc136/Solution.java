package lc136;

import java.util.*;

public class Solution {
    public int singleNumber(int[] nums) {
    	if (nums == null || nums.length == 0) return 0;
    	int a = 0;
        for (int i = 0; i < nums.length; i++) {
        	a = a ^ nums[i];
        }
        return a;
    } 

    public static void main(String[] args) {
    	Solution solution = new Solution();
    	System.out.println(solution.singleNumber(new int[]{1,1,2,3,3}));
    }
}
