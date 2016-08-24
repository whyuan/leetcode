package lc64;

public class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null) return 0;
        if (grid.length == 0) return 0;
        if (grid[0].length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        int[][] board = new int[m][n];
        board[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
        	board[i][0] = grid[i][0]+board[i-1][0];
        }
        for (int i = 1; i < n; i++) {
        	board[0][i] = grid[0][i]+board[0][i-1];
        }
        for (int i = 1; i < m; i++) {
        	for (int j = 1; j < n; j++) {
        		board[i][j] = Math.min(board[i-1][j], board[i][j-1])+grid[i][j];
        	}
        }
        return board[m-1][n-1];
    }
    
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	System.out.println(solution.minPathSum(new int[][]{{0,9,1},{0,1,0},{1,0,0}}));
    }
}
