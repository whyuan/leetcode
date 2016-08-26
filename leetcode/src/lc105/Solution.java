package lc105;

import common.TreeNode;

public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    	if (preorder == null || inorder == null) return null; 
    	return buildTree(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }
    
    private TreeNode buildTree(int[] preorder, int h0, int t0, int[] inorder, int h1, int t1) {
    	if (h0 == t0) return null;
    	if (h0 == t0-1) return new TreeNode(preorder[h0]);
    	int val = preorder[h0];
    	TreeNode newNode = new TreeNode(val);
    	for (int i = h1; i < t1; i++) {
    		if (inorder[i] == val) {
    			newNode.left = buildTree(preorder, h0+1, h0+i-h1+1, inorder, h1, i);
    			newNode.right = buildTree(preorder, h0+i-h1+1, t0, inorder, i+1, t1);
    			return newNode;
    		}
    	}
    	return null;
    }
}
