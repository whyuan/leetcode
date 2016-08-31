package lc128;

import java.util.*;

public class Solution {
    public int longestConsecutive(int[] nums) {
    	if (nums == null || nums.length == 0) return 0;
    	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    	int max = 0;
    	for (int num : nums) {
    		if (!map.containsKey(num)) {
    			int leftNum = map.containsKey(num-1)?map.get(num-1):0;
    			int rightNum = map.containsKey(num+1)?map.get(num+1):0;
    			int total = leftNum + rightNum + 1;
    			if (total > max) max = total;
    			map.put(num, 1);
    			map.put(num-leftNum, total);
    			map.put(num+rightNum, total);
    		}
    	}
    	return max;
    }
    
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	System.out.println(solution.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    	System.out.println(solution.longestConsecutive(new int[]{1}));
    	System.out.println(solution.longestConsecutive(new int[]{4,0,-4,-2,2,5,2,0,-8,-8,-8,-8,-1,7,4,5,5,-4,6,6,-3}));
    }
}
