package lc315;

import java.util.*;

public class Solution {

    public List<Integer> countSmaller(int[] nums) {
        if (nums.length == 0) return new ArrayList<Integer>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
        	min = nums[i]<min?nums[i]:min;
        }
        int[] nums1 = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
        	nums1[i] = nums[i]-min+1;
        	max = nums1[i]>max?nums1[i]:max;
        }
        int[] tree = new int[max+1];
        List<Integer> result = new ArrayList<Integer>();
        for (int i = nums1.length-1; i >= 0; i--) {
        	result.add(0, get(nums1[i]-1, tree));
        	update(nums1[i], tree);
        }
        return result;
    }
    
    private int get(int i, int[] tree) {
    	int result = 0;
    	while (i > 0) {
    		result += tree[i];
    		i -= (i&(-i));
    	}
    	return result;
    }
    
    private void update(int i, int[] tree) {
    	while (i < tree.length) {
    		tree[i]++;
    		i += (i&(-i));
    	}
    }

    public static void main(String[] args) {
    	Solution solution = new Solution();
    }
}
