package lc389;

import java.util.*;

public class Solution {
	
    public char findTheDifference(String s, String t) {
    	char[] cs = s.toCharArray();
    	char[] ct = t.toCharArray();
    	char res = 0;
    	for (char c : cs) {
    		res ^= c;
    	}
    	for (char c : ct) {
    		res ^= c;
    	}
    	return res;
    }

    public char findTheDifference1(String s, String t) {
    	int[] count = new int[26];
    	char[] cs = s.toCharArray();
    	char[] ct = t.toCharArray();
    	for (int i = 0; i < cs.length; i++) {
    		count[cs[i]-'a']++;
    	}
    	for (int i = 0; i < ct.length; i++) {
    		count[ct[i]-'a']--;
    		if (count[ct[i]-'a'] < 0) return ct[i];
    	}
    	return 0;
    }

    public static void main(String[] args) {
    	Solution solution = new Solution();
    }
}