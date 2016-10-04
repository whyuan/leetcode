package lc321;

import java.util.*;

public class Solution {

	public int[] maxNumber(int[] nums1, int[] nums2, int k) {
		int[] ans = new int[k];
		for (int i = Math.max(0, k-nums2.length); i <= nums1.length && i <= k; i++) {
			int[] newAns = merge(maxArray(nums1, i), maxArray(nums2, k-i));
			if (isGreater(newAns, 0, ans, 0)) {
				ans = newAns;
			}
		}
		return ans;
	}
	
	private int[] merge(int[] nums0, int[] nums1) {
		int[] result = new int[nums0.length+nums1.length];
		for (int i = 0, j = 0, k = 0; i < result.length; i++) {
			result[i] = isGreater(nums0, j, nums1, k) ? nums0[j++] : nums1[k++];
		}
		return result;
	}
	
	private boolean isGreater(int[] nums0, int i, int[] nums1, int j) {
		while (i < nums0.length && j < nums1.length && nums0[i] == nums1[j]) {
			i++;
			j++;
		}
		return (j==nums1.length) || (i < nums0.length && nums0[i] > nums1[j]);
	}
	
	private int[] maxArray(int[] nums, int k) {
		int[] ans = new int[k];
		for (int i = 0, j = 0; i < nums.length; i++) {
			while (nums.length-i+j>k && j>0 && nums[i] > ans[j-1]) j--;
			if (j < k) ans[j++] = nums[i];
		}
		return ans;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
	}
}
