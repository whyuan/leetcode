public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int l0 = matrix.length, l1 = matrix[0].length;
        int l = 0, r = l0*l1;
        int m, x, y;
        while (l < r) {
            m = (l+r)/2;
            x = m/l1;
            y = m%l1;
            if (matrix[x][y] == target) return true;
            if (matrix[x][y] < target) {
                l = m+1;
            } else {
                r = m;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,50}}, 19));
    }
}
