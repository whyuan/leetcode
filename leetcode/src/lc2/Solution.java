/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode result = null;
        ListNode resultTail = null;
        int h = 0;
        ListNode p0 = result;
        while (p1 != null || p2 != null) {
            int v1 = 0;
            int v2 = 0;
            if (p1 != null) {
                v1 = p1.val;
            }
            if (p2 != null) {
                v2 = p2.val;
            }
            int val = ((v1+v2+h)%10);
            h = (int)Math.floor((v1+v2+h)/10);
            if (p1 != null) {
                p1 = p1.next;
            }
            if (p2 != null) {
                p2 = p2.next;
            }
            ListNode p = new ListNode(val);
            if (result == null) {
                result = p;
                resultTail = result;
            } else {
                resultTail.next = p;
                resultTail = resultTail.next;
            }
        }
        if (h != 0) {
            ListNode last = new ListNode(h);
            resultTail.next = last;
        }
        return result;
    }

    public static void main(String[] args) {
//        ListNode a0 = new ListNode(2);
//        ListNode a1 = new ListNode(4);
//        ListNode a2 = new ListNode(3);
//        a0.next = a1;
//        a1.next = a2;
        ListNode a0 = new ListNode(1);


        ListNode b0 = new ListNode(9);
        ListNode b1 = new ListNode(9);
        b0.next = b1;

        Solution solution = new Solution();
        ListNode result = solution.addTwoNumbers(a0, b0);
        System.out.printf("%d%d%d", result.val, result.next.val, result.next.next.val);
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
