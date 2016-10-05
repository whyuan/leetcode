package lc324;

import java.util.*;

public class Solution {
	
    public void wiggleSort(int[] nums) {
//    	int median = findKthLargest(nums, (nums.length+1)/2);
    	int median = quickselect(nums, 0, nums.length-1, (nums.length-1)/2);
    	int left = 0, i = 0, right = nums.length-1, n = nums.length;
    	while (i <= right) {
    		if (nums[pos(i, n)] > median) {
    			swap(nums, pos(i++, n), pos(left++, n));
    		} else if (nums[pos(i, n)] < median) {
    			swap(nums, pos(i, n), pos(right--, n));
    		} else {
    			i++;
    		}
    	}
    }
    
    private void swap(int[] nums, int i, int j) {
    	int temp = nums[i];
    	nums[i] = nums[j];
    	nums[j] = temp;
    }
    
    private int pos(int i, int n) {
    	return (1+i*2) % (n|1);
    }
    
    private int quickselect(int[] nums, int left, int right, int k) {
        if (left >= right) {
            return nums[left];
        }
        int position = partition(nums, left, right);
        if (position == k) {
            return nums[position];
        } else if (position < k) {
            return quickselect(nums, position + 1, right, k);
        } else {
            return quickselect(nums, left, position - 1, k);
        }
    }
    
    private int partition(int[] nums, int left, int right) {
        if (left >= right) {
            return left;
        }
        int value = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= value) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] < value) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = value;
        return left;
    }

    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        return f(nums, k, 0, nums.length-1);
    }
    
    public int f(int[] nums, int k, int start, int end) {
        int h = start, t = end, temp = 0;
        int xIndex = genP(nums, start, end);
        temp = nums[xIndex];
        nums[xIndex] = nums[start];
        nums[start] = temp;
        int x = nums[start];
        while (h < t) {
        	while (h < t && x > nums[t]) t--;
        	while (h < t && x <= nums[h]) h++;
        	if (h < t) {
        		temp = nums[h];
        		nums[h] = nums[t];
        		nums[t] = temp;
        	}
        }
        nums[start] = nums[h];
        nums[h] = x;
		if (h == k - 1) {
			return nums[h];
		} else if (h < k - 1) {
			return f(nums, k, h + 1, end);
		} else {
			return f(nums, k, start, h - 1);
		}
    }

    public int genP(int[] nums, int l, int r)
    {
        int m = (l+r)/2;
        if (nums[l] > nums[r]) {
        	if (nums[r]>nums[m]) return r;
        	else return nums[l]>nums[m]?m:l;
        } else {
        	if (nums[l]>nums[m]) return l;
        	else return nums[m]>nums[r]?r:m;
        }
    }

    public static void main(String[] args) {
    	Solution solution = new Solution();
    }
}
