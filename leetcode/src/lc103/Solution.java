package lc103;

import common.TreeNode;
import java.util.*;

public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Stack<TreeNode> q0 = new Stack<TreeNode>();
        Stack<TreeNode> q1 = new Stack<TreeNode>();
        q0.push(root);
        int depth = 0;
		List<Integer> cur = null;
		while (q0.size() > 0) {
			TreeNode head = q0.pop();
			if (head != null) {
				if (depth % 2 == 0) {
					q1.push(head.left);
					q1.push(head.right);
				} else {
					q1.push(head.right);
					q1.push(head.left);
				}
				if (depth >= result.size()) {
					result.add(new ArrayList<Integer>());
					cur = result.get(result.size() - 1);
				}
				cur.add(head.val);
			}
			if (q0.size() == 0) {
				depth++;
				Stack<TreeNode> temp = q0;
				q0 = q1;
				q1 = temp;
			}
		}
		return result;
	}
}
