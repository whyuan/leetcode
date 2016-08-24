package lc21;

/**
 * Created by wanghaoyuan on 2016/8/5.
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
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
        Solution solution = new Solution();
        ListNode a = new ListNode(2);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        ListNode a0 = new ListNode(1);
        ListNode result = solution.mergeTwoLists(a, a0);
        System.out.println(result.next.next.next.val);
    }
}
