package lc201;

import java.util.*;

public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
    	int d = n - m;
    	int step = 0, result = m, tail = 0, cur = 1;
    	while (step < 31 && cur <= m) {
    		int t = (cur)&m;
    		if (t > 0 && d < t-tail) {
    			return result;
    		}
    		tail |= t;
    		result = result - t;
    		step++;
    		cur = 1<<step;
    	}
    	return result;
    }

    public static void main(String[] args) {
    	Solution solution = new Solution();
    }
}