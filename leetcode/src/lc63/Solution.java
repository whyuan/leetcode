package lc63;

public class Solution {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if (obstacleGrid == null) return 0;
		if (obstacleGrid.length == 0) return 0;
		if (obstacleGrid[0].length == 0) return 0;
		int m = obstacleGrid.length, n = obstacleGrid[0].length;
		int[][] board = new int[m][n];
		board[0][0] = obstacleGrid[0][0]==1?0:1;
		for (int i = 1; i < m; i++) {
			if (obstacleGrid[i][0] == 1) {
				board[i][0] = 0;
			} else {
				board[i][0] = board[i-1][0];
			}
		}
		for (int i = 1; i < n; i++) {
			if (obstacleGrid[0][i] == 1) {
				board[0][i] = 0;
			} else {
				board[0][i] = board[0][i-1];
			}
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (obstacleGrid[i][j] == 1) {
					board[i][j] = 0;
				} else {
					board[i][j] = board[i-1][j]+board[i][j-1];
				}
			}
		}
		return board[m-1][n-1];
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.uniquePathsWithObstacles(new int[][]{{0,0,0},{0,1,0},{0,0,0}}));
		System.out.println(solution.uniquePathsWithObstacles(new int[][]{{0,0,1},{0,1,0},{0,0,0}}));
	}
}
