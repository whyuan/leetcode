package lc222;

import common.TreeNode;
import java.util.*;

public class Solution {
    public int countNodes(TreeNode root) {
    	if (root == null) return 0;
        TreeNode p = root;
        int depth = 0;
        while (p.left != null) {
        	depth++;
        	p = p.left;
        }
        int lastNum = 1<<depth;
        int l = 0, r = lastNum-1;
        while (l < r) {
        	int m = (l+r+1)/2;
        	TreeNode t = root;
        	for (int i = depth-1; i >= 0; i--) {
        		if ((m&(1<<i)) != 0) {
        			t = t.right;
        		} else {
        			t = t.left;
        		}
        	}
        	if (t == null) {
        		r = m-1;
        	} else {
        		l = m;
        	}
        }
        if (depth == 0) {
        	return 1;
        } else {
        	return ((1<<(depth))-1)+l+1;
        }
    }

    public static void main(String[] args) {
    }
}