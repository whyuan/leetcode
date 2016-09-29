package lc349;

import java.util.*;

public class Solution {

    public int[] intersection(int[] nums1, int[] nums2) {
    	Set<Integer> set1 = new HashSet<Integer>();
    	Set<Integer> resultSet = new HashSet<Integer>();
    	for (int i = 0; i < nums1.length; i++) {
    		set1.add(nums1[i]);
    	}
    	for (int i = 0; i < nums2.length; i++) {
    		if (set1.contains(nums2[i])) {
    			resultSet.add(nums2[i]);
    		}
    	}
    	int[] result = new int[resultSet.size()];
    	int i = 0;
    	for (Integer num : resultSet) {
    		result[i++] num;
    	}
    	return result;
    }

    public static void main(String[] args) {
    	Solution solution = new Solution();
    }

}
