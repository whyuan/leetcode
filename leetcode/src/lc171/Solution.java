package lc171;

import java.util.*;

public class Solution {
    public int titleToNumber(String s) {
    	if (s == null) return 0;
    	char[] cs = s.toCharArray();
    	int result = 0;
    	for (int i = 0; i < cs.length; i++) {
    		result = result*26+(cs[i]-'A'+1);
    	}
    	return result;
    }
    
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	System.out.println(solution.titleToNumber("AA"));
    	System.out.println(solution.titleToNumber("AB"));
    }
}