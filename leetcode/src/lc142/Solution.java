package lc142;

import common.ListNode;
import java.util.*;

public class Solution {
	public ListNode detectCycle(ListNode head) {
		if (head == null) return null;
		ListNode node0 = head, node1 = head;
		while (true) {
			if (node0 == null || node0.next == null) return null;
			node0 = node0.next.next;
			node1 = node1.next;
			if (node0 == node1) break;
		}
		node1 = head;
		while (node0 != node1) {
			node1 = node1.next;
			node0 = node0.next;
		}
		return node1;
	}

    public ListNode detectCycle1(ListNode head) {
    	if (head == null) return null;
        ListNode node0 = head, node1 = head, node2 = null;
        int step = 0;
        while (true) {
        	if (!(node0 != null && node0.next != null)) {
        		return null;
        	}
        	if (node0.next.next == node1.next) {
        		if (node0.next != node1) return node1.next;
        	}
        	node0 = node0.next.next;
        	node1 = node1.next;
        	step++;
        	if (node0 == node1) break;
        }
        int l = reverse(node0);
		node1 = head;
		while (node1 != node0) {
			node1 = node1.next;
			step++;
		}
		reverse(node0);

		int a = (step-l)/2;
		node1 = head;
		for (int i = 0; i < a; i++) {
			node1 = node1.next;
		}
		return node1;
    }
    
    private int reverse(ListNode node0) {
    	int l = 0;
    	ListNode node1 = node0, node2 = node0;
		node1 = node0.next;
		node2 = node1.next;
		if (node0 == node1) return 1;
		else if (node2 == node0) return 2;
		while (node2 != node0) {
			node1.next = node0;
			node0 = node1;
			node1 = node2;
			node2 = node2.next;
			l++;
		}
		return l;
    }
    
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	ListNode a = new ListNode(1);
    	ListNode b = new ListNode(2);
    	ListNode c = new ListNode(3);
    	ListNode d = new ListNode(4);
    	ListNode e = new ListNode(5);
    	ListNode f = new ListNode(6);
    	ListNode g = new ListNode(7);
    	ListNode h = new ListNode(8);
    	ListNode i = new ListNode(9);
    	ListNode j = new ListNode(10);
    	a.next = b;
    	b.next = c;
    	c.next = d;
    	d.next = b;
    	e.next = f;
    	f.next = g;
    	g.next = h;
    	h.next = i;
    	i.next = j;
    	j.next = b;
    	System.out.println(solution.detectCycle(a).val);
    }
}
