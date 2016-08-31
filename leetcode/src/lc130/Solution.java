package lc130;

public class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;
        int l0 = board.length, l1 = board[0].length;
        boolean[][] visited = new boolean[l0][l1];
        for (int i = 0; i < l1; i++) {
        	dye(board, 0, i, visited);
        	if (l0 > 1) dye(board, l0-1, i, visited);
        }
        for (int i = 1; i < l0-1; i++) {
        	dye(board, i, 0, visited);
        	if (l1 > 1) dye(board, i, l1-1, visited);
        }
        for (int i = 0; i < l0; i++) {
        	for (int j = 0; j < l1; j++) {
        		if (!visited[i][j] && board[i][j] == 'O') {
        			board[i][j] = 'X';
        		}
        	}
        }
    }

    private void dye(char[][] board, int x, int y, boolean[][] visited) {
    	if (board[x][y] == 'X') return;
    	visited[x][y] = true;
    	if (x+1 <= board.length-2 && visited[x+1][y] == false && board[x+1][y] == 'O') {
    		dye(board, x+1, y, visited);
    	}
    	if (x-1 >= 1 && visited[x-1][y] == false && board[x-1][y] == 'O') {
    		dye(board, x-1, y, visited);
    	}
    	if (y+1 <= board[0].length-2 && visited[x][y+1] == false && board[x][y+1] == 'O') {
    		dye(board, x, y+1, visited);
    	}
    	if (y-1 >= 1 && visited[x][y-1] == false && board[x][y-1] == 'O') {
    		dye(board, x, y-1, visited);
    	}
    }
    
    public static void main(String[] args) {
    }

}
