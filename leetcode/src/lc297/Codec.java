package lc297;

import common.TreeNode;
import java.util.*;

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
    	if (root == null) return "";
    	List<TreeNode> q = new ArrayList<TreeNode>();
    	int h = 0, t = 1;
    	q.add(root);
    	StringBuilder s = new StringBuilder();
    	while (h < t) {
    		TreeNode cur = q.get(h);
    		s.append(cur.val).append(",");
    		TreeNode child = null;
    		for (int i = 0; i < 2; i++) {
    			if (i == 0) child = cur.left;
    			else child = cur.right;
				if (child != null) {
					s.append("" + t).append(",");
					q.add(child);
					t++;
				} else {
					s.append("0,");
				}
    		}
    		h++;
    	}
    	return s.delete(s.length()-1, s.length()).toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
    	if (data.equals("")) return null;
    	String[] ds = data.split(",");
    	int[] vals = new int[ds.length];
    	for (int i = 0; i < ds.length; i++) {
    		vals[i] = Integer.parseInt(ds[i]);
    	}
    	TreeNode[] nodes = new TreeNode[vals.length/3];
    	for (int i = 0; i < ds.length; i+=3) {
    		TreeNode newNode = null;
    		int index = i/3;
    		if (nodes[index] == null) {
    			newNode = new TreeNode(vals[i]);
    			nodes[index] = newNode;
    		} else {
    			newNode = nodes[index];
    			newNode.val = vals[i];
    		}
    		if (vals[i+1] != 0) {
    			TreeNode leftNode = new TreeNode(0);
    			newNode.left = leftNode;
    			nodes[vals[i+1]] = leftNode;
    		}
    		if (vals[i+2] != 0) {
    			TreeNode rightNode = new TreeNode(0);
    			newNode.right = rightNode;
    			nodes[vals[i+2]] = rightNode;
    		}
    	}
    	return nodes[0];
    }

    public static void main(String[] args) {
    	Codec codec = new Codec();
    	TreeNode a = new TreeNode(1);
    	TreeNode b = new TreeNode(2);
    	TreeNode c = new TreeNode(3);
    	TreeNode d = new TreeNode(4);
    	a.left = b;
    	b.left = c;
    	a.right = d;
    	System.out.println(codec.serialize(a));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
