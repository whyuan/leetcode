package lc229;

import java.util.*;

public class Solution {
    public List<Integer> majorityElement(int[] nums) {
    	if (nums == null) return null;
    	if (nums.length == 0) return new ArrayList<Integer>();
        int a = 0, b = 0, aCount = 0, bCount = 0;
        for (int i = 0; i < nums.length; i++) {
        	if (aCount == 0) {
        		a = nums[i];
        		aCount++;
        	} else if (a == nums[i]) {
        		aCount++;
        	} else if (bCount == 0) {
        		b = nums[i];
        		bCount++;
        	} else if (b == nums[i]) {
        		bCount++;
        	} else {
        		aCount--;
        		bCount--;
        		if (bCount != 0 && aCount == 0) {
        			int temp = bCount;
        			bCount = aCount;
        			aCount = temp;
        			temp = a;
        			a = b;
        			b = temp;
        		}
        	}
        }
        List<Integer> result = new ArrayList<Integer>();
        tryToAdd(result, nums, a, aCount);
        tryToAdd(result, nums, b, bCount);
        return result;
    }
    
    private void tryToAdd(List<Integer> result, int[] nums, int a, int aCount) {
        int count = 0;
        if (aCount > 0) {
        	for (int i = 0; i < nums.length; i++) {
        		if (nums[i] == a) count++;
        	}
        	if (count > nums.length/3) result.add(a);
        }
    }

    public static void main(String[] args) {
    	Solution solution = new Solution();
    	System.out.println(solution.majorityElement(new int[]{1,2,3,4}));
    	System.out.println(solution.majorityElement(new int[]{1,1,12,3,4}));
    	System.out.println(solution.majorityElement(new int[]{1,2}));
    	System.out.println(solution.majorityElement(new int[]{1}));
    }
}