package lc402;

import java.util.*;

public class Solution {

    public String removeKdigits(String num, int k) {
    	if (num.equals("")) return "0";
    	if (k == 0) return num;
    	char[] cs = num.toCharArray();
    	int t = 0;
    	for (int i = 1; i < cs.length; i++) {
			while (k > 0 && t >= 0 && cs[t] > cs[i]) {
				t--;
				k--;
			}
			cs[++t] = cs[i];
    	}
    	while (k > 0 && t >= 0) {
    		t--;
    		k--;
    	}
    	StringBuilder res = new StringBuilder();
    	int p = 0;
    	while (p <= t && cs[p] == '0') p++;
    	for (int i = p; i <= t; i++) {
    		res.append(cs[i]);
    	}
    	if (res.length() == 0) return "0";
    	else return res.toString();
    }

    public static void main(String[] args) {
    	Solution solution = new Solution();
    	solution.removeKdigits("", 0);
    }
}