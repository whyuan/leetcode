package lc300;

import java.util.*;

public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] pre = new int[nums.length];
        int size = 0;
        for (int i = 0; i < nums.length; i++) {
        	int cur = nums[i];
        	int h = 0, t = size;
        	while (h < t) {
        		int m = h+(t-h)/2;
        		if (pre[m] > cur) {
        			t = m;
        		} else if (pre[m] == cur) {
        			break;
        		} else {
        			h = m+1;
        		}
        	}
        	if (h == size) pre[size++] = cur;
        	else pre[h] = Math.min(pre[h], cur);
        }
        return size;
    }

    public static void main(String[] args) {
    	Solution solution = new Solution();
    }
}
