package lc232;

import java.util.*;

class MyQueue {
	private List<Integer> list = new ArrayList<Integer>();
    // Push element x to the back of queue.
    public void push(int x) {
    	list.add(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if (list.size() > 0) {
        	list.remove(list.size()-1);
        }
    }

    // Get the front element.
    public int peek() {
        if (list.size() > 0) {
        	return list.get(list.size()-1);
        } else {
        	return 0;
        }
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return (list.size()<=0);
    }
    
    public static void main(String[] args) {
    	MyQueue myQueue = new MyQueue();
    	myQueue.push(2);
   	myQueue.push(3);
    	myQueue.push(4);
    	myQueue.pop();
    	myQueue.peek();
    	myQueue.pop();
    	myQueue.empty();
    }
}