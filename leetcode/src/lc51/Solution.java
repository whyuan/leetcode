package lc51;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	public List<List<String>> solveNQueens(int n) {
		List<List<String>> result = new ArrayList<List<String>>();
		char[][] board = new char[n][n];
		for (int i = 0; i < board.length; i++) {
			Arrays.fill(board[i], '.');
		}
		int[] pos = new int[n];
		dfs(result, board, pos, 0);
		return result;
	}
	
	private void dfs(List<List<String>> result, char[][] board, int[] pos, int step) {
		if (step >= board.length) {
			String[] as = new String[board.length];
			for (int i = 0; i < board.length; i++) {
				as[i] = String.valueOf(board[i]);
			}
			result.add(Arrays.asList(as));
		} else {
			for (int i = 0; i < board.length; i++) {
				boolean flag = true;
				for (int j = step-1; j >= 0; j--) {
					if ((pos[j] == i || pos[j]-i==step-j || pos[j]-i==j-step)) {
						flag = false;
						break;
					}
				}
				if (!flag) continue;
				pos[step] = i;
				board[step][i] = 'Q';
				dfs(result, board, pos, step+1);
				board[step][i] = '.';
				pos[step] = -1;
			}
		}
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.solveNQueens(4));
	}
}
