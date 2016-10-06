package lc372;

import java.util.*;

public class Solution {

    public int superPow(int a, int[] b) {
    	if (a % 1337 == 0) return 0;
    	int p = 0;
        for (int i : b) {
        	p = (p*10+i)%1140;
        }
        if (p == 0) p = 1140;
        return pow(a, p);
    }
    
    private int pow(int a, int p) {
    	a %= 1337;
    	int res = 1;
    	while (p > 0) {
    		if ((p&1) == 1) res = res * a % 1337;
    		a = a * a % 1337;
    		p >>= 1;
    	}
    	return res;
    }

    public static void main(String[] args) {
    	Solution solution = new Solution();
    }

}
