package lc26;

public class Solution {
    public int removeDuplicates(int[] nums) {
        int result = 0;
        int step = 0;
        if (nums.length <= 0) return 0;
        while (true) {
            nums[result++] = nums[step++];
            while (step < nums.length && nums[step] == nums[step-1]) { step++; }
            if (step == nums.length) break;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeDuplicates(new int[]{1,2,3,5,5,5,5,5}));
    }
}
