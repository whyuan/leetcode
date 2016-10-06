package lc380;

import java.util.*;

public class RandomizedSet {
	List<Integer> nums = new ArrayList<>();
	Map<Integer, Integer> locs = new HashMap<>();
	Random rand = new Random();

    /** Initialize your data structure here. */
    public RandomizedSet() {
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (locs.containsKey(val)) {
        	return false;
        }
        nums.add(val);
        locs.put(val, nums.size()-1);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!locs.containsKey(val)) {
        	return false;
        }
        int index = locs.get(val);
        if (index != nums.size()) {
        	nums.set(index, nums.get(nums.size()-1));
        	locs.put(nums.get(index), index);
        }
        locs.remove(val);
        nums.remove(nums.size()-1);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
}