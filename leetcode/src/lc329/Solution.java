package lc329;

import java.util.*;

public class Solution {
	
    public int longestIncreasingPath(int[][] matrix) {
    	if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int[][] count = new int[matrix.length][matrix[0].length];
        int l0 = count.length, l1 = count[0].length;
        int max = 0;
        for (int i = 0; i < count.length; i++) {
        	for (int j = 0; j < count[0].length; j++) {
        		if (count[i][j] == 0) {
        			setCount(count, i, j, matrix, l0, l1);
        		}
        		max = Math.max(count[i][j], max);
        	}
        }
        return max;
    }
    
    private int[][] d = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    
    private void setCount(int[][] count, int i, int j, int[][] matrix, int l0, int l1) {
    	if (count[i][j] == 0) count[i][j] = 1;
    	for (int x = 0; x < 4; x++) {
			if (i+d[x][0] < l0 && i+d[x][0] >= 0 && j+d[x][1] < l1 && j+d[x][1] >= 0 && matrix[i+d[x][0]][j+d[x][1]] > matrix[i][j]) {
				if (count[i+d[x][0]][j+d[x][1]] == 0) {
					setCount(count, i+d[x][0], j+d[x][1], matrix, l0, l1);
				}
				count[i][j] = Math.max(count[i+d[x][0]][j+d[x][1]]+1, count[i][j]);
			}
    	}
    }

    public static void main(String[] args) {
    	Solution solution = new Solution();
    }
}
