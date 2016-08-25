package lc66;

public class Solution {
    public int[] plusOne(int[] digits) {
        boolean allNine = true;
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] != 9) {
                allNine = false;
                break;
            }
        }
        if (!allNine) {
            int g = 0;
            digits[digits.length-1] = digits[digits.length-1]+1;
            for (int i = digits.length-1; i >= 0; i--) {
                int temp = digits[i];
                digits[i] = (g+digits[i])%10;
                g = (g+temp)/10;
            }
            return digits;
        } else {
            int[] result = new int[digits.length+1];
            result[0] = 1;
            return result;
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.plusOne(new int[]{1,2,3}));
    }
}
