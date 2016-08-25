package lc99;

import common.TreeNode;

public class Solution {
	private TreeNode prevVal;
    public void recoverTree(TreeNode root) {
    	f(root);
    	Integer temp = firstVal.val;
    	firstVal.val = secondVal.val;
    	secondVal.val = temp;
    }
    
    private TreeNode firstVal;
    private TreeNode secondVal;
    private void f(TreeNode root) {
        if (root == null) return;
        f(root.left);
        if (prevVal != null && prevVal.val >= root.val && firstVal == null) {
        	firstVal = prevVal;
        }
        if (prevVal != null && prevVal.val >= root.val && firstVal != null) {
        	secondVal = root;
        }
        prevVal = root;
        f(root.right);
    }
    
    public static void main(String[] args) {
    }
}
