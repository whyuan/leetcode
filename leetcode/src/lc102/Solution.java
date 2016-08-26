package lc102;

import common.TreeNode;
import java.util.*;

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        dfs(result, root, 0);
        return result;
    }
    
    private void dfs(List<List<Integer>> result, TreeNode root, int depth) {
    	if (root == null) {
    		return;
    	} else {
    		if (depth >= result.size()) {
    			result.add(new ArrayList<Integer>());
    		}
    		List<Integer> a = result.get(depth);
    		a.add(root.val);
    		dfs(result, root.left, depth+1);
    		dfs(result, root.right, depth+1);
    	}
    }
    
    public static void main(String[] args) {
    }
}
