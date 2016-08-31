package lc131;

import java.util.*;

public class Solution {
    public boolean isPalindrome(String s) {
    	if (s == null || s.length() == 0) return true;
    	int h = 0, t = s.length()-1;
    	s = s.toLowerCase();
    	while (h < t) {
    		while ((s.charAt(h) < 'a' || s.charAt(h) > 'z') && (s.charAt(h) < '0' || s.charAt(h) > '9') && h < t) {
    			h++;
    		}
    		while ((s.charAt(t) < 'a' || s.charAt(t) > 'z') && (s.charAt(t) < '0' || s.charAt(t) > '9') && h < t) {
    			t--;
    		}
    		if (h < t && s.charAt(h) == s.charAt(t)) {
    			h++;
    			t--;
    		} else if (h < t) {
    			return false;
    		}
    	}
    	return true;
    }
    
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	System.out.println(solution.isPalindrome("A man, a plan, a canal: Panama"));
    	System.out.println(solution.isPalindrome(""));
    	System.out.println(solution.isPalindrome("0P"));
    	System.out.println(solution.isPalindrome("race a car"));
    }
}
