package lc230;

import common.TreeNode;
import java.util.*;

public class Solution {
    public boolean isPowerOfTwo(int n) {
    	while (n > 0) {
    		if ((n&1) == 1) {
    			if (n > 1) return false;
    			else return true;
    		}
    		n = n>>1;
    	}
    	return false;
    }

    public static void main(String[] args) {
    }
}