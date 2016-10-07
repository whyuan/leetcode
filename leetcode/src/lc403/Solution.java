package lc403;

import java.util.*;

public class Solution {

    public boolean canCross(int[] stones) {
    	if (stones == null || stones.length == 0) return true;
    	Map<Integer, Set<Integer>> map = new HashMap<>(stones.length);
        for (int stone : stones) {
        	map.put(stone, new HashSet<Integer>());
        }
        map.get(stones[0]).add(1);
        for (int i = 0; i < stones.length; i++) {
        	int stone = stones[i];
        	Set<Integer> cur = map.get(stone);
        	for (int interval : cur) {
        		if (stone+interval == stones[stones.length-1]) {
        			return true;
        		}
        		Set<Integer> next = map.get(stone+interval);
        		if (next != null && next != cur) {
        			if (interval-1 > 0) next.add(interval-1);
        			next.add(interval);
        			next.add(interval+1);
        		}
        	}
        }
        return false;
    }

    public static void main(String[] args) {
    	Solution solution = new Solution();
    	solution.canCross(new int[]{0,1,3,4,5,7,9,10,12});
    }
}