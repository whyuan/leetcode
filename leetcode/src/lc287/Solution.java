package lc287;

import java.util.*;

public class Solution {
    public int findDuplicate(int[] nums) {
    	if (nums == null || nums.length < 2) return -1;
    	int p0 = 0, p1 = 0;
    	while (true) {
    		p0 = nums[p0];
    		p1 = nums[p1];
    		p1 = nums[p1];
    		if (p0 == p1) break;
    	}
    	p0 = 0;
    	while (true) {
    		p0 = nums[p0];
    		p1 = nums[p1];
    		if (p0 == p1) break;
    	}
    	return p0;
    }

    public static void main(String[] args) {
    }
}
