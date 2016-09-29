package lc345;

import java.util.*;

public class Solution {

    public String reverseVowels(String s) {
    	char[] cs = s.toCharArray();
    	int i = 0, j = cs.length-1;
    	String ss = "AEIOUaeiou";
    	while (i < j) {
    		while (i < j && ss.indexOf(cs[i])==-1) i++;
    		while (i < j && ss.indexOf(cs[j])==-1) j--;
    		char c = cs[i];
    		cs[i] = cs[j];
    		cs[j] = c;
    		i++;
    		j--;
    	}
    	return new String(cs);
    }

    public static void main(String[] args) {
    	Solution solution = new Solution();
    }

}
