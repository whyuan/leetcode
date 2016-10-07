package lc390;

import java.util.*;

public class Solution {
	
    public int lastRemaining(int n) {
    	if (n == 0) return 0;
    	else if (n == 1) return 1;
    	else {
    		return (n%2==0?n:(n-1))+2-lastRemaining(n/2)*2;
    	}
    }

    public static void main(String[] args) {
    	Solution solution = new Solution();
    }
}