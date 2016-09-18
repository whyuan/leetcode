package lc257;

import common.TreeNode;
import java.util.*;

import common.TreeNode;

public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
	if (root == null) return new ArrayList<String>();
	return dfs(root, new ArrayList<TreeNode>(), new ArrayList<String>());
    }

    private List<String> dfs(TreeNode root, List<TreeNode> cur, List<String> result) {
	if (root == null) return result;
	if (root.left == null && root.right == null) {
            cur.add(root);
	    StringBuilder s = new StringBuilder();
	    for (int i = 0; i < cur.size(); i++) {
                s.append(cur.get(i).val);
		if (i != cur.size()-1) {
		    s.append("->");
		}
	    }
	    result.add(s.toString());
	    cur.remove(root);
	    return result;
	}
	cur.add(root);
	dfs(root.left, cur, result);
	dfs(root.right, cur, result);
	cur.remove(cur.size()-1);
	return result;
    }

    public static void main(String[] args) {
    }
}
