package lc350;

import java.util.*;

public class Solution {

    public int[] intersect(int[] nums1, int[] nums2) {
    	if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) return new int[]{};
    	if (nums1.length < nums2.length) {
    		int[] temp = nums1;
    		nums1 = nums2;
    		nums2 = temp;
    	}
    	Arrays.sort(nums1);
    	Arrays.sort(nums2);
    	int step = 0;
    	int start = 0;
    	for (int i = 0; i < nums2.length; i++) {
    		int v = nums2[i];
    		int x = search(nums1, start, nums1.length, v);
    		if (x >= 0) {
    			nums2[step++] = v;
    			start = x+1;
    		}
    	}
    	return Arrays.copyOf(nums2, step);
    }
    
    private int search(int[] nums, int start, int end, int v) {
    	while (start < end) {
    		int m = start + (end-start)/2;
    		if (nums[m] < v) {
    			start = m+1;
    		} else if (nums[m] >= v) {
    			end = m;
    		}
    	}
    	if (start >= nums.length || nums[start] != v) {
    		return -1;
    	} else {
    		return start;
    	}
    }
    

    public static void main(String[] args) {
    	Solution solution = new Solution();
    	solution.intersect(new int[]{4,7,9,7,6,7}, new int[]{5,0,0,6,1,6,2,2,4});
    }

}
