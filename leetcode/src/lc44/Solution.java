package lc44;

public class Solution {
    public boolean isMatch(String s, String p) {
    	int sl = s.length(), pl = p.length();
    	boolean[][] f = new boolean[sl+1][pl+1];
    	char[] cs = s.toCharArray(), cp = p.toCharArray();
    	int i = 0;
    	for (int j = 0; j < pl+1; j++) {
			if (i == 0 && j == 0)
				f[i][j] = true;
			else if (i == 0 && j == 1 && cp[0] == '*')
				f[i][j] = true;
			else if (i == 0)
				f[i][j] = f[i][j - 1] && cp[j-1] == '*';
    	}
    	for (i = 1; i < sl+1; i++) {
    		for (int j = 0; j < pl+1; j++) {
    			if (j == 0) f[i][j] = false;
    			else if (cp[j-1] == '*') {
    				f[i][j] = f[i][j-1] || f[i-1][j-1] || f[i-1][j];
    			} else if (cp[j-1] == '?') {
    				f[i][j] = f[i-1][j-1];
    			} else {
    				f[i][j] = f[i-1][j-1] && (cp[j-1] == cs[i-1]);
    			}
    		}
    	}
    	return f[sl][pl];
    }
    
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	System.out.println(solution.isMatch("abefcdgiescdfimde", "ab*cd?i*de"));
    	System.out.println(solution.isMatch("aa", "?*"));
    	System.out.println(solution.isMatch("aa", "a"));
    	System.out.println(solution.isMatch("aaba", "aaba"));
    }
}
