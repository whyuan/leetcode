package lc140;

import java.util.*;

public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
    	if (wordDict == null || wordDict.size() == 0 || s == null) return new ArrayList<String>();
    	boolean[] b = new boolean[s.length()+1];
//    	String[][] ss = new String[s.length()+1][];
    	List<List<String>> ss = new ArrayList<List<String>>();
    	b[0] = true;
    	for (int i = 1; i < b.length; i++) {
    		ss.add(new ArrayList<String>());
    		boolean flag = false;
    		for (int j = i-1; j >= 0; j--) {
    			if (b[j] && wordDict.contains(s.substring(j,i))) {
    				b[i] = true;
    				ss.get(i-1).add(s.substring(j,i));
    			}
    		}
    	}
    	return wordBreak(new ArrayList<String>(), new ArrayList<String>(), ss, s.length()-1);
    }
    
    private List<String> wordBreak(List<String> cur, List<String> result, List<List<String>> ss, int pos) {
    	if (pos < 0) {
    		String curS = "";
    		boolean isFirst = true;
    		for (String a : cur) {
    			curS = a + (isFirst?"":" ") + curS;
    			isFirst = false;
    		}
    		result.add(curS);
    	} else {
    		List<String> sList = ss.get(pos);
    		for (String as : sList) {
    			cur.add(as);
    			wordBreak(cur, result, ss, pos-as.length());
    			cur.remove(cur.size()-1);
    		}
    	}
    	return result;
    }
    
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	Set<String> wordDict = new HashSet<String>();
//    	["cat", "cats", "and", "sand", "dog"]
    	wordDict.add("cat");
    	wordDict.add("cats");
    	wordDict.add("and");
    	wordDict.add("sand");
    	wordDict.add("dog");
    	System.out.println(solution.wordBreak("catsanddog", wordDict));
    }
}
