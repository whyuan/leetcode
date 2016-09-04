package lc160;

import common.ListNode;
import java.util.*;

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    	if (headA == null || headB == null) return null;
        ListNode a = headA, b = headB;
        while (a != null && b != null) {
        	a = a.next;
        	b = b.next;
        }
        int x = a == null ? 0 : 1;
        ListNode p = x == 0 ? headB : headA;
        ListNode p1 = a == null ? b : a;
        int step = 0;
        while (p1 != null) {
        	p = p.next;
        	p1 = p1.next;
        	step++;
        }
        if (x == 0) {
        	b = p;
        	a = headA;
        } else {
        	a = p;
        	b = headB;
        }
        while (a != b && a != null && b != null) {
        	a = a.next;
        	b = b.next;
        }
        return a;
    }
    
    public static void main(String[] args) {
    	ListNode a = new ListNode(1);
    	ListNode b = new ListNode(2);
    	ListNode c = new ListNode(3);
    	b.next = c;
    	Solution solution = new Solution();
    	System.out.println(solution.getIntersectionNode(a, b));
    }
}