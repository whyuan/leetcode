package lc312;

import java.util.*;

public class Solution {
    public int maxCoins(int[] nums) {
    	int[] nums1 = new int[nums.length+2];
    	int n = 1;
    	for (int i = 0; i < nums.length; i++) {
    		if (nums[i] > 0) {
    			nums1[n++] = nums[i];
    		}
    	}
    	nums1[0] = nums1[n++] = 1;
    	int[][] f = new int[n][n];
    	for (int k = 2; k < n; k++) {
    		for (int left = 0; left < n-k; left++) {
    			int right = left+k;
    			for (int i = left+1; i < right; i++) {
    				f[left][right] = Math.max(f[left][right], f[left][i]+f[i][right]+nums1[left]*nums1[i]*nums1[right]);
    			}
    		}
    	}
    	return f[0][n-1];
    }

    public static void main(String[] args) {
    	Solution solution = new Solution();
    }
}
