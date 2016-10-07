package lc395;

import java.util.*;

public class Solution {
	
    public int longestSubstring(String s, int k) {
    	if (s == null || s.length() == 0) return 0;
    	return doLongestSubstring(s.toCharArray(), k, 0, s.length());
    }
    
    private int doLongestSubstring(char[] cs, int k, int start, int end) {
    	if (start == end) return 0;
    	int[] count = new int[26];
    	for (int i = start; i < end; i++) {
    		count[cs[i]-'a']++;
    	}
    	int pre = start;
    	int max = 0;
    	for (int i = start; i < end; i++) {
    		if (count[cs[i]-'a'] < k) {
    			if (i > pre) {
					max = Math.max(max, doLongestSubstring(cs, k, pre, i));
    			}
    			pre = i + 1;
    		}
    	}
    	if (pre == start) return end-start;
    	else return Math.max(max, doLongestSubstring(cs, k, pre, end));
    }

    public static void main(String[] args) {
    	Solution solution = new Solution();
    }
}