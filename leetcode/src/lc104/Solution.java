package lc104;

import common.TreeNode;

public class Solution {
    public int maxDepth(TreeNode root) {
    	if (root == null) {
    		return 0;
    	} else {
    		return 1+Math.max(maxDepth(root.left), maxDepth(root.right));
    	}
    }
}
