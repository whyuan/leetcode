package lc218;

import java.util.*;

public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new ArrayList<int[]>();
        if (buildings == null || buildings.length == 0 || buildings[0].length == 0) return result;
//        result.add(new int[]{buildings[0][0], buildings[0][2]});
//        result.add(new int[]{buildings[0][1], 0});
        int t = 0;
        for (int i = 0; i < buildings.length; i++) {
        	while (t+1 < result.size() && result.get(t+1)[0] < buildings[i][0]) t++;
        	if (t == result.size()) {
        		result.add(new int[]{buildings[i][0], buildings[i][2]});
        		result.add(new int[]{buildings[i][1], 0});
        	} else {
        		if (buildings[i][2] >= result.get(t)[1]) {
        			int t1 = t;
        			while (t1+1 < result.size() && result.get(t1+1)[0] <= buildings[i][1]) t1++;
        			int h = 0;
        			if (t1+1 < result.size()) {
        				h = result.get(t1)[1];
        			}
        			for (int i0 = t; i0 < t1; i0++) {
        				result.remove(t+1);
        			}
        			if (buildings[i][2] > result.get(t)[1]) {
        				result.add(t+1, new int[]{buildings[i][0], buildings[i][2]});
        				result.add(t+2, new int[]{buildings[i][1], h});
        			} else {
        				result.add(t+1, new int[]{buildings[i][1], h});
        			}
        		} else {
        			int t2 = t;
//        			while (t2+1 < result.size() && result.get(t2+1)[1] >= buildings[i][2] && result.get(t2+1)[0] <= buildings[i][1]) t2++;
        			while (t2+1 < result.size() && result.get(t2+1)[1] >= buildings[i][2] && result.get(t2+1)[0] <= buildings[i][1]) t2++;
        			if (t2+1 < result.size() && result.get(t2+1)[0] <= buildings[i][1] && result.get(t2+1)[1] < buildings[i][2]) {
        				int t3 = t2+1;
        				while (t3+1 < result.size() && result.get(t3+1)[0] <= buildings[i][1]) t3++;
        				int h = 0;
        				if (t3 < result.size()) {
        					h = result.get(t3)[1];
        				}
        				int x0 = result.get(t2+1)[0];
        				for (int i1 = t2+1; i1 <= t3; i1++) {
        					result.remove(t2+1);
        				}
        				result.add(t2+1, new int[]{x0, buildings[i][2]});
        				result.add(t2+2, new int[]{buildings[i][1], h});
        			}
        		}
        	}
        }
        List<int[]> result0 = new ArrayList<int[]>(result.size());
        for (int j = 0; j < result.size(); j++) {
        	if (result0.size() == 0) {
        		result0.add(result.get(j));
        	} else {
        		int[] a = result0.get(result0.size()-1);	
        		int[] b = result.get(j);
        		if (a[0] == b[0] || a[1] == b[1]) {
        			result0.remove(a);
        			result0.add(b);
        		} else {
        			result0.add(b);
        		}
        	}
        }
        return result0;
    }

    public static void main(String[] args) {
    	Solution solution = new Solution();
    	System.out.println(solution.getSkyline(new int[][]{{0,2,3},{2,5,3}}));
//    	System.out.println(solution.findKthLargest(new int[]{-1,2,0}, 3));
    }
}