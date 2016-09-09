package lc205;

import java.util.*;

public class Solution {
    public boolean isIsomorphic(String s, String t) {
    	if (s == null && t == null) return true;
    	if (s == null || t == null) return false;
    	if (s.length() != t.length()) return false;
    	if (s.length() == 0) return true;
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        int[] map = new int[257];
        boolean[] visited = new boolean[257];
        for (int i = 0; i < cs.length; i++) {
        	int index = cs[i];
        	if ((map[1+cs[i]] != 0 && map[1+cs[i]] != 1+ct[i])
        		|| (map[1+cs[i]] == 0 && visited[1+ct[i]])) {
        		return false;
        	} else if (map[1+cs[i]] == 0) {
        		map[1+cs[i]] = 1+ct[i];
        		visited[1+ct[i]] = true;
        	}
        }
        return true;
    }

    public static void main(String[] args) {
    	Solution solution = new Solution();
    	System.out.println(solution.isIsomorphic("egg", "add"));
    }
}