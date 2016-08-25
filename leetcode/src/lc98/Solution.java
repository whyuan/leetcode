package lc98;

import common.TreeNode;

public class Solution {
	private int preVal = Integer.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
    	if (root == null) return true;
		if (!isValidBST(root.left)) {
			return false;
		}
		if (preVal > root.val)
			return false;
		preVal = root.val;
		return isValidBST(root.right);
    }
    
    public static void main(String[] args) {
    	Solution solution = new Solution();
//    	solution.isVali
    }
}
