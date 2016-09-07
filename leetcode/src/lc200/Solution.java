package lc200;

import java.util.*;

public class Solution {
    public int numIslands(char[][] grid) {
    	if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
//        return dfs(grid, 0, new char[grid.length][grid[0].length]);
    	int l0 = grid.length, l1 = grid[0].length;
    	boolean[][] visited = new boolean[l0][l1];
    	int result = 0;
    	for (int i = 0; i < l0; i++) {
    		for (int j = 0; j < l1; j++) {
    			if (!visited[i][j] && grid[i][j] == '1') {
    				dfs(i, j, visited, grid, l0, l1);
    				result++;
    			}
    		}
    	}
    	return result;
    }
    
    private void dfs(int i, int j, boolean[][] visited, char[][] grid, int l0, int l1) {
    	visited[i][j] = true;
    	if (i+1 < l0 && visited[i+1][j] == false && grid[i+1][j] == '1') {
    		dfs(i+1, j, visited, grid, l0, l1);
    	}
    	if (j+1 < l1 && visited[i][j+1] == false && grid[i][j+1] == '1') {
    		dfs(i, j+1, visited, grid, l0, l1);
    	}
    	if (i-1 >= 0 && visited[i-1][j] == false && grid[i-1][j] == '1') {
    		dfs(i-1, j, visited, grid, l0, l1);
    	}
    	if (j-1 >= 0 && visited[i][j-1] == false && grid[i][j-1] == '1') {
    		dfs(i, j-1, visited, grid, l0, l1);
    	}
    }

    public static void main(String[] args) {
    	Solution solution = new Solution();
    }
}