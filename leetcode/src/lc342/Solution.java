package lc342;

import java.util.*;

public class Solution {

    public boolean isPowerOfThree(int n) {
        return (n > 0 && 1162261467%n == 0);
    }

    public static void main(String[] args) {
    	Solution solution = new Solution();
    	int i = 1;
    	while (i > 0) {
    		i = i*4;
    		System.out.println(i);
    	}
    }
}
