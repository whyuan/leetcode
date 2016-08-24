package lc41;

public class Solution {
    public int firstMissingPositive(int[] nums) {
    	int temp;
    	for (int i = 0; i < nums.length; i++) {
    		if (nums[i] > 0 && nums[i] < nums.length && nums[nums[i]-1] != nums[i]) {
    			temp = nums[nums[i]-1];
    			nums[nums[i]-1] = nums[i];
    			nums[i] = temp;
    			i--;
    		}
    	}
    	for (int i = 0; i < nums.length; i++) {
    		if (nums[i] != i+1) {
    			return i+1;
    		}
    	}
    	return nums.length+1;
    }
    
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	System.out.println(solution.firstMissingPositive(new int[]{2,3,2,2,2,0}));
    	System.out.println(solution.firstMissingPositive(new int[]{2,-3,-2,1,2,2,0}));
    }
}