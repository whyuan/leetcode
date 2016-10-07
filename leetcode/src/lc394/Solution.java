package lc394;

import java.util.*;

public class Solution {
	
    public String decodeString(String s) {
        if (s == null || s.equals("")) return "";
        step = 0;
        return doDecodeString(s.toCharArray()).toString();
    }
    
    private int step;
    private StringBuilder doDecodeString(char[] cs) {
    	StringBuilder res = new StringBuilder();
    	if (step >= cs.length) return res;
		while (step < cs.length && cs[step] != ']') {
			while (step < cs.length && cs[step] != ']' && (cs[step] >= 'a' && cs[step] <= 'z')) {
				res.append(cs[step++]);
			}
			int num = 0;
			while (step < cs.length && cs[step] >= '0' && cs[step] <= '9') {
				num = num * 10 + (cs[step++] - '0');
			}
			if (step < cs.length && cs[step] == '[') {
				step++;
				StringBuilder s = doDecodeString(cs);
				for (int i = 0; i < num; i++) {
					res.append(s);
				}
			}
		}
		if (step < cs.length) step++;
		return res;
    }

    public static void main(String[] args) {
    	Solution solution = new Solution();
    }
}