package lc7;

/**
 * Created by wanghaoyuan on 2016/7/29.
 */
public class Solution {
    public int reverse(int x) {
        long result = 0;
        while (x != 0) {
            result = result*10+x%10;
            if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
                return 0;
            }
            x = x/10;
        }
        return (int)result;
    }

    private static int top = Integer.MAX_VALUE/10;
    private static int bottom = Integer.MIN_VALUE/10;
    public int reverse_2(int x) {
        int result = 0;
        int a = 0;
        while (x != 0) {
            a = x%10;
            x = x/10;
            if (Solution.top<result || Solution.bottom>result) {
                return 0;
            }
            result = result*10+a;
        }
        return result;
    }

    public int reverse_1(int x) {
        String a = ""+x;
        StringBuilder b = new StringBuilder();
        int l = a.length();
        for (int i = 0; i < l; i++) {
//            b.setCharAt(i, a.charAt(l-i-1));
            b.append(a.charAt(l-i-1));
        }
        try {
            if (x < 0) {
                return -Integer.parseInt(b.toString().substring(0, b.length()-1));
            } else {
                return Integer.parseInt(b.toString());
            }
        } catch(NumberFormatException e) {
            return 0;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.print(solution.reverse(123));
        System.out.print(solution.reverse(0));
        System.out.print(solution.reverse(-2334));
//        System.out.print(solution.reverse(9646324351));
        System.out.print(solution.reverse(1534236469));
    }
}

