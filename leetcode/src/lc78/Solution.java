package lc78;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	List<Integer> cur = new ArrayList<Integer>();
    	dfs(result, cur, 0, nums.length, nums);
    	return result;
    }
    
    private void dfs(List<List<Integer>> result, List<Integer> cur, int step, int targetL, int[] nums) {
    	if (step == targetL) {
    		result.add(new ArrayList<Integer>(cur));
    	} else {
    		for (int i = 0; i < 2; i++) {
    			if (i == 0) {
    				dfs(result, cur, step+1, targetL, nums);
    			} else {
    				cur.add(nums[step]);
    				dfs(result, cur, step+1, targetL, nums);
    				cur.remove(cur.size()-1);
    			}
    		}
    	}
    }
    
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	System.out.println(solution.subsets(new int[]{1,2,3}));
    }
}
