/**
 * Created by wanghaoyuan on 2016/7/25.
 */
package lc1;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = {};
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    int[] a = {i, j};
                    result = a;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int target = 9;
        int[] nums = {2, 7, 11, 15};
        Solution solution = new Solution();
        int[] result = solution.twoSum(nums, target);
        System.out.print(result[1]);
    }
}
