package lc173;

import common.TreeNode;
import java.util.*;

public class BSTIterator {
	private class Node {
		public TreeNode treeNode;
		public int step;
		public Node(TreeNode treeNode, int step) {
			this.treeNode = treeNode;
			this.step = step;
		}
	}
	private Stack<Node> stack = new Stack<Node>();

    public BSTIterator(TreeNode root) {
    	if (root != null) {
    		stack.push(new Node(root, 0));
    	}
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return (stack.size() > 0);
    }

    /** @return the next smallest number */
    public int next() {
    	while (stack.size() > 0) {
    		Node cur = stack.pop();
    		if (cur.step == 0) {
    			cur.step = 1;
    			stack.push(cur);
    			if (cur.treeNode.left != null) {
    				stack.push(new Node(cur.treeNode.left, 0));
    			}
    		} else if (cur.step == 1) {
    			int result = cur.treeNode.val;
    			cur.step = 2;
    			if (cur.treeNode.right != null) {
    				stack.push(new Node(cur.treeNode.right, 0));
    			}
    			return result;
    		}
    	}
    	return 0;
    }
    
    public static void main(String[] args) {
    	TreeNode a = new TreeNode(1);
    	TreeNode b = new TreeNode(2);
    	TreeNode c = new TreeNode(3);
    	a.left = b;
    	a.right = c;
    	BSTIterator i = new BSTIterator(a);
    	while (i.hasNext()) System.out.println(i.next());
    }
}