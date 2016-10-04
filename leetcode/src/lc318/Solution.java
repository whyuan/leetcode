package lc318;

import java.util.*;

public class Solution {
    public int maxProduct(String[] words) {
        if (words.length == 0) return 0;
        int[] nums = new int[words.length];
        for (int i = 0; i < words.length; i++) {
        	for (int j = 0; j < words[i].length(); j++) {
        		nums[i] = nums[i] | 1<<(words[i].charAt(j)-'a');
        	}
        }
        int max = 0;
        for (int i = 0; i < words.length; i++) {
        	for (int j = i+1; j < words.length; j++) {
        		if (((nums[i] & nums[j]) == 0) && words[i].length()*words[j].length()>max) {
        			max = words[i].length()*words[j].length();
        		}
        	}
        }
        return max;
    }

    public static void main(String[] args) {
    	Solution solution = new Solution();
    }
}
