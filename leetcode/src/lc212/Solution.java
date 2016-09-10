package lc212;

import java.util.*;

class TrieNode {
	public String word;
	public TrieNode[] nexts = new TrieNode[26];
}

public class Solution {
    public List<String> findWords(char[][] board, String[] words) {
    	List<String> result = new ArrayList<String>();
    	if (board == null || words == null || board.length == 0 || board[0].length == 0 || words.length == 0) return result;
    	int l0 = board.length, l1 = board[0].length;
    	TrieNode root = this.buildTrieTree(words);
    	for (int i = 0; i < l0; i++) {
    		for (int j = 0; j < l1; j++) {
    			dfs(board, i, j, root, result);
    		}
    	}
    	return result;
    }
    
    private void dfs(char[][] board, int i, int j, TrieNode root, List<String> result) {
    	char c = board[i][j];
    	if (board[i][j] == '#' || root.nexts[c-'a'] == null) return;
    	TrieNode next = root.nexts[c-'a'];
    	if (next.word != null) {
    		result.add(next.word);
    		next.word = null;
    	}
    	board[i][j] = '#';
    	if (i > 0) dfs(board, i-1, j, next, result);
    	if (j > 0) dfs(board, i, j-1, next, result);
    	if (i < board.length-1) dfs(board, i+1, j, next, result);
    	if (j < board[0].length-1) dfs(board, i, j+1, next, result);
    	board[i][j] = c;
    }
    
    private TrieNode buildTrieTree(String[] words) {
    	TrieNode result = new TrieNode();
    	for (int i = 0; i < words.length; i++) {
    		char[] cw = words[i].toCharArray();
    		TrieNode cur = result;
    		for (int j = 0; j < cw.length; j++) {
    			if (cur.nexts[cw[j]-'a'] == null) cur.nexts[cw[j]-'a'] = new TrieNode();
    			cur = cur.nexts[cw[j]-'a'];
    		}
    		cur.word = words[i];
    	}
    	return result;
    }
    
    public static void main(String[] args) {
    	Solution solution = new Solution();
//    	solution.fin
    	System.out.println(solution.findWords(new char[][]{{'a'}}, new String[]{"a", "b"}));
    	System.out.println(solution.findWords(new char[][]{{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}}, new String[]{"oateo", "pea", "eat", "rain"}));
    }
}