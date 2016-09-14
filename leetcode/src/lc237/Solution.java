package lc237;

import java.util.*;

public class Solution {
	public int maximalSquare(char[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
		int l0 = matrix.length, l1 = matrix[0].length;
		int[] highs = new int[l1+2];
		int max = 0;
		for (int i = 0; i < l0; i++) {
			for (int j = 0; j < l1; j++) {
				if (matrix[i][j] == '1') {
					highs[j+1]++;
				} else {
					highs[j+1] = 0;
				}
			}
			int[] prevs = new int[l1+1];
			int t = 0;
			for (int j = 1; j < highs.length; j++) {
				while (t > 0 && highs[prevs[t]] >= highs[j]) {
					int a = Math.min(highs[prevs[t]], (j-prevs[t-1]-1));
					max = Math.max(a*a, max);
					t--;
				}
				prevs[++t] = j;
			}
		}
		return max;
	}

    public static void main(String[] args) {
		Solution solution = new Solution();
		String[] ss = new String[] { "10011011", "10000100", "01110011", "00010001", "00000111", "01111111", "10010110",
				"01101110" };
		char[][] a = new char[ss.length][ss[0].length()];
		for (int i = 0; i < ss.length; i++) {
			a[i] = ss[i].toCharArray();
		}
		System.out.println(solution.maximalSquare(a));
		//    	System.out.println(solution.maximalSquare(new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '1', '0', '0'}}));
//    	System.out.println(solution.maximalSquare(new char[][]{{'0'}}));
//    	System.out.println(solution.maximalSquare(new char[][]{{'1', '0', '1', '0'}, {'1', '0', '1', '1'}, {'1', '0', '1', '1'}, {'1', '1', '1', '1'}}));
//    	System.out.println(solution.maximalSquare(new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '1', '0', '0'}}));
    }
}