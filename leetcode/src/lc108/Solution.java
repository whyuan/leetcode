package lc108;

import common.TreeNode;

public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
    	return sortedArrayToBST(nums, 0, nums.length);
    }
    
    private TreeNode sortedArrayToBST(int[] nums, int h, int t) {
    	if (h >= t) return null;
    	if (h == t-1) return new TreeNode(nums[h]);
    	int i = (t-h)>>1;
    	TreeNode result = new TreeNode(nums[h+i]);
    	result.left = sortedArrayToBST(nums, h, h+i);
    	result.right = sortedArrayToBST(nums, h+i+1, t);
    	return result;
    }
    
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	solution.sortedArrayToBST(new int[]{1,2,3,4,5,6});
    }

}
