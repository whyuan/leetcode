package lc139;

import java.util.*;

public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
    	boolean[] b = new boolean[s.length()+1];
    	b[0] = true;
    	for (int i = 1; i < b.length; i++) {
    		boolean flag = false;
    		for (int j = i-1; j >= 0; j--) {
    			if (b[j] && wordDict.contains(s.substring(j,i))) {
    				flag = true;
    				break;
    			}
    		}
    		if (flag) b[i] = true;
    	}
    	return b[b.length-1];
    }
    
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	Set<String> wordDict = new HashSet<String>();
    	wordDict.add("leet");
    	wordDict.add("code");
    	System.out.println(solution.wordBreak("l1eetcode", wordDict));
    }
}
