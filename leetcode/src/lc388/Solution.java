package lc388;

import java.util.*;

public class Solution {

    public int lengthLongestPath(String input) {
    	if (input == null || input.length() == 0) return 0;
    	char[] cs = input.toCharArray();
    	step = 0;
    	return doGetLengthLongestPath(cs, 0);
    }
    
    private int step;
    private int doGetLengthLongestPath(char[] cs, int depth) {
    	int l = 0;
    	int res = 0;
    	boolean isFile = false;
    	while (step < cs.length && (cs[step] == '\n' || cs[step] == '\t')) step++;
    	while (step < cs.length && ((cs[step] >= 'a' && cs[step] <= 'z') || ((cs[step] >= 'A' && cs[step] <= 'Z')) || cs[step] == ' ' || cs[step] == '.' || (cs[step] >= '0' && cs[step] <= '9'))) {
    		if (cs[step] == '.') isFile = true;
    		l++;
    		step++;
    	}
    	if (isFile) {
    		return l;
    	} else {
    		int max = 0;
    		while (step < cs.length && cs[step] == '\n') {
    			int l0 = 0;
    			int step0 = step;
    			while (step0 < cs.length && cs[step0] == '\n') step0++;
    			while (step0 < cs.length && cs[step0] == '\t') {
    				step0++;
    				l0++;
    			}
    			if (l0 > depth) {
    				step = step0;
    				max = Math.max(max, doGetLengthLongestPath(cs, depth+1));
    			} else {
    				break;
    			}
    		}
    		if (max > 0) {
    			return l+max+1;
    		} else {
    			return 0;
    		}
    	}
    }

    public static void main(String[] args) {
    	Solution solution = new Solution();
    	solution.lengthLongestPath("aaaa\n\taaaa");
    }
}