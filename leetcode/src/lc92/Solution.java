package lc92;

import common.ListNode;

public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
    	if (m == n) return head;
    	ListNode dump = new ListNode(0);
    	dump.next = head;
        ListNode h = dump;
        m = m-1;
        n = n-1;
        int step = 0;
        while (step < m) {
        	step++;
        	h = h.next;
        }
        ListNode t = null;
        if (h.next != null) {
        	t = h.next.next;
        }
        ListNode h0 = h;
        ListNode cur = h.next;
        while (step < n && t != null) {
        	cur.next = h;
        	h = cur;
        	cur = t;
        	t = t.next;
        	step++;
        }
        if (cur != null) {
        	cur.next = h;
        }
//        h0.next = cur;
        h0.next.next = t;
        h0.next = cur;
        return dump.next;
    }
    
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	ListNode a = new ListNode(1);
    	ListNode b = new ListNode(2);
    	ListNode c = new ListNode(3);
    	ListNode d = new ListNode(4);
    	ListNode e = new ListNode(5);
    	a.next = b;
    	b.next = c;
    	c.next = d;
    	d.next = e;
    	System.out.println(solution.reverseBetween(a, 1, 5));
    }

}