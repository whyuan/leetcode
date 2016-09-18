package lc260;

import java.util.*;

public class Solution {
    public int[] singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) return new int[]{0, 0};
        int x = 0, y = 0;
        for (int i = 0; i < nums.length; i++) {
        	x = x ^ nums[i];
        }
        int a = 1;
        while ((x & a) == 0) {
        	a <<= 1;
        }
        x = 0;
        for (int i = 0; i < nums.length; i++) {
        	if ((nums[i] & a) > 0) {
        		x = x ^ nums[i];
        	} else {
        		y = y ^ nums[i];
        	}
        }
        return new int[]{x, y};
    }

    public static void main(String[] args) {
		Solution solution = new Solution();
    }
}