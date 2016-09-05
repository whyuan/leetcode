package lc174;

import java.util.*;

public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
    	if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) return 0;
    	int l0 = dungeon.length, l1 = dungeon[0].length;
    	int[][] f = new int[l0+1][l1+1];
    	int[][] accu = new int[l0+1][l1+1];
    	for (int i = 0; i < l0+1; i++) {
    		f[i][0] = 1;
    		accu[i][0] = 1;
    	}
    	for (int i = 0; i < l1+1; i++) {
    		f[0][i] = 1;
    		accu[i][0] = 1;
    	}
    	for (int i = 1; i < l0+1; i++) {
    		for (int j = 1; j < l1+1; j++) {
    			int prevI = i-1, prevJ = j;
    			if (f[i-1][j] > f[i][j-1]) {
    				prevI = i;
    				prevJ = j-1;
    			}
				if (accu[prevI][prevJ] + dungeon[i-1][j-1] <= 0) {
					f[i][j] = f[prevI][prevJ] + 1 - (accu[prevI][prevJ] + dungeon[i-1][j-1]);
					accu[i][j] = 1;
				} else {
					f[i][j] = f[prevI][prevJ];
					accu[i][j] = accu[prevI][prevJ] + dungeon[i-1][j-1];
				}
    		}
    	}
    	return f[l0][l1];
    }
    
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	System.out.println(solution.calculateMinimumHP(new int[][]{{-2,-3,3},{-5,-10,1},{10,30,-5}}));
    }
}