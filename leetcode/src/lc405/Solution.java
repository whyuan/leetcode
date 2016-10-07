package lc405;

import java.util.*;

public class Solution {

    public String toHex(int num) {
    	if (num == 0) return "0";
    	char[] cs = new char[]{'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
    	char[] sb = new char[8];
        for (int i = 0; i < 8; i++) {
        	sb[i] = cs[num&0xF];
        	num >>= 4;
        }
        StringBuilder res = new StringBuilder();
        int p = 7;
        while (sb[p] == '0') p--;
        while (p>=0) res.append(sb[p--]);
        return res.toString();
    }

    public static void main(String[] args) {
    	Solution solution = new Solution();
    }
}