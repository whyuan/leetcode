package lc53;

public class Solution {

    public int maxSubArray(int[] nums) {
    	if (nums.length <= 0) return 0;
    	int[] sums = new int[nums.length+1];
    	sums[0] = 0;
    	for (int i = 1; i < sums.length; i++) {
    		sums[i] = sums[i-1] + nums[i-1];
    	}
    	int min = sums[0], result = sums[1];
    	for (int i = 2; i < sums.length; i++) {
    		if (sums[i-1] < min) {
    			min = sums[i-1];
    		}
    		if (sums[i]-min > result) {
    			result = sums[i]-min;
    		}
    	}
    	return result;
    }

	public static void main(String[] args) {
//		[-2,1,-3,4,-1,2,1,-5,4]	
		Solution solution = new Solution();
		System.out.println(solution.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
		System.out.println(solution.maxSubArray(new int[]{0,0}));
		System.out.println(solution.maxSubArray(new int[]{0}));
		System.out.println(solution.maxSubArray(new int[]{}));
		System.out.println(solution.maxSubArray(new int[]{-1,0,0,-34}));
	}
}
