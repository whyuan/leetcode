package lc347;

import java.util.*;

public class Solution {

    public List<Integer> topKFrequent(int[] nums, int k) {
    	Map<Integer, Integer> map = new HashMap<>();
    	List<Integer>[] bucket = new List[nums.length+1];
    	for (int i = 0; i < nums.length; i++) {
    		map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
    	}
    	for (Integer key : map.keySet()) {
    		Integer val = map.get(key);
    		if (bucket[val] == null) {
    			bucket[val] = new ArrayList<Integer>();
    		}
    		bucket[val].add(key);
    	}
    	List<Integer> ans = new ArrayList<Integer>();
    	for (int i = bucket.length-1; i >= 0 && ans.size() < k; i--) {
    		if (bucket[i] != null) {
    			ans.addAll(bucket[i]);
    		}
    	}
    	return ans;
    }

    public static void main(String[] args) {
    	Solution solution = new Solution();
    }
}
