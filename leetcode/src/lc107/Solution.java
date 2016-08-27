package lc107;

import common.TreeNode;
import java.util.*;

public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        return levelOrderBottom(root, 0, new ArrayList<List<Integer>>());
    }
    
    private List<List<Integer>> levelOrderBottom(TreeNode root, int depth, List<List<Integer>> result) {
    	if (root == null) return result;
    	if (depth >= result.size()) {
    		result.add(0, new ArrayList<Integer>());
    	}
    	result.get(result.size()-depth-1).add(root.val);
    	levelOrderBottom(root.left, depth+1, result);
    	levelOrderBottom(root.right, depth+1, result);
    	return result;
    }
}