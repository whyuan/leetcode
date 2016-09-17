package lc234;

import common.ListNode;
import java.util.*;

public class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        int count = 0;
        ListNode p = head;
        while (p != null) {
        	p = p.next;
        	count++;
        }
        if (count == 1) return true;
        int m = count/2;
        p = head;
        while (m > 0) {
        	p = p.next;
        	m--;
        }
        ListNode q = p.next;
        ListNode r = null;
        if (q != null) {
        	r = q.next;
        }
        while (q != null) {
        	q.next = p;
        	p = q;
        	q = r;
        	if (r != null) {
        		r = r.next;
        	}
        }
        q = head;
        int step = 0;
        m = count/2;
        while (q.val == p.val) {
        	q = q.next;
        	p = p.next;
        	step++;
        	if (step == m) {
        		return true;
        	}
        }
        return false;
    }

    public static void main(String[] args) {
		Solution solution = new Solution();
    }
}