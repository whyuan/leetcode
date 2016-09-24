package lc313;

import java.util.*;

public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        if (n == 0 || primes == null || primes.length == 0) return 0;
        int[] a = new int[n];
        int[] p = new int[primes.length];
        a[0] = 1;
        for (int i = 1; i < n; i++) {
        	int min = 0;
        	for (int j = 0; j < primes.length; j++) {
        		if (min == 0 || a[p[j]]*primes[j] < min) {
        			min = a[p[j]]*primes[j];
        		}
        	}
        	for (int j = 0; j < primes.length; j++) {
        		if (min == a[p[j]]*primes[j]) p[j]++;
        	}
        	a[i] = min;
        }
        return a[n-1];
    }

    public static void main(String[] args) {
    	Solution solution = new Solution();
    }
}
