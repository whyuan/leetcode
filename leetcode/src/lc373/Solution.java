package lc373;

import java.util.*;

public class Solution {
	
	public class Tuple implements Comparable<Tuple> {
		public int x, y, val;
		public Tuple(int x, int y, int val) {
			this.x = x;
			this.y = y;
			this.val = val;
		}
		
		@Override
		public int compareTo(Tuple a) {
			return this.val - a.val;
		}
	}

    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new ArrayList<int[]>();
        if (k <= 0 || nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) return res;
        PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>();
        for (int i = 0; i < nums1.length; i++) pq.add(new Tuple(i, 0, nums1[i]+nums2[0]));
        while (res.size() < k && pq.size() > 0) {
        	Tuple tuple = pq.poll();
        	res.add(new int[]{nums1[tuple.x], nums2[tuple.y]});
        	if (tuple.y < nums2.length-1) {
        		pq.offer(new Tuple(tuple.x, tuple.y+1, nums1[tuple.x]+nums2[tuple.y+1]));
        	}
        }
        return res;
    }

    public static void main(String[] args) {
    	Solution solution = new Solution();
    }

}
