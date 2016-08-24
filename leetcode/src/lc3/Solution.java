
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        } else {
            int h = 0;
            int l = 1;
            for (int i = 1; i < s.length(); i++) {
                int newStart = -1;
                if ((newStart = s.substring(h, i).indexOf(s.charAt(i))) >= 0) {
                    h = h+newStart+1;
                }
                if (i-h+1 > l) {
                    l = i-h+1;
                }
            }
            return l;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.print(solution.lengthOfLongestSubstring(""));
    }
}