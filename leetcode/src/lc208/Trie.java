package lc208;

import java.util.*;

class TrieNode {
	public char val;
	public ArrayList<TrieNode> nexts = new ArrayList<TrieNode>();
    // Initialize your data structure here.
    public TrieNode() {
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        char[] cw = word.toCharArray();
        insert(root, cw, 0);
    }
    
    private void insert(TrieNode root, char[] cw, int step) {
    	if (step == cw.length) {
			TrieNode endNode = new TrieNode();
			endNode.val = '$';
			root.nexts.add(endNode);
			return;
    	}
    	for (int i = 0; i < root.nexts.size(); i++) {
    		if (root.nexts.get(i).val == cw[step]) {
    			insert(root.nexts.get(i), cw, step+1);
    			return;
    		}
    	}
    	TrieNode newNode = this.buildNodes(cw, step);
    	root.nexts.add(newNode);
    }
    
    private TrieNode buildNodes(char[] cw, int step) {
    	TrieNode newNode = new TrieNode();
    	TrieNode result = newNode;
    	newNode.val = cw[step];
    	for (int i = step+1; i < cw.length; i++) {
    		TrieNode curNewNode = new TrieNode();
    		curNewNode.val = cw[i];
    		newNode.nexts.add(curNewNode);
    		newNode = curNewNode;
    	}
    	TrieNode endNode = new TrieNode();
    	endNode.val = '$';
    	newNode.nexts.add(endNode);
    	return result;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
    	char[] cw = word.toCharArray();
    	return search(root, cw, 0);
    }
    
    private boolean search(TrieNode root, char[] cw, int step) {
    	if (step == cw.length) {
    		for (int i = 0; i < root.nexts.size(); i++) {
    			if (root.nexts.get(i).val == '$') {
    				return true;
    			}
    		}
    		return false;
    	}
    	if (step == cw.length) return false;
    	for (int i = 0; i < root.nexts.size(); i++) {
    		if (cw[step] == root.nexts.get(i).val) {
    			return search(root.nexts.get(i), cw, step+1);
    		}
    	}
    	return false;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
    	char[] cw = prefix.toCharArray();
    	return startsWith(root, cw, 0);
    }
    
    private boolean startsWith(TrieNode root, char[] cw, int step) {
    	if (step == cw.length) return true;
    	if (root.val == '$') return false;
    	for (int i = 0; i < root.nexts.size(); i++) {
    		if (cw[step] == root.nexts.get(i).val) {
    			return startsWith(root.nexts.get(i), cw, step+1);
    		}
    	}
    	return false;
    }
    
    public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("somestr");
		trie.insert("somestring");
		trie.insert("som");
		System.out.println(trie.search("somestr"));
		System.out.println(trie.startsWith("somestr"));
		System.out.println(trie.startsWith("somsstr"));
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");