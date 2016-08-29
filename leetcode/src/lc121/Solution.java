package lc121;

import java.util.*;

public class Solution {
    public int maxProfit(int[] prices) {
    	if (prices == null || prices.length == 0) return 0;
        int min = Integer.MAX_VALUE, result = 0;
        for (int i = 0; i < prices.length; i++) {
        	if (prices[i] < min) min = prices[i];
        	if (prices[i] - min > result) result = prices[i] - min;
        }
        return result;
    }
    
    public static void main(String[] args) {
    	Solution solution = new Solution();
    }
}
