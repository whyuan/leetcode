package lc115;

public class Solution {
    public int numDistinct(String s, String t) {
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        int[][] f = new int[ct.length+1][cs.length+1];
        for (int i = 0; i <= cs.length; i++) {
        	f[0][i] = 1;
        }
        for (int i = 0; i < ct.length; i++) {
        	for (int j = 0; j < cs.length; j++) {
        		f[i+1][j+1] = f[i+1][j];
        		if (ct[i] == cs[j]) f[i+1][j+1] += f[i][j];
        	}
        }
        return f[ct.length][cs.length];
    }
    
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	System.out.println(solution.numDistinct("rabbbit", "rabbit"));
    }
}
