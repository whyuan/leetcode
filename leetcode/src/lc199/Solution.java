package lc199;

import common.TreeNode;
import java.util.*;

public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
    	List<Integer> result = new ArrayList<Integer>();
    	if (root == null) return result;
    	else return dfs(root, 0, result);
    }
    
    private List<Integer> dfs(TreeNode root, int depth, List<Integer> result) {
    	if (depth >= result.size()) {
    		result.add(root.val);
    	}
    	if (root.right != null) {
    		dfs(root.right, depth+1, result);
    	}
    	if (root.left != null) {
    		dfs(root.left, depth+1, result);
    	}
    	return result;
    }

    public static void main(String[] args) {
    	Solution solution = new Solution();
//    	System.out.println(solution.rightSideView(null));
    }
}