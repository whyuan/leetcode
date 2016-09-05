package lc168;

import java.util.*;

public class Solution {
    public String convertToTitle(int n) {
        if (n <= 0) return "";
        StringBuilder result = new StringBuilder();
        while (n > 0) {
        	result.append((char)((n-1)%26+'A'));
        	n = (n-1)/26;
        }
        return result.reverse().toString();
    }
    
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	System.out.println(solution.convertToTitle(26));
    	System.out.println(solution.convertToTitle(10));
    	System.out.println(solution.convertToTitle(28));
    	System.out.println(solution.convertToTitle(27));
    }
}