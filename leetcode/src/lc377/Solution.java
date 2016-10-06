package lc377;

import java.util.*;

public class Solution {

    public int combinationSum4(int[] nums, int target) {
    	if (nums == null || nums.length == 0) return 0;
    	Arrays.sort(nums);
    	int[] dp = new int[target+1];
    	dp[0] = 1;
    	for (int i = 1; i < dp.length; i++) {
    		for (int num : nums) {
    			if (i-num >= 0) {
    				dp[i] += dp[i-num];
    			} else {
    				break;
    			}
    		}
    	}
    	return dp[target];
    }

    public int combinationSum41(int[] nums, int target) {
    	if (nums == null || nums.length == 0) return 0;
    	Arrays.sort(nums);
    	return dfs(nums, target, 0, 0);
    }
    
    private int dfs(int[] nums, int target, int step, int cur) {
    	if (cur == target) {
    		return 1;
    	}
    	int res = 0;
    	for (int i = 0; i < nums.length; i++) {
    		if (nums[i]+cur > target) {
    			break;
    		}
    		res += dfs(nums, target, i, nums[i]+cur);
    	}
    	return res;
    }

    public static void main(String[] args) {
    	Solution solution = new Solution();
    }
}