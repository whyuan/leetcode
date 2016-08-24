package lc54;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
    	List<Integer> result = new LinkedList<Integer>();
    	if (matrix.length <= 0) return result;
    	int rowsL = matrix.length, colsL = matrix[0].length;
        int[][] d = {{0,1},{1,0},{0,-1},{-1,0}};
        int curD = 0;
        int x = 0, y = -1;
        int l;
        while (true) {
        	if (curD%2 == 0) l = colsL;
        	else l = rowsL;
        	if (l <= 0) break;
        	for (int i = 0; i < l; i++) {
        		x += d[curD][0];
        		y += d[curD][1];
        		result.add(matrix[x][y]);
        	}
        	curD = (curD+1)%d.length;
        	if (curD%2 == 0) colsL--;
        	else rowsL--;
        }
        return result;
    }
    
    public static void main(String[] args) {
    	Solution solution = new Solution();
//    	int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
//    	int[][] matrix = {{1},{4},{7}};
//    	int[][] matrix = {{1}};
    	int[][] matrix = {{}};
    	System.out.println(solution.spiralOrder(matrix));
//    	System.out.println(solution.spiralOrder({{1,2,3},{4,5,6},{7,8,9}}));
    }
}
