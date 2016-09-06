package lc187;

import java.util.*;

public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
    	List<String> result = new ArrayList<String>();
    	if (s == null || s.length() <= 10) return result;
    	char[] cs = s.toCharArray();
    	int[] rule = new int[26];
    	rule['G'-'A'] = 1;
    	rule['C'-'A'] = 2;
    	rule['T'-'A'] = 3;
    	int cur = 0;
    	long[] mark = new long[16384];
    	long[] addMark = new long[16384];
    	for (int i = 0; i < 10; i++) {
    		cur = (cur<<2)+rule[cs[i]-'A'];
    	}
    	mark[cur>>6] |= 1L<<(cur&0x3f);
    	for (int i = 10; i < cs.length; i++) {
    		cur = ((cur<<2)&0xfffff)+rule[cs[i]-'A'];
    		int index = cur>>6;
    		long bMask = 1L<<(cur&0x3f);
    		if ((mark[index]&(bMask)) > 0) {
    			if ((addMark[index]&(bMask)) == 0) {
    				addMark[index] |= (bMask);
    				result.add(s.substring(i-9, i+1));
    			}
    		} else {
    			mark[index] |= (bMask);
    		}
    	}
    	return result;
    } 

    public static void main(String[] args) {
    	Solution solution = new Solution();
    	System.out.println(solution.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCAAAAAGGGTTT"));
//    	System.out.println(solution.calculateMinimumHP(new int[][]{{-2,-3,3},{-5,-10,1},{10,30,-5}}));
    }
}