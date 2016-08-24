package lc16;

import java.util.Arrays;

/**
 * Created by wanghaoyuan on 2016/8/4.
 */
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3) return 0;
        Arrays.sort(nums);
        int min = nums[0]+nums[1]+nums[2];
        for (int i = 0; i < nums.length-2; i++) {
            int l = i+1, r = nums.length-1;
            while (l < r) {
                if (target-nums[i] == nums[l]+nums[r]) {
                    return target;
                } else if (target-nums[i] < nums[l]+nums[r]) {
                    while (l < r && target-nums[i] < nums[l]+nums[r]) r--;
                    if (Math.abs(target-nums[i]-nums[l]-nums[r+1]) < Math.abs(target-min)) {
                        min = nums[i]+nums[l]+nums[r+1];
                    }
                } else {
                    while (l < r && target-nums[i] > nums[l]+nums[r]) l++;
                    if (Math.abs(target-nums[i]-nums[l-1]-nums[r]) < Math.abs(target-min)) {
                        min = nums[i]+nums[l-1]+nums[r];
                    }
                }
            }
        }
        return min;
    }

    public int threeSumClosest1(int[] nums, int target) {
        if (nums.length < 3) return 0;
        Arrays.sort(nums);
        int step0 = 0;
        int min = nums[0]+nums[1]+nums[2];
        while (step0 < nums.length) {
            int step1 = step0+1;
            while (step1 < nums.length) {
                int a = Arrays.binarySearch(nums, step1+1, nums.length, target-nums[step0]-nums[step1]);
                if (a >= 0) {
                    return target;
                } else {
                    int cur = min;
                    if (-(a+1) < nums.length) {
                        int x = (nums[-(a+1)]+nums[step1]+nums[step0]);
                        if (-(a+1)>step1+1) {
                            int y = (nums[-(a+1)-1]+nums[step1]+nums[step0]);
                            cur = Math.abs(target-x)>Math.abs(target-y)?y:x;
                        } else {
                            cur = x;
                        }
                    } else if (step1 < nums.length-1) {
                        cur = nums[step0] + nums[step1] + nums[nums.length-1];
                    }
                    if (Math.abs(target-cur)<Math.abs(target-min)) {
                        min = cur;
                    }
                }
                while (step1+1<nums.length && nums[step1]==nums[step1+1]) {
                    step1++;
                }
                step1++;
            }
            while (step0+1<nums.length && nums[step0]==nums[step0+1]) {
                step0++;
            }
            step0++;
        }
        return min;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.threeSumClosest(new int[]{-20,2,3,1,-40}, -40));//-37
        System.out.println(solution.threeSumClosest(new int[]{0,1,2}, 0)); //3
        System.out.println(solution.threeSumClosest(new int[]{23,1,2,3,44,5,3,2}, 5)); //5
        System.out.println(solution.threeSumClosest(new int[]{0,0,0,0,0}, 1));
        System.out.println(solution.threeSumClosest(new int[]{0,0,0,0,0}, 0));
    }
}
