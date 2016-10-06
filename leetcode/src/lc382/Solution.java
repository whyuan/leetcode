package lc382;

import common.ListNode;
import java.util.*;

public class Solution {
	
	ListNode head;
	Random rand = new Random();

	public Solution(ListNode head) {
		this.head = head;
	}

	/** Returns a random node's value. */
	public int getRandom() {
		ListNode p = head;
		int res = 0;
		int step = 1;
		while (p != null) {
			int a = rand.nextInt(step);
			if (a == 0) res = p.val;
			step++;
			p = p.next;
		}
		return res;
	}

	public static void main(String[] args) {
	}
}