package lc120;

import java.util.*;

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
    	if (triangle.size() == 0 || triangle.get(triangle.size()-1).size() == 0) return 0;
    	int[] sums = new int[triangle.get(triangle.size()-1).size()+1];
        for (int i = triangle.size()-1; i >= 0; i--) {
        	List<Integer> cur = triangle.get(i);
        	for (int j = 0; j < i+1; j++) {
				sums[j] = Math.min(sums[j], sums[j + 1]) + cur.get(j);
        	}
        }
        return sums[0];
    }
}
