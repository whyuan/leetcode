package lc150;

import java.util.*;

public class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens == null) return 0;
        Stack<String> stack = new Stack<String>();
        for (int i = 0; i < tokens.length; i++) {
        	String cur = tokens[i];
        	if (cur.equals("+") || cur.equals("-") || cur.equals("*") || cur.equals("/")) {
        		int a = Integer.parseInt(stack.pop());
        		int b = Integer.parseInt(stack.pop());
        		int c;
        		if (cur.equals("+")) c = b+a;
        		else if (cur.equals("-")) c = b-a;
        		else if (cur.equals("*")) c = b*a;
        		else c = b/a;
        		stack.push(Integer.toString(c));
        	} else {
        		stack.push(cur);
        	}
        }
        return Integer.parseInt(stack.pop());
    } 

    public static void main(String[] args) {
//    	solution.sortList(a);
    	Solution solution = new Solution();
    	System.out.println(solution.evalRPN(new String[]{"0","3","/"}));
    	System.out.println(solution.evalRPN(new String[]{"2", "1", "+", "3", "*"}));
    	System.out.println(solution.evalRPN(new String[]{"4", "13", "5", "/", "+"}));
    }
}