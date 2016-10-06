package lc378;

import java.util.*;

public class Solution {
	
	public class Tuple implements Comparable<Tuple> {
		private int x, y, val;
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

    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0; 
        PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>(matrix[0].length);
        for (int i = 0; i < matrix[0].length; i++) pq.offer(new Tuple(0, i, matrix[0][i]));
        for (int i = 0; i < k-1; i++) {
        	Tuple tuple = pq.poll();
        	if (tuple.x < matrix.length-1) {
        		pq.offer(new Tuple(tuple.x+1, tuple.y, matrix[tuple.x+1][tuple.y]));
        	}
        }
        return pq.poll().val;
    }

    public static void main(String[] args) {
    	Solution solution = new Solution();
    }
}