import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        Integer[] cur = new Integer[k];
        boolean[] visited = new boolean[n];
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        dfs(n, k, cur, visited, result, 0);
        return result;
    }
    
    private void dfs(int n, int k, Integer[] cur, boolean[] visited, List<List<Integer>> result, int step) {
        if (k == 0) {
            List<Integer> result0 = Arrays.asList(new Integer[cur.length]);
            Collections.copy(result0, Arrays.asList(cur));
            result.add(result0);
        } else {
            for (int i = step; i < n; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    cur[cur.length-k] = i+1;
                    dfs(n, k-1, cur, visited, result, i+1);
                    visited[i] = false;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.combine(4, 2));
    }
}
