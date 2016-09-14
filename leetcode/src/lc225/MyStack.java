package lc225;

import java.util.*;

public class MyStack {
	private LinkedList<Integer> list = new LinkedList<Integer>();
	
    // Push element x onto stack.
    public void push(int x) {
    	list.add(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
    	if (list.size() > 0) {
    		list.remove(list.size()-1);
    	}
    }

    // Get the top element.
    public int top() {
    	return list.peekLast();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return (list.size()==0);
    }
    
    public static void main(String[] args) {
    }
}