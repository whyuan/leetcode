package lc33;

public class Solution {
    public int search(int[] nums, int target) {
    	if (nums.length <= 0 ) return -1;
    	int l = 0, r = nums.length, m;
    	while (l < r-1) {
    		m = (l+r)/2;
    		if (nums[m] >= nums[l]) {
    			l = m;
    		} else {
    			r = m;
    		}
    	}
    	int maxP = l;
    	l = binarySearch(nums, 0, maxP+1, target);
    	if (l < maxP+1 && nums[l] == target) {
    		return l;
    	} else if (maxP+1 < nums.length) {
    		l = binarySearch(nums, maxP+1, nums.length, target);
    		if (l < nums.length && nums[l] == target) {
    			return l;
    		}
    	}
    	return -1;
    }
    
    private int binarySearch(int[] nums, int l, int r, int target) {
    	int m;
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
    	System.out.println(solution.search(new int[]{3,4,5,6,1,2}, 4));
    	System.out.println(solution.search(new int[]{3,4,5,6,1,2}, 1));
    	System.out.println(solution.search(new int[]{3,4,5,6,1,2}, 7));
    	System.out.println(solution.search(new int[]{3,4,5,6,1,2}, 0));
    	System.out.println(solution.search(new int[]{6,6,6,6,6,6,6,6}, 6));
    }
}
