package lc299;

import java.util.*;

public class Solution {
    public String getHint(String secret, String guess) {
    	if (secret == null || guess == null) return "0A0B";
        char[] cs = secret.toCharArray();
        char[] cg = guess.toCharArray();
        int[] map = new int[10];
        int a = 0, b = 0;
        for (int i = 0; i < cs.length; i++) {
        	if (cs[i] == cg[i]) a++;
        	else {
        		if (++map[cs[i]-'0'] <= 0) b++;
        		if (--map[cg[i]-'0'] >= 0) b++;
        	}
        }
        return a+"A"+b+"B";
    }

    public static void main(String[] args) {
    	Solution solution = new Solution();
    }
}
