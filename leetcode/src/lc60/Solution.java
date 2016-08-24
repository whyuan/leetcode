package lc60;

public class Solution {
    public String getPermutation(int n, int k) {
    	if (n <= 0) return "";
        int[] fi = new int[n];
        fi[0] = 1;
        for (int i = 1; i < n; i++) {
        	fi[i] = fi[i-1]*(i);
        	if (fi[i] >= k) break; 
        }
        char[] ws = new char[]{'1','2','3','4','5','6','7','8','9'};
        boolean[] visited = new boolean[9];
        StringBuilder result = new StringBuilder();
        k = k-1;
        for (int i = n-1; i >= 0; i--) {
        	if (fi[i] == 0) {
        		result.append(ws[n-1-i]);
        		visited[n-1-i] = true;
        	} else {
        		int index = k/fi[i];
        		int step = 0;
        		int target = 0;
        		for (int j = 0; j < visited.length; j++) {
        			if (!visited[j]) {
        				if (index == step) {
        					target = j;
        					break;
        				}
        				step++;
        			}
        		}
        		result.append(ws[target]);
        		visited[target] = true;
        		k = k%fi[i];
        	}
        }
        return result.toString();
    }
    
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	System.out.println(solution.getPermutation(1, 1));
    }
}
