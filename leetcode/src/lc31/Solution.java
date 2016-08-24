package lc31;

import java.util.Arrays;

public class Solution {
    public void nextPermutation(int[] nums) {
    	int temp, len;
    	for (int i = nums.length-1; i > 0; i--) {
    		if (nums[i] > nums[i-1]) {
                len = (nums.length-i)/2;
                for (int k = i; k < i+len; k++) {
                    if (nums[nums.length-1-k+i] == nums[k]) break;
                    temp = nums[k];
                    nums[k] = nums[nums.length-1-k+i];
                    nums[nums.length-1-k+i] = temp;
                }
//                int j = Arrays.binarySearch(nums, i, nums.length, nums[i-1]+.5);
                int target = nums[i-1]+1;
                int l = i, r = nums.length;
                while (l < r) {
                	int m = (r-l)/2+l;
                	if (nums[m] >= target) r = m;
                	else l = m+1;
                }
                target = l;
//                if (j >= 0) target = j;
//                else target = -(j+1);
                temp = nums[i-1];
                nums[i-1] = nums[target];
                nums[target] = temp;
                return;
    		}
    	}
    	len = nums.length/2;
		for (int k = 0; k < len; k++) {
			temp = nums[k];
			nums[k] = nums[nums.length-1-k];
			nums[nums.length-1-k] = temp;
		}
    }
    
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	int[] test = {2,1,2,2,2,2,2,1};
    	solution.nextPermutation(test);
    	System.out.println(test[2]);
    }
}
