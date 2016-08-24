package lc85;

public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int[] heights = new int[matrix[0].length];
        int l1 = heights.length;;
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
        	for (int j = 0; j < l1; j++) {
        		if (matrix[i][j] != '0') {
        			heights[j] += 1;
        		} else {
        			heights[j] = 0;
        		}
        	}
        	int area = largestRectangleArea(heights);
        	if (area > max) max = area;
        }
        return max;
    }

    private int largestRectangleArea(int[] heights) {
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
    	System.out.println(solution.maximalRectangle(new char[][]{{1,0,1,0,0},{1,0,1,1,1},{1,1,1,1,1},{1,0,0,1,0}}));
    }
}
