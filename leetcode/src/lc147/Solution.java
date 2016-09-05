package lc147;

import common.ListNode;
import java.util.*;

public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) return head;
        ListNode cur = head.next;
        ListNode preCur = head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        while (cur != null) {
        	ListNode p = dummy;
        	while (p.next.val < cur.val) {
        		p = p.next;
        	}
        	if (p.next != cur) {
				ListNode pNext = p.next;
				ListNode curNext = cur.next;
				p.next = cur;
				cur.next = pNext;
				preCur.next = curNext;
				cur = curNext;
        	} else {
        		preCur = cur;
        		cur = cur.next;
        	}
        }
        return dummy.next;
    }
    
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	ListNode a = new ListNode(10);
    	ListNode b = new ListNode(1);
    	ListNode c = new ListNode(3);
    	ListNode d = new ListNode(1);
//    	a.next = b;
//    	b.next = c;
//    	c.next = d;
    	solution.insertionSortList(a);
    }
}
