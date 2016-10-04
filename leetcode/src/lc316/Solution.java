package lc316;

import java.util.*;

public class Solution {
    public String removeDuplicateLetters(String s) {
       char[] cs = s.toCharArray();
       boolean[] visited = new boolean[26];
       int[] count = new int[26];
       for (int i = 0; i < cs.length; i++) {
    	   count[cs[i]-'a']++;
       }
       Stack<Character> stack = new Stack<Character>();
       for (int i = 0; i < cs.length; i++) {
    	   count[cs[i]-'a']--;
    	   char c = cs[i];
    	   if (visited[cs[i]-'a']) continue;
    	   while (!stack.isEmpty() && stack.peek() >= c && count[stack.peek()-'a']>0) {
    		   visited[stack.peek()-'a'] = false;
    		   stack.pop();
    	   }
    	   stack.push(cs[i]);
    	   visited[cs[i]-'a'] = true;
       }
       StringBuilder sb = new StringBuilder();
       for (char c : stack) {
    	   sb.append(c);
       }
       return sb.toString();
    }

    public static void main(String[] args) {
    	Solution solution = new Solution();
    }
}
