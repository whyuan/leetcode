package lc301;

import java.util.*;

public class Solution {
    public List<String> removeInvalidParentheses(String s) {
    	if (s == null) return null;
    	List<String> result = new ArrayList<String>();
        removeInvalidParentheses(s, result, 0, 0, new char[]{'(', ')'});
        return result;
    }
    
    private void removeInvalidParentheses(String s, List<String> result, int lastI, int lastJ, char[] ws) {
    	for (int i = lastI, stack = 0; i < s.length(); i++) {
    		if (s.charAt(i) == ws[0]) stack++;
    		if (s.charAt(i) == ws[1]) stack--;
    		if (stack >= 0) continue;
    		for (int j = lastJ; j <= i; j++) {
    			if (s.charAt(j) == ws[1] && (j == lastJ || s.charAt(j-1) != ws[1])) {
    				removeInvalidParentheses(s.substring(0, j)+s.substring(j+1, s.length()), result, i, j, ws);
    			}
    		}
    		return;
    	}
    	String reverse = (new StringBuilder(s)).reverse().toString();
    	if (ws[0] == '(') {
    		removeInvalidParentheses(reverse, result, 0, 0, new char[]{')', '('});
    	} else {
    		result.add(reverse);
    	}
    }

    public static void main(String[] args) {
    	Solution solution = new Solution();
    }
}
