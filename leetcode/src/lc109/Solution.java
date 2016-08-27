package lc109;

import common.ListNode;
import common.TreeNode;

public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
    	int l = 0;
    	ListNode h = head;
    	while(h != null) {
    		h = h.next;
    		l++;
    	}
    	preNode = head;
        return sortedListToBST(head, l);
    }

    private ListNode preNode = null;
    private TreeNode sortedListToBST(ListNode head, int l) {
    	if (l == 0) return null;
    	int i = l>>1;
    	TreeNode result = new TreeNode(0);
    	result.left = sortedListToBST(head, i);
    	result.val = preNode.val;
    	preNode = preNode.next;
    	result.right = sortedListToBST(preNode, l-i-1);
    	return result;
    }
}
