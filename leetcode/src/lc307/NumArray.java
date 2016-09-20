package lc307;

import java.util.*;

public class NumArray {
	class TreeNode {
		int start, end;
		TreeNode left, right;
		int sum;
	}
	
	private TreeNode tree;

    public NumArray(int[] nums) {
        if (!(nums == null || nums.length == 0)) {
        	tree = buildTree(nums, 0, nums.length-1);
        }
    }
    
    private TreeNode buildTree(int[] nums, int h, int t) {
    	if (h > t) {
    		return null;
    	} else if (h == t) {
    		TreeNode result = new TreeNode();
    		result.sum = nums[h];
    		result.start = h;
    		result.end = t;
    		return result;
    	} else {
    		int m = h+(t-h)/2;
    		TreeNode result0 = new TreeNode();
    		result0.start = h;
    		result0.end = t;
    		result0.left = buildTree(nums, h, m);
    		result0.right = buildTree(nums, m+1, t);
    		int leftSum = 0, rightSum = 0;
    		if (result0.left != null) leftSum = result0.left.sum;
    		if (result0.right != null) rightSum = result0.right.sum;
    		result0.sum = leftSum + rightSum;
    		return result0;
    	}
    }

    void update(int i, int val) {
    	if (tree != null) {
    		update(tree, i, val);
    	}
    }
    
    void update(TreeNode tree, int i, int val) {
    	if (tree == null) return;
    	if (i < tree.start || i > tree.end) {
    		return;
    	} else if (tree.start == tree.end && tree.start == i) {
    		tree.sum = val;
    	} else {
    		TreeNode cur = null;
    		if (tree.left != null && i <= tree.left.end) cur = tree.left;
    		else cur = tree.right;
    		update(cur, i, val);
    		int leftSum = 0, rightSum = 0;
    		if (tree.left != null) leftSum = tree.left.sum;
    		if (tree.right != null) rightSum = tree.right.sum;
    		tree.sum = leftSum + rightSum;
    	}
    }

    public int sumRange(int i, int j) {
    	if (tree != null) {
    		return sumRange(tree, i, j);
    	}
    	return 0;
    }
    
    private int sumRange(TreeNode tree, int i, int j) {
    	if (tree == null) return 0;
    	if (i < tree.start || j > tree.end) return 0;
    	else if (tree.start == i && tree.end == j) {
    		return tree.sum;
    	} else {
    		int m = tree.start+(tree.end-tree.start)/2;
    		if (i > m) return sumRange(tree.right, i, j);
    		else if (j <= m) return sumRange(tree.left, i, j);
    		else return sumRange(tree.left, i, m)+sumRange(tree.right, m+1, j);
    	}
    }
    
    public static void main(String[] args) {
    	 NumArray numArray = new NumArray(new int[]{1,3,5});
    	 System.out.println(numArray.sumRange(0, 1));
    	 System.out.println(numArray.sumRange(0, 2));
    	 System.out.println(numArray.sumRange(1, 2));
    	 System.out.println(numArray.sumRange(0, 0));
    	 System.out.println(numArray.sumRange(1, 1));
    	 System.out.println(numArray.sumRange(2, 2));
    	 numArray.update(1, 10);
    	 System.out.println(numArray.sumRange(1, 2));
    	 System.out.println(numArray.sumRange(0, 2));
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);