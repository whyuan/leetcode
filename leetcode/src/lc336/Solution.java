package lc336;

import java.util.*;

public class Solution {

    public List<List<Integer>> palindromePairs(String[] words) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	if (words == null || words.length <= 1) return result;
    	Map<String, Integer> map = new HashMap<>();
    	for (int i = 0; i < words.length; i++) map.put(words[i], i);
    	for (int j = 0; j < words.length; j++) {
    		String word = words[j];
    		for (int i = 0; i < word.length()+1; i++) {
    			String str0 = word.substring(0, i);
    			String str1 = word.substring(i);
    			if (isPalindrome(str0)) {
    				String str2 = (new StringBuilder(str1)).reverse().toString();
    				if (map.containsKey(str2) && map.get(str2) != j) {
    					List<Integer> a = new ArrayList<Integer>();
    					a.add(map.get(str2));
    					a.add(j);
    					result.add(a);
    				}
    			}
    			if (isPalindrome(str1) && !str1.equals("")) {
    				String str3 = (new StringBuilder(str0)).reverse().toString();
    				if (map.containsKey(str3) && map.get(str3) != j) {
    					List<Integer> b = new ArrayList<Integer>();
    					b.add(j);
    					b.add(map.get(str3));
    					result.add(b);
    				}
    			}
    		}
    	}
    	return result;
    }
    
    private boolean isPalindrome(String s) {
    	int h = 0, t = s.length()-1;
    	while (h <= t) {
    		if (s.charAt(h++) != s.charAt(t--)) return false;
    	}
    	return true;
    }

    public static void main(String[] args) {
    	Solution solution = new Solution();
    }
}
