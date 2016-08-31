package lc129;

import common.TreeNode;
import java.util.*;

public class Solution {
    public int sumNumbers(TreeNode root) {
    	sum = 0;
        sumNumbers(root, 0);
        return sum;
    }
    
    private int sum = 0;
    private void sumNumbers(TreeNode root, int cur) {
    	if (root == null) return;
    	if (root.left == null && root.right == null) {
    		cur = cur*10+root.val;
    		sum += cur;
    	} else {
    		sumNumbers(root.left, cur*10+root.val);
    		sumNumbers(root.right, cur*10+root.val);
    	}
    }
}
