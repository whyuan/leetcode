package lc227;

import java.util.*;

public class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) return;
	int step = 0;
	for (int i = 0; i < nums.length; i++) {
	    if (nums[i] != 0) {
                nums[step++] = nums[i];
	    }
	}
	for (int i = step; i < nums.length; i++) {
	    nums[i] = 0;
	}
    }

    public static void main(String[] args) {
    }
}
