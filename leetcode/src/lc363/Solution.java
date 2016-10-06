package lc363;

import java.util.*;

public class Solution {

    public int maxSumSubmatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length==0 || matrix[0].length==0) return 0;
        int n = Math.min(matrix.length, matrix[0].length);
        int m = Math.max(matrix.length, matrix[0].length);
        boolean isCol = matrix[0].length>matrix.length;
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
        	int[] sum = new int[m];
        	for (int j = i; j >= 0; j--) {
        		TreeSet<Integer> tree = new TreeSet<Integer>();
        		int val = 0;
        		tree.add(0);
        		for (int k = 0; k < m; k++) {
        			sum[k] = sum[k]+(isCol?matrix[j][k]:matrix[k][j]);
        			val += sum[k];
        			Integer a = tree.ceiling(val-target);
        			if (a != null) {
        				ans = Math.max(ans, val-a);
        				if (ans == target) return ans;
        			}
        			tree.add(val);
        		}
        	}
        }
        return ans;
    }

    public static void main(String[] args) {
    	Solution solution = new Solution();
    }

}
