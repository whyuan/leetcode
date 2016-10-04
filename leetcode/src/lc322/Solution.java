package lc322;

import java.util.*;

public class Solution {
	
    public int coinChange(int[] coins, int amount) {
        int[] amounts = new int[amount+1];
        Arrays.fill(amounts, Integer.MAX_VALUE);
        amounts[0] = 0;
        for (int coin : coins) {
        	for (int i = coin; i < amounts.length; i++) {
        		if (amounts[i-coin] != Integer.MAX_VALUE && amounts[i-coin]+1<amounts[i]) {
        			amounts[i] = amounts[i-coin]+1;
        		}
        	}
        }
        return amounts[amounts.length-1] != Integer.MAX_VALUE ? amounts[amounts.length-1] : -1;
    }

    public static void main(String[] args) {
    	Solution solution = new Solution();
    }
}
