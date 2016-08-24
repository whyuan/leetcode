/**
 * Created by wanghaoyuan on 2016/7/28.
 */
public class Solution {
    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }
        for (int i = 0; i < s.length()-1; i++) {
            this.longestPalindromeInPos(s, i, i);
            this.longestPalindromeInPos(s, i, i+1);
        }
        return s.substring(maxLengthPos, maxLengthPos+maxLength);
    }

    private int maxLength = 0;
    private int maxLengthPos = 0;
    private void longestPalindromeInPos(String s, int l, int r) {
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        int total = r-l-1;
        if (total > this.maxLength) {
            this.maxLength = total;
            this.maxLengthPos = l+1;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.print(solution.longestPalindrome("dferferdfafdwerqvfd"));
    }
}
