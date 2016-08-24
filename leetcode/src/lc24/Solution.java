package lc24;

import common.ListNode;

import java.util.*;

public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode st = dummy;
        while (true) {
            if (st.next != null && st.next.next!=null) {
                ListNode first = st.next.next.next;
                st.next.next.next = st.next;
                st.next = st.next.next;
                st.next.next.next = first;
                st = st.next.next;
//                ListNode second = st.next.next;
//                st.next = second;
//                first.next = second.next;
//                second.next = first;
//                st = first
            } else {
                break;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(2);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        ListNode a0 = null;
        ListNode a1 = new ListNode(0);
        ListNode b1 = new ListNode(2);
        ListNode c1 = new ListNode(3);
        ListNode d1 = new ListNode(8);
        ListNode a2 = null;
        Solution solution = new Solution();
        System.out.println(solution.swapPairs(a));
        System.out.println(solution.swapPairs(a0));
        System.out.println(solution.swapPairs(a1));
        System.out.println(solution.swapPairs(a2));

//        System.out.println(solution.generateParenthesis(0));
//        System.out.println(solution.generateParenthesis(3));
    }
}

