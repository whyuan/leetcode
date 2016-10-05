package lc338;

import java.util.*;

public class Solution {

    public int[] countBits(int num) {
    	int[] ans = new int[num+1];
    	ans[0] = 0;
    	if (num <= 0) return ans;
    	ans[1] = 1;
    	int a = 2;
    	int b = 4;
        for (int i = 2; i <= num; i++) {
        	if (i >= b) {
        		b = b<<1;
        		a = a<<1;
        	}
        	ans[i] = ans[i-a]+1;
        }
        return ans;
    }	

    public static void main(String[] args) {
    	Solution solution = new Solution();
    }
}
