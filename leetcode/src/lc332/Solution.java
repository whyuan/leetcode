package lc332;

import java.util.*;

public class Solution {

	private Map<String, PriorityQueue<String>> targets = new HashMap<>();
	private LinkedList<String> route = new LinkedList<String>();
    public List<String> findItinerary(String[][] tickets) {
        for (String[] ticket : tickets) {
        	targets.putIfAbsent(ticket[0], new PriorityQueue());
        	targets.get(ticket[0]).add(ticket[1]);
        }
        visit("JFK");
        return route;
    }	
    
    private void visit(String pos) {
    	PriorityQueue<String> target = targets.get(pos);
    	while (target != null && !target.isEmpty()) {
    		visit(target.poll());
    	}
    	route.addFirst(pos);
    }

    public static void main(String[] args) {
    	Solution solution = new Solution();
    }
}
