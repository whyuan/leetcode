package lc94;

import common.TreeNode;
import java.util.*;

public class Solution {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		if (root != null) {
			if (root.left != null) {
				result.addAll(inorderTraversal(root.left));
			}
			result.add(root.val);
			if (root.right != null) {
				result.addAll(inorderTraversal(root.right));
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		// solution.inorderTraversal(a);
	}
}
