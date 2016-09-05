package lc152;

import java.util.*;

public class Solution {
    public int maxProduct(int[] nums) {
    	if (nums == null || nums.length == 0) return 0;
        int[] products = new int[nums.length];
        int step = 0;
        int max = getMax(nums, 1);
        max = Math.max(max, getMax(nums, -1));
        return max;
    }

    private int getMax(int[] nums, int d) {
    	int step = 0;
        int[] a = new int[2];
        int max = nums[0];
        int m = 1;
        int i = d==1?0:nums.length-1;
        int count = 0;
        while (count < nums.length) {
         	if (nums[i] > 0) {
        		if (a[step] == 0) a[step] = nums[i];
        		else a[step] *= nums[i];
        		max = Math.max(a[step], max);
        	} else if (nums[i] < 0) {
        		if (step == 0) {
        			m = nums[i];
        			step = 1;
        			max = Math.max(max, m);
        			if (a[0] != 0) {
        				max = Math.max(max, a[0]);
        			}
        			a[1] = 0;
        		} else {
        			step = 0;
        			if (a[0] == 0) {
        				if (a[1] != 0) {
        					a[0] = m*a[1]*nums[i];
        				} else {
        					a[0] = m*nums[i];
        				}
        			} else {
						if (a[1] != 0) {
							a[0] = a[0] * m * a[1] * nums[i];
						} else {
							a[0] = a[0] * m * nums[i];
						}
        			}
        			max = Math.max(max, a[step]);
        		}
        	} else {
        		max = Math.max(max, Math.max(a[step], 0));
        		a[0] = 0;
        		a[1] = 0;
        		step = 0;
        	}       	
        	i += d;
        	count++;
        }
        return max;
    }

    public static void main(String[] args) {
    	Solution solution = new Solution();
    	System.out.println(solution.maxProduct(new int[]{2,-5,-2,-4,3}));
    	System.out.println(solution.maxProduct(new int[]{6, 3, -10, 0, 2}));
    	System.out.println(solution.maxProduct(new int[]{-2, 3, -4}));
    	System.out.println(solution.maxProduct(new int[]{-2, 0, -1}));
    	System.out.println(solution.maxProduct(new int[]{2, 3}));
    	System.out.println(solution.maxProduct(new int[]{-4, -3}));
    	System.out.println(solution.maxProduct(new int[]{-2}));
    	System.out.println(solution.maxProduct(new int[]{2,3,-2,4}));
    	System.out.println(solution.maxProduct(new int[]{0,2,0,2,3,-2,4}));
    }
}