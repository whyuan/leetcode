package lc375;

import java.util.*;

public class Solution {
    public int getMoneyAmount(int n) {
    	int[][] dp = new int[n+2][n+2];
    	for (int d = 2; d <= n; d++) {
    		for (int i = 1; i+d-1 <= n; i++) {
    			int j = i+d-1;
    			dp[i][j] = Integer.MAX_VALUE;
    			for (int k = i; k <= j; k++) {
    				dp[i][j] = Math.min(dp[i][j], k+Math.max(dp[i][k-1], dp[k+1][j]));
    			}
    		}
    	}
    	return dp[1][n];
    }
}