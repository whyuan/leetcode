package lc122;

import java.util.*;

public class Solution {
    public int maxProfit(int[] prices) {
    	int result = 0;
    	for (int i = 0; i < prices.length-1; i++) {
    		if (prices[i+1]>prices[i]) result += prices[i+1]-prices[i];
    	}
    	return result;
    }
    
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	System.out.println(solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
