package lc275;

import java.util.*;

public class Solution {
    public int hIndex(int[] citations) {
    	if (citations == null || citations.length == 0) return 0;
    	int h = 0, t = citations.length;
    	while (h < t) {
    		int m = h+(t-h)/2;
    		if (citations[m] >= citations.length-m) {
    			t = m;
    		} else {
    			h = m+1;
    		}
    	}
    	return citations.length-h;
    }

    public static void main(String[] args) {
    	Solution solution = new Solution();
    	System.out.println(solution.hIndex(new int[]{1,1,1,1,56}));
    }
}
