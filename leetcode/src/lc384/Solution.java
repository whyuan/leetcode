package lc384;

import java.util.*;

public class Solution {
	
	private int[] arrs;
	private int[] ori;
	private Random rand = new Random();

    public Solution(int[] nums) {
    	arrs = new int[nums.length];
    	ori = new int[nums.length];
        System.arraycopy(nums, 0, arrs, 0, nums.length);
        System.arraycopy(nums, 0, ori, 0, nums.length);
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        System.arraycopy(ori, 0, arrs, 0, ori.length);
        return arrs;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for (int i = arrs.length-1; i > 0; i--) {
        	int j = rand.nextInt(i+1);
        	int temp = arrs[i];
        	arrs[i] = arrs[j];
        	arrs[j] = temp;
        }
        return arrs;
    }

	public static void main(String[] args) {
	}
}