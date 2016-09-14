package lc226;

import common.TreeNode;
import java.util.*;

public class Solution {
    public TreeNode invertTree(TreeNode root) {
    	if (root == null) return null;
    	TreeNode temp;
    	invertTree(root.left);
    	invertTree(root.right);
    	temp = root.left;
    	root.left = root.right;
    	root.right = temp;
    	return root;
    }

    public static void main(String[] args) {
    }
}