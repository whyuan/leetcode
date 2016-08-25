package lc27;

public class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums.length <= 0) return 0;
        int l = nums.length;
        for (int i = 0; i < l; i++) {
            while (nums[i] == val && i < l) {
                nums[i] = nums[--l];
            }
        }
        return l;
    }
    
    public int removeElement1(int[] nums, int val) {
        if (nums.length <= 0) return 0;
        int p0 = 0;
        int p1 = 0;
        while (p1 < nums.length) {
            while (p1 < nums.length && nums[p1] == val) p1++;
            while (p1 < nums.length && nums[p1] != val) nums[p0++] = nums[p1++];
        }
        return p0;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeElement(new int[]{3,2,2,3}, 3));
    }
}
