package lc331;

import java.util.*;

public class Solution {
	
    public boolean isValidSerialization(String preorder) {
    	if (preorder == null || preorder.equals("")) return false;
    	String[] ss = preorder.split(",");
    	Stack<String> stack = new Stack<String>();
    	for (int i = 0; i < ss.length; i++) {
    		if (ss[i].equals("#")) {
    			if (!stack.isEmpty()) {
    				while (!stack.isEmpty() && stack.peek().equals("#")) {
    					stack.pop();
    					stack.pop();
    				}
    				if (stack.isEmpty() && i!=ss.length-1) {
    					return false;
    				}
    				stack.push("#");
    			} else {
    				return false;
    			}
    		} else {
    			stack.push(ss[i]);
    		}
    	}
    	if (stack.size() > 1) {
    		return false;
    	} else {
    		return true;
    	}
    }

    public static void main(String[] args) {
    	Solution solution = new Solution();
    	System.out.println(solution.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
    	System.out.println(solution.isValidSerialization("1,#,#,#,#"));
    }
}
