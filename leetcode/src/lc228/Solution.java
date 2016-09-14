package lc228;

import java.util.*;

public class Solution {
    public List<String> summaryRanges(int[] nums) {
    	if (nums == null) return null;
    	if (nums.length == 0) return new ArrayList<String>();
    	List<int[]> temp = summaryRanges(nums, 0, nums.length);
    	List<String> result = new ArrayList<String>(temp.size());
    	for (int i = 0; i < temp.size(); i++) {
    		if (temp.get(i)[0] == temp.get(i)[1]) {
    			result.add(Integer.toString(temp.get(i)[0]));
    		} else {
    			result.add(Integer.toString(temp.get(i)[0])+"->"+Integer.toString(temp.get(i)[1]));
    		}
    	}
    	return result;
    }
    
    private List<int[]> summaryRanges(int[] nums, int h, int t) {
    	if (h == t) return null;
    	if (nums[t-1]-nums[h] == (t-1-h)) {
    		List<int[]> result = new ArrayList<int[]>();
    		result.add(new int[]{nums[h], nums[t-1]});
    		return result;
    	} else {
    		int m = (h+t)/2;
    		List<int[]> a = summaryRanges(nums, h, m);
    		List<int[]> b = summaryRanges(nums, m, t);
    		if (a.get(a.size()-1)[1]+1 == b.get(0)[0]) {
    			int[] temp = a.get(a.size()-1);
    			temp[1] = b.get(0)[1];
    			a.addAll(b.subList(1, b.size()));
    		} else {
    			a.addAll(b);
    		}
    		return a;
    	}
    }

    public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.summaryRanges(new int[]{0,1,2,4,5,7}));
		System.out.println(solution.summaryRanges(new int[]{0}));
		System.out.println(solution.summaryRanges(new int[]{0, 5}));
    }
}