package lc138;

import common.RandomListNode;
import java.util.*;

public class Solution {
	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null) return null;
		RandomListNode node = head;
		while (node != null) {
			RandomListNode newOne = new RandomListNode(node.label);
			RandomListNode next = node.next;
			node.next = newOne;
			newOne.next = next;
			node = next;
		}
		node = head;
		while (node != null) {
			if (node.random == null) {
				node.next.random = null;
			} else {
				node.next.random = node.random.next;
			}
			node = node.next.next;
		}
		node = head;
		RandomListNode result = node.next;
		while (node != null && node.next != null) {
			RandomListNode newNode = node.next;
			node.next = newNode.next;
			node = newNode;
		}
		return result;
	}
	
    public RandomListNode copyRandomList1(RandomListNode head) {
    	if (head == null) return null;
    	Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
    	return copyRandomList1(head, map);
    }

    private RandomListNode copyRandomList1(RandomListNode node, Map<RandomListNode, RandomListNode> map) {
    	if (node == null) return null;
    	if (!map.containsKey(node)) {
    		map.put(node, new RandomListNode(node.label));
    	}
    	RandomListNode newNode = map.get(node);
    	if (node.random != null) {
    		if (map.containsKey(node.random)) {
    			newNode.random = map.get(node.random);
    		} else {
    			newNode.random = copyRandomList1(node.random, map);
    		}
    	}
    	if (node.next != null) {
    		if (map.containsKey(node.next)) {
    			newNode.next = map.get(node.next);
    		} else {
    			newNode.next = copyRandomList1(node.next, map);
    		}
    	}
    	return newNode;
    }
    
    public static void main(String[] args) {
    	Solution solution = new Solution();
//    	System.out.println(solution.singleNumber(new int[]{0,1,0,1,0,1,98}));
    }
}
