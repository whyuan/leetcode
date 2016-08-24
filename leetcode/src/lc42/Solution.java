package lc42;

public class Solution {

    public int trap(int[] height) {
    	int sum = 0, highest = 0, start = 0, acum = 0, a = 0;
    	for (int i = 0; i < height.length; i++) {
    		if (height[i] >= highest) {
    			sum += (i-start-1)*highest-acum;
    			highest = height[i];
    			start = i;
    			acum = 0;
    			a = highest;
    		} else {
    			acum += height[i];
    		}
    	}
    	start = height.length-1;
    	acum = 0;
    	highest = 0;
    	for (int i = height.length-1; i >= 0; i--) {
    		if (height[i] >= highest) {
    			sum += (start-i-1)*highest-acum;
    			highest = height[i];
    			start = i;
    			acum = 0;
    			if (highest >= a) {
    				break;
    			}
    		} else {
    			acum += height[i];
    		}
    	}
    	return sum;
    }
    
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	System.out.println(solution.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    	System.out.println(solution.trap(new int[]{3,0,0,0,0,3,0,0,4,0,0,3}));
    }

}
