package lc295;

import java.util.*;

public class MedianFinder {
	private PriorityQueue<Integer> small = new PriorityQueue<Integer>(Collections.reverseOrder());
	private PriorityQueue<Integer> large = new PriorityQueue<Integer>();
	private boolean even = true;
    // Adds a number into the data structure.
    public void addNum(int num) {
        if (even) {
        	large.offer(num);
        	small.offer(large.poll());
        } else {
        	small.offer(num);
        	large.offer(small.poll());
        }
        even = !even;
    }

    // Returns the median of current data stream
    public double findMedian() {
        if (even) {
        	return (large.peek()+small.peek())/2.0;
        } else {
        	return small.peek();
        }
    }

    public static void main(String[] args) {
    }
};
