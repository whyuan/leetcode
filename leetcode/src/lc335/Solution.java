package lc335;

import java.util.*;

public class Solution {

    public boolean isSelfCrossing(int[] x) {
        if (x == null || x.length < 4) return false;
        for (int i = 3; i < x.length; i++) {
        	if (x[i-1] <= x[i-3]) {
        		if (i >= 4 && x[i-2] > x[i-4]) {
					if ((i >= 5 && x[i - 1] < x[i - 3] - x[i - 5]) || (i == 4 && x[i - 1] != x[i - 3])) {
						if (x[i] >= x[i - 2])
							return true;
					} else {
						if (x[i] >= x[i - 2] - x[i - 4])
							return true;
					}
        		} else if (x[i] >= x[i-2]) {
        			return true;
        		}
        	}
        }
        return false;
    }

    public static void main(String[] args) {
    	Solution solution = new Solution();
    }
}
