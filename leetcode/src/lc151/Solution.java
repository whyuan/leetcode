package lc151;

import java.util.*;

public class Solution {
    public String reverseWords(String s) {
    	if (s == null) return null;
        String[] ss = s.trim().split(" ");
        StringBuilder result = new StringBuilder();
        for (int i = ss.length-1; i >= 0; i--) {
        	if (!ss[i].equals("")) {
        		result.append(ss[i]).append(" ");
        	}
        }
        return result.toString().trim();
    }

    public static void main(String[] args) {
    	Solution solution = new Solution();
    	System.out.println(solution.reverseWords("   a   b "));
    }
}