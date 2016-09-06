package lc191;

import java.util.*;

public class Solution {
    public int hammingWeight(int n) {
    	int num = 0;
    	for (int i = 0; i < 32; i++) {
    		
        	num += n&1;
        	n >>= 1;
    	}
//        while (n > 0) {
//        }
        return num;
    } 

    public static void main(String[] args) {
    	Solution solution = new Solution();
    	System.out.println(solution.hammingWeight(11));
    	System.out.println(solution.hammingWeight(-2147483648));
    }
}