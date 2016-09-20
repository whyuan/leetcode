package lc303;

import java.util.*;

public class NumArray {

	private int[] sums;

	public NumArray(int[] nums) {
		if (!(nums == null || nums.length == 0)) {
			sums = new int[nums.length];
			sums[0] = nums[0];
			for (int i = 1; i < nums.length; i++) {
				sums[i] = sums[i - 1] + nums[i];
			}
		}
	}

	public int sumRange(int i, int j) {
		if (sums != null && i >= 0 && i <=j && j < sums.length) {
			if (i == 0) return sums[j];
			else return sums[j]-sums[i-1];
		}
		return 0;
	}

	public static void main(String[] args) {
	}
}
