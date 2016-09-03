package lc155;

import java.util.*;

public class MinStack {
	List<Integer> list = new LinkedList<Integer>();
	List<Integer> minList = new LinkedList<Integer>();
	int min = Integer.MAX_VALUE;

    /** initialize your data structure here. */
    public MinStack() {
    }
    
    public void push(int x) {
    	int min = x;
    	if (minList.size() > 0) {
    		min = Math.min(minList.get(minList.size()-1), min);
    	}
    	minList.add(min);
        list.add(x);
    }
    
    public void pop() {
    	if (list.size() > 0) {
    		list.remove(list.size()-1);
    		minList.remove(minList.size()-1);
    	}
    }
    
    public int top() {
    	if (list.size() > 0) {
    		return list.get(list.size()-1);
    	} else {
    		return 0;
    	}
    }
    
    public int getMin() {
    	if (minList.size() > 0) {
    		return minList.get(minList.size()-1);
    	} else {
    		return Integer.MAX_VALUE;
    	}
    }
    
    public static void main(String[] args) {
    	MinStack obj = new MinStack();
    	obj.push(2);
    	obj.pop();
    	System.out.println(obj.top());
    	System.out.println(obj.getMin());
    }
}