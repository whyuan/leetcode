package lc82;

import common.ListNode;

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dump = new ListNode(0);
        dump.next = head;
        ListNode t = dump;
        while (t != null && t.next != null && t.next.next != null) {
        	if (t.next.val == t.next.next.val) {
        		int val = t.next.val;
        		ListNode t1 = t.next;
        		while (t1 != null && t1.val == val) t1 = t1.next;
        		t.next = t1;
        	} else {
        		t = t.next;
        	}
        }
        return dump.next;
    }
    
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	ListNode a = new ListNode(1);
    	ListNode b = new ListNode(1);
    	ListNode c = new ListNode(2);
    	ListNode d = new ListNode(2);
    	a.next = b;
    	b.next = c;
    	c.next = d;
    	System.out.println(solution.deleteDuplicates(a));
    	ListNode a0 = new ListNode(1);
    	ListNode b0 = new ListNode(1);
    	a0.next = b0;
    	System.out.println(solution.deleteDuplicates(a0));
    }
}
