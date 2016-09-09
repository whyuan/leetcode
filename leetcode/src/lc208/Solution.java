package lc208;

import common.ListNode;
import java.util.*;

public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        while (p.next != null) {
        	if (p.next.val == val) {
        		p.next = p.next.next;
        	} else {
        		p = p.next;
        	}
        }
        return dummy.next;
    }

    public static void main(String[] args) {
    	Solution solution = new Solution();
    }
}