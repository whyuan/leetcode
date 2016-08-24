package lc65;

public class Solution {
    public boolean isNumber(String s) {
    	boolean checkDot = false;
    	boolean checkSpace = false;
    	boolean checkE = false;
    	boolean checkNum = false;
    	boolean checkSign = false;
    	int l = s.length();
    	for (int i = 0; i < l; i++) {
    		char c = s.charAt(i);
    		if (c == ' ') {
    			if (!checkSpace) {
    				continue;
    			} else {
    				for (int j = i+1; j < l; j++) {
    					if (s.charAt(j) != ' ') return false;
    				}
    				return true;
    			}
    		} else if (c >= '0' && c <= '9') {
    			if (!checkSpace) checkSpace = true;
    			checkNum = true;
    		} else if (c == '.') {
    			if (!checkSpace) checkSpace = true;
    			if (checkDot || checkE) {
    				return false;
    			} else {
    				checkDot = true;
    				if (!checkNum && (i < l-1 && !(s.charAt(i+1) >= '0' && s.charAt(i+1) <= '9'))) {
    					return false;
    				}
    			}
    		} else if (c == 'e') {
    			if (!checkSpace) checkSpace = true;
    			if (checkE || !checkNum) {
    				return false;
    			} else {
    				checkE = true;
    				if (i == l-1 || !(s.charAt(i+1) >= '0' && s.charAt(i+1) <= '9')) {
    					return false;
    				}
    			}
    		} else if (c == '-' || c == '+') {
    			if (!checkSpace) checkSpace = true;
    			if (checkSign) {
    				return false;
    			} else {
    				checkSign = true;
    				if (i < l-1 && !(s.charAt(i+1) >= '0' && s.charAt(i+1) <= '9' || s.charAt(i+1) == '.')) {
    					return false;
    				}
    			}
    		} else {
    			return false;
    		}
    	}
    	return checkNum;
    }
    
    public static void main(String[] args) {
    	Solution solution = new Solution();
//    	"0" => true
//    			" 0.1 " => true
//    			"abc" => false
//    			"1 a" => false
//    			"2e10" => true
    	System.out.println(solution.isNumber(" 005047e+6"));//true
    	System.out.println(solution.isNumber("+.8"));//true
    	System.out.println(solution.isNumber("-1.5e"));//false
    	System.out.println(solution.isNumber("-1. "));//true
    	System.out.println(solution.isNumber(". ")); // false
    	System.out.println(solution.isNumber("3.")); // true
    	System.out.println(solution.isNumber("e9")); // false
    	System.out.println(solution.isNumber(" ")); // false
    	System.out.println(solution.isNumber(".")); // false
    	System.out.println(solution.isNumber("4")); // true
    	System.out.println(solution.isNumber("e")); // false
    	System.out.println(solution.isNumber("0")); // true
    	System.out.println(solution.isNumber(" 0.1 ")); // true
    	System.out.println(solution.isNumber("abc")); // false
    	System.out.println(solution.isNumber("1 a")); // false
    	System.out.println(solution.isNumber("2e10")); // true
    	System.out.println(solution.isNumber("2.0e10")); // true
    	System.out.println(solution.isNumber("20e1.0")); // false
    }
}
