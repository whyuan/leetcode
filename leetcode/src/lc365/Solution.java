package lc365;

import java.util.*;

public class Solution {

    public boolean canMeasureWater(int x, int y, int z) {
    	if (x + y == z || x == z || y == z) return true;
        if (z > x + y || x == 0 || y == 0) return false;
        int a = x<y?gcd(x, y):gcd(y, x);
        return (z % a == 0);
    }
    
    private int gcd(int x, int y) {
    	if (y%x == 0) return x;
    	else return gcd(y%x, x);
    }

    public static void main(String[] args) {
    	Solution solution = new Solution();
    }

}
