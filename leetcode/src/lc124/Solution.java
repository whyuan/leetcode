package lc124;

import common.TreeNode;
import java.util.*;

public class Solution {
	private int maxResult = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
    	f(root);
        return maxResult;
    }
    
    private int f(TreeNode root) {
    	if (root == null) return 0;
    	int left = f(root.left);
    	int right = f(root.right);
    	int total = 0;
    	if (left > 0) total += left;
    	if (right > 0) total += right;
    	if (root.val+total > maxResult) maxResult = root.val+total;
    	int max = Math.max(left, right);
    	if (max > 0) {
    		return max+root.val;
    	} else {
    		return root.val;
    	}
    }

    public static void main(String[] args) {
    	Solution solution = new Solution();
    	TreeNode a = new TreeNode(2);
    	TreeNode b = new TreeNode(-1);
    	a.left = b;
    	System.out.println(solution.maxPathSum(a));
    }
}
