package lc143;

import common.ListNode;
import java.util.*;

public class Solution {
    public void reorderList(ListNode head) {
    	if (head == null || head.next == null) return;
    	ListNode dummy = new ListNode(0);
    	dummy.next = head;
    	ListNode node0 = dummy, node1 = dummy;
    	while (node0 != null) {
    		if (node0.next != null) node0 = node0.next.next;
    		else node0 = node0.next;
    		node1 = node1.next;
    	}
    	ListNode node;
    	node = this.reverse(node1.next);
    	node1.next = null;
    	node1 = node;
    	node0 = head;
    	while (node0 != null && node1 != null) {
			node = node0.next;
			node0.next = node1;
			node0 = node1;
			node1 = node;
    	}
    	return;
    }
    
    private ListNode reverse(ListNode node0) {
    	if (node0 == null) return null;
    	if (node0.next == null) return node0;
    	ListNode node1, node2, dump = new ListNode(0);
    	dump.next = node0;
    	node0 = dump;
    	node1 = dump.next;
    	node2 = dump.next.next;
    	while (node2 != null) {
			node1.next = node0;
			node0 = node1;
			node1 = node2;
			node2 = node2.next;
    	}
    	node1.next = node0;
    	dump.next.next = null;
    	return node1;
    }
    
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	ListNode a = new ListNode(1);
    	ListNode b = new ListNode(2);
    	ListNode c = new ListNode(3);
    	ListNode d = new ListNode(4);
    	ListNode e = new ListNode(5);
    	ListNode f = new ListNode(6);
    	a.next = b;
    	b.next = c;
    	c.next = d;
    	d.next = e;
    	solution.reorderList(a);
    	System.out.println(a);
    }
}
