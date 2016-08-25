package lc14;

import java.util.Arrays;

/**
 * Created by wanghaoyuan on 2016/8/3.
 */
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length <= 0) return "";
        Arrays.sort(strs);

        int i = 0;
        int l = strs.length;
        int ll = strs[l-1].length();
        char[] str0 = strs[0].toCharArray();
        char[] str1 = strs[l-1].toCharArray();
        for (i = 0; i < str0.length; i++) {
            if (i >= ll || str1[i] != str0[i]) {
                break;
            }
        }
        return strs[0].substring(0, i);
    }

    public String longestCommonPrefix1(String[] strs) {
        if (strs.length <= 0) return "";
        int i = 0;
        aa:
        for (i = 0; i < strs[0].length(); i++) {
            for (int j = 1; j< strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != strs[0].charAt(i)) {
                    break aa;
                }
            }
        }
        return strs[0].substring(0, i);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strings = new String[]{"aaa", "bbb"};
        System.out.println(solution.longestCommonPrefix(new String[]{"aaa", "aab", "acd"}));
    }
}
