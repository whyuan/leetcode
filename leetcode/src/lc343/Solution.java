package lc343;

import java.util.*;

public class Solution {

    public int integerBreak(int n) {
    	if (n == 0) return 0;
    	else if (n == 1) return 1;
    	else if (n == 2) return 1;
    	else if (n == 3) return 2;
    	else {
    		int ans = 1;
    		while (n > 4) {
    			n -= 3;
    			ans *= 3;
    		}
    		return (ans *= n);
    	}
    }

    public static void main(String[] args) {
    	Solution solution = new Solution();
    }
}
