package lc211;

import java.util.*;

class TrieNode {
	public boolean isWord;
	public TrieNode[] nexts = new TrieNode[26];
    public TrieNode() {
    }
}

public class WordDictionary {
	private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }
    // Adds a word into the data structure.
    public void addWord(String word) {
        char[] cw = word.toCharArray();
        TrieNode cur = root;
        TrieNode newNode = null;
        for (int i = 0; i < cw.length; i++) {
        	if ((newNode = cur.nexts[cw[i]-'a']) == null) newNode = new TrieNode();
        	cur.nexts[cw[i]-'a'] = newNode;
        	cur = newNode;
        }
        cur.isWord = true;
    }
    
    public boolean search(String word) {
    	char[] cw = word.toCharArray();
    	return search(cw, root, 0);
    }
    
    private boolean search(char[] cw, TrieNode cur, int step) {
    	if (step == cw.length && cur.isWord) return true;
    	for (int i = step; i < cw.length; i++) {
    		if (cw[i] == '.') {
    			for (int j = 0; j < cur.nexts.length; j++) {
    				if (cur.nexts[j] != null && search(cw, cur.nexts[j], i+1)) {
    					return true;
    				}
    			}
    			return false;
    		} else {
    			if ((cur = cur.nexts[cw[i]-'a']) == null) return false;
    		}
    	}
    	return cur.isWord;
    }


    public static void main(String[] args) {
    	 WordDictionary wordDictionary = new WordDictionary();
    	 wordDictionary.addWord("word");
    	 wordDictionary.addWord("wordd");
    	 System.out.println(wordDictionary.search("pattern"));
    	 System.out.println(wordDictionary.search("word"));
    	 System.out.println(wordDictionary.search("wor"));
    	 System.out.println(wordDictionary.search("wordd"));
    	 System.out.println(wordDictionary.search("w.rdd"));
    	 System.out.println(wordDictionary.search("....."));
    	 System.out.println(wordDictionary.search("worddd"));
    }
}