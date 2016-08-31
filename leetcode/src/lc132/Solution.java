package lc132;

import java.util.*;

public class Solution {
    public int minCut(String s) {
    	if (s == null || s.length() == 0) return 0;
        char[] cs = s.toCharArray();
        int[] f = new int[cs.length+1];
        boolean[][] b = new boolean[cs.length][cs.length];
        for (int i = 0; i < f.length; i++) {
        	f[i] = i-1;
        }
        for (int i = 0; i < cs.length; i++) {
        	for (int j = 0; j <= i; j++) {
        		if (cs[i] == cs[j] && (i-1 < j+1 || b[i-1][j+1])) {
        			b[i][j] = true;
        			f[i+1] = Math.min(f[i+1], 1+f[j]);
        		}
        	}
        }
        return f[cs.length];
    }

    
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	System.out.println(solution.minCut("cbaa"));
    	System.out.println(solution.minCut("abaa"));
    	System.out.println(solution.minCut("aaaa"));
    	System.out.println(solution.minCut("aab"));
    	System.out.println(solution.minCut("ab"));
    	System.out.println(solution.minCut("b"));
    }
}
