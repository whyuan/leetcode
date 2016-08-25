package lc67;

public class Solution {
    public String addBinary(String a, String b) {
        String result = "";
    int g = 0;
    String temp;
    if (b.length() > a.length()) {
        temp = b;
        b = a;
        a = temp;
    }
    for (int t = a.length()-1; t >= 0; t--) {
        int i = t;
        int j = b.length()-(a.length()-t);
        if (j >= 0) {
        if (a.charAt(i) == '0' && b.charAt(j) == '0' && g == 0) {
            result = "0"+result;
            g = 0;
        } else if ((a.charAt(i) == '0' && b.charAt(j) == '1' && g == 0) 
            || (a.charAt(i) == '1' && b.charAt(j) == '0' && g == 0)
            || (a.charAt(i) == '0' && b.charAt(j) == '0' && g == 1)) {
            result = "1"+result;
            g = 0;
        } else if ((a.charAt(i) == '1' && b.charAt(j) == '1' && g == 0) 
            || (a.charAt(i) == '1' && b.charAt(j) == '0' && g == 1)
            || (a.charAt(i) == '0' && b.charAt(j) == '1' && g == 1)) {
            result = "0"+result;
            g = 1;
        } else {
            result = "1"+result;
            g = 1;
        }
        } else {
            if (a.charAt(i) == '0' && g == 1) {
                result = "1"+result;
                g = 0;
            } else if (a.charAt(i) == '1' && g == 1) {
                result = "0"+result;
                g = 1;
            } else if (a.charAt(i) == '0' && g == 0) {
                result = "0"+result;
                g = 0;
            } else {
                result = "1"+result;
                g = 0;
            }
        }
    }
    if (g == 1) {
        result = "1"+result;
    }
    return result;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.addBinary("101", "11"));
    }
}
