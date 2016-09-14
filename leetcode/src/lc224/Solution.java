package lc224;

import java.util.*;

public class Solution {
    public int calculate(String s) {
    	Stack<Character> stack0 = new Stack<Character>();
    	Stack<String> stack1 = new Stack<String>();
    	int step = 0;
    	char[] cs = s.toCharArray();
    	boolean isFirst = true;
    	boolean isNeg = false;
    	while (step < cs.length) {
    		if (cs[step] >= '0' && cs[step] <= '9') {
    			int step1 = step;
    			while (step1<cs.length && cs[step1] >= '0' && cs[step1] <= '9') step1++;
    			stack1.push(s.substring(step, step1));
    			step = step1;
    		} else if (cs[step] == '-' || cs[step] == '+') {
    			if (isFirst) {
    				isFirst = false;
    				stack1.push("0");
    			}
    			while (stack0.size() > 0 && (stack0.peek() == '-' || stack0.peek() == '+')) {
    				stack1.push(Character.toString(stack0.pop()));
    			}
    			stack0.push(cs[step]);
    			step++;
    		} else if (cs[step] == '*' || cs[step] == '/') {
    			while (stack0.size() > 0 && (stack0.peek() == '-' || stack0.peek() == '+' || stack0.peek() == '*' || stack0.peek() == '/')) {
    				stack1.push(Character.toString(stack0.pop()));
    			}
    			stack0.push(cs[step]);
    			step++;
    		} else if (cs[step] == '(') {
    			stack0.push(cs[step]);
    			step++;
    			isFirst = true;
    		} else if (cs[step] == ')') {
    			while (stack0.size() > 0 && (stack0.peek() != '(')) {
    				stack1.push(Character.toString(stack0.pop()));
    			}
    			stack0.pop();
    			step++;
    		} else {
    			step++;
    		}
    	}
    	while (stack0.size() > 0) {
    		stack1.push(Character.toString(stack0.pop()));
    	}
    	Integer result = null;
    	while (stack1.size() > 0) {
    		String top = stack1.pop();
    		if (top.equals("*") || 
    			top.equals("/") ||
    			top.equals("+") ||
    			top.equals("-")) {
    			stack0.push(top.toCharArray()[0]);
    		} else {
    			if (result == null) {
    				result = Integer.parseInt(top);
    			} else {
					char top0 = stack0.pop();
					Integer cur = Integer.parseInt(top);
					if (top0 == '+') {
						result += cur;
					} else if (top0 == '-') {
						result -= cur;
					} else if (top0 == '/') {
						result /= cur;
					} else if (top0 == '*') {
						result *= cur;
					}
    			}
    		}
    	}
    	return result;
    }

    public static void main(String[] args) {
    }
}