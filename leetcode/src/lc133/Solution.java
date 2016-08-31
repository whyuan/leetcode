package lc133;

import common.UndirectedGraphNode;
import java.util.*;

public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    	if (node == null) return null;
    	Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
    	return cloneGraph(node, map);
    } 
    
    private UndirectedGraphNode cloneGraph(UndirectedGraphNode node, Map<UndirectedGraphNode, UndirectedGraphNode> map) {
    	if (node == null) return null;
    	if (!map.containsKey(node)) {
    		map.put(node, new UndirectedGraphNode(node.label));
    	}
    	UndirectedGraphNode curNewNode = map.get(node);
    	for (UndirectedGraphNode item : node.neighbors) {
    		if (!map.containsKey(item)) {
    			curNewNode.neighbors.add(cloneGraph(item, map));
    		} else {
    			curNewNode.neighbors.add(map.get(item));
    		}
    	}
    	return curNewNode;
    }

    public static void main(String[] args) {
    	Solution solution = new Solution();
    	UndirectedGraphNode a = new UndirectedGraphNode(0);
    	UndirectedGraphNode b = new UndirectedGraphNode(1);
    	UndirectedGraphNode c = new UndirectedGraphNode(2);
    	a.neighbors.add(b);
    	a.neighbors.add(c);
    	b.neighbors.add(a);
    	b.neighbors.add(c);
    	c.neighbors.add(a);
    	c.neighbors.add(b);
    	c.neighbors.add(c);
    	UndirectedGraphNode result = solution.cloneGraph(a);
    	System.out.println(result);
    }
}
