package lc189;

import java.util.*;

public class Solution {
    public void rotate(int[] nums, int k) {
    	if (nums == null || nums.length == 0 || k%nums.length == 0) return;
        int start = 0, step = 0;
        int nextPos = (start+k)%nums.length, cur = nums[start];
        while (step < nums.length) {
        	int temp = nums[nextPos];
        	nums[nextPos] = cur;
        	cur = temp;
        	if (nextPos == start) {
        		start++;
        		nextPos = (start+k)%nums.length;
        		cur = nums[start];
        	} else {
        		nextPos = (nextPos+k)%nums.length;
        	}
        	step++;
        }
    }
    
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	int[] nums = new int[]{1,2,3,4,5,6};
    	solution.rotate(nums, 4);
//    	System.out.println(solution.calculateMinimumHP(new int[][]{{-2,-3,3},{-5,-10,1},{10,30,-5}}));
    }
}