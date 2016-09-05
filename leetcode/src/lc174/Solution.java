package lc174;

import java.util.*;

public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
    	if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) return 0;
    	int l0 = dungeon.length, l1 = dungeon[0].length;
    	int[][] f = new int[l0][l1];
    	f[l0-1][l1-1] = Math.min(dungeon[l0-1][l1-1], 0);
    	for (int i = l0-2; i >= 0; i--) {
    		f[i][l1-1] = Math.min(f[i+1][l1-1]+dungeon[i][l1-1], 0);
    	}
    	for (int i = l1-2; i >= 0; i--) {
    		f[l0-1][i] = Math.min(f[l0-1][i+1]+dungeon[l0-1][i], 0);
    	}
    	for (int i = l0-2; i >= 0; i--) {
    		for (int j = l1-2; j >= 0; j--) {
    			int preI = i+1, preJ = j;
    			if (f[i+1][j] < f[i][j+1]) {
    				preI = i;
    				preJ = j+1;
    			}
//    			accu[i][j] = accu[preI][preJ]+dungeon[i][j];
    			f[i][j] = Math.min(f[preI][preJ]+dungeon[i][j], 0);
    		}
    	}
    	return 1-f[0][0];
    }
    
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	System.out.println(solution.calculateMinimumHP(new int[][]{{-2,-3,3},{-5,-10,1},{10,30,-5}}));
    }
}