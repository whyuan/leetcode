package lc106;

import common.TreeNode;

public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
    	if (postorder == null || inorder == null) return null; 
    	return buildTree(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }
    
    private TreeNode buildTree(int[] inorder, int h0, int t0, int[] postorder, int h1, int t1) {
    	if (h0 == t0) return null;
    	if (h0 == t0-1) return new TreeNode(postorder[h1]);
    	int val = postorder[t1-1];
    	TreeNode newNode = new TreeNode(val);
    	for (int i = t0-1; i >= h0; i--) {
    		if (inorder[i] == val) {
    			newNode.left = buildTree(inorder, h0, i, postorder, h1, h1+i-h0);
    			newNode.right = buildTree(inorder, i+1, t0, postorder, h1+i-h0, t1-1);
    			return newNode;
    		}
    	}
    	return null;
    }
    
}
