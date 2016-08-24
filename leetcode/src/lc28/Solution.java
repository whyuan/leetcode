public class Solution {
    public int strStr(String haystack, String needle) {
        int l0 = haystack.length();
        int l1 = needle.length();
        if (l0 <= 0 && l1 <= 0) return 0;
        if (l0 <= 0) return -1;
        int i,j;
        for (i = 0; i < l0-l1+1; i++) {
            for (j = 0; j < l1; j++) {
                if (haystack.charAt(i+j) != needle.charAt(j)) {
                    break;
                }
            }
            if (j == l1) {
                return i;
            }
        }
        return -1;
    } 

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.strStr("abcabcaaa", "aaaa"));
        System.out.println(solution.strStr("", "aaaa"));
        System.out.println(solution.strStr("", ""));
    }
}
