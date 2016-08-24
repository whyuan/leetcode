package lc86;

import common.ListNode;

public class Solution {
    public ListNode partition(ListNode head0, int x) {
    	ListNode dump0 = new ListNode(0), dump1 = new ListNode(0);
    	ListNode head = head0;
    	if (head == null) return null;
    	ListNode h0 = dump0, h1 = dump1;
    	while (head != null) {
    		if (head.val < x) {
    			h0.next = head;
    			h0 = h0.next;
    		} else {
    			h1.next = head;
    			h1 = h1.next;
    		}
    		head = head.next;
    	}
    	h1.next = null;
    	h0.next = dump1.next;
    	return dump0.next;
    }
    
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	ListNode a = new ListNode(2);
    	ListNode b = new ListNode(1);
    	ListNode c = new ListNode(3);
    	ListNode d = new ListNode(2);
    	ListNode e = new ListNode(5);
    	ListNode f = new ListNode(2);
    	a.next = b;
//    	b.next = c;
//    	c.next = d;
//    	d.next = e;
//    	e.next = f;
    	System.out.println(solution.partition(a, 2));
    }
}
