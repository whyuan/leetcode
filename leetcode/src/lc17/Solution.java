package lc17;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wanghaoyuan on 2016/8/4.
 */
public class Solution {
    String[] letters = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        if (digits.length() <= 0) return new ArrayList();
        char[] ds = digits.toCharArray();
        char[] cur = new char[ds.length];
        List<String> result = new ArrayList<String>();
        // 不用递归
        // 不使用递归
        for (int i = 0; i < ds.length; i++) {
            int c = ds[i]-'2';
            if (c < 0 || c >= letters.length) return new ArrayList();
            cur[i] = letters[c].charAt(0);
        }
        int step = 0;
        int r = letters[ds[ds.length-1]-'2'].length();
        while (true) {
            while (step < r) {
                cur[cur.length-1] = letters[ds[ds.length-1]-'2'].charAt(step);
                result.add(String.valueOf(cur));
                step++;
            }
            for (int j = cur.length-1; j >= 0; j--) {
                String w = letters[ds[j]-'2'];
                if (cur[j] == w.charAt(w.length()-1)) {
                    cur[j] = w.charAt(0);
                    if (j == 0) {
                        return result;
                    }
                } else {
                    cur[j] = w.charAt(w.indexOf(cur[j])+1);
                    break;
                }
            }
            step = 0;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.letterCombinations(""));
        System.out.println(solution.letterCombinations("23"));
        System.out.println(solution.letterCombinations("0231"));
    }
}
