package lc90;

import java.util.*;

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums.length == 0) {
        	return result;
        }
        for (int i = 0; i < nums.length; i++) {
        	if (map.containsKey(nums[i])) {
        		map.put(nums[i], map.get(nums[i])+1);
        	} else {
        		map.put(nums[i], 1);
        	}
        }
        List<Integer> cur = new ArrayList<Integer>();
        dfs(result, map, cur, 0, map.keySet().toArray());
        return result;
    }
    
    private void dfs(List<List<Integer>> result, Map<Integer, Integer> map, List<Integer> cur, int step, Object[] keys) {
    	if (step == map.size()) {
    		result.add(new ArrayList<Integer>(cur));
    	} else {
    		int num = (Integer)keys[step];
    		int count = map.get(num);
    		for (int i = 0; i < count+1; i++) {
    			if (i > 0) {
    				cur.add(num);
    			}
    			dfs(result, map, cur, step+1, keys);
    		}
    		for (int i = 0; i < count; i++) {
    			cur.remove(cur.size()-1);
    		}
    	}
    }
    
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	System.out.println(solution.subsetsWithDup(new int[]{1,2}));
    }
}
