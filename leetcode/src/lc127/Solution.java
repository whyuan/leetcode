package lc127;

import java.util.*;

public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
    	Set<String> beginSet = new HashSet<String>(), endSet = new HashSet<String>();
    	beginSet.add(beginWord);
    	endSet.add(endWord);
    	wordList.remove(beginWord);
    	wordList.remove(endWord);
    	return f(beginSet, endSet, wordList, 2);
    }
    
    private int f(Set<String> beginSet, Set<String> endSet, Set<String> wordList, int step) {
    	Set<String> newSet = new HashSet<String>();
    	for (String s : beginSet) {
    		char[] cs = s.toCharArray();
    		for (int i = 0; i < cs.length; i++) {
    			char bak = cs[i];
    			for (char j = 'a'; j <= 'z'; j++) {
    				cs[i] = j;
    				String newS = String.valueOf(cs);
    				if (endSet.contains(newS)) {
    					return step;
    				} else if (wordList.contains(newS)) {
    					wordList.remove(newS);
    					newSet.add(newS);
    				}
    			}
    			cs[i] = bak;
    		}
    	}
    	if (newSet.size() == 0) return 0;
    	if (newSet.size() > endSet.size()) {
    		return f(endSet, newSet, wordList, step+1);
    	} else {
    		return f(newSet, endSet, wordList, step+1);
    	}
    }
    
    public static void main(String[] args) {
    	Solution solution = new Solution();
//    	beginWord = "hit"
//    			endWord = "cog"
//    			wordList = ["hot","dot","dog","lot","log"]
    	HashSet<String> hashSet = new HashSet<String>();
    	hashSet.add("hot");
    	hashSet.add("dot");
    	hashSet.add("dog");
    	hashSet.add("lot");
    	hashSet.add("log");
    	System.out.println(solution.ladderLength("hit", "cog", hashSet));
    	HashSet<String> hashSet1 = new HashSet<String>();
    	hashSet1.add("hot");
    	hashSet1.add("dog");
    	System.out.println(solution.ladderLength("hot", "dog", hashSet1));
    }
}
