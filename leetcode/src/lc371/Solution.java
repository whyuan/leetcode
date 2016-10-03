package lc371;

import java.util.*;

public class Solution {

    public int getSum(int a, int b) {
    	int sum = a;
    	while (b != 0) {
    		sum = a ^ b;
    		b = (a & b) << 1;
    		a = sum;
    	}
    	return sum;
    }

    public static void main(String[] args) {
    	Solution solution = new Solution();
    }

}
