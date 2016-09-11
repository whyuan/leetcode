package lc220;

import java.util.*;

public class Solution {
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		TreeSet<Integer> tree = new TreeSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			Integer h = tree.higher(nums[i]-t-1);
			if (h != null && Math.abs(nums[i]-h) <= t) return true;
			tree.add(nums[i]);
			if (i >= k) tree.remove(nums[i-k]);
		}
		return false;
	}

    public static void main(String[] args) {
    	Solution solution = new Solution();
    	System.out.println(solution.containsNearbyAlmostDuplicate(new int[]{-1,2,0}, 3, 2));
    	System.out.println(solution.containsNearbyAlmostDuplicate(new int[]{2,1}, 0, 1));
    	System.out.println(solution.containsNearbyAlmostDuplicate(new int[]{4,4,4,4,4,4}, 6, 2));
    }
}