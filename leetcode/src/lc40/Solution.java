package lc40;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    	List<List<Integer>> results = new LinkedList<List<Integer>>();
    	List<Integer> curResult = new LinkedList<Integer>();
    	Arrays.sort(candidates);
        dfs(candidates, target, curResult, 0, results, 0);
        return results;
    }
    
    private void dfs(int[] candidates, int target, List<Integer> curResult, int sum, List<List<Integer>> results, int step) {
    	if (step >= candidates.length || sum == target) {
    		if (sum == target) {
    			List<Integer> a = new LinkedList<Integer>(Arrays.asList(new Integer[curResult.size()]));
    			Collections.copy(a, curResult);
    			results.add(a);
    		}
    	} else {
    		int lastI = -1;
    		for (int i = step; i < candidates.length; i++) {
    			if (lastI == -1 || candidates[i] != candidates[lastI]) {
    				if (candidates[i]+sum <= target) {
    					curResult.add(candidates[i]);
    					dfs(candidates, target, curResult, candidates[i]+sum, results, i+1);
    					curResult.remove(curResult.size()-1);
    					lastI = i;
    				} else {
    					break;
    				}
    			}
    		}
    	}
    }
    
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	System.out.println(solution.combinationSum2(new int[]{}, 8));
    	System.out.println(solution.combinationSum2(new int[]{2,2,2,3,4,5,6,6,6}, 8));
    }
}