public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return head;
        if (k <= 1) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        ListNode p1 = p;
        ListNode p0 = p;
        ListNode h = p;
        ListNode t = h;
        int step = 0;
        while (true) {
            p = h;
//          for (int i = 0; i < k; i++) {
//              p = p.next;
//              if (p == null) {
//                  return dummy.next;
//              }
//          }
//          t = p.next;

            p0 = h;
            p = h.next;
            if (p == null) return dummy.next;
            p1 = p.next;
            for (int i = 0; i < k; i++) {
                p.next = p0;
                p0 = p;
                p = p1;
                if (p1 != null) {
                    p1 = p1.next;
                }
                if (p == null && i < k-1) {
//                  修复
                    h.next.next = null;
                    h.next = reverseKGroup(p0, i+1);
                    return dummy.next;
                }
            }
            t = p;
            h.next.next = t;
            p1 = h.next;
            h.next = p0;
            h = p1;
            if (h.next == null) return dummy.next;
        }
    }
    
    public ListNode reverseKGroup0(ListNode head, int k) {
        if (head == null) return head;
        ListNode[] nodes = new ListNode[k];
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        ListNode h = p;
        int step = 0;
        while (true) {
            h = p;
            for (int i = 0; i < k; i++) {
                nodes[i] = p.next;
                p = p.next;
                if (p == null) {
                    return dummy.next;
                }
            }
            nodes[0].next = p.next;
            h.next = nodes[nodes.length-1];
            for (int i = k-1; i > 0; i--) {
                nodes[i].next = nodes[i-1];
            }
            p = nodes[0];
            if (p.next == null) return dummy.next;
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
//      c.next = d;
//      d.next = e;
        System.out.println(solution.reverseKGroup(a, 3));
    }
}
