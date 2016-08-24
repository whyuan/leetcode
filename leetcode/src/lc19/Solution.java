package lc19;

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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n <= 0) {
            return head;
        }
        ListNode first = head, second = head;
        for (int i = 0; i < n; i++) {
            first = first.next;
        }
        if (first == null) {
            return head.next;
        } else {
            while (first.next != null) {
                first = first.next;
                second = second.next;
            }
            second.next = second.next.next;
            return head;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        System.out.println(solution.removeNthFromEnd(a, 2).val);
        ListNode a0 = new ListNode(1);
        System.out.println(solution.removeNthFromEnd(a0, 1));
        ListNode a1 = new ListNode(1);
        ListNode b1 = new ListNode(2);
        a1.next = b1;
        System.out.println(solution.removeNthFromEnd(a1, 1).val);
    }
}
