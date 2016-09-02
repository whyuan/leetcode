package lc146;

import java.util.*;

public class LRUCache {
	private int capacity;
	private Map<Integer, Integer> map;
    
    public LRUCache(int capacity) {
    	map = new LinkedCappedHashMap(capacity);
    }
    
    public int get(int key) {
    	if (map.containsKey(key)) {
    		return map.get(key);
    	}
    	return -1;
    }
    
    public void set(int key, int value) {
    	map.put(key, value);
    }
    
    private static class LinkedCappedHashMap<K,V> extends LinkedHashMap<K,V> {
    	int capacity;

    	LinkedCappedHashMap(int capacity) {
    		super(1, 1, true);
    		this.capacity = capacity;
    	}

		protected boolean removeEldestEntry(Map.Entry eldest) {
			return (size() > capacity);
		}
    	
    }
}
