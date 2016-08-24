/**
 * Created by wanghaoyuan on 2016/7/28.
 */
public class Solution {
    public String convert(String s, int numRows) {
//        String result = "";
//        StringBuffer result = new StringBuffer(s);
        StringBuilder result = new StringBuilder(s);
        if (s.length() < 1) {
            return "";
        } else {
            int n = (numRows-1)*2;
            if (n == 0) n = 1;
            int n1 = n;
            int step = 0;
            for (int i = 0; i < numRows; i++) {
                int index = i;
//                n1 = (n-2*i+n-1)%n+1;
                n1 = (n-2*i);
                if (n1 == 0) n1 = n;
                while (index < s.length()) {
                    result.setCharAt(step++, s.charAt(index));
                    index += n1;
//                    n1 = (n-n1+n-1)%n+1;
                    if (n1 != n) {
                        n1 = n-n1;
                    }
                }
            }
            return result.toString();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.convert("PAYPALISHIRING", 3));
        System.out.println(solution.convert("", 4));
        System.out.println(solution.convert("A", 2));
    }
}
