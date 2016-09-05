package lc144;

import common.TreeNode;
import java.util.*;

public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
//        return preorderTraversal(root, new ArrayList<Integer>());
    	List<Integer> result = new ArrayList<Integer>();
    	if (root == null) return result;
    	ArrayList<TreeNode> q = new ArrayList<TreeNode>();
    	ArrayList<Integer> state = new ArrayList<Integer>();
    	q.add(root);
    	state.add(0);
    	int t = 1;
    	while (t > 0) {
    		TreeNode cur = q.get(t-1);
    		Integer curState = state.get(t-1);
    		// 减少调用次数
    		if (curState == 0) {
    			result.add(cur.val);
    			state.set(t-1, curState+1);
    			t = this.deal(cur.left, t, q, state);
    		} else if (curState == 1) {
    			state.set(t-1, curState+1);
    			t = this.deal(cur.right, t, q, state);
    		} else {
    			t--;
    		}
    	}
    	return result;
    }
    
    private Integer deal(TreeNode node, Integer t, List<TreeNode> q, List<Integer> state) {
		if (node != null) {
			if (t == q.size()) {
				q.add(node);
				state.add(0);
			} else {
				q.set(t, node);
				state.set(t, 0);
			}
			t++;
		}
		return t;
    }
    
    private List<Integer> preorderTraversal(TreeNode root, List<Integer> result) {
    	if (root == null) return result;
    	result.add(root.val);
    	preorderTraversal(root.left, result);
    	preorderTraversal(root.right, result);
    	return result;
    }
    
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	TreeNode a = new TreeNode(1);
    	TreeNode b = new TreeNode(2);
    	TreeNode c = new TreeNode(3);
    	a.left = b;
    	a.right = c;
    	solution.preorderTraversal(a);
    }

}
