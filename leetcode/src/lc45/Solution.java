package lc45;

public class Solution {
    public int jump(int[] nums) {
    	int curV = 0, curP = 0, nextP = 0;
    	for (int i = 0; i < nums.length; i++) {
    		if (i > curP) {
    			curV = curV+1;
    			curP = nextP;
    		}
			if (i + nums[i] > nextP) {
				nextP = i+nums[i];
			}
    	}
    	return curV;
    }
    
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	System.out.println(solution.jump(new int[]{2,3,1,1,4}));
    	System.out.println(solution.jump(new int[]{}));
    	System.out.println(solution.jump(new int[]{2}));
    	System.out.println(solution.jump(new int[]{2,2}));
    }
}
