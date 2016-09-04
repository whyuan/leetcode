package lc165;

import java.util.*;

public class Solution {
    public int compareVersion(String version1, String version2) {
    	String[] v1 = version1.split("\\.");
    	String[] v2 = version2.split("\\.");
    	int l1 = v1.length, l2 = v2.length;
    	while (l1 > 1 && Integer.parseInt(v1[l1-1]) == 0) {
    		l1--;
    	}
    	while (l2 > 1 && Integer.parseInt(v2[l2-1]) == 0) {
    		l2--;
    	}
    	int l = Math.min(l1, l2);
    	for (int i = 0; i < l; i++) {
    		int iv1 = Integer.parseInt(v1[i]);
    		int iv2 = Integer.parseInt(v2[i]);
    		if (iv1 < iv2) {
    			return -1;
    		} else if (iv1 > iv2) {
    			return 1;
    		}
    	}
    	if (l1 < l2) {
    		return -1;
    	} else if (l1 > l2) {
    		return 1;
    	} else {
    		return 0;
    	}
    }
    
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	System.out.println(solution.compareVersion("1.0.0", "1"));
    	System.out.println(solution.compareVersion("1.0.1", "1"));
    	System.out.println(solution.compareVersion("1.0.1", "1.2"));
    }
}