package lc310;

import java.util.*;

public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
    	if (n == 1) return Collections.singletonList(0);
        List<Set<Integer>> nodes = new ArrayList<Set<Integer>>(n);
        for (int i = 0; i < n; i++) {
        	nodes.add(new HashSet<Integer>());
        }
        for (int i = 0; i < edges.length; i++) {
        	nodes.get(edges[i][0]).add(edges[i][1]);
        	nodes.get(edges[i][1]).add(edges[i][0]);
        }
        List<Integer> leaves = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
        	if (nodes.get(i).size() == 1) {
        		leaves.add(i);
        	}
        }
        while (n > 2) {
        	n -= leaves.size();
        	List<Integer> newLeaves = new ArrayList<Integer>();
        	for (int i = 0; i < leaves.size(); i++) {
        		int j = nodes.get(leaves.get(i)).iterator().next();
        		nodes.get(j).remove(leaves.get(i));
        		if (nodes.get(j).size() == 1) newLeaves.add(j);
        	}
        	leaves = newLeaves;
        }
        return leaves;
    }

    public static void main(String[] args) {
    	Solution solution = new Solution();
    }
}
