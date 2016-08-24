package lc57;


import common.Interval;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution {
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    	List<Interval> result = new ArrayList<Interval>();
    	Interval cur, target;
		for (int i = 0; i < intervals.size(); i++) {
			if (newInterval.start <= intervals.get(i).end && newInterval.end >= intervals.get(i).start) {
				cur = intervals.get(i);
				cur.start = Math.min(newInterval.start, cur.start);
				cur.end = Math.max(newInterval.end, cur.end);
				int step = i;
				while (step<intervals.size()-1 && cur.end >= intervals.get(step+1).start) {
					cur.end = Math.max(cur.end, intervals.get(step+1).end);
					step++;
				}
				result.add(cur);
				for (int j = step+1; j < intervals.size(); j++) {
					result.add(intervals.get(j));
				}
//				break;
				return result;
			} else if (newInterval.end < intervals.get(i).start) {
				result.add(newInterval);
				for (int j = i; j < intervals.size(); j++) {
					result.add(intervals.get(j));
				}
				return result;
			} else {
				result.add(intervals.get(i));
			}
		}
		result.add(newInterval);
		return result;
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
    	List<Interval> b = new ArrayList<Interval>();
    	b.add(new Interval(1,5));
    	System.out.println(solution.insert(b, new Interval(0,0)));
    	List<Interval> a = new ArrayList<Interval>();
    	a.add(new Interval(1,2));
    	a.add(new Interval(3,5));
    	a.add(new Interval(6,7));
    	a.add(new Interval(8,10));
    	a.add(new Interval(12,16));
    	System.out.println(solution.insert(new ArrayList<Interval>(), new Interval(4,9)));
    	System.out.println(solution.insert(a, new Interval(4,9)));
	}
}
