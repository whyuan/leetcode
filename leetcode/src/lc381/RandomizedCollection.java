package lc381;

import java.util.*;

public class RandomizedCollection {
	List<Integer> nums = new ArrayList<>();
	Map<Integer, Set<Integer>> locs = new HashMap<>();
	Random rand = new Random();

    /** Initialize your data structure here. */
    public RandomizedCollection() {
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
    	boolean res = false;
        nums.add(val);
        if (!locs.containsKey(val)) {
        	locs.put(val, new HashSet<Integer>());
        	res = true;
        }
        locs.get(val).add(nums.size()-1);
        return res;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!locs.containsKey(val)) {
        	return false;
        }
        int index = locs.get(val).iterator().next();
		locs.get(val).remove(index);
		if (index < nums.size()-1) {
			nums.set(index, nums.get(nums.size() - 1));
			Set<Integer> lastSet = locs.get(nums.get(index));
			lastSet.remove(nums.size() - 1);
			lastSet.add(index);
		}
        if (locs.get(val).isEmpty()) locs.remove(val);
        nums.remove(nums.size()-1);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
}