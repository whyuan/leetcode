package lc214;

import java.util.*;

public class Solution {
	public String shortestPalindrome(String s) {
    	if (s == null || s.length() == 0) return "";
    	StringBuilder sb = new StringBuilder();
    	String sReversed = sb.append(s).reverse().toString();
    	char[] cs = (s+"#"+sReversed+"#").toCharArray();
    	int[] nexts = new int[cs.length];
    	nexts[0] = -1;
    	int t = -1;
    	for (int i = 0; i < nexts.length-1; i++) {
    		while (t >= 0 && cs[t] != cs[i]) t = nexts[t];
    		nexts[i+1] = ++t;
    	}
    	return sReversed.substring(0, sReversed.length()-nexts[nexts.length-1])+s;
	}

    public String shortestPalindrome1(String s) {
    	if (s == null || s.length() == 0) return "";
        char[] cs = s.toCharArray();
        StringBuilder head = new StringBuilder();
        for (int j = cs.length-1; j >= 0; j--) {
        	int h = 0, t = j;
        	while (cs[h] == cs[t] && h < t) {
        		h++;
        		t--;
        	}
        	if (h >= t) {
        		return head.append(s).toString();
        	} else {
        		head.append(cs[j]);
        	}
        }
        return "";
    }

    public static void main(String[] args) {
    	Solution solution = new Solution();
    	System.out.println(solution.shortestPalindrome("aaab"));
    	System.out.println(solution.shortestPalindrome("aacecaaa"));
    	System.out.println(solution.shortestPalindrome(""));
    	System.out.println(solution.shortestPalindrome("a"));
    	System.out.println(solution.shortestPalindrome("aaa"));
    }
}