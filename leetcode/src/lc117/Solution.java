package lc117;

import common.TreeLinkNode;

public class Solution {
    public void connect(TreeLinkNode root) {
    	dfs(root, null);
    	TreeLinkNode a = root, b;
    	while (a != null) {
    		b = a;
    		a = a.next;
    		b.next = null;
    	}
    }
    
    private void dfs(TreeLinkNode root, TreeLinkNode parent) {
    	if (root == null) return;
    	TreeLinkNode pre = null;
    	if (root.left != null) root.next = root.left;
    	else if (root.right != null) root.next = root.right;
    	if (parent != null && parent.next != root) {
    		pre = parent.next;
    		parent.next = root;
    		if (pre.next != null) {
    			root.next = pre.next;
    		}
    		pre.next = root;
    	}
    	dfs(root.left, root);
    	dfs(root.right, root);
    }
    
    public static void main(String[] args) {
    	TreeLinkNode a = new TreeLinkNode(3);
    	TreeLinkNode b = new TreeLinkNode(9);
    	TreeLinkNode c = new TreeLinkNode(20);
    	TreeLinkNode d = new TreeLinkNode(15);
    	TreeLinkNode e = new TreeLinkNode(7);
    	a.left = b;
    	a.right = c;
    	c.left = d;
    	c.right = e;
    	Solution solution = new Solution();
    	solution.connect(a);
    	System.out.println(a);
    }
}
