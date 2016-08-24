package lc32;

import java.util.List;

public class Solution {
    public int longestValidParentheses(String s) {
        char[] cs = s.toCharArray();
        int[] counts = new int[s.length()+1];
        int st = 0;
        int result = 0;
        for (int i = 0; i < cs.length; i++) {
        	if (cs[i] == '(') {
        		st++;
        	} else {
        		if (st > 0) {
        			counts[st-1] += 2;
        			st--;
        		} else {
        			int sum = 0;
        			st = 0;
        			while (st < counts.length && counts[st] > 0) {
        				sum += counts[st];
        				counts[st++] = 0;
        			}
        			if (sum > result) {
        				result = sum;
        			}
        			st = 0;
        		}
        	}
        }
//		if (counts[st] > 0) {
//			int sum = 0;
//			while (st > 0 && counts[st-1] > 0) { st--; }
//		}
        	int sum = 0;
			while (st < counts.length && counts[st] > 0) {
				sum += counts[st];
				counts[st++] = 0;
			}
			if (sum > result) {
				result = sum;
			}
        return result;
    }
    
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	System.out.println(solution.longestValidParentheses(")(((((()())()()))()(()))("));
    	System.out.println(solution.longestValidParentheses("()(()"));
    	System.out.println(solution.longestValidParentheses("((()))())"));
    	System.out.println(solution.longestValidParentheses("(()(((()"));
    	System.out.println(solution.longestValidParentheses("((())))()()("));
    	System.out.println(solution.longestValidParentheses("()(()"));
    	System.out.println(solution.longestValidParentheses(""));
    	System.out.println(solution.longestValidParentheses("((("));
    	System.out.println(solution.longestValidParentheses("((()"));
    	System.out.println(solution.longestValidParentheses("((())))()()("));
    }
}
