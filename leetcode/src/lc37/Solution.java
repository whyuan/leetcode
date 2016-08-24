package lc37;

public class Solution {
	private boolean[][] rows = new boolean[10][10];
	private boolean[][] cols = new boolean[10][10];
	private boolean[][] blocks = new boolean[10][10];
	private int len = 9;
	public void solveSudoku(char[][] board) {
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				if (board[i][j] != '.') {
					rows[i][board[i][j]-'0'] = true;
					cols[j][board[i][j]-'0'] = true;
					blocks[i/3*3+j/3][board[i][j]-'0'] = true;
				}
			}
		}
		dfs(board, 0);
	}
	
	private boolean dfs(char[][] board, int step) {
		if (step == totalStep) {
			return true;
		}
		int curX = step/9, curY = step%9;
		int k0;
		if (board[curX][curY] == '.') {
			for (char k = '1'; k <= '9'; k++) {
				k0 = k-'0';
				if (!rows[curX][k0] && !cols[curY][k0] && !blocks[curX/3*3+curY/3][k0]) {
					rows[curX][k0] = true;
					cols[curY][k0] = true;
					blocks[curX/3*3+curY/3][k0] = true;
					board[curX][curY] = (k);
					if (dfs(board, step+1)) {
						return true;
					} else {
						rows[curX][k0] = false;
						cols[curY][k0] = false;
						blocks[curX/3*3+curY/3][k0] = false;
					}
				}
			}
			board[curX][curY] = '.';
			return false;
		} else {
			return dfs(board, step+1);
		}
	}
	
	static int totalStep = 81;
	static int max = 0;
	public void solveSudoku0(char[][] board) {
		f(board, 0);
	}
	
	private boolean f(char[][] board, int step) {
		if (step == totalStep) {
			return true;
		}
		int curX = step/9, curY = step%9;
		if (board[curX][curY] == '.') {
			for (char k = '1'; k < '9'+1; k++) {
				board[curX][curY] = k;
				if (isValid(board, curX, curY)) {
					if (f(board, step+1)) {
						return true;
					}
				}
			}
			board[curX][curY] = '.';
			return false;
		} else {
			return f(board, step+1);
		}
	}
	
	private boolean isValid(char[][] board, int curX, int curY) {
    	int len = 9;
    	int i0, j0;
    	int mask = 0, a = curX/3*3, b = curY/3*3, c;
    	int mask0 = 0, mask1 = 0, mask2 = 0;
    	for (int i = 0; i < len; i++) {
    		if (board[curX][i] != '.') {
				if ((mask0 & (1<<(board[curX][i]-'0'))) != 0) return false;
				mask0 |= (1<<(board[curX][i]-'0'));
    		}
    		if (board[i][curY] != '.') {
				if ((mask1 & (1<<(board[i][curY]-'0'))) != 0) return false;
				mask1 |= (1<<(board[i][curY]-'0'));
    		}
			i0 = a+i/3;
			j0 = b+i%3;
			if (board[i0][j0] != '.') {
				if ((mask2 & (1<<(board[i0][j0]-'0'))) != 0) return false;
				mask2 |= (1<<(board[i0][j0]-'0'));
			}
    	}
    	return true;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
//		["..9748...","7........",".2.1.9...","..7...24.",".64.1.59.",".98...3..","...8.3.2.","........6","...2759.."]
		char[][] board = new char[][] { 
				{ '.', '.', '9', '7', '4', '8', '.', '.', '.' },
				{ '7', '.', '.', '.', '.', '.', '.', '.', '.' }, 
				{ '.', '2', '.', '1', '.', '9', '.', '.', '.' },
				{ '.', '.', '7', '.', '.', '.', '2', '4', '.' }, 
				{ '.', '6', '4', '.', '1', '.', '5', '9', '.' },
				{ '.', '9', '8', '.', '.', '.', '3', '.', '.' }, 
				{ '.', '.', '.', '8', '.', '3', '.', '2', '.' },
				{ '.', '.', '.', '.', '.', '.', '.', '.', '6' }, 
				{ '.', '.', '.', '2', '7', '5', '9', '.', '.' }};
//		char[][] board = new char[][] { 
//				{ '.', '8', '7', '6', '5', '4', '3', '2', '1' },
//				{ '2', '.', '.', '.', '.', '.', '.', '.', '.' }, 
//				{ '3', '.', '.', '.', '.', '.', '.', '.', '.' },
//				{ '4', '.', '.', '.', '.', '.', '.', '.', '.' }, 
//				{ '5', '.', '.', '.', '.', '.', '.', '.', '.' },
//				{ '6', '.', '.', '.', '.', '.', '.', '.', '.' }, 
//				{ '7', '.', '.', '.', '.', '.', '.', '.', '.' },
//				{ '8', '.', '.', '.', '.', '.', '.', '.', '.' }, 
//				{ '9', '.', '.', '.', '.', '.', '.', '.', '.' }};
		solution.solveSudoku(board);
		System.out.println(board);
	}
}
