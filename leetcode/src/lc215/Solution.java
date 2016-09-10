package lc215;

import java.util.*;

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        return f(nums, k, 0, nums.length-1);
    }
    
    public int f(int[] nums, int k, int start, int end) {
        int h = start, t = end, temp = 0;
        int xIndex = genP(nums, start, end);
        temp = nums[xIndex];
        nums[xIndex] = nums[start];
        nums[start] = temp;
        int x = nums[start];
        while (h < t) {
        	while (h < t && x > nums[t]) t--;
        	while (h < t && x <= nums[h]) h++;
        	if (h < t) {
        		temp = nums[h];
        		nums[h] = nums[t];
        		nums[t] = temp;
        	}
        }
        nums[start] = nums[h];
        nums[h] = x;
		if (h == k - 1) {
			return nums[h];
		} else if (h < k - 1) {
			return f(nums, k, h + 1, end);
		} else {
			return f(nums, k, start, h - 1);
		}
    }

    public int genP(int[] nums, int l, int r)
    {
        int m = (l+r)/2;
        if (nums[l] > nums[r]) {
        	if (nums[r]>nums[m]) return r;
        	else return nums[l]>nums[m]?m:l;
        } else {
        	if (nums[l]>nums[m]) return l;
        	else return nums[m]>nums[r]?r:m;
        }
    }

    public static void main(String[] args) {
    	Solution solution = new Solution();
    	System.out.println(solution.findKthLargest(new int[]{-1,2,0}, 3));
    	System.out.println(solution.findKthLargest(new int[]{2,1}, 1));
    	System.out.println(solution.findKthLargest(new int[]{4,4,4,4,4,4}, 6));
    }
}