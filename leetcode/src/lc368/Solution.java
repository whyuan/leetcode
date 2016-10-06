package lc368;

import java.util.*;

public class Solution {

    public List<Integer> largestDivisibleSubset(int[] nums) {
    	List<Integer> res = new ArrayList<Integer>();
    	if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        int[] f = new int[nums.length];
        int[] pre = new int[nums.length];
        int maxIndex = 0;
        for (int i = 0; i < f.length; i++) {
        	f[i] = 1;
        	pre[i] = -1;
        	for (int j = i-1; j >= 0; j--) {
        		if (nums[i] % nums[j] == 0 && f[i] < f[j]+1) {
        			f[i] = f[j] + 1;
        			pre[i] = j;
        			if (f[i] > f[maxIndex]) {
        				maxIndex = i;
        			}
        		}
        	}
        }
        int curIndex = maxIndex;
        while (curIndex >= 0) {
        	res.add(nums[curIndex]);
        	curIndex = pre[curIndex];
        }
        return res;
    }

    public static void main(String[] args) {
    	Solution solution = new Solution();
    }

}
