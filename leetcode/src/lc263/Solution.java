package lc263;

import java.util.*;

public class Solution {
    public boolean isUgly(int num) {
	if (num <= 0) return false;
	if (num == 1) return true;
	int a = 2, b = 3, c = 5;
	while (num > 1) {
            boolean flag = false;
	    if (num / a * a == num) { num /= a; flag = true; }
	    if (num / b * b == num) { num /= b; flag = true; }
	    if (num / c * c == num) { num /= c; flag = true; }
	    if (!flag) return false;
	}
	return true;
    } 

    public static void main(String[] args) {
	Solution solution = new Solution();
    }
}
