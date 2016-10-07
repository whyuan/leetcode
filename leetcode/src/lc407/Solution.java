package lc407;

import java.util.*;

public class Solution {
	
	public class Cell implements Comparable<Cell>{
		public int x, y, val;
		public Cell(int x, int y, int val) {
			this.x = x;
			this.y = y;
			this.val = val;
		}
		
		@Override
		public int compareTo(Cell that) {
			return this.val - that.val;
		}
	}

    public int trapRainWater(int[][] heightMap) {
    	if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) return 0;
    	PriorityQueue<Cell> pq = new PriorityQueue<Cell>();
    	int n = heightMap.length;
    	int m = heightMap[0].length;
    	boolean[][] visited = new boolean[n][m];
    	for (int i = 0; i < n; i++) {
    		visited[i][0] = true;
    		visited[i][m-1] = true;
    		pq.add(new Cell(i, 0, heightMap[i][0]));
    		pq.add(new Cell(i, m-1, heightMap[i][m-1]));
    	}
    	for (int i = 0; i < m; i++) {
    		visited[0][i] = true;
    		visited[n-1][i] = true;
    		pq.add(new Cell(0, i, heightMap[0][i]));
    		pq.add(new Cell(n-1, i, heightMap[n-1][i]));
    	}
    	int[][] dirs = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    	int res = 0;
    	while (!pq.isEmpty()) {
    		Cell cell = pq.poll();
    		for (int[] d : dirs) {
    			int newX = cell.x+d[0];
    			int newY = cell.y+d[1];
    			if (newX>=0&&newX<n&&newY>=0&&newY<m&&!visited[newX][newY]) {
    				res += Math.max(0, cell.val-heightMap[newX][newY]);
    				pq.add(new Cell(newX, newY, Math.max(heightMap[newX][newY], cell.val)));
    				visited[newX][newY] = true;
    			}
    		}
    	}
    	return res;
    }

    public static void main(String[] args) {
    	Solution solution = new Solution();
    }
}