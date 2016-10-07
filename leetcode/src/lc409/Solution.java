package lc409;

import java.util.*;

public class Solution {
	
    public int longestPalindrome(String s) {
        char[] cs = s.toCharArray();
        int[] count = new int[52];
        int res = 0;
        for (int i = 0; i < cs.length; i++) {
        	int index = cs[i]-((cs[i]>='a' && cs[i]<='z')?'a':'A'-26);
        	if (count[index] == 0) count[index] = 1;
        	else {
        		count[index] = 0;
        		res += 2;
        	}
        }
        for (int i = 0; i < count.length; i++) {
        	if (count[i] > 0) {
        		return res+1;
        	}
        }
        return res;
    }

    public static void main(String[] args) {
    	Solution solution = new Solution();
    }
}