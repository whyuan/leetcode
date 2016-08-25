package lc101;

import common.TreeNode;

import java.util.*;

public class Solution {
	public boolean isSymmetric(TreeNode root) {
		if (root == null) return true;
		else {
			List<TreeNode> stack0 = new ArrayList<TreeNode>(), stack1 = new ArrayList<TreeNode>();
			stack0.add(root.left);
			stack1.add(root.right);
			while (stack0.size() > 0) {
				TreeNode root0 = stack0.remove(stack0.size()-1);
				TreeNode root1 = stack1.remove(stack1.size()-1);
				if (!(root0 == null && root1 == null)) {
					if (root0 == null || root1 == null) return false;
					else if (root0.val != root1.val) return false;
					else {
						if (root0.left != null || root1.right != null) {
							stack0.add(root0.left);
							stack1.add(root1.right);
						}
						if (root0.right != null || root1.left != null) {
							stack0.add(root0.right);
							stack1.add(root1.left);
						}
					}
				}
			}
		}
		return true;
	}


    public boolean isSymmetric0(TreeNode root) {
        if (root == null) return true;
        else return f(root.left, root.right);
    }
    
    private boolean f(TreeNode root0, TreeNode root1) {
    	if (root0 == null && root1 == null) return true;
    	else if (root0 == null || root1 == null) return false;
    	else if (root0.val != root1.val) return false;
    	else return (f(root0.left, root1.right) && f(root0.right, root1.left));
    }
}
