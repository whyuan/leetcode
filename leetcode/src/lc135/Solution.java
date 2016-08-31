package lc135;

import java.util.*;

public class Solution {
    public int candy(int[] ratings) {
    	if (ratings == null || ratings.length == 0) return 0;
    	int step = 0;
    	int[] f = new int[ratings.length];
    	int[] h = new int[ratings.length];
    	f[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
        	if (ratings[i] > ratings[i-1]) f[i] = f[i-1]+1;
        	else f[i] = 1;
        }
        h[ratings.length-1] = 1;
        for (int i = ratings.length-2; i >= 0; i--) {
        	if (ratings[i] > ratings[i+1]) h[i] = h[i+1]+1;
        	else h[i] = 1;
        }
        int sum = 0;
        for (int i = 0; i < ratings.length; i++) {
        	if (f[i] > h[i]) {
        		sum += f[i];
        	} else {
        		sum += h[i];
        	}
        }
        return sum;
    }
    
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	System.out.println(solution.candy(new int[]{1,2,3,1}));
    }
}
