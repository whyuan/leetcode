package lc148;

import java.util.*;

import common.ListNode;

public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null) return head;
        ListNode node = head;
        int l = 0;
        while (node != null) {
        	l++;
        	node = node.next;
        }
        ListNode result = mergeSort(head, l);
        return result;
    }
    
    private ListNode mergeSort(ListNode head, int l) {
    	if (l <= 1) return head;
    	int m = l/2;
    	ListNode t1 = head;
    	ListNode t0 = null;
    	while (m > 0) {
    		m--;
    		t0 = t1;
    		t1 = t1.next;
    	}
    	t0.next = null;
    	ListNode list0 = mergeSort(head, l/2);
    	ListNode list1 = mergeSort(t1, l-l/2);
    	ListNode dummy = new ListNode(0);
    	ListNode p = dummy;
    	while (list0 != null || list1 != null) {
    		if (list0 == null) {
    			p.next = list1;
    			break;
    		}
    		if (list1 == null) {
    			p.next = list0;
    			break;
    		}
    		if (list0.val < list1.val) {
    			p.next = list0;
    			p = list0;
    			list0 = list0.next;
    		} else {
    			p.next = list1;
    			p = list1;
    			list1 = list1.next;
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
    	ListNode e = new ListNode(2);
    	a.next = b;
    	b.next = c;
    	c.next = d;
    	d.next = e;
    	solution.sortList(a);
    }
}