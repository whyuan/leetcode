package lc13;
/**
 * Created by wanghaoyuan on 2016/8/3.
 */
public class Solution {
    static int[] a = {1, 5, 10, 50, 100, 500, 1000};
    static String p = "IVXLCDM";
    public int romanToInt(String s) {
        int step = 0;
        int b;
        int result = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            b = Solution.a[Solution.p.indexOf(s.charAt(i))];
            if (b >= step) {
                step = b;
                result += b;
            } else {
                result -= b;
            }
        }
        return result;
    }

//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        System.out.println(solution.romanToInt("XIX"));
//        System.out.println(solution.romanToInt("I"));
//        System.out.println(solution.romanToInt("II"));
//        System.out.println(solution.romanToInt("III"));
//        System.out.println(solution.romanToInt("IV"));
//        System.out.println(solution.romanToInt("V"));
//        System.out.println(solution.romanToInt("VI"));
//        System.out.println(solution.romanToInt("VII"));
//        System.out.println(solution.romanToInt("VIII"));
//        System.out.println(solution.romanToInt("IX"));
//        System.out.println(solution.romanToInt("X"));
//        System.out.println(solution.romanToInt("DC"));
//    }
}
