package lc354;

import java.util.*;

public class Solution {

    public int maxEnvelopes(int[][] envelopes) {
    	if (envelopes == null || envelopes.length == 0) return 0;
    	else if (envelopes.length == 1) return 1;
    	Arrays.sort(envelopes, new Comparator<int[]>() {
    		public int compare(int[] a, int[] b) {
    			if (a[0] == b[0]) {
    				return b[1] - a[1];
    			} else {
    				return a[0] - b[0];
    			}
    		}
    	});
    	int[] f = new int[envelopes.length];
    	int len = 0;
    	for (int[] envelope : envelopes) {
    		int index = Arrays.binarySearch(f, 0, len, envelope[1]);
    		if (index < 0) {
    			index = -index-1;
    		}
    		f[index] = envelope[1];
    		if (index == len) len++;
    	}
    	return len;
    }

    public static void main(String[] args) {
    	Solution solution = new Solution();
    }

}
