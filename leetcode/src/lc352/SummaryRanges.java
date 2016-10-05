package lc352;

import java.util.*;

// Definition for an interval.
class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}
}

public class SummaryRanges {

	private List<Interval> intervals = new ArrayList<Interval>();
    /** Initialize your data structure here. */
    public SummaryRanges() {
    }
    
    public void addNum(int val) {
    	Interval left = null, right = null;
    	int index = 0;
    	for (Interval interval : intervals) {
    		if (interval.end >= val && interval.start <= val) return;
    		if (interval.end+1 == val) left = interval;
    		if (interval.start-1 == val) right = interval;
    		if (val > interval.start) index++;
    		if (right != null || (left != null && left != interval) || interval.start > val) break;
    	}
    	if (left != null && right != null) {
    		left.end = right.end;
    		intervals.remove(right);
    		return;
    	} else if (left != null) {
    		left.end = val;
    		return;
    	} else if (right != null) {
    		right.start = val;
    		return;
    	}
    	
    	intervals.add(index, new Interval(val, val));
    }
    
    public List<Interval> getIntervals() {
        return intervals;
    }
}