package lc398;

import java.util.*;

public class Solution {

	private int[] nums;
	private Random rand = new Random();
    public Solution(int[] nums) {
        this.nums = nums;
    }
    
    public int pick(int target) {
    	int res = -1;
    	int count = 0;
        for (int i = 0; i < nums.length; i++) {
        	if (nums[i] == target && rand.nextInt(++count) == 0) {
        		res = i;
        	}
        }
        return res;
    }

    public static void main(String[] args) {
    }
}