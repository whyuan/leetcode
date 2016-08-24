package lc79;

public class Solution {
    public boolean exist(char[][] board, String word) {
    	int l0 = board.length, l1 = board[0].length;
    	boolean[][] visited = new boolean[l0][l1];
    	for (int i = 0; i < l0; i++) {
    		for (int j = 0; j < l1; j++) {
    			if (board[i][j] == word.charAt(0)) {
    				visited[i][j] = true;
    				boolean flag = dfs(i, j, visited, 1, board, word, l0, l1);
    				visited[i][j] = false;
    				if (flag) return true;
    			}
    		}
    	}
    	return false;
    }
    
    private int[][] ds = {{0,1},{1,0},{0,-1},{-1,0}};
    private boolean dfs(int x, int y, boolean[][] visited, int step, char[][] board, String word, int l0, int l1) {
    	if (word.length() == step) {
    		return true;
    	} else {
    		for (int i = 0; i < ds.length; i++) {
    			int newX = x+ds[i][0];
    			int newY = y+ds[i][1];
    			if (newX < l0 && newY < l1 && newX >= 0 && newY >= 0 && visited[newX][newY] == false && board[newX][newY] == word.charAt(step)) {
    				visited[newX][newY] = true;
    				if (dfs(newX, newY, visited, step+1, board, word, l0, l1)) {
    					return true;
    				};
    				visited[newX][newY] = false;
    			}
    		} 
    	}
    	return false;
    }

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCB"));
	}
}
