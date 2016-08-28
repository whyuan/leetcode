package lc114;

import common.TreeNode;

public class Solution {
	private TreeNode preElement = null;
    public void flatten(TreeNode root) {
    	if (root == null) return;
    	preElement = root;
    	flatten(root.left);
    	TreeNode leftLastElement = preElement;
    	flatten(root.right);
//    	TreeNode rightLastElement = preElement;
    	if (leftLastElement != root) {
			leftLastElement.right = root.right;
			root.right = root.left;
			root.left = null;
    	}
    }
}
