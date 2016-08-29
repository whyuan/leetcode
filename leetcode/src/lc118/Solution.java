package lc118;

import java.util.*;

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < numRows; i++) {
        	Integer[] cur = new Integer[i+1];
        	List<Integer> last = null;
        	if (i > 0) {
        		last = result.get(result.size()-1);
        	}
        	for (int j = 0; j <= i; j++) {
        		if (j == 0 || j == i) {
        			cur[j] = 1;
        		} else {
        			cur[j] = last.get(j-1)+last.get(j);
        		}
        	}
        	result.add(Arrays.asList(cur));
        }
        return result;
    }
    
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	System.out.println(solution.generate(5));
    }
}
