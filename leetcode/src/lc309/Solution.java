package lc309;

import java.util.*;

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0 || prices.length == 1) return 0;
        if (prices.length == 2) return Math.max(0, prices[1]-prices[0]);
        if (prices.length == 3) return Math.max(Math.max(prices[2]-prices[1], prices[2]-prices[0]), prices[1]-prices[0]);
        int[] f0 = new int[prices.length];
        int[] f1 = new int[prices.length];
        f0[0] = -prices[0];
        for (int i = 1; i < f0.length; i++) {
        	f0[i] = Math.max(f0[i-1], -prices[i]);
        }
        int l = f1.length;
        if (f1.length % 2 == 0) l = f1.length-1;
        for (int i = 0; i < f1.length; i++) {
        	for (int j = i+1; j < f1.length; j++) {
				if (i % 2 == 0) {
					f1[j] = Math.max(f1[j-1], f0[j-1]+prices[j]);
				} else {
					f1[j] = Math.max(f1[j-1], f0[j-2]-prices[j]);
				}
        	}
        	int[] temp = f0;
        	f0 = f1;
        	f1 = temp;
        }
        return f1[f1.length-1];
    }

    public static void main(String[] args) {
    	Solution solution = new Solution();
    	System.out.println(solution.maxProfit(new int[]{1,2,3,0,2}));
    }
}
