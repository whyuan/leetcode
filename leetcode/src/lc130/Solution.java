package lc130;

import java.util.*;

public class Solution {
	private int[][] d = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    public void solve(char[][] board) {
    	if (board == null || board.length == 0 || board[0].length == 0) return;
        boolean[][] visited = new boolean[board.length][board[0].length];
        int l0 = board.length, l1 = board[0].length;
        int step = 0, x = 0, y = 0;
        while (x >= 0 && x < l0 && y >= 0 && y < l1) {
        	if (!visited[x][y] && board[x][y] == 'O') {
        		List<Integer> xs = new ArrayList<Integer>();
        		List<Integer> ys = new ArrayList<Integer>();
        		int h = 0, t = 1;
        		xs.add(x);
        		ys.add(y);
        		while (h < t) {
        			int x1 = xs.get(h);
        			int y1 = ys.get(h);
					visited[x1][y1] = true;
					for (int i = 0; i < d.length; i++) {
						int newX = x1 + d[i][0], newY = y1 + d[i][1];
						if (newX >= 0 && newX < l0 && newY >= 0 && newY < l1 && board[newX][newY] == 'O'
								&& visited[newX][newY] == false) {
							xs.add(newX);
							ys.add(newY);
							t++;
						}
					}
					h++;
        		}
        	}
        	if (x+d[step][0] >= l0 || x+d[step][0] < 0 || y+d[step][1] >= l1 || y+d[step][1] < 0) step = (step+1)%d.length;
        	x = x + d[step][0];
        	y = y + d[step][1];
        	if (x == 0 && y == 0) break;
        }
        for (int i = 0; i < l0; i++) {
        	for (int j = 0; j < l1; j++) {
        		if (!visited[i][j] && board[i][j] == 'O') {
        			board[i][j] = 'X';
        		}
        	}
        }
    }
    
    private void dye(char[][] board, int x, int y, boolean[][] visited, int l0, int l1) {
    	if (board[x][y] == 'X') return;
    	visited[x][y] = true;
    	for (int i = 0; i < d.length; i++) {
    		int newX = x+d[i][1], newY = y+d[i][0];
    		if (newX >= 0 && newX < l0 && newY >= 0 && newY < l1 && board[newX][newY] == 'O' && visited[newX][newY] == false) {
    			dye(board, newX, newY, visited, l0, l1);
    		}
    	}
    }
    
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	solution.solve(new char[][]{{'X'}});
    	System.out.println();
    }
}
