package lc337;

import common.TreeNode;
import java.util.*;

public class Solution {

	private Map<TreeNode, Integer> map = new HashMap<>();
    public int rob(TreeNode root) {
    	if (root == null) return 0;
    	if (root.val < 0) return -root.val;
    	int a = rob(root.left) + rob(root.right);
    	int b = root.val + ((root.left!=null)?(rob(root.left.left)+rob(root.left.right)):0) + ((root.right!=null)?(rob(root.right.left)+rob(root.right.right)):0);
    	int result = a>b?a:b;
    	root.val = -result;
    	return result;
    }

    public static void main(String[] args) {
    	Solution solution = new Solution();
    }
}
