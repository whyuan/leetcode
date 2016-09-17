package lc239;

import java.util.*;

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
    	if (nums == null) return null;
    	int[] result = new int[nums.length-k+1];
        if (k == 0 || nums.length == 0) return new int[]{};
        List<Integer> pos = new ArrayList<Integer>();
        for (int i = 0; i < k; i++) {
        	if (pos.size() == 0) {
        		pos.add(i);
        	} else {
        		pos = this.add(pos, i, k, nums);
        	}
        }
        result[0] = nums[pos.get(0)];
        for (int i = k; i < nums.length; i++) {
        	if (pos.get(0) == i-k) {
        		pos.remove(0);
        	}
        	pos = this.add(pos, i, k, nums);
        	result[i-k+1] = nums[pos.get(0)];
        }
        return result;
    }
    
    private List<Integer> add(List<Integer> pos, int p, int k, int[] nums) {
    	while (!pos.isEmpty() && nums[pos.get(pos.size()-1)] <= nums[p]) {
    		pos.remove(pos.size()-1);
    	}
    	pos.add(p);
		return pos;
    }

    public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.maxSlidingWindow(new int[]{7,2,4}, 2));
    }
}