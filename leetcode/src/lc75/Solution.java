public class Solution {
    public void sortColors(int[] nums) {
        int[] a = new int[]{0, 0, 0}; 
        for (int i = 0; i < nums.length; i++) {
            a[nums[i]]++;
        }
        int step = 0;
        for (int i = 0; i < 3; i++) {
            while (a[i] > 0) {
                nums[step++] = i;
                a[i]--;
            }
        }
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a = new int[]{1,2,0,1,1,1,1,2,2,0};
        solution.sortColors(a);
        System.out.println(a);
    }
}
