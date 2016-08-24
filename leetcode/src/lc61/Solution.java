package lc61;

import common.ListNode;

public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
    	if (head == null) return head;
    	int l = 0;
    	ListNode a = head;
    	ListNode b = head;
    	while (a!=null) {
    		b = a;
			a = a.next;
			l++;
    	}
    	k = k%l;
    	int step = l - k;
    	if (step == 0) return head;
    	a = head;
    	for (int i = 0; i < step-1; i++) {
    		a = a.next;
    	}
    	b.next = head;
    	ListNode result = a.next;
    	a.next = null;
    	return result;
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
		System.out.println(solution.rotateRight(a, 2));
		ListNode a0 = new ListNode(1);
		System.out.println(solution.rotateRight(a0, 0));
	}
}
