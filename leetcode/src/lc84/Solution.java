package lc84;

import java.util.Arrays;
import java.util.List;

public class Solution {
    public int largestRectangleArea(int[] heights) {
    	if (heights == null || heights.length == 0) return 0;
        int[] stack = new int[heights.length];
        int t = 0;
        int max = 0;
        for (int i = 0; i <= heights.length; i++) {
        	while (t > 0 && (i == heights.length || heights[i] <= heights[stack[t-1]])) {
        		int x = stack[t-1];
        		int x0 = t>1?stack[t-2]:(-1);
        		int area = heights[x]*(i-1-x0);
        		if (area > max) {
        			max = area;
        		}
        		t--;
        	}
        	stack[t++] = i;
        }
        return max;
    }
    
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	System.out.println(solution.largestRectangleArea(new int[]{2,1,5,6,2,1}));
    	System.out.println(solution.largestRectangleArea(new int[]{}));
    }
}
