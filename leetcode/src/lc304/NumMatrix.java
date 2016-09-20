package lc304;

import java.util.*;

public class NumMatrix {
	
	private int[][] sums;

    public NumMatrix(int[][] matrix) {
    	if (!(matrix == null || matrix.length==0 || matrix[0].length == 0)) {
    		int l0 = matrix.length, l1 = matrix[0].length;
    		sums = new int[l0][l1];
    		for (int i = 0; i < l0; i++) {
    			for (int j = 0; j < l1; j++) {
    				if (i == 0 && j == 0) sums[i][j] = matrix[i][j];
    				else if (i == 0) sums[i][j] = sums[i][j-1]+matrix[i][j];
    				else if (j == 0) sums[i][j] = sums[i-1][j]+matrix[i][j];
    				else sums[i][j] = matrix[i][j]+sums[i-1][j]+sums[i][j-1]-sums[i-1][j-1];
    			}
    		}
    	}
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (sums != null && row1 >= 0 && row2 >= row1 && row2 < sums.length && col1 >= 0 && col2 >= col1 && col2 < sums[0].length) {
        	if (row1 == 0 && col1 == 0) {
        		return sums[row2][col2];
        	} else if (row1 == 0) {
        		return sums[row2][col2]-sums[row2][col1-1];
        	} else if (col1 == 0) {
        		return sums[row2][col2]-sums[row1-1][col2];
        	} else {
        		return sums[row2][col2]+sums[row1-1][col1-1]-sums[row1-1][col2]-sums[row2][col1-1];
        	}
        }
        return 0;
    }

    public static void main(String[] args) {
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.sumRegion(1, 2, 3, 4);