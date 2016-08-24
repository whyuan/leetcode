package lc56;


import common.Interval;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
    	intervals.sort(new Comparator<Interval>() {
    		public int compare(Interval a, Interval b) {
    			return a.start-b.start;
    		}
    	});
    	List<Interval> result = new ArrayList<Interval>();
    	Interval cur, target;
    	for (int i = 0; i < intervals.size(); i++) {
    		if (result.size() > 0) {
    			cur = result.get(result.size()-1);
    			target = intervals.get(i);
    			if (cur.end >= target.start) {
    				if (target.end > cur.end) {
    					cur.end = target.end;
    				}
    			} else {
//    				result.add(new Interval(target.start, target.end));
    				result.add(target);
    			}
    		} else {
    			result.add(new Interval(intervals.get(i).start, intervals.get(i).end));
//    			result.add(target);
    		}
    	}
    	return result;
    }
    
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	List<Interval> a = new ArrayList<Interval>();
    	a.add(new Interval(1,3));
    	a.add(new Interval(2,6));
    	a.add(new Interval(8,10));
    	a.add(new Interval(15,18));
    	System.out.println(solution.merge(a));
    }
}
