package lc8;

/**
 * Created by wanghaoyuan on 2016/7/29.
 */
public class Solution {
    public int myAtoi(String str) {
        int l = str.length();
        if (l == 0) return 0;
        boolean hasSign = false;
        boolean isNeg = false;
        long result = 0;
        for (int i = 0; i < l; i++) {
            char a = str.charAt(i);
            if (a == '-' && !hasSign) {
                isNeg = true;
            } else if (a == '+' && !hasSign) {
            } else if (a == ' ' && !hasSign) {
                continue;
            } else if (a >= 48 && a <= 57) {
                result = result*10+(str.charAt(i)-48);
                if (!isNeg && result>Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                } else if (isNeg && Integer.MIN_VALUE>-result) {
                    return Integer.MIN_VALUE;
                }
            } else {
                break;
            }
            if (!hasSign) hasSign = true;
        }
        return (int)(isNeg?(-result):result);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.print(solution.myAtoi("-2343445454334534"));
//        System.out.print(solution.myAtoi("-23dfdf534"));
//        System.out.print(solution.myAtoi("+234"));

        System.out.println(solution.myAtoi("123  456"));
        System.out.println(solution.myAtoi("2147483648"));
        System.out.println(solution.myAtoi("\t+0\t123"));
        System.out.println(solution.myAtoi("   +0  0023a34"));
        System.out.println(solution.myAtoi("     -023"));
        System.out.println(solution.myAtoi(new String("   +0 123")));
        System.out.println(-Integer.MIN_VALUE);
        System.out.println(solution.myAtoi("-23"));
        System.out.println(solution.myAtoi("     -23"));
        System.out.println(solution.myAtoi("     -0023a34"));
        System.out.println(solution.myAtoi("   +0  0023a34"));
    }
}
