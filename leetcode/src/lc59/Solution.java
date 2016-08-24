package lc59;

public class Solution {
	private int[][] d = {{0,1},{1,0},{0,-1},{-1,0}};
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int curD = 0, x = 0, y = -1, l, colsL = n, rowsL = n, step = 0;
        while (true) {
        	if (curD%2 == 0) l = colsL;
        	else l = rowsL;
        	if (l <= 0) break;
        	for (int i = 0; i < l; i++) {
        		x += d[curD][0];
        		y += d[curD][1];
        		result[x][y] = ++step;
        	}
        	curD = (curD+1)%d.length;
        	if (curD%2 == 0) colsL--;
        	else rowsL--;
        }
        return result;
    }
    
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	System.out.println(solution.generateMatrix(0));
    	System.out.println(solution.generateMatrix(10));
    }
}
