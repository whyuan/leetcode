package lc34;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
    	if (nums.length <= 0) {
    		return new int[]{-1, -1};
    	}
    	int l = 0, r = nums.length, m, resultl, resultr;
    	while (l < r) {
    		m = (l+r)/2;
    		if (nums[m] >= target) {
    			r = m;
    		} else {
    			l = m+1;
    		}
    	}
    	resultl = l;
    	if (!(resultl < nums.length && nums[resultl] == target)) {
    		return new int[]{-1, -1};
    	}
    	int starting = l;
    	l = l;
    	r = nums.length;
    	while (l < r) {
    		m = (l+r)/2;
    		if (nums[m] > target) {
    			r = m;
    		} else {
    			l = m+1;
    		}
    	}
    	resultr = r-1;
    	return (new int[]{resultl, resultr});
    }
    
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	System.out.println(solution.searchRange(new int[]{3,4,4,4,4,5,6}, 4));
    	System.out.println(solution.searchRange(new int[]{3,4,5,6}, 4));
    	System.out.println(solution.searchRange(new int[]{3,4,5,6}, 1));
    }
}
