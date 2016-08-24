package lc80;

import java.util.Arrays;

public class Solution {
	public int removeDuplicates(int[] nums) {
		Arrays.sort(nums);
		int count = 0, start = 0, temp;
		for (int i = 0; i < nums.length; i++) {
			nums[start] = nums[i];
			if (i == 0 || nums[i] != nums[i-1] || (start < 2 || nums[start] != nums[start-2])) {
				start++;
			}
		}
		return start;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.removeDuplicates(new int[] { 1, 1, 1, 1, 2, 2, 3 }));
	}
}
