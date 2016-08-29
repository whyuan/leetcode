package lc123;

import java.util.*;

public class Solution {
    public int maxProfit(int[] prices) {
    	if (prices == null || prices.length == 0) return 0;
        int min = Integer.MAX_VALUE, max = 0, cur = 0;
        int[] f0 = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
        	if (prices[i] < min) min = prices[i];
        	if (prices[i] - min > cur) cur = prices[i] - min;
        	f0[i] = cur;
        }
        cur = 0;
        int result = f0[prices.length-1];
        for (int i = prices.length-1; i > 0; i--) {
        	if (prices[i] > max) max = prices[i];
        	if (max - prices[i] > cur) cur = max - prices[i];
        	if (cur + f0[i-1] > result) result = cur + f0[i-1];
        }
        return result;
    }
    
    public static void main(String[] args) {
    	Solution solution = new Solution();
    }
}
