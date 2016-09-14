package lc224;

import java.util.*;

public class Solution {
    public int calculate(String s) {
    	Stack<Character> stack0 = new Stack<Character>();
    	Stack<String> stack1 = new Stack<String>();
    	int step = 0;
    	char[] cs = s.toCharArray();
    	boolean isFirst = true;
    	while (step < cs.length) {
    		if (cs[step] >= '0' && cs[step] <= '9') {
    			int step1 = step;
    			while (step1<cs.length && cs[step1] >= '0' && cs[step1] <= '9') step1++;
    			stack1.push(s.substring(step, step1));
    			step = step1;
    			isFirst = false;
    		} else if (cs[step] == '-' || cs[step] == '+') {
    			if (isFirst) {
    				isFirst = false;
    				stack1.push("0");
    			}
    			while (stack0.size() > 0 && (stack0.peek() == '-' || stack0.peek() == '+' || stack0.peek() == '*' || stack0.peek() == '/')) {
    				stack1.push(Character.toString(stack0.pop()));
    			}
    			stack0.push(cs[step]);
    			step++;
    		} else if (cs[step] == '*' || cs[step] == '/') {
    			while (stack0.size() > 0 && (stack0.peek() == '*' || stack0.peek() == '/')) {
    				stack1.push(Character.toString(stack0.pop()));
    			}
    			stack0.push(cs[step]);
    			step++;
    			isFirst = false;
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
    			isFirst = false;
    		} else {
    			step++;
    		}
    	}
    	while (stack0.size() > 0) {
    		stack1.push(Character.toString(stack0.pop()));
    	}
    	Stack<String> stack2 = new Stack<String>();
    	while (stack1.size() > 0) {
    		stack2.push(stack1.pop());
    	}
    	Stack<Integer> stack3 = new Stack<Integer>();
    	while (stack2.size() > 0) {
    		String top = stack2.pop();
    		if (top.equals("*")) {
    			stack3.push(stack3.pop()*stack3.pop());
    		} else if (top.equals("/")) {
    			Integer b = stack3.pop();
    			Integer a = stack3.pop();
    			stack3.push(a/b);
    		} else if (top.equals("+")) {
    			stack3.push(stack3.pop()+stack3.pop());
    		} else if (top.equals("-")) {
    			Integer d = stack3.pop();
    			Integer c = stack3.pop();
    			stack3.push(c-d);
    		} else {
    			stack3.push(Integer.parseInt(top));
    		}
    	}
    	return stack3.pop();
    }

    public static void main(String[] args) {
    }
}