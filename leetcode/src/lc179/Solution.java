package lc179;

import java.util.*;

public class Solution {
    public String largestNumber(int[] nums) {
    	if (nums == null) return null;
    	if (nums.length == 0) return "";
        String[] snums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
        	snums[i] = Integer.toString(nums[i]);
        }
        List<String> list = Arrays.asList(snums);
        list.sort(new Comparator<String>(){
            public int compare(String a, String b) {  
            	String x = a+b;
            	String y = b+a;
            	return -x.compareTo(y);
            }  
        });
        String result = String.join("", list);
        if (result.charAt(0) == '0') return "0";
        else return result;
    } 

    public static void main(String[] args) {
    	Solution solution = new Solution();
    	System.out.println(solution.largestNumber(new int[]{0, 0}));
    	System.out.println(solution.largestNumber(new int[]{898, 89}));
    	System.out.println(solution.largestNumber(new int[]{121, 12}));
    	System.out.println(solution.largestNumber(new int[]{3, 9, 34, 12}));
    }
}
