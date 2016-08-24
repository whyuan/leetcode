package lc18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wanghaoyuan on 2016/8/4.
 */
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        if (nums.length < 4) return result;
        for (int i = 0; i < nums.length-3; i++) {
            for (int j = i+1; j < nums.length-2; j++) {
                int l = j+1, r = nums.length-1;
                while (l < r) {
                    int sum = nums[i]+nums[j]+nums[l]+nums[r];
                    if (sum > target) {
                        while (nums[i]+nums[j]+nums[l]+nums[r] > target && l < r) r--;
                    } else if (sum < target) {
                        while (nums[i]+nums[j]+nums[l]+nums[r] < target && l < r) l++;
                    } else if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        l++;
                        while(l < r && nums[l] == nums[l-1]) l++;
                    }
                }
                while (j < nums.length-2 && nums[j+1] == nums[j]) j++;
            }
            while (i < nums.length-2 && nums[i+1] == nums[i]) i++;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.fourSum(new int[]{1,1,0,1,10,-1,0,-2,2}, 0));
        System.out.println(solution.fourSum(new int[]{0,0,0,0}, 0));
        System.out.println(solution.fourSum(new int[]{1,2,3,1}, 0));
    }
}
