package lc96;

public class Solution {
    public int numTrees(int n) {
    	if (n == 0) return 0;
    	int[] f = new int[n+1];
    	f[0] = 1;
        for (int i = 1; i <= n; i++) {
        	for (int j = 0; j < i; j++) {
        		f[i] += f[j]*f[i-j-1];
        	}
        }
        return f[n];
    }
    
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	System.out.println(solution.numTrees(3));
    	System.out.println(solution.numTrees(2));
    	System.out.println(solution.numTrees(1));
    	System.out.println(solution.numTrees(0));
    }
}
