package lc400;

import java.util.*;

public class Solution {

    public int findNthDigit(int n) {
    	if (n <= 0) return 0;
    	int step = 0;
    	int a = 1;
    	int preSum = 0;
    	long sum = 0;
    	while (sum < n) {
    		step++;
    		a = a==1?9:a*10;
    		preSum = (int)sum;
    		sum += (long)step * a;
    	}
    	int b = a/9+(n-preSum-1)/(step);
    	int l = step-(n-preSum-1)%step-1;
    	while (l > 0) {
    		b /= 10;
    		l--;
    	}
    	return b%10;
    }

    public static void main(String[] args) {
    }
}