package lc188;

import java.util.*;

public class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int[] f = new int[prices.length];
        f[0] = -prices[0];
        for (int i = 1; i < f.length; i++) {
        	f[i] = Math.max(f[i-1], -prices[i]);
        }
        int max = 0;
        if (2 * k > f.length) {
        	for (int i = 1; i < f.length; i++) {
        		if (prices[i] > prices[i-1]) max += prices[i]-prices[i-1];
        	}
        } else {
			for (int i = 1; i < 2 * k; i++) {
				for (int j = 1; j < f.length; j++) {
					if (i % 2 == 0) {
						f[j] = Math.max(f[j] - prices[j], f[j - 1]);
					} else {
						f[j] = Math.max(f[j] + prices[j], f[j - 1]);
					}
					if (f[j] > max) {
						max = f[j];
					}
				}
			}
        }
        return max;
    } 

    public static void main(String[] args) {
    	Solution solution = new Solution();
    	System.out.println(solution.maxProfit(2, new int[]{3, 2, 6, 5, 0, 3}));
    	System.out.println(solution.maxProfit(2, new int[]{2, 2, 89, 0, 2}));
    	System.out.println(solution.maxProfit(4, new int[]{1,2,4,2,5,7,2,4,9,0}));
//    	System.out.println(solution.calculateMinimumHP(new int[][]{{-2,-3,3},{-5,-10,1},{10,30,-5}}));
    }
}