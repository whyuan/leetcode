package lc396;

import java.util.*;

public class Solution {
	
    public int maxRotateFunction(int[] A) {
        if (A == null || A.length == 0) return 0;
        int sum = 0;
        int f = 0;
        for (int i = 0; i < A.length; i++) {
        	sum += A[i];
        	f += i*A[i];
        }
        int last = A.length-1;
        int max = f;
        for (int i = 0; i < A.length-1; i++) {
        	f = f+sum-(A.length)*A[last--];
        	max = max>f?max:f;
        }
        return max;
    }

    public static void main(String[] args) {
    	Solution solution = new Solution();
    }
}