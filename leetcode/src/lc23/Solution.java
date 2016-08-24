package lc23;

import common.ListNode;

import java.util.*;

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result;
        if (lists.length <= 0) return null;
        else if (lists.length == 1) return lists[0];
        else if (lists.length == 2) return mergeTwoLists(lists[0], lists[1]);
        else {
//            ListNode[] a = new ListNode[]{new ListNode(0)};
            ListNode[] a = new ListNode[lists.length/2];
            ListNode[] b = new ListNode[lists.length-(lists.length/2)];
            System.arraycopy(lists, 0, a, 0, lists.length/2);
            System.arraycopy(lists, lists.length/2, b, 0, lists.length-(lists.length/2));
//            return mergeKLists(a, b);
            return mergeTwoLists(mergeKLists(a), mergeKLists(b));
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode h1 = l1, h2 = l2;
        ListNode dummy = new ListNode(0);
        ListNode t = dummy;
        while (h1 != null || h2 != null) {
            if (h2 == null) {
                t.next = h1;
                break;
            } else if (h1 == null) {
                t.next = h2;
                break;
            } else {
                if (h1.val <= h2.val) {
                    t.next = h1;
                    h1 = h1.next;
                } else {
                    t.next = h2;
                    h2 = h2.next;
                }
                t = t.next;
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
        System.out.println(solution.mergeKLists(new ListNode[]{a,a0,a1,a2}));
//        System.out.println(solution.generateParenthesis(0));
//        System.out.println(solution.generateParenthesis(3));
    }
}

