package lc344;

import java.util.*;

public class Solution {

    public String reverseString(String s) {
    	char[] cs = s.toCharArray();
    	int l = cs.length/2;
    	for (int i = 0; i < l; i++) {
    		char c = cs[i];
    		cs[i] = cs[cs.length-i];
    		cs[cs.length-i] = c;
    	}
    	return cs.toString();
    }

    public static void main(String[] args) {
    	Solution solution = new Solution();
    }
}
