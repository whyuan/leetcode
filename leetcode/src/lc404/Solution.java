package lc404;

import common.TreeNode;
import java.util.*;

public class Solution {

    public int sumOfLeftLeaves(TreeNode root) {
        sum = 0;
        doSumOfLeftLeaves(root, false);
        return sum;
    }
    
    private int sum;
    private void doSumOfLeftLeaves(TreeNode root, boolean isLeft) {
    	if (root == null) return;
    	if (isLeft && root.left == null && root.right == null) sum += root.val;
    	else {
    		if (root.left != null) doSumOfLeftLeaves(root.left, true);
    		if (root.right != null) doSumOfLeftLeaves(root.right, false);
    	}
    }

    public static void main(String[] args) {
    	Solution solution = new Solution();
    }
}