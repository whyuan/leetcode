package lc22;

import java.util.*;

/**
 * Created by wanghaoyuan on 2016/8/4.
 */
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new LinkedList<>();
        if (n <= 0) return result;
        char[] s = new char[n*2];
        int l = 0; // 使用(数
        int p = 0; // 位置
        int[] stackP = new int[n*2];
        int[] stackL = new int[n*2];
        int st = 0;
        while (true) {
            if (p-l < l) {
                if (l < n) {
                    // (或者)
                    stackL[st] = l;
                    stackP[st] = p;
                    st++;
                    s[p++] = '(';
                    l++;
                } else {
                    // 只能)
                    s[p++] = ')';
                }
            } else {
                // 只能(
                s[p++] = '(';
                l++;
            }
            if (p == s.length) {
                result.add(String.valueOf(s));
                // 此时出栈
                if (st > 0) {
                    st--;
                    l = stackL[st];
                    p = stackP[st];
                    s[p++] = ')';
                } else {
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.generateParenthesis(0));
        System.out.println(solution.generateParenthesis(3));
    }
}

