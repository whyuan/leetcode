package lc134;

import java.util.*;

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || gas.length == 0 || cost == null || cost.length == 0) return -1;
        int[] f = new int[gas.length];   
        int min = Integer.MAX_VALUE, minIndex = -1;
        int sum = 0;
        for (int i = 0; i < f.length; i++) {
        	f[i] = gas[i] - cost[i];
        	sum += f[i];
        	if (sum < min) {
        		min = sum;
        		minIndex = i;
        	}
        }
        sum = 0;
        minIndex = (minIndex+1)%f.length;
        for (int i = 0; i < f.length; i++) {
//        	if (f[i]-f[0]+min >= 0) return i;
        	sum += f[(minIndex+i)%f.length];
        	if (sum < 0) return -1;
        }
        return minIndex;
    }
    
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	System.out.println(solution.canCompleteCircuit(new int[]{2}, new int[]{3}));
    }
}
