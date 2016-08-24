package lc48;

public class Solution {
    public void rotate(int[][] matrix) {
        int l = matrix.length/2;
        int[] temp0;
        for (int i = 0; i < l; i++) {
        	temp0 = matrix[i];
        	matrix[i] = matrix[matrix.length-i-1];
        	matrix[matrix.length-i-1] = temp0;
        }
        for (int i = 1; i < matrix.length; i++) {
        	for (int j = 0; j < i; j++) {
        		int temp = matrix[i][j];
        		matrix[i][j] = matrix[j][i];
        		matrix[j][i] = temp;
        	}
        }
    }
    
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	int[][] matrix = {{1,2,3},{1,3,4},{3,4,5}};
//    	int[][] matrix = {};
    	solution.rotate(matrix);
    	System.out.println(matrix);
    }
}
