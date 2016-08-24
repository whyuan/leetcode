import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wanghaoyuan on 2016/8/3.
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int step0 = 0;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        while (step0 < nums.length && nums[step0] < 0) {
            int step1 = step0+1;
            while (step1 < nums.length && nums[step0]+nums[step1]<=0) {
                int a = Arrays.binarySearch(nums, step1+1, nums.length, 0-nums[step0]-nums[step1]);
                if (a >= 0) {
                    ArrayList<Integer> arrayList = new ArrayList<Integer>();
                    arrayList.add(nums[step0]);
                    arrayList.add(nums[step1]);
                    arrayList.add(0-nums[step0]-nums[step1]);
                    result.add(arrayList);
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
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.threeSum(new int[]{-1,0,1,21,3,4,5,2}));
        System.out.println(solution.threeSum(new int[]{-1, 0, 1, 2, -1, -1, -4}));
    }
}
