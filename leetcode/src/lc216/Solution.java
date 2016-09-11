package lc216;

import java.util.*;

public class Solution {
    public boolean containsDuplicate(int[] nums) {
    	if (nums == null || nums.length < 2) return false;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1; i++) {
        	if (nums[i] == nums[i+1]) return true;
        }
        return false;
    } 

    public static void main(String[] args) {
    	Solution solution = new Solution();
    	System.out.println(solution.containsDuplicate(new int[]{2,2}));
    	System.out.println(solution.containsDuplicate(new int[]{2,1}));
    }
}