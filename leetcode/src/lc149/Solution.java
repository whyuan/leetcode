package lc149;

import common.Point;
import java.util.*;

public class Solution {
    public int maxPoints(Point[] points) {
    	if (points == null || points.length == 0) return 0;
    	if (points.length <= 2) return points.length;
    	Map<Integer, Map<Integer, Integer>> map = new HashMap<Integer, Map<Integer, Integer>>();
    	int result = 0;
    	for (int i = 0; i < points.length; i++) {
    		map.clear();
    		int overlap = 1;
    		int max = 0;
    		for (int j = i+1; j < points.length; j++) {
    			if (j == i) continue;
    			int x = points[j].x-points[i].x;
    			int y = points[j].y-points[i].y;
    			if (x == 0 && y == 0) {
    				overlap++;
    				continue;
    			}
    			int gcdV = gcd(x, y);
    			if (gcdV != 0) {
    				x /= gcdV;
    				y /= gcdV;
    			}
    			if (map.containsKey(x)) {
    				if (map.get(x).containsKey(y)) {
    					map.get(x).put(y, map.get(x).get(y)+1); 
    				} else {
    					map.get(x).put(y, 1);
    				}
    			} else {
    				Map map0 = new HashMap<Integer, Integer>();
    				map0.put(y, 1);
    				map.put(x, map0);
    			}
    			max = Math.max(max, map.get(x).get(y));
    		}
    		result = Math.max(result, max+overlap);
    	}
    	return result;
    }
    
    private int gcd(int a, int b) {
    	if (b == 0) return a;
    	else return gcd(b, a%b);
    }
    
    public static void main(String[] args) {
//    	solution.sortList(a);
    }
}
