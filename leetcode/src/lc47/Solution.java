package lc47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<List<Integer>> permuteUnique(int[] nums) {
    	Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList<Integer>();
        boolean[] visited = new boolean[nums.length];
        dfs(nums, visited, result, 0, cur);
        return result;
    }
    
    private void dfs(int[] nums, boolean[] visited, List<List<Integer>> result, int step, List<Integer>cur) {
    	if (step >= nums.length) {
    		result.add(new ArrayList<Integer>(cur));
    	} else {
    		int last = -1;
    		for (int i = 0; i < nums.length; i++) {
    			if (!visited[i] && (last == -1 || nums[last] != nums[i])) {
    				last = i;
    				cur.add(nums[i]);
    				visited[i] = true;
    				dfs(nums, visited, result, step+1, cur);
    				visited[i] = false;
    				cur.remove(cur.size()-1);
    			}
    		}
    	}
    }

    
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	System.out.println(solution.permuteUnique(new int[]{1,1,1,2}));
    }
}
