package lc55;

public class Solution {
    public boolean canJump(int[] nums) {
    	int max = 0;
        for (int i = 0; i < nums.length; i++) {
        	if (i+nums[i] >= max) {
        		max = i+nums[i];
        		if (max >= nums.length-1) {
        			return true;
        		}
        	}
        	if (max==i) {
        		return false;
        	}
        }
        return false;
    }
    
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	System.out.println(solution.canJump(new int[]{3,2,1,0,1}));
    	System.out.println(solution.canJump(new int[]{3,2,1,1,1}));
    	System.out.println(solution.canJump(new int[]{0}));
    	System.out.println(solution.canJump(new int[]{1}));
    }
}
