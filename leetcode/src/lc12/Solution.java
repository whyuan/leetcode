package lc12;

/**
 * Created by wanghaoyuan on 2016/8/3.
 */
public class Solution {
    static String[] a = {"", "M", "MM", "MMM"};
    static String[] b = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    static String[] c = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    static String[] d = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
    public String intToRoman(int num) {
        if (num < 1 || num > 3999) return "";
        return Solution.a[num/1000]+Solution.b[num%1000/100]+Solution.c[num%100/10]+Solution.d[num%10];
    }

    public String intToRoman2(int num) {
        if (num < 1 || num > 3999) return "";
        StringBuilder result = new StringBuilder("");
        String a = "IVXLCDM";
        int[] b = {1, 10, 100, 1000};
        int step = 0;
        while (num > 0) {
//            int d = num%10;
//            num = num/10;
            int d = num/b[b.length-(step/2)-1];
            num -= d*b[b.length-(step/2)-1];
            if (d != 0) {
                int step0 = a.length()-step-1;
                char x = a.charAt(step0);
                char y = 0, z = 0;
                if (step0 <= a.length()-3) {
                    y = a.charAt(step0+1);
                    z = a.charAt(step0+2);
                }
                switch (d) {
                    case 1:
                        result.append(x);
                        break;
                    case 2:
                        result.append(x).append(x);
                        break;
                    case 3:
                        result.append(x).append(x).append(x);
                        break;
                    case 4:
                        result.append(x).append(y);
                        break;
                    case 5:
                        result.append(y);
                        break;
                    case 6:
                        result.append(y).append(x);
                        break;
                    case 7:
                        result.append(y).append(x).append(x);
                        break;
                    case 8:
                        result.append(y).append(x).append(x).append(x);
                        break;
                    case 9:
                        result.append(x).append(z);
                        break;
                }
            }
            step += 2;
        }
        return result.toString();
    }

    public String intToRoman1(int num) {
        if (num < 1 || num > 3999) return "";
        StringBuilder result = new StringBuilder("");
        String a = "IVXLCDM";
        int step = 0;
        while (num != 0) {
            int d = num%10;
            num = num/10;
            StringBuilder result1 = new StringBuilder();
            char x = a.charAt(step);
            char y = a.charAt(step+1);
            char z = a.charAt(step+2);
            switch (d) {
                case 1:
                    result1.append(x);
                    break;
                case 2:
                    result1.append(x).append(x);
                    break;
                case 3:
                    result1.append(x).append(x).append(x);
                    break;
                case 4:
                    result1.append(x).append(y);
                    break;
                case 5:
                    result1.append(y);
                    break;
                case 6:
                    result1.append(y).append(x);
                    break;
                case 7:
                    result1.append(y).append(x).append(x);
                    break;
                case 8:
                    result1.append(y).append(x).append(x).append(x);
                    break;
                case 9:
                    result1.append(x).append(z);
                    break;
            }
            result = result1.append(result);
            step += 2;
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.intToRoman(400));
        System.out.println(solution.intToRoman(10));
        System.out.println(solution.intToRoman(67));
        System.out.println(solution.intToRoman(89));
        System.out.println(solution.intToRoman(3));
        System.out.println(solution.intToRoman(1));
        System.out.println(solution.intToRoman(2));
        System.out.println(solution.intToRoman(3));
        System.out.println(solution.intToRoman(4));
        System.out.println(solution.intToRoman(5));
        System.out.println(solution.intToRoman(6));
        System.out.println(solution.intToRoman(7));
        System.out.println(solution.intToRoman(8));
        System.out.println(solution.intToRoman(9));
    }
}
