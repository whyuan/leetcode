public class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length <= 0 || matrix[0].length <= 0) return;
        int l0 = matrix.length, l1 = matrix[0].length;
        boolean[] flags0 = new boolean[l0], flags1 = new boolean[l1];
        for (int i = 0; i < l0; i++) {
            for (int j = 0; j < l1; j++) {
                if (matrix[i][j] == 0) {
                    flags0[i] = true;
                    flags1[j] = true;
                }
            }
        }
        for (int i = 0; i < l0; i++) {
            if (flags0[i]) {
                for (int j = 0; j < l1; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < l1; i++) {
            if (flags1[i]) {
                for (int j = 0; j < l0; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
        return;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] a = new int[][]{{1,2,3},{4,0,6},{7,8,9}};
        solution.setZeroes(a);
        System.out.println(a);
    }
}
