package lc399;

import java.util.*;

public class Solution {

    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
    	Map<String, Map<String, Double>> map = new HashMap<>();
    	for (int i = 0; i < equations.length; i++) {
    		if (!map.containsKey(equations[i][0])) {
    			map.put(equations[i][0], new HashMap<String, Double>());
    		}
    		if (!map.containsKey(equations[i][1])) {
    			map.put(equations[i][1], new HashMap<String, Double>());
    		}
    		map.get(equations[i][0]).put(equations[i][0], 1.0);
    		map.get(equations[i][1]).put(equations[i][1], 1.0);
    		map.get(equations[i][0]).put(equations[i][1], values[i]);
    		map.get(equations[i][1]).put(equations[i][0], 1/values[i]);
    	}
    	for (String c : map.keySet()) {
    		for (String a : map.get(c).keySet()) {
    			for (String b : map.get(c).keySet()) {
    				map.get(a).put(b, map.get(a).get(c)*map.get(c).get(b));
    			}
    		}
    	}
    	double[] res = new double[queries.length];
    	for (int i = 0; i < queries.length; i++) {
    		if (map.containsKey(queries[i][0])) {
    			res[i] = map.get(queries[i][0]).getOrDefault(queries[i][1], -1.0);
    		} else {
    			res[i] = -1.0;
    		}
    	}
    	return res;
    }

    public static void main(String[] args) {
    }
}