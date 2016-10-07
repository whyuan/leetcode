package lc392;

import java.util.*;

public class Solution {
	
    public boolean isSubsequence(String s, String t) {
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        int p0 = 0, p1 = 0;
        while (p0 < cs.length && p1 < ct.length) {
        	if (cs[p0] == ct[p1]) {
        		p0++;
        		p1++;
        	} else {
        		p1++;
        	}
        }
        return (p0 == cs.length);
    }

    public static void main(String[] args) {
    	Solution solution = new Solution();
    }
}