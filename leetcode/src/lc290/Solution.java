package lc290;

import java.util.*;

public class Solution {
    public boolean wordPattern(String pattern, String str) {
        Map<Character, String> map = new HashMap<Character, String>();
        Map<String, Character> map1 = new HashMap<String, Character>();
        char[] cs = pattern.toCharArray();
        String[] strs = str.split(" ");
        if (cs.length != strs.length) return false;
        for (int i = 0; i < cs.length; i++) {
        	if (!map.containsKey(cs[i]) && !map1.containsKey(strs[i])) {
        		map.put(cs[i], strs[i]);
        		map1.put(strs[i], cs[i]);
        	} else if (!(map.containsKey(cs[i]) && map1.containsKey(strs[i]) && map.get(cs[i]).equals(strs[i]))) {
        		return false;
        	}
        }
        return true;
    }

    public static void main(String[] args) {
    	Solution solution = new Solution();
    	System.out.println(solution.wordPattern("abba", "dog dog dog dog"));
    }
}
