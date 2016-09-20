package lc306;

import java.util.*;

public class Solution {
    public boolean isAdditiveNumber(String num) {
        if (num == null || num.length() == 0) return false;
        char[] cn = num.toCharArray();
        for (int i = 0; i < cn.length-1; i++) {
        	for (int j = i+1; j < cn.length-1; j++) {
        		if (check(0, i, i+1, j, cn)) return true;
        		if (cn[i+1] == '0') break;
        	}
        	if (cn[0] == '0') return false;
        }
        return false;
    }
    
    private boolean check(int start0, int end0, int start1, int end1, char[] cn) {
    	if (end1 == cn.length-1) return true;
    	if (end0-start0+1>cn.length-1-end1 || end1-start1+1>cn.length-1-end1) return false;
    	char[] sum = this.getSum(start0, end0, start1, end1, cn);
    	for (int i = 0; i < sum.length; i++) {
    		if (sum[i] != cn[end1+i+1]) {
    			return false;
    		}
    	}
    	return check(start1, end1, end1+1, end1+sum.length, cn);
    }
    
    private char[] getSum(int start0, int end0, int start1, int end1, char[] cn) {
    	int l = Math.max(end0-start0+1, end1-start1+1);
    	char[] result = new char[l+1];
    	int g = 0, r = 0;
    	for (int i = 0; i < l; i++) {
    		int a = 0, x = 0, y = 0;
    		if (end0-i >= start0) x = cn[end0-i]-'0';
    		if (end1-i >= start1) y = cn[end1-i]-'0';
    		a = x+y+result[l-i];
    		result[l-i] = (char)(a%10+'0');
    		result[l-i-1] = (char)(a/10);
    	}
    	if (result[0] == 0) {
    		char[] result0 = new char[l];
    		System.arraycopy(result, 1, result0, 0, l);
    		return result0;
    	} else {
    		result[0] = (char)('0'+result[0]);
    		return result;
    	}
    }

    public static void main(String[] args) {
    	Solution solution = new Solution();
    	System.out.println(solution.isAdditiveNumber("19910011992"));
    	System.out.println(solution.isAdditiveNumber("112358"));
    	System.out.println(solution.isAdditiveNumber("199100198"));
    	System.out.println(solution.isAdditiveNumber("101"));
    	System.out.println(solution.isAdditiveNumber("1001"));
    }
}