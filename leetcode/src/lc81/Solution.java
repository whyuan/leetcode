package lc81;

public class Solution {
    public boolean search(int[] nums, int target) {
    	if (nums.length == 0 || nums == null) return false;
        int l = 0, r = nums.length;
        while (l < r) {
        	int m = (l+r)/2;
        	if (nums[m] > nums[l]) {
        		if (target > nums[l] && target < nums[m]) r = m;
        		else if (target == nums[l] || target == nums[m]) return true;
        		else l = m+1;
        	} else if (nums[m] < nums[r-1]) {
        		if (target > nums[m] && target < nums[r-1]) l = m+1;
        		else if (target == nums[m] || target == nums[r-1]) return true;
        		else r = m;
        	} else if (nums[m] == target) {
        		return true;
        	} else {
        		if (nums[m] == nums[l]) l++;
        		else r--;
        	}
        }
        if (l >= nums.length) return false;
        else return (nums[l] == target);
    }
    
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	System.out.println(solution.search(new int[]{1,3,1,1}, 3));
    	System.out.println(solution.search(new int[]{1,2,0,1,1,1}, 0));
    	System.out.println(solution.search(new int[]{2,2,2,0}, 0));
    	System.out.println(solution.search(new int[]{2,2,2,0,2,2}, 1));
    	System.out.println(solution.search(new int[]{2,2,2,0,2,2}, 2));
    	System.out.println(solution.search(new int[]{3,4,5,6,1,2}, 1));
    	System.out.println(solution.search(new int[]{3,4,5,6,1,2}, 7));
    	System.out.println(solution.search(new int[]{3,4,5,6,1,2}, 0));
    	System.out.println(solution.search(new int[]{6,6,6,6,6,6,6,6}, 6));
    }
}
