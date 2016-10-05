package lc327;

import java.util.*;

public class Solution {

    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] sums = new long[nums.length+1];
        for (int i = 0; i < sums.length-1; i++) {
        	sums[i+1] = sums[i] + nums[i];
        }
        return countAndMergeSort(sums, 0, sums.length, lower, upper);
    }
    
    private int countAndMergeSort(long[] sums, int h, int t, int lower, int upper) {
    	if (h+1 >= t) return 0;
    	int m = h+(t-h)/2;
    	int count = countAndMergeSort(sums, h, m, lower, upper) + countAndMergeSort(sums, m, t, lower, upper);
    	long[] newSums = new long[t-h];
    	int r = m;
    	for (int i = h, j = m, k = m, step = 0; i < m; i++) {
    		while (j < t && sums[j]-sums[i] < lower) j++;
    		while (k < t && sums[k]-sums[i] <= upper) k++;
    		while (r < t && sums[i] >= sums[r]) newSums[step++] = sums[r++];
    		newSums[step++] = sums[i];
    		count += k-j;

    	}
    	System.arraycopy(newSums, 0, sums, h, r-h);
    	return count;
    }

    public static void main(String[] args) {
    	Solution solution = new Solution();
    }
}
