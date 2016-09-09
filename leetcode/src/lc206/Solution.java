package lc206;

import common.ListNode;
import java.util.*;

public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode node0 = dummy, node1 = dummy.next, node2 = dummy.next.next;
        while (true) {
        	node1.next = node0;
        	if (node2 != null) {
				node0 = node1;
				node1 = node2;
				node2 = node2.next;
        	} else {
        		break;
        	}
        }
        dummy.next.next = null;
        return node1;
    }

    public static void main(String[] args) {
    	Solution solution = new Solution();
    }
}