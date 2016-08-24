import java.util.List;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        List<Integer> curList = new LinkedList<Integer>();
        dfs(candidates, target, 0, 0, result, curList);
        return result;
    }

    private void dfs(int[] candidates, int target, int step, int sum, List<List<Integer>> allList, List<Integer> curList) {
        if (step == candidates.length || target == sum) {
            if (target == sum) {
                List<Integer> a = Arrays.asList(new Integer[curList.size()]);
                Collections.copy(a, curList);
                allList.add(a);
            }
        } else {
            for (int i = step; i < candidates.length; i++) {
                if (candidates[i]+sum <= target) {
                    curList.add(candidates[i]);
                    dfs(candidates, target, i, sum+candidates[i], allList, curList);
                    curList.remove(curList.size()-1);
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.combinationSum(new int[] { 6, 7, 2, 3 }, 0));
    }
}
