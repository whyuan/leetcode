package lc406;

import java.util.*;

public class Solution {

    public int[][] reconstructQueue(int[][] people) {
    	if (people == null) return null;
    	int[][] res = new int[people.length][2];
    	Arrays.sort(people, new Comparator<int[]>(){
    		public int compare(int[] a, int[] b) {
    			if (a[0] == b[0]) {
    				return a[1] - b[1];
    			} else {
    				return b[0] - a[0];
    			}
    		}
    	});
    	List<int[]> list = new ArrayList<int[]>();
    	for (int[] a : people) {
    		list.add(a[1], a);
    	}
    	return list.toArray(res);
    }

    public static void main(String[] args) {
    	Solution solution = new Solution();
    }
}