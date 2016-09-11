package lc219;

import java.util.*;

public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> aSet = new HashSet<Integer>();
        for (int i = 0; i <nums.length; i++) {
        	if (i > k) {
        		aSet.remove(nums[i-k-1]);
        	}
        	if (!aSet.add(nums[i])) return true;
        }
        return false;
    }

    public static void main(String[] args) {
    	Solution solution = new Solution();
    	System.out.println(solution.containsNearbyDuplicate(new int[]{1,1}, 1));
    }
}