package lc72;

public class Solution {
    public int minDistance(String word1, String word2) {
        if (word1 == null || word1.length() == 0) {
            if (word2 == null) { return 0; }
            else { return word2.length(); }
        }
        int[][] f = new int[word1.length()+1][word2.length()+1];
        int l0 = f.length, l1 = f[0].length;
        for (int i = 0; i < l0; i++) {
            for (int j = 0; j < l1; j++) {
                if (i == 0) {
                    f[i][j] = j;
                } else if (j == 0) {
                    f[i][j] = i;
                } else {
                    if (word1.charAt(i-1) == word2.charAt(j-1)) {
                        f[i][j] = Math.min(Math.min(f[i-1][j]+1, f[i][j-1]+1), f[i-1][j-1]);
                    } else {
                        f[i][j] = Math.min(Math.min(f[i-1][j]+1, f[i][j-1]+1), f[i-1][j-1]+1);
                    }
                }
            }
        }
        return f[word1.length()][word2.length()];
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minDistance("bbbabc", "bbbabc"));
    }
}
