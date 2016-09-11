package lc221;

import java.util.*;

public class Solution {
    public int maximalSquare(char[][] matrix) {
    	if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
    	int l0 = matrix.length, l1 = matrix[0].length;
    	int[] highs = new int[l1];
    	int max = 0;
    	for (int i = 0; i < l0; i++) {
    		for (int j = 0; j < l1; j++) {
    			if (matrix[i][j] == '1') {
    				highs[j]++;
    			} else {
    				highs[j] = 0;
    			}
    		}
			int[] prevs = new int[l1];
			int tPrevs = -1;
    		for (int j = 0; j < l1+1; j++) {
				while (tPrevs >= 0 && highs[prevs[tPrevs]] > (j == l1 ? 0 : highs[j])) {
					 if (highs[prevs[tPrevs]] == (j - 1 - (tPrevs>0?prevs[tPrevs-1]:-1))) {
					max = Math.max(max, highs[prevs[tPrevs]] * (j - 1 - (tPrevs>0?prevs[tPrevs-1]:-1)));
					 }
					tPrevs--;
				}
				if (tPrevs < l1-1) {
					prevs[++tPrevs] = j;
				}
    		}
    	}
    	return max;
    }

    public static void main(String[] args) {
    	Solution solution = new Solution();
//    	System.out.println(solution.maximalSquare(new char[][]{{'0'}}));
//    	System.out.println(solution.maximalSquare(new char[][]{{'1', '0', '1', '0'}, {'1', '0', '1', '1'}, {'1', '0', '1', '1'}, {'1', '1', '1', '1'}}));
    	System.out.println(solution.maximalSquare(new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '1', '0', '0'}}));
    }
}