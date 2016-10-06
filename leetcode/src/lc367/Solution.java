package lc367;

import java.util.*;

public class Solution {

    public boolean isPerfectSquare(int num) {
    	if (num <= 0) return false;
    	int root = 0, bit = 1 << 15;
    	while (bit > 0) {
    		root |= bit;
    		if (root > num/root) {
    			root ^= bit;
    		}
    		bit >>= 1;
    	}
    	return root * root == num;
    }

    public boolean isPerfectSquare1(int num) {
        if (num <= 0) return false;
        if (num == 1) return true;
        long h = 1, t = num;
        while (h < t) {
        	long m = h+(t-h)/2;
        	long m2 = m*m;
        	if (m2 < num) {
        		h = m+1;
        	} else if (m2 > num) {
        		t = m;
        	} else if (m2 == num) {
        		return true;
        	}
        }
        return h*h==num;
    }

    public static void main(String[] args) {
    	Solution solution = new Solution();
    	solution.isPerfectSquare(808201);
    }

}
