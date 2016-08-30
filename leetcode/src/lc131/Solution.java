package lc131;

import java.util.*;

public class Solution {
    public List<List<String>> partition(String s) {
    	List<List<String>> ss = new ArrayList<List<String>>();
    	char[] cs = s.toCharArray();
    	for (int i = 0; i < cs.length; i++) {
    		List<String> cur = new ArrayList<String>();
    		ss.add(cur);
    		for (int j = 0; j <= i; j++) {
    			boolean flag = false;
    			for (int h = i-j, t = i; h <= t; h++, t--) {
    				if (cs[h] != cs[t]) {
    					flag = true;
    					break;
    				}
    			}
    			if (!flag) {
    				cur.add(s.substring(i-j, i+1));
    			}
    		}
    	}
    	return dfs(new ArrayList<List<String>>(), ss, new ArrayList<String>(), cs.length-1);
    }
    
    private List<List<String>> dfs(List<List<String>> result, List<List<String>> ss, List<String> cur, int index) {
    	if (index < 0) {
    		List<String> aResult = new ArrayList(cur);
    		Collections.reverse(aResult);
    		result.add(aResult);
    		return result;
    	} else {
    		List<String> strings = ss.get(index);
    		for (int i = 0; i < strings.size(); i++) {
    			String as = strings.get(i);
    			cur.add(as);
    			dfs(result, ss, cur, index-as.length());
    			cur.remove(cur.size()-1);
    		}
    		return result;
    	}
    }
    
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	System.out.println(solution.partition("aab"));
    }
}