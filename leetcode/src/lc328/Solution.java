package lc328;

import common.ListNode;
import java.util.*;

public class Solution {

    public ListNode oddEvenList(ListNode head) {
        ListNode odd = new ListNode(0);
        ListNode even = new ListNode(0);
        boolean flag = false;
        ListNode pOdd = odd, pEven = even;
        while (head != null) {
        	if (flag) {
        		pEven.next = head;
        		pEven = pEven.next;
        	} else {
        		pOdd.next = head;
        		pOdd = pOdd.next;
        	}
        	head = head.next;
        	flag = !flag;
        }
        pOdd.next = even.next;
        return odd.next;
    }

    public static void main(String[] args) {
    	Solution solution = new Solution();
    	ListNode a = new ListNode(1);
    	ListNode b = new ListNode(2);
    	ListNode c = new ListNode(3);
    	a.next = b;
    	b.next = c;
    	solution.oddEvenList(a);
    }
}
