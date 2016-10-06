package lc376;

import java.util.*;

public class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        int a = nums[0];
        int d = 0;
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
        	int d0 = d;
        	if (d == 0) {
        		if (nums[i] > a) {
        			d = 1;
        		} else if (nums[i] < a) {
        			d = -1;
        		}
        	} else if (d == 1 && nums[i] < a) {
        		d = -1;
        	} else if (d == -1 && nums[i] > a) {
        		d = 1;
        	}
        	if (d0 != d) res++;
        	a = nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
    	Solution solution = new Solution();
    }
}