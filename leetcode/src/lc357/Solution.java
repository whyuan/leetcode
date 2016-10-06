package lc357;

import java.util.*;

public class Solution {

    public int countNumbersWithUniqueDigits(int n) {
    	if (n <= 0) return 1;
    	if (n > 10) n = 10;
    	int ans = 10;
    	int cur = 9;
    	int step = 9;
    	while (n > 1) {
    		cur = cur * step--;
    		ans += cur;
    		n--;
    	}
    	return ans;
    }

    public static void main(String[] args) {
    	Solution solution = new Solution();
    }

}
