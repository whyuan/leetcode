package lc268;

import java.util.*;

public class Solution {
    public int missingNumber(int[] nums) {
    	if (nums == null || nums.length == 0) return 0;
    	int sum = 0;
    	for (int i = 0; i < nums.length; i++) {
    		sum += nums[i];
    	}
    	int n = nums.length;
    	int a = n*(n+1)/2;
    	return a - sum;
    }

    public static void main(String[] args) {
    }
}
