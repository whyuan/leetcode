package lc141;

import common.ListNode;
import java.util.*;

public class Solution {
    public boolean hasCycle(ListNode head) {
    	if (head == null) return false;
        ListNode node0 = head, node1 = head;
        while (true) {
        	if (node0 != null && node0.next != null) {
        		node0 = node0.next.next;
        	} else {
        		return false;
        	}
        	node1 = node1.next;
        	if (node0 == node1) return true;
        }
    }
    
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	ListNode a = new ListNode(1);
    	ListNode b = new ListNode(1);
    	ListNode c = new ListNode(1);
    	ListNode d = new ListNode(1);
    	a.next = b;
    	b.next = c;
    	c.next = d;
//    	d.next = a;
    	System.out.println(solution.hasCycle(a));
    }
}
