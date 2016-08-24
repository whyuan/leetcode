package lc35;

public class Solution {
    public int searchInsert(int[] nums, int target) {
    	if (nums.length <= 0) return 0;
    	int l = 0, r = nums.length, m;
    	while (l < r) {
    		m = (l+r)/2;
    		if (nums[m] >= target) {
    			r = m;
    		} else {
    			l = m+1;
    		}
    	}
    	return l;
    }
    
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	System.out.println(solution.searchInsert(new int[]{1,2,3,4,5}, 0));
    	System.out.println(solution.searchInsert(new int[]{1,2,3,4,5}, 1));
    	System.out.println(solution.searchInsert(new int[]{1,2,3,3,5}, 3));
    	System.out.println(solution.searchInsert(new int[]{1,2,3,4,5}, 5));
    	System.out.println(solution.searchInsert(new int[]{1,2,3,4,5}, 6));
    }
}
